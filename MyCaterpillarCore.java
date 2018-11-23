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
    void Cylinder(double radius, double height, int sides,GLAutoDrawable drawable, GL2 gl, GLUT glut){
        int i;
        double step = 3.141592 *2.0/(double)sides;
        double t;

        /*上*/
       // gl.glNormal3d(0.0,1.0,0.0);
        gl.glNormal3d(0.0,1.0,0.0);
        //gl.glBegin(gl.GL_TRIANGLE_FAN);
        gl.glBegin(GL2.GL_POLYGON);
       // gl.glVertex3d(0.0, height, 0.0);
        /*for(i=0; i<=sides; i++){
            t = step*(double)i;
            setlist(tyoutenlist,radius*Math.sin(t), height, radius*Math.cos(t));
            gl.glVertex3dv(tyoutenlist,0);
        }
        gl.glEnd();*/


        /*下*/

        gl.glNormal3d(0.0,-1.0,0.0);
        //gl.glBegin(gl.GL_TRIANGLE_
        // FAN);
        gl.glBegin(GL2.GL_POLYGON);
        //gl.glVertex3dv(0.0, -height, 0.0);
        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);
        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, red, 0);
        for(i=0; i<=sides; i++){
            t = step*(double)i;
            setlist(tyoutenlist,radius*Math.sin(t), -height, radius*Math.cos(t));
            gl.glVertex3dv(tyoutenlist,0);
        }
        gl.glEnd();
        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);
        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, white, 0);
        /*横*/
        //gl.glBegin(gl.GL_QUAD_STRIP);
        for(i=0; i<=sides; i++){
            gl.glBegin(GL2.GL_POLYGON);
            double theta = step*(double)i;
            double x =Math.sin(theta);
            double z = Math.cos(theta);
            double nextx=Math.sin(theta + step);

            double nextz = Math.cos(theta+ step);
            double normallist ;

            
            setlist(tyoutenlist,x,0.0,z);
            gl.glNormal3dv(tyoutenlist,0);

            setlist(tyoutenlist,radius*x, height, radius*z);
            gl.glVertex3dv(tyoutenlist,0);
            setlist(tyoutenlist,radius*x, -height, radius*z);
            gl.glVertex3dv(tyoutenlist,0);
            setlist(tyoutenlist,radius*nextx, -height, radius*nextz);
            gl.glVertex3dv(tyoutenlist,0);
            setlist(tyoutenlist,radius*nextx, height, radius*nextz);
            gl.glVertex3dv(tyoutenlist,0);

            //gl.glVertex3d(radius*nextx, -height, radius*z);
            gl.glEnd();
        }



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

        gl.glTranslated(-0.0,0.25,0.0);
        // draw_foot(drawable,gl,glut);
        gl.glRotated(90, 1.0, 0.0, 0.0);

        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);
        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, white, 0);
        Cylinder(0.05, 1.0, sides,drawable, gl,glut);

        //gl.glRotated(-900, 1.0, 0.0, 0.0);
        gl.glTranslated(0.0,-0.25,0.0);//}



        calculateMovement();
    }



}
