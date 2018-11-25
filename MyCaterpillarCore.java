/**
 * Model of a CaterpillarCore
 */

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.gl2.GLUT;



public class MyCaterpillarCore {

    // Colors
    float color[] = { 0.0f, 1.0f, 0.0f, 1.0f };
    float black[] = {0.0f,0.0f,0.0f,1.0f};
    float silver[] = { 0.5f, 0.5f, 0.5f, 1.0f };
    float green[] = {0.0f,1.0f,0.0f,1.0f};
    float white[] = {1.0f,1.0f,1.0f,1.0f};
    float red[] = {1.0f,0.0f,0.0f,1.0f};
    float blue[] = {0.0f,0.0f,1.0f,1.0f};
    float orange[] ={0.5f,0.5f,0.0f,1.0f};

    double vertex_tirepart[][] = {
            { -0.1, 0.0, -0.3 },
            {  0.1, 0.0, -0.3 },
            {  0.1, 0.02, -0.3 },
            { -0.1, 0.02, -0.3 },
            { -0.1, 0.0,  0.5 },
            {  0.1, 0.0,  0.5 },
            {  0.1, 0.02,  0.5 },
            { -0.1, 0.02,  0.5 }
    };

    // IDs of vertices of faces
    int face[][] = {
            { 0, 3, 2, 1 },
            { 1, 2, 6, 5 },
            { 5, 6, 7, 4 },
            { 4, 7, 3, 0 },
            { 4, 0, 1, 5 },
            { 3, 7, 6, 2 }
    };

    // Normal vector of vertices
    double normal[][] = {
            { 0.0, 0.0, 1.0 },
            {-1.0, 0.0, 0.0 },
            { 0.0, 0.0,-1.0 },
            { 1.0, 0.0, 0.0 },
            { 0.0, 1.0, 0.0 },
            { 0.0,-1.0, 0.0 }
    };

    double tire_housen[][]={
            {0.0,0.0,1.0},
            {0.0,0.0,-1.0},
            {0.0,1.0,0.0},
            {0.0,-1.0,0.0},
            {0.0,0.866,0.5}
    };

    // Rotation angle
    int r = 0;

    // Speed
    int velocity = 5;

    // Distance from the center of the orbit
    double transformx = 0;
    double transformy = 0;
    double transformz = 0;

    double syokix=0;
    double syokiy=0;
    double syokiz=0;

    double dx = 0;
    double dy = 0;
    double dz = 0;
    int dr=0;

    double vmae =0;

    int sides;
    int id = 0;




    /**
     * Set color
     */
    public void setColor(double r, double g, double b) {
        color[0] = (float)r;
        color[1] = (float)g;
        color[2] = (float)b;
        color[3] = 1.0f;
    }

    /**
     * Set velocity
     */
    public void setVelocity(int v) {
        velocity = v;
    }

    /**
     * Set transform
     */

    public void setsides(int t) {
        sides = t;
    }

    public void setSyokix(double t) {
        syokix = t;
        transformx=syokix;
    }
    public void setSyokiy(double t) {
        syokiy = t;
        transformy=syokiy;
    }
    public void setSyokiz(double t) {
        syokiz = t;
        transformz=syokiz;
    }
    public void setr(int t) {
        r = t;
    }

    public void setdx(double t) {
        dx=t;
    }

    public void setdy(double t) {
        dy=t;
    }

    public void setdz(double t) {
        dz=t;
    }

    public void setvmae(double t) {
        vmae=t;
    }
    /**
     * Calculate the movement (rotation angle)
     */
    public void calculateMovement() {
        dx+=vmae*Math.cos(Math.toRadians(dr*0.1));
        dz+=vmae*Math.sin(Math.toRadians(dr*0.1));
        //System.out.println(Math.toRadians(dr*0.1) +" " + Math.cos(Math.toRadians(dr*0.1)) +" "+ Math.sin(Math.toRadians(dr*0.1)));
    }


    /**
     * Reset the movement (reset the rotation angle)
     */
    public void resetMovement() {
        dx=0;
        dy=0;
        dz=0;
        dr=0;
        transformx=syokix;
        transformy=syokiy;
        transformz=syokiz;
    }

    public void Turn(int right) {
        dr+=right;
    }

    private void setlist(double[] list1,double x,double y,double z){
        list1[0]=x;
        list1[1]=y;
        list1[2]=z;
    }
    double[] tyoutenlist = {0,0,0};
    void Cylinder(double radius, double height, int sides,GLAutoDrawable drawable, GL2 gl, GLUT glut) {

        glut.glutSolidCylinder(radius/2.0, height*1.0, sides, 10); //(4)円筒

        gl.glRotated(180, 0.0, 1.0, 0.0);
        glut.glutSolidCylinder(radius/2.0, height*1.0, sides, 10); //(4)円筒
    }

    /**
     * Draw the car
     */
    public void draw(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        GLUT glut = new GLUT();

        gl.glTranslated(dx,dy,dz);
        gl.glRotated(((double)dr*-0.1),0.0,1.0,0.0);
        gl.glTranslated(transformx,transformy,transformz);
        gl.glTranslated(0.0,0.25,0.0);
        // draw_foot(drawable,gl,glut);

        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);
        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, white, 0);

        Cylinder(0.05, 1.0, sides,drawable, gl,glut);


        gl.glTranslated(0.0,-0.25,0.0);

        calculateMovement();
    }



}
