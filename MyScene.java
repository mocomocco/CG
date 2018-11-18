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
	/**
	 * Initialization
	 */

	private static void robotinit(){
		caterpillars1 = new MyCaterpillar[18];
		caterpillars2 = new MyCaterpillar[18];
		robot1 = new MyRobot();
		double vmae;
		vmae=-0.01;
		/*robot1.setColor(0.0, 1.0, 0.0);
		robot1.setVelocity(5);
		robot1.setTransform(1.5);*/
		for (int i=0 ;i<18;i++){
			caterpillars1[i]=new MyCaterpillar();
			caterpillars1[i].id=1;
			caterpillars1[i].setSyokiy(0);
			caterpillars1[i].setSyokiz(0.5);
			caterpillars1[i].setvmae(vmae);

			caterpillars2[i]=new MyCaterpillar();
			caterpillars2[i].id=2;
			caterpillars2[i].setSyokiy(0);
			caterpillars2[i].setSyokiz(-0.5);
			caterpillars2[i].setvmae(vmae);


			if (i<5){//0,1,2,3,4
				caterpillars1[i].setr(0);
				caterpillars1[i].setSyokix(1.3-0.35*i);
				caterpillars2[i].setr(0);
				caterpillars2[i].setSyokix(1.3-0.35*i);
			}else if (i<=8){//5,6,7,8
				caterpillars1[i].setr(350*(i-4));
				caterpillars1[i].setSyokix(-0.1);
				caterpillars2[i].setr(350*(i-4));
				caterpillars2[i].setSyokix(-0.1);
			}else if (i<=13){//9,10,11,12,13
				caterpillars1[i].setr(1800);
				caterpillars1[i].setSyokix(-0.1+0.35*(i-9));
				caterpillars2[i].setr(1800);
				caterpillars2[i].setSyokix(-0.1+0.35*(i-9));
			}else if(i<=17){//14,15,16,17
				caterpillars1[i].setr(1800+350*(i-13));
				caterpillars1[i].setSyokix(1.3);
				caterpillars2[i].setr(1800+350*(i-13));
				caterpillars2[i].setSyokix(1.3);
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

		for (int i=0;i<18;i++){
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
	}
	
}
