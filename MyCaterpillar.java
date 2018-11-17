/**
 * Model of a car
 */

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.gl2.GLUT;


public class MyCaterpillar {

    // Colors
    float color[] = { 0.0f, 1.0f, 0.0f, 1.0f };
    float black[] = {0.0f,0.0f,0.0f,1.0f};
    float silver[] = { 0.5f, 0.5f, 0.5f, 1.0f };
    float green[] = {0.0f,1.0f,0.0f,1.0f};

    // Positions of vertices

    double vertex_tirepart[][] = {
            { -0.1, 0.0, -0.5 },
            {  0.1, 0.0, -0.5 },
            {  0.1, 0.02, -0.5 },
            { -0.1, 0.02, -0.5 },
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
    double transform = 1.0;


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
    public void setTransform(double t) {
        transform = t;
    }

    /**
     * Calculate the movement (rotation angle)
     */
    public void calculateMovement() {
        r += velocity;
        if (r >= 3600) {
            r = 0;
        }
    }


    /**
     * Reset the movement (reset the rotation angle)
     */
    public void resetMovement() {
        r = 0;
    }

    private void draw_tire_part(GLAutoDrawable drawable, GL2 gl, GLUT glut){
        for(int h=0;h<5;++h) {
            for (int j = 0; j < 6; ++j) {//面を一個作る
                //ポリゴンの描写を始めるよ
                gl.glBegin(GL2.GL_POLYGON);
                //変数 normal[j] に設定されている 3 個の実数を、j 番目の四角形の法線ベクトルとして指定するよ
                gl.glNormal3dv(normal[j], 0);
                gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);
                gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, black, 0);
                for (int i = 0; i < 4; ++i) {//頂点を決める
                    double[] tyoutenlist={0,0,0};
                    tyoutenlist[0]=vertex_tirepart[face[j][i]][0]+0.25*h;
                    tyoutenlist[1]=vertex_tirepart[face[j][i]][1];
                    tyoutenlist[2]=vertex_tirepart[face[j][i]][2];
                    gl.glVertex3dv(tyoutenlist, 0);
                }
                gl.glEnd();
                gl.glBegin(GL2.GL_POLYGON);
                gl.glNormal3dv(normal[j], 0);
                gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);
                gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, green, 0);
                for (int i = 0; i < 4; ++i) {//頂点を決める
                    double[] tyoutenlist = vertex_tirepart[face[j][i]];
                    tyoutenlist[0]=vertex_tirepart[face[j][i]][0]+0.25*h;
                    tyoutenlist[1]=vertex_tirepart[face[j][i]][1]+0.02;
                    tyoutenlist[2]=vertex_tirepart[face[j][i]][2];
                    gl.glVertex3dv(tyoutenlist, 0);
                }
                gl.glEnd();
            }
        }
    }


    private void draw_tires(GLAutoDrawable drawable, GL2 gl, GLUT glut){
        draw_tire_part(drawable,gl,glut);
    }

    private void draw_tire_core(GLAutoDrawable drawable, GL2 gl, GLUT glut){

    }

    private void draw_foot(GLAutoDrawable drawable, GL2 gl, GLUT glut){
        draw_tires(drawable,gl,glut);
        draw_tire_core(drawable,gl,glut);
    }


    /**
     * Draw the car
     */
    public void draw(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        GLUT glut = new GLUT();
        gl.glTranslated(0.0, 0.0, transform);

        // Set reflection coefficients

        draw_foot(drawable,gl,glut);

        calculateMovement();
    }



}
