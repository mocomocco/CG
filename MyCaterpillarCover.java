/**
 * Model of a Caterpillar
 */

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.gl2.GLUT;


public class MyCaterpillarCover {

    // Colors
    float color[] = { 0.0f, 1.0f, 0.0f, 1.0f };
    float black[] = {0.0f,0.0f,0.0f,1.0f};
    float silver[] = { 0.5f, 0.5f, 0.5f, 1.0f };
    float green[] = {0.0f,1.0f,0.0f,1.0f};
    float white[] = {1.0f,1.0f,1.0f,1.0f};
    float red[] = {1.0f,0.0f,0.0f,1.0f};
    float blue[] = {0.0f,0.0f,1.0f,1.0f};
    float orange[] ={0.5f,0.5f,0.0f,1.0f};

    double vertex_cover[][] = {
            { -0.7, 0.02, -0.2 },
            {  0.7, 0.02, -0.2 },
            {  0.7, 0.025, -0.2 },
            { -0.7, 0.025, -0.2 },
            { -0.7, 0.02,  0.2 },
            {  0.7, 0.02,  0.2 },
            {  0.7, 0.025,  0.2 },
            { -0.7, 0.025,  0.2 }
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
    int syokir=0;

    int isBack=0;

    double dx = 0;
    double dy = 0;
    double dz = 0;
    int dr = 0;

    double vmae =0;

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
        syokir=t;
        r = t;
    }

    public void setdr(int t) {
        dr=t;
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

    public void Back() {
        if(isBack==0){
            isBack=1;
        }else{
            isBack=0;
        }
    }

    public void Turn(int right) {
        dr+=right;
    }
    /**
     * Calculate the movement (rotation angle)
     */
    public void calculateMovement() {
        dx+=vmae*Math.cos(Math.toRadians(dr*0.1));
        dz+=vmae*Math.sin(Math.toRadians(dr*0.1));
    }


    /**
     * Reset the movement (reset the rotation angle)
     */
    public void resetMovement() {
        dx=0;
        dy=0;
        dz=0;
        dr=0;
        r = syokir;
        transformx=syokix;
        transformy=syokiy;
        transformz=syokiz;
    }

    private void draw_cover(GLAutoDrawable drawable, GL2 gl, GLUT glut){
        for (int j = 0; j < 6; ++j) {//面を一個作る
            //ポリゴンの描写を始めるよ
            gl.glBegin(GL2.GL_POLYGON);
            //変数 normal[j] に設定されている 3 個の実数を、j 番目の四角形の法線ベクトルとして指定するよ
            gl.glNormal3dv(normal[j], 0);
            /*gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, black, 0);*/
            /*if(id==1){
                gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE,blue, 0);
            }*/
            for (int i = 0; i < 4; ++i) {//頂点を決める
                double[] tyoutenlist={0,0,0};
                tyoutenlist[0]=vertex_cover[face[j][i]][0];
                tyoutenlist[1]=vertex_cover[face[j][i]][1];
                tyoutenlist[2]=vertex_cover[face[j][i]][2];
                gl.glVertex3dv(tyoutenlist, 0);
            }
            gl.glEnd();
        }

    }



    /**
     * Draw the car
     */
    public void draw(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        GLUT glut = new GLUT();


        //gl.glRotated(((double)dr*0.1),0.0,1.0,0.0);
        gl.glTranslated(dx,dy,dz);
        gl.glRotated(((double)dr*(-0.1)),0.0,1.0,0.0);
        //gl.glTranslated(dx,0.0,0.0);

        gl.glTranslated(transformx,transformy,transformz);
        //gl.glRotated(((double)r * 0.1), 0.0, 0.0, 1.0);
        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);
        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, black, 0);
        //gl.glTranslated(-0.0,0.26,0.0);
        draw_cover(drawable,gl,glut);
        /*gl.glTranslated(0.0,0.53,0.0);

        draw_cover(drawable,gl,glut);
        gl.glTranslated(0.0,-0.53
                ,0.0);
        gl.glTranslated(0.0,-0.26,0.0);//}
*/
        calculateMovement();
    }



}
