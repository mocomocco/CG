/**
 * Model of a scene
 */

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;


public class MyScene {

	// Models of a flag and a car
	static MyFlag flag1 = null;
	static MyCar car1 = null;
	static MyRobot robot1=null;
	static MyCaterpillar[] caterpillars1;
	static MyCaterpillar[] caterpillars2;
	static int caterpillarnum=18;
	static int tirenum=3;
	static MyCaterpillarTire[] tire1;
	static MyCaterpillarTire[] tire2;
	static MyCaterpillarCore[] core;
	static double vmae;
	/**
	 * Initialization
	 */

	private static void robotreset(){
		for (int i=0;i<caterpillarnum;i++) {
			caterpillars1[i].resetMovement();
			caterpillars2[i].resetMovement();
		}
		for(int i=0;i<tirenum;i++) {
			tire1[i].resetMovement();
			tire2[i].resetMovement();
			core[i].resetMovement();
		}
	}
	private static void robotback(){
		vmae=-vmae;
		for (int i=0;i<caterpillarnum;i++) {
			caterpillars1[i].setvmae(vmae);
			caterpillars2[i].setvmae(vmae);
			caterpillars1[i].Back();
			caterpillars2[i].Back();
		}
		for(int i=0;i<tirenum;i++) {
			tire1[i].setvmae(vmae);
			tire2[i].setvmae(vmae);
			core[i].setvmae(vmae);
		}
	}

	private static void robotturn(int right){
		vmae=-vmae;
		for (int i=0;i<caterpillarnum;i++) {
			caterpillars1[i].Turn(right*10);
			caterpillars2[i].Turn(right*10);
		}
		for(int i=0;i<tirenum;i++) {
			tire1[i].Turn(right*10);
			tire2[i].Turn(right*10);
			core[i].Turn(right*10);
		}
	}

	private static void robotinit(){
		caterpillars1 = new MyCaterpillar[caterpillarnum];
		caterpillars2 = new MyCaterpillar[caterpillarnum];
		tire1 = new MyCaterpillarTire[tirenum];
		tire2 = new MyCaterpillarTire[tirenum];
		core = new MyCaterpillarCore[tirenum];

		robot1 = new MyRobot();
		vmae=-0.01;
		/*robot1.setColor(0.0, 1.0, 0.0);
		robot1.setVelocity(5);
		robot1.setTransform(1.5);*/

		for(int i=0;i<tirenum;i++) {
			tire1[i] = new MyCaterpillarTire();
			tire1[i].sides = 30;
			if (i==0){tire1[i].sides = 10;}
			tire1[i].setSyokix(0.65*(i-1));
			tire1[i].setSyokiy(-0.25);
			tire1[i].setSyokiz(0.8);
			tire1[i].setvmae(vmae);

			tire2[i] = new MyCaterpillarTire();
			tire2[i].sides = 30;
			if (i==0){tire2[i].sides = 10;}
			tire2[i].setSyokix(0.65*(i-1));
			tire2[i].setSyokiy(-0.25);
			tire2[i].setSyokiz(-0.8);
			tire2[i].setvmae(vmae);

			core[i]= new MyCaterpillarCore();
			core[i].sides=10;
			core[i].setSyokix(0.65*(i-1));
			core[i].setSyokiy(-0.25);
			core[i].setSyokiz(0);
			core[i].setvmae(vmae);
		}


		for (int i=0 ;i<caterpillarnum;i++){
			caterpillars1[i]=new MyCaterpillar();
			caterpillars1[i].id=i*2;
			caterpillars1[i].setSyokiy(0);
			caterpillars1[i].setSyokiz(0.8);
			caterpillars1[i].setvmae(vmae);

			caterpillars2[i]=new MyCaterpillar();
			caterpillars2[i].id=i*2+1;
			caterpillars2[i].setSyokiy(0);
			caterpillars2[i].setSyokiz(-0.8);
			caterpillars2[i].setvmae(vmae);


			if (i<5){//0,1,2,3,4
				caterpillars1[i].setr(0);
				caterpillars1[i].setSyokix(0.7-0.35*i);
				caterpillars2[i].setr(0);
				caterpillars2[i].setSyokix(0.7-0.35*i);
			}else if (i<=8){//5,6,7,8
				caterpillars1[i].setr(350*(i-4));
				caterpillars1[i].setSyokix(-0.7);
				caterpillars2[i].setr(350*(i-4));
				caterpillars2[i].setSyokix(-0.7);
			}else if (i<=13){//9,10,11,12,13
				caterpillars1[i].setr(1800);
				caterpillars1[i].setSyokix(-0.7+0.35*(i-9));
				caterpillars2[i].setr(1800);
				caterpillars2[i].setSyokix(-0.7+0.35*(i-9));
			}else if(i<=17){//14,15,16,17
				caterpillars1[i].setr(1800+350*(i-13));
				caterpillars1[i].setSyokix(0.7);
				caterpillars2[i].setr(1800+350*(i-13));
				caterpillars2[i].setSyokix(0.7);
			}
		}
	}

	public static void init() {
		 // Allocate a flag
		 //flag1 = new MyFlag();

		 // Allocate a car
		 car1 = new MyCar();
		 car1.setColor(1.0, 0.0, 0.0);
		 car1.setVelocity(5);
		 car1.setTransform(1.5);

		 robotinit();


	}

	/**
	 * Draw the scene
	 */

	private static void drawrobot(GLAutoDrawable drawable,GL2 gl){
		gl.glPushMatrix();
		if(robot1 != null)
			robot1.draw(drawable);
		gl.glPopMatrix();

		for (int i=0;i<tirenum;i++) {
			/*gl.glPushMatrix();
			if (tire1[i] != null)
				tire1[i].draw(drawable);
			gl.glPopMatrix();

			gl.glPushMatrix();
			if (tire2[i] != null)
				tire2[i].draw(drawable);
			gl.glPopMatrix();
*/
			gl.glPushMatrix();
			if (core[i] != null)
				core[i].draw(drawable);
			gl.glPopMatrix();
		}

		for (int i=0;i<caterpillarnum;i++){
			gl.glPushMatrix();
			if(caterpillars1[i] != null)
				caterpillars1[i].draw(drawable);
			gl.glPopMatrix();

			gl.glPushMatrix();
			if(caterpillars2[i] != null)
				caterpillars2[i].draw(drawable);
			gl.glPopMatrix();
		}
	}

	public static void draw(GLAutoDrawable drawable) {
		if(drawable == null) return;

		GL2 gl = drawable.getGL().getGL2();
		 gl.glLightModeli(GL2.GL_LIGHT_MODEL_TWO_SIDE, GL2.GL_TRUE);

	    // Draw the flag
	    /*gl.glPushMatrix();
	    if(flag1 != null)
	    	flag1.draw(drawable);
	    gl.glPopMatrix();*/

	    // Draw the car
		/*gl.glPushMatrix();
	    if(car1 != null)
	    	car1.draw(drawable);
	    gl.glPopMatrix();*/

		/*gl.glPushMatrix();
		if(robot1 != null)
			robot1.draw(drawable);
		gl.glPopMatrix();
	  */
		drawrobot(drawable,gl);
	}

	/**
	 * Reset the movement
	 */
	public static void resetMovement() {

		// Reset the position of the car
	//	car1.resetMovement();
		robotreset();
	}
	public static void back() {

		robotback();
	}

	public static void turn(int right) {//right 90 down 180...みたいな
			robotturn(right);
	}
}
