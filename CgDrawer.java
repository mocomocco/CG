/**
 * Drawing functions
 */


import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.glu.gl2.GLUgl2;
import com.jogamp.opengl.util.gl2.GLUT;


public class CgDrawer implements GLEventListener {
	GLAutoDrawable glAD;
	
	// Positions of light sources
	static float light0pos[] = { 0.0f, -3.0f, -5.0f, 1.0f };
	static float light1pos[] = { 5.0f, 3.0f, 3.0f, 1.0f };


	
	/**
	 * Initialization of drawing setting
	 */
    public void init(GLAutoDrawable drawable) {
        float silver[] = {0.5f, 0.5f, 0.5f, 1.0f};
    	
        this.glAD = drawable;
      
        GL2 gl= drawable.getGL().getGL2();
	    
        // Initialization of OpenGL setting
		gl.glEnable(GL.GL_RGBA);
		gl.glEnable(GL2.GL_DEPTH);
        gl.glEnable(GL2.GL_DOUBLE);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glEnable(GL2.GL_NORMALIZE);
        gl.glEnable(GL.GL_CULL_FACE);
        gl.glCullFace(GL.GL_BACK);
        
        // Initialization of light sources
        gl.glEnable(GL2.GL_LIGHTING);
        gl.glEnable(GL2.GL_LIGHT0);
        gl.glEnable(GL2.GL_LIGHT1);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, silver, 0);
        gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_DIFFUSE, silver, 0);
        
        // Specification of background color背景色設定(R,G,B,_)
        gl.glClearColor(0.7f, 0.7f, 0.7f, 1.0f);
        
	}
    
    /**
     * Called when the shape of the window is modified
     */
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();
        GLUgl2 glu = new GLUgl2();

        if (height <= 0) 
            height = 1;
        float h = (float) width / (float) height;

        // Set the viewport
        gl.glViewport(0, 0, width, height);

        // Set the matrix for coordinate system transformation
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(30.0, h, 1.0, 100.0);

        // Set the matrix for object transformation
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        
		 
    }
    

    /**
     * Called when redraw is needed
     */
    public void display(GLAutoDrawable drawable) {
        draw(drawable);
    }
    

    /**
     * Dummy function (DO NOT remove)
     */
    public void displayChanged(
    	GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    	;
    }

    

	/**
	 * Called when redraw is needed
	 */
	public void draw(GLAutoDrawable drawable) {
		 GL2 gl = drawable.getGL().getGL2();
		 GLUgl2 glu = new GLUgl2();

		 // Clear the scene
		 gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

		 // Set the viewpoint
	     gl.glLoadIdentity();
		 glu.gluLookAt(3.0, 2.0, 5.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
		//(ex,ey,ez):視点の位置(cx,cy,cz):目標の位置(ux,uy,uz)ウィンドウに表示される画像の上方向
		 // Set the positions of light sources
		 gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, light0pos, 0);
		 gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_POSITION, light1pos, 0);
		
		 // Draw
		 MyScene.draw(drawable);
		 
	}
	
	
	public GLAutoDrawable getGLAutoDrawable() {
		return glAD;
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
