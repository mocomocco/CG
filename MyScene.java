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
	static MyCaterpillar caterpillar1=null;
	static MyCaterpillar caterpillar2=null;
	
	/**
	 * Initialization
	 */

	private static void robotinit(){
		robot1 = new MyRobot();
		/*robot1.setColor(0.0, 1.0, 0.0);
		robot1.setVelocity(5);
		robot1.setTransform(1.5);*/
		caterpillar1=new MyCaterpillar();
		caterpillar1.setTransformx(-0.1);
		caterpillar1.setTransformy(0);
		caterpillar1.setTransformz(0.5);
		caterpillar1.id=0;
		caterpillar2=new MyCaterpillar();
		caterpillar2.setTransformx(1.6);
		caterpillar2.setTransformy(0);
		caterpillar2.setTransformz(0.5);
		caterpillar2.id=1;
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

		gl.glPushMatrix();
		if(caterpillar1 != null)
			caterpillar1.draw(drawable);
		gl.glPopMatrix();
		gl.glPushMatrix();
		if(caterpillar2 != null)
			caterpillar2.draw(drawable);
		gl.glPopMatrix();
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
		gl.glPushMatrix();
	    if(car1 != null)
	    	car1.draw(drawable);
	    gl.glPopMatrix();

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
