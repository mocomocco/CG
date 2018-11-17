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
	static MyCaterpillar caterpillar3=null;
	static MyCaterpillar caterpillar4=null;
	static MyCaterpillar caterpillar5=null;
	static MyCaterpillar caterpillar6=null;
	static MyCaterpillar caterpillar7=null;
	static MyCaterpillar caterpillar8=null;
	static MyCaterpillar[] caterpillars;
	/**
	 * Initialization
	 */

	private static void robotinit(){
		caterpillars = new MyCaterpillar[16];
		robot1 = new MyRobot();
		/*robot1.setColor(0.0, 1.0, 0.0);
		robot1.setVelocity(5);
		robot1.setTransform(1.5);*/
		for (int i=0 ;i<16;i++){
			caterpillars[i]=new MyCaterpillar();
			caterpillars[i].id=i;
			caterpillars[i].setSyokiy(0);
			caterpillars[i].setSyokiz(0.5);
			System.out.println(i);

			if (i<5){//0,1,2,3,4
				caterpillars[i].setr(0);
				caterpillars[i].setSyokix(1.3-0.35*i);
			}else if (i<=7){//5,6,7
				caterpillars[i].setr(350*(i-4));
				caterpillars[i].setSyokix(-0.1);
			}else if (i<=12){//8,9,10,11,12
				caterpillars[i].setr(1800);
				caterpillars[i].setSyokix(-0.1+0.35*(i-8));
			}else if(i<=15){//13,14,15
				caterpillars[i].setr(1800+350*(i-12));
				caterpillars[i].setSyokix(1.3);
			}
		}
		/*
		caterpillar1=new MyCaterpillar();
		caterpillar1.setSyokix(-0.1);
		caterpillar1.setSyokiy(0);
		caterpillar1.setSyokiz(0.5);
		caterpillar1.setr(0);
		caterpillar1.id=0;
		caterpillar2=new MyCaterpillar();
		caterpillar2.setSyokix(0.25);
		caterpillar2.setSyokiy(0);
		caterpillar2.setSyokiz(0.5);
		caterpillar2.id=1;
		caterpillar3=new MyCaterpillar();
		caterpillar3.setSyokix(0.6);
		caterpillar3.setSyokiy(0);
		caterpillar3.setSyokiz(0.5);
		caterpillar3.id=2;
		caterpillar4=new MyCaterpillar();
		caterpillar4.setSyokix(0.95);
		caterpillar4.setSyokiy(0);
		caterpillar4.setSyokiz(0.5);
		caterpillar4.id=3;
		caterpillar5=new MyCaterpillar();
		caterpillar5.setSyokix(1.3);
		caterpillar5.setSyokiy(0);
		caterpillar5.setSyokiz(0.5);
		caterpillar5.id=4;
		caterpillar6=new MyCaterpillar();
		caterpillar6.setSyokix(-0.1);
		caterpillar6.setSyokiy(0);
		caterpillar6.setSyokiz(0.5);
		caterpillar6.setr(350);
		caterpillar6.id=5;
		caterpillar7=new MyCaterpillar();
		caterpillar7.setSyokix(-0.1);
		caterpillar7.setSyokiy(0);
		caterpillar7.setSyokiz(0.5);
		caterpillar7.setr(700);
		caterpillar7.id=6;
		caterpillar8=new MyCaterpillar();
		caterpillar8.setSyokix(-0.1);
		caterpillar8.setSyokiy(0);
		caterpillar8.setSyokiz(0.5);
		caterpillar8.setr(1050);
		caterpillar8.id=7;
*/
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

		for (int i=0;i<16;i++){
			gl.glPushMatrix();
			if(caterpillars[i] != null)
				caterpillars[i].draw(drawable);
			gl.glPopMatrix();
		}/*
		gl.glPushMatrix();
		if(caterpillar1 != null)
			caterpillar1.draw(drawable);
		gl.glPopMatrix();
		gl.glPushMatrix();
		if(caterpillar2 != null)
			caterpillar2.draw(drawable);
		gl.glPopMatrix();
		gl.glPushMatrix();
		if(caterpillar3 != null)
			caterpillar3.draw(drawable);
		gl.glPopMatrix();
		gl.glPushMatrix();
		if(caterpillar4 != null)
			caterpillar4.draw(drawable);
		gl.glPopMatrix();
		gl.glPushMatrix();
		if(caterpillar5 != null)
			caterpillar5.draw(drawable);
		gl.glPopMatrix();
		gl.glPushMatrix();
		if(caterpillar6 != null)
			caterpillar6.draw(drawable);
		gl.glPopMatrix();
		gl.glPushMatrix();
		if(caterpillar7 != null)
			caterpillar7.draw(drawable);
		gl.glPopMatrix();
		gl.glPushMatrix();
		if(caterpillar8 != null)
			caterpillar8.draw(drawable);
		gl.glPopMatrix();*/
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
