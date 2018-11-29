/**
 * Model of a scene
 */

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;


public class MyScene {

	// Models of a flag and a car
	static MyCaterpillar[] caterpillars1;
	static MyCaterpillar[] caterpillars2;
	static int caterpillarnum=18;
	static int tirenum=3;
	static MyCaterpillarTire[] tire1;
	static MyCaterpillarTire[] tire2;
	static MyCaterpillarCore[] core;
	static MyCaterpillarCover[] cover1;
	static MyCaterpillarCover[] cover2;
	static MyRobot robot;
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
		for(int i=0;i<2;i++){
			cover1[i].resetMovement();
			cover2[i].resetMovement();
		}
		robot.resetMovement();
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
		for(int i=0;i<2;i++){
			cover1[i].setvmae(vmae);
			cover2[i].setvmae(vmae);
		}
		robot.setvmae(vmae);
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
		for (int i=0;i<2;i++) {
			cover1[i].Turn(right * 10);
			cover2[i].Turn(right * 10);
		}
		robot.Turn(right *10);
	}

	private static void robotinit(){
		caterpillars1 = new MyCaterpillar[caterpillarnum];
		caterpillars2 = new MyCaterpillar[caterpillarnum];
		tire1 = new MyCaterpillarTire[tirenum];
		tire2 = new MyCaterpillarTire[tirenum];
		core = new MyCaterpillarCore[tirenum];
		cover1 = new MyCaterpillarCover[2];
		cover2 = new MyCaterpillarCover[2];
		robot = new MyRobot();
		vmae=-0.01;

		robot.setSyokix(0);
		robot.setSyokiy(0);
		robot.setSyokiz(0);
		robot.inithyoujou();
		robot.setvmae(vmae);

		for(int i=0;i<tirenum;i++) {
			tire1[i] = new MyCaterpillarTire();
			tire1[i].sides = 30;
			if (i==0){tire1[i].sides = 10;}
			tire1[i].setSyokix(0.65*(i-1));
			tire1[i].setSyokiy(0);
			tire1[i].setSyokiz(0.8);
			tire1[i].setvmae(vmae);

			tire2[i] = new MyCaterpillarTire();
			tire2[i].sides = 30;
			if (i==0){tire2[i].sides = 10;}
			tire2[i].setSyokix(0.65*(i-1));
			tire2[i].setSyokiy(0);
			tire2[i].setSyokiz(-0.8);
			tire2[i].setvmae(vmae);

			core[i]= new MyCaterpillarCore();
			core[i].sides=10;
			core[i].setSyokix(0.65*(i-1));
			core[i].setSyokiy(0);
			core[i].setSyokiz(0);
			core[i].setvmae(vmae);
		}

		for(int i=0;i<2;i++){
			cover1[i]=new MyCaterpillarCover();
			cover1[i].setSyokix(0);
			cover1[i].setSyokiz(0.8);
			cover1[i].setvmae(vmae);
			cover2[i]=new MyCaterpillarCover();
			cover2[i].setSyokix(0);
			cover2[i].setSyokiz(-0.8);
			cover2[i].setvmae(vmae);
			if(i==1){
				cover1[i].setSyokiy(-0.04);
				cover2[i].setSyokiy(-0.04);
			}else{
				cover1[i].setSyokiy(0.49);
				cover2[i].setSyokiy(0.49);
			}


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
		 // Allocate a robot

		 robotinit();


	}

	/**
	 * Draw the scene
	 */

	private static void drawrobot(GLAutoDrawable drawable,GL2 gl){


		gl.glPushMatrix();
		if (robot != null)
			robot.draw(drawable);
		gl.glPopMatrix();

		for (int i=0;i<tirenum;i++) {
			gl.glPushMatrix();
			if (tire1[i] != null)
				tire1[i].draw(drawable);
			gl.glPopMatrix();

			gl.glPushMatrix();
			if (tire2[i] != null)
				tire2[i].draw(drawable);
			gl.glPopMatrix();

			gl.glPushMatrix();
			if (core[i] != null)
				core[i].draw(drawable);
			gl.glPopMatrix();
		}

		for(int i=0;i<2;i++){
			gl.glPushMatrix();
			if (cover1[i] != null)
				cover1[i].draw(drawable);
			gl.glPopMatrix();

			gl.glPushMatrix();
			if (cover2[i] != null)
				cover2[i].draw(drawable);
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

  public static void armchange(int mode,int id ){
     robot.armchange(mode,id);
  }

	public static void draw(GLAutoDrawable drawable) {
		if(drawable == null) return;

		GL2 gl = drawable.getGL().getGL2();
		 gl.glLightModeli(GL2.GL_LIGHT_MODEL_TWO_SIDE, GL2.GL_TRUE);


		drawrobot(drawable,gl);
	}

	/**
	 * Reset the movement
	 */
	public static void resetMovement() {

		// Reset the position of the robot
		robotreset();
	}
	public static void back() {

		robotback();
	}

	public static void turn(int right) {//right 90 down 180...みたいな
			robotturn(right);
	}
}
