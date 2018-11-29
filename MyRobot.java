/**
 * Model of a foot
 */

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.gl2.GLUT;
import java.util.Arrays;


public class MyRobot {

    // Colors
    float color[] = { 0.0f, 1.0f, 0.0f, 1.0f };
    float black[] = {0.0f,0.0f,0.0f,1.0f};
    float gray[] = {0.5f,0.5f,0.5f,1.0f};
    float silver[] = { 0.5f, 0.5f, 0.5f, 1.0f };
    float green[] = {0.0f,1.0f,0.0f,1.0f};
    float white[] = {1.0f,1.0f,1.0f,1.0f};
    float red[] = {1.0f,0.0f,0.0f,1.0f};
    float blue[] = {0.0f,0.0f,1.0f,1.0f};
    float orange[] ={0.5f,0.5f,0.0f,1.0f};
    float yellow[] ={1.0f,1.0f,0.0f,1.0f};
    float lightcolor[]={0.0f,1.0f,0.0f,1.0f};
    float signalcolor1[]=green;
    float signalcolor2[]=gray;
    float signalcolor3[]=gray;

    double yokohaba=1.0;
    double tatehaba=0.95;
    double haratakasa=0.90;
    double munetakasa=0.20;
    double atamatakasa=0.60;
    double armkibantakasa=0.60;
    double hidarikadoububunnnotakasa=0.0;
    double migikadoububunnnotakasa=0.0;
    double udenemotonagasa=yokohaba/40.0;//yokohaba/5.0;
    double udesakinagasa=yokohaba/10.0;//yokohaba/5.0;
    double ninoudenagasa=yokohaba/3.0;
    double migiudexr=900;//腕根元の回転（体にとっての上下方向）
    double migiudezr=0;//腕先の回転
    double migiudeyr=0;//腕根元の回転（体にとっての前後方向）
    double hidariudexr=900;//腕根元の回転（体にとっての上下方向）
    double hidariudezr=0;//腕先の回転
    double hidariudeyr=0;//腕根元の回転（体にとっての前後方向）

    double vertex_chokuhoutai[][]={
            { -1.0, -1.0, -1.0 },
            {  1.0, -1.0, -1.0 },
            {  1.0, 1.0, -1.0 },
            { -1.0, 1.0, -1.0 },
            { -1.0, -1.0,  1.0 },
            {  1.0, -1.0,  1.0 },
            {  1.0, 1.0,1.0 },
            { -1.0, 1.0,1.0 }
    };


    double vertex_armkibanmizo[][] = {
            { -yokohaba/100.0, -armkibantakasa*0.9, -yokohaba/10.0 },
            {  yokohaba/100.0, -armkibantakasa*0.9, -yokohaba/10.0 },
            {  yokohaba/100.0, armkibantakasa*0.9, -yokohaba/10.0 },
            { -yokohaba/100.0, armkibantakasa*0.9, -yokohaba/10.0 },
            { -yokohaba/100.0, -armkibantakasa*0.9,  yokohaba/10.0 },
            {  yokohaba/100.0, -armkibantakasa*0.9,  yokohaba/10.0 },
            {  yokohaba/100.0, armkibantakasa*0.9,  yokohaba/10.0 },
            { -yokohaba/100.0, armkibantakasa*0.9,  yokohaba/10.0 }
    };

    double vertex_armkiban[][]={
            { -yokohaba/9.0, -armkibantakasa, -yokohaba/50.0 },
            {  yokohaba/9.0, -armkibantakasa, -yokohaba/50.0 },
            {  yokohaba/9.0, armkibantakasa, -yokohaba/50.0 },
            { -yokohaba/9.0, armkibantakasa, -yokohaba/50.0 },
            { -yokohaba/9.0, -armkibantakasa,  yokohaba/50.0 },
            {  yokohaba/9.0, -armkibantakasa,  yokohaba/50.0 },
            {  yokohaba/9.0, armkibantakasa,  yokohaba/50.0 },
            { -yokohaba/9.0, armkibantakasa,  yokohaba/50.0 }
    };

    double vertex_armmizo[][] = {
            { -yokohaba/20.0, -armkibantakasa, -yokohaba/20.0 },
            {  yokohaba/20.0, -armkibantakasa, -yokohaba/20.0 },
            {  yokohaba/20.0, armkibantakasa, -yokohaba/20.0 },
            { -yokohaba/20.0, armkibantakasa, -yokohaba/20.0 },
            { -yokohaba/20.0, -armkibantakasa,  yokohaba/20.0 },
            {  yokohaba/20.0, -armkibantakasa,  yokohaba/20.0 },
            {  yokohaba/20.0, armkibantakasa,  yokohaba/20.0 },
            { -yokohaba/20.0, armkibantakasa,  yokohaba/20.0 }
    };

    double vertex_kadoububunkiban[][] = {
            { -yokohaba/20.0, -yokohaba/20.0, -yokohaba/20.0 },
            {  yokohaba/20.0, -yokohaba/20.0, -yokohaba/20.0 },
            {  yokohaba/20.0, yokohaba/20.0, -yokohaba/20.0 },
            { -yokohaba/20.0, yokohaba/20.0, -yokohaba/20.0 },
            { -yokohaba/20.0, -yokohaba/20.0,  yokohaba/20.0 },
            {  yokohaba/20.0, -yokohaba/20.0,  yokohaba/20.0 },
            {  yokohaba/20.0, yokohaba/20.0,  yokohaba/20.0 },
            { -yokohaba/20.0, yokohaba/20.0,  yokohaba/20.0 }
    };

    double vertex_kadoububunnemoto[][] = {
            { -yokohaba/10.0, -yokohaba/10.0 , -udenemotonagasa},
            {  yokohaba/10.0, -yokohaba/10.0 , -udenemotonagasa},
            {  yokohaba/10.0, yokohaba/10.0 , -udenemotonagasa},
            { -yokohaba/10.0, yokohaba/10.0 ,-udenemotonagasa},
            { -yokohaba/10.0,  -yokohaba/10.0 , udenemotonagasa},
            {  yokohaba/10.0,  -yokohaba/10.0 , udenemotonagasa},
            {  yokohaba/10.0,  yokohaba/10.0 , udenemotonagasa},
            { -yokohaba/10.0,  yokohaba/10.0 , udenemotonagasa}
    };

    double vertex_kadoububunsaki[][] = {
            { -yokohaba/20.0, -yokohaba/20.0 , -1},
            {  yokohaba/20.0, -yokohaba/20.0 , -1},
            {  yokohaba/20.0, yokohaba/20.0 , -1},
            { -yokohaba/20.0, yokohaba/20.0 ,-1},
            { -yokohaba/20.0,  -yokohaba/20.0 , 1},
            {  yokohaba/20.0,  -yokohaba/20.0 , 1},
            {  yokohaba/20.0,  yokohaba/20.0 , 1},
            { -yokohaba/20.0,  yokohaba/20.0 , 1}
    };

    double vertex_ninoude[][] = {
            { -yokohaba/10.0, -yokohaba/20.0 , -ninoudenagasa},
            {  yokohaba/10.0, -yokohaba/20.0 , -ninoudenagasa},
            {  yokohaba/10.0, yokohaba/20.0 , -ninoudenagasa},
            { -yokohaba/10.0, yokohaba/20.0 ,-ninoudenagasa},
            { -yokohaba/10.0,  -yokohaba/20.0 , ninoudenagasa},
            {  yokohaba/10.0,  -yokohaba/20.0 , ninoudenagasa},
            {  yokohaba/10.0,  yokohaba/20.0 , ninoudenagasa},
            { -yokohaba/10.0,  yokohaba/20.0 , ninoudenagasa}
    };

    double vertex_hara[][] = {
            { -yokohaba, -haratakasa, -tatehaba },
            {  yokohaba, -haratakasa, -tatehaba },
            {  yokohaba, haratakasa, -tatehaba },
            { -yokohaba, haratakasa, -tatehaba },
            { -yokohaba, -haratakasa,  tatehaba },
            {  yokohaba, -haratakasa,  tatehaba },
            {  yokohaba, haratakasa,  tatehaba },
            { -yokohaba, haratakasa,  tatehaba }
    };

    double vertex_mune[][] = {
            { -yokohaba, -munetakasa, -tatehaba },
            {  yokohaba, -munetakasa, -tatehaba },
            {  yokohaba, munetakasa, -tatehaba },
            { -yokohaba, munetakasa, -tatehaba },
            { -yokohaba, -munetakasa,  tatehaba },
            {  yokohaba, -munetakasa,  tatehaba },
            {  yokohaba, munetakasa,  tatehaba },
            { -yokohaba, munetakasa,  tatehaba }
    };

    double vertex_atama[][] = {
            { -yokohaba, -atamatakasa, -tatehaba },
            {  yokohaba, -atamatakasa, -tatehaba },
            {  yokohaba, atamatakasa, -tatehaba },
            { -yokohaba, atamatakasa, -tatehaba },
            { -yokohaba, -atamatakasa,  tatehaba },
            {  yokohaba, -atamatakasa,  tatehaba },
            {  yokohaba, atamatakasa,  tatehaba },
            { -yokohaba, atamatakasa,  tatehaba }
    };

    double vertex_light[][] = {
            { -yokohaba*0.9, -atamatakasa/10.0, -tatehaba/40.0 },
            {  yokohaba*0.9, -atamatakasa/10.0, -tatehaba/40.0 },
            {  yokohaba*0.9, atamatakasa/10.0, -tatehaba/40.0 },
            { -yokohaba*0.9, atamatakasa/10.0, -tatehaba/40.0 },
            { -yokohaba*0.9, -atamatakasa/10.0,  tatehaba/40.0 },
            {  yokohaba*0.9, -atamatakasa/10.0,  tatehaba/40.0 },
            {  yokohaba*0.9, atamatakasa/10.0,  tatehaba/40.0 },
            { -yokohaba*0.9, atamatakasa/10.0,  tatehaba/40.0 }
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
    int[][] hyoujou;


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

    public void inithyoujou() {
        hyoujou=new int[11][21];
        for(int i=0;i<11;i++){
          Arrays.fill(hyoujou[i],0);
        }

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
    public void set_lightcolor(float[] color){
      for(int i=0;i<3;i++){
            lightcolor[i]=color[i];
       }
    }

    public void setvmae(double t) {
        vmae=t;
        if(t<0) {
            smile();
            set_lightcolor(green);
            signalcolor1=green;
            signalcolor2=gray;
            signalcolor3=gray;
        }else{
            inithyoujou();
            set_hyoujou("b", 15, 1);
            set_hyoujou("a", 10, 2);
            set_hyoujou("c", 5, 1);
            set_hyoujou("k", 0, 2);
            set_lightcolor(red);
            signalcolor1=gray;
            signalcolor2=yellow;
            signalcolor3=gray;
        }
    }
    /**
     * Calculate the movement (rotation angle)
     */
    public void calculateMovement() {
        dx+=vmae*Math.cos(Math.toRadians(dr*0.1));
        dz+=vmae*Math.sin(Math.toRadians(dr*0.1));
        //System.out.println(Math.toRadians(dr*0.1) +" " + Math.cos(Math.toRadians(dr*0.1)) +" "+ Math.sin(Math.toRadians(dr*0.1)));
    }

  public void armchange(int mode, int id){
     if(mode==0){
      if(id==1){
        if((migikadoububunnnotakasa<armkibantakasa*0.7)){
         migikadoububunnnotakasa+=yokohaba*id/20.0;
        }
      }else{
        if((migikadoububunnnotakasa>-armkibantakasa*0.7) ){
         migikadoububunnnotakasa+=yokohaba*id/20.0;
        }
      }
     }
     if(mode==1){
      if(id==1){
        if((hidarikadoububunnnotakasa<armkibantakasa*0.7)){
         hidarikadoububunnnotakasa+=yokohaba*id/20.0;
        }
      }else{
        if((hidarikadoububunnnotakasa>-armkibantakasa*0.7) ){
         hidarikadoububunnnotakasa+=yokohaba*id/20.0;
        }
      }
     }
     if(mode==2){
      if(id==1){
        if(migiudexr<900){
        migiudexr+=20;
        hidariudexr+=20;
        }
      }else{
        if(migiudeyr<900){
        migiudeyr+=100;
        hidariudeyr+=100;
        }
      }
     }
     if(mode==3){
      if(id==1){
          if(hidariudexr>=-850){
	        hidariudexr-=20;
          migiudexr-=20;
	        }
      }else{
          if(hidariudeyr>=-850){
	        hidariudeyr-=20;
          migiudeyr-=20;
	        }
      }
     }
     if(mode==4){
      if(id==1){
         if(udesakinagasa<yokohaba*2.0){
         udesakinagasa+=id*0.1;
         }
      }else{
         if(udesakinagasa>yokohaba/10.0+yokohaba/10.0){
         udesakinagasa+=id*0.1;
          }
      }
     }

   }
    /**
     * Reset the movement (reset the rotation angle)
     */
    public void resetMovement() {
        dx=0;
        dy=0;
        dz=0;
        dr=0;
        migiudexr=900;
        migiudeyr=0;
        migiudezr=0;
        hidariudexr=900;
        hidariudeyr=0;
        hidariudezr=0;
        migikadoububunnnotakasa=0;
        hidarikadoububunnnotakasa=0;
        udesakinagasa=yokohaba/10.0;
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


    public void draw_chokuhoutai(GLAutoDrawable drawable, GL2 gl, GLUT glut,double xhaba,double yhaba,double zhaba,float[] color,float[] hansha){
        for (int j = 0; j < 6; ++j) {//面を一個作る
            //ポリゴンの描写を始めるよ
            gl.glBegin(GL2.GL_POLYGON);
            //変数 normal[j] に設定されている 3 個の実数を、j 番目の四角形の法線ベクトルとして指定するよ
            gl.glNormal3dv(normal[j], 0);
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, hansha, 0);
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, color, 0);
            for (int i = 0; i < 4; ++i) {//頂点を決める
                double[] tyoutenlist={0,0,0};
                tyoutenlist[0]=vertex_chokuhoutai[face[j][i]][0]*xhaba;
                tyoutenlist[1]=vertex_chokuhoutai[face[j][i]][1]*yhaba;
                tyoutenlist[2]=vertex_chokuhoutai[face[j][i]][2]*zhaba;
                gl.glVertex3dv(tyoutenlist, 0);
            }
            gl.glEnd();
        }

    }

    public void draw_foot(GLAutoDrawable drawable, GL2 gl, GLUT glut){
      draw_chokuhoutai(drawable,gl,glut,0.5,0.20,0.5,white,silver);
    }

    public void draw_hara(GLAutoDrawable drawable, GL2 gl, GLUT glut){
        for (int j = 0; j < 6; ++j) {//面を一個作る
            //ポリゴンの描写を始めるよ
            gl.glBegin(GL2.GL_POLYGON);
            //変数 normal[j] に設定されている 3 個の実数を、j 番目の四角形の法線ベクトルとして指定するよ
            gl.glNormal3dv(normal[j], 0);
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, white, 0);
            for (int i = 0; i < 4; ++i) {//頂点を決める
                double[] tyoutenlist={0,0,0};
                tyoutenlist[0]=vertex_hara[face[j][i]][0];
                tyoutenlist[1]=vertex_hara[face[j][i]][1];
                tyoutenlist[2]=vertex_hara[face[j][i]][2];
                gl.glVertex3dv(tyoutenlist, 0);
            }
            gl.glEnd();
        }

    }

    public void draw_mune(GLAutoDrawable drawable, GL2 gl, GLUT glut){
        for (int j = 0; j < 6; ++j) {//面を一個作る
            //ポリゴンの描写を始めるよ
            gl.glBegin(GL2.GL_POLYGON);
            //変数 normal[j] に設定されている 3 個の実数を、j 番目の四角形の法線ベクトルとして指定するよ
            gl.glNormal3dv(normal[j], 0);
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, green, 0);
            for (int i = 0; i < 4; ++i) {//頂点を決める
                double[] tyoutenlist={0,0,0};
                tyoutenlist[0]=vertex_mune[face[j][i]][0];
                tyoutenlist[1]=vertex_mune[face[j][i]][1];
                tyoutenlist[2]=vertex_mune[face[j][i]][2];
                gl.glVertex3dv(tyoutenlist, 0);
            }
            gl.glEnd();
        }

    }

    public void draw_atama(GLAutoDrawable drawable, GL2 gl, GLUT glut){
        for (int j = 0; j < 6; ++j) {//面を一個作る
            //ポリゴンの描写を始めるよ
            gl.glBegin(GL2.GL_POLYGON);
            //変数 normal[j] に設定されている 3 個の実数を、j 番目の四角形の法線ベクトルとして指定するよ
            gl.glNormal3dv(normal[j], 0);
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, white, 0);
            for (int i = 0; i < 4; ++i) {//頂点を決める
                double[] tyoutenlist={0,0,0};
                tyoutenlist[0]=vertex_atama[face[j][i]][0];
                tyoutenlist[1]=vertex_atama[face[j][i]][1];
                tyoutenlist[2]=vertex_atama[face[j][i]][2];
                gl.glVertex3dv(tyoutenlist, 0);
            }
            gl.glEnd();
        }
    }

    public void draw_armkiban(GLAutoDrawable drawable, GL2 gl, GLUT glut){
        for (int j = 0; j < 6; ++j) {//面を一個作る
            //ポリゴンの描写を始めるよ
            gl.glBegin(GL2.GL_POLYGON);
            //変数 normal[j] に設定されている 3 個の実数を、j 番目の四角形の法線ベクトルとして指定するよ
            gl.glNormal3dv(normal[j], 0);
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, black, 0);
            for (int i = 0; i < 4; ++i) {//頂点を決める
                double[] tyoutenlist={0,0,0};
                tyoutenlist[0]=vertex_armkiban[face[j][i]][0];
                tyoutenlist[1]=vertex_armkiban[face[j][i]][1];
                tyoutenlist[2]=vertex_armkiban[face[j][i]][2];
                gl.glVertex3dv(tyoutenlist, 0);
            }
            gl.glEnd();
        }

    }

    public void draw_armkibanmizo(GLAutoDrawable drawable, GL2 gl, GLUT glut){
        for (int j = 0; j < 6; ++j) {//面を一個作る
            //ポリゴンの描写を始めるよ
            gl.glBegin(GL2.GL_POLYGON);
            //変数 normal[j] に設定されている 3 個の実数を、j 番目の四角形の法線ベクトルとして指定するよ
            gl.glNormal3dv(normal[j], 0);
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, black, 0);
            for (int i = 0; i < 4; ++i) {//頂点を決める
                double[] tyoutenlist={0,0,0};
                tyoutenlist[0]=vertex_armkibanmizo[face[j][i]][0];
                tyoutenlist[1]=vertex_armkibanmizo[face[j][i]][1];
                tyoutenlist[2]=vertex_armkibanmizo[face[j][i]][2];
                gl.glVertex3dv(tyoutenlist, 0);
            }
            gl.glEnd();
        }

    }
    public void draw_armkadoububun(GLAutoDrawable drawable, GL2 gl, GLUT glut){
      //if((kadoububunnnotakasa < armkibantakasa*0.9) && (  kadoububunnnotakasa > -armkibantakasa*0.9)){

                for (int j = 0; j < 6; ++j) {//面を一個作る
				            //ポリゴンの描写を始めるよ
				            gl.glBegin(GL2.GL_POLYGON);
				            //変数 normal[j] に設定されている 3 個の実数を、j 番目の四角形の法線ベクトルとして指定するよ
				            gl.glNormal3dv(normal[j], 0);
				            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);
				            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, black, 0);
				            for (int i = 0; i < 4; ++i) {//頂点を決める
				                double[] tyoutenlist={0,0,0};
				                tyoutenlist[0]=vertex_kadoububunkiban[face[j][i]][0];
				                tyoutenlist[1]=vertex_kadoububunkiban[face[j][i]][1];
				                tyoutenlist[2]=vertex_kadoububunkiban[face[j][i]][2];
				                gl.glVertex3dv(tyoutenlist, 0);
				            }
				            gl.glEnd();
				        }

      //}
    }

    public void draw_armkadoububunnemoto(GLAutoDrawable drawable, GL2 gl, GLUT glut){
      //if((kadoububunnnotakasa < armkibantakasa*0.9) && (  kadoububunnnotakasa > -armkibantakasa*0.9)){
        //gl.glTranslated(0.0,kadoububunnnotakasa,0.0);
                for (int j = 0; j < 6; ++j) {//面を一個作る
				            //ポリゴンの描写を始めるよ
				            gl.glBegin(GL2.GL_POLYGON);
				            //変数 normal[j] に設定されている 3 個の実数を、j 番目の四角形の法線ベクトルとして指定するよ
				            gl.glNormal3dv(normal[j], 0);
				            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);
				            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, white, 0);
				            for (int i = 0; i < 4; ++i) {//頂点を決める
				                double[] tyoutenlist={0,0,0};
				                tyoutenlist[0]=vertex_kadoububunnemoto[face[j][i]][0];
				                tyoutenlist[1]=vertex_kadoububunnemoto[face[j][i]][1];
				                tyoutenlist[2]=vertex_kadoububunnemoto[face[j][i]][2];
				                gl.glVertex3dv(tyoutenlist, 0);
				            }
				            gl.glEnd();
				        }
        //gl.glTranslated(0.0,-kadoububunnnotakasa,0.0);
      //}
    }

    public void draw_armkadoububunsaki(GLAutoDrawable drawable, GL2 gl, GLUT glut){
      //if((kadoububunnnotakasa < armkibantakasa*0.9) && (  kadoububunnnotakasa > -armkibantakasa*0.9)){
        //gl.glTranslated(0.0,kadoububunnnotakasa,0.0);
                for (int j = 0; j < 6; ++j) {//面を一個作る
				            //ポリゴンの描写を始めるよ
				            gl.glBegin(GL2.GL_POLYGON);
				            //変数 normal[j] に設定されている 3 個の実数を、j 番目の四角形の法線ベクトルとして指定するよ
				            gl.glNormal3dv(normal[j], 0);
				            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);
				            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, white, 0);
				            for (int i = 0; i < 4; ++i) {//頂点を決める
				                double[] tyoutenlist={0,0,0};
				                tyoutenlist[0]=vertex_kadoububunsaki[face[j][i]][0];
				                tyoutenlist[1]=vertex_kadoububunsaki[face[j][i]][1];
				                tyoutenlist[2]=vertex_kadoububunsaki[face[j][i]][2]*udesakinagasa;
				                gl.glVertex3dv(tyoutenlist, 0);
				            }
				            gl.glEnd();
				        }
      //  gl.glTranslated(0.0,-kadoububunnnotakasa,0.0);
      //}
    }

    public void draw_ninoude(GLAutoDrawable drawable, GL2 gl, GLUT glut){
      //if((kadoububunnnotakasa < armkibantakasa*0.9) && (  kadoububunnnotakasa > -armkibantakasa*0.9)){
        //gl.glTranslated(0.0,kadoububunnnotakasa,0.0);
                for (int j = 0; j < 6; ++j) {//面を一個作る
				            //ポリゴンの描写を始めるよ
				            gl.glBegin(GL2.GL_POLYGON);
				            //変数 normal[j] に設定されている 3 個の実数を、j 番目の四角形の法線ベクトルとして指定するよ
				            gl.glNormal3dv(normal[j], 0);
				            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);
				            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, white, 0);
				            for (int i = 0; i < 4; ++i) {//頂点を決める
				                double[] tyoutenlist={0,0,0};
				                tyoutenlist[0]=vertex_ninoude[face[j][i]][0];
				                tyoutenlist[1]=vertex_ninoude[face[j][i]][1];
				                tyoutenlist[2]=vertex_ninoude[face[j][i]][2];
				                gl.glVertex3dv(tyoutenlist, 0);
				            }
				            gl.glEnd();
				        }
        //gl.glTranslated(0.0,-kadoububunnnotakasa,0.0);
      //}
    }


    public void draw_armmizo(GLAutoDrawable drawable, GL2 gl, GLUT glut){
        for (int j = 0; j < 6; ++j) {//面を一個作る
            //ポリゴンの描写を始めるよ
            gl.glBegin(GL2.GL_POLYGON);
            //変数 normal[j] に設定されている 3 個の実数を、j 番目の四角形の法線ベクトルとして指定するよ
            gl.glNormal3dv(normal[j], 0);
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, black, 0);
            for (int i = 0; i < 4; ++i) {//頂点を決める
                double[] tyoutenlist={0,0,0};
                tyoutenlist[0]=vertex_armmizo[face[j][i]][0];
                tyoutenlist[1]=vertex_armmizo[face[j][i]][1];
                tyoutenlist[2]=vertex_armmizo[face[j][i]][2];
                gl.glVertex3dv(tyoutenlist, 0);
            }
            gl.glEnd();
        }
    }

    public void draw_armkadou(GLAutoDrawable drawable, GL2 gl, GLUT glut,int isleft){
         double idou1=-yokohaba/30.0;
         if (isleft==1){idou1=-idou1;}
         gl.glTranslated(0.0,0.0,idou1);
         double kadoububunnnotakasa=migikadoububunnnotakasa;
         if(isleft==1){kadoububunnnotakasa=hidarikadoububunnnotakasa;}
         gl.glTranslated(0.0,kadoububunnnotakasa,0.0);
         draw_armkadoububun(drawable,gl,glut);
         double idou2=-Math.min(udenemotonagasa,yokohaba*2);
         if (isleft==1){idou2=-idou2;}
         gl.glTranslated(0.0,0.0,idou2);
         double idou3= idou2 -yokohaba/10.0;
         if (isleft==1){idou3=-idou3;}
         draw_armkadoububunnemoto(drawable,gl,glut);
         gl.glTranslated(0.0,0.0,idou3);
         draw_armkadoububunsaki(drawable,gl,glut);
         double idou4=-udesakinagasa-0.05;
         if (isleft==1){idou4=-idou4;}
         gl.glTranslated(0.0,0.0,idou4);

             gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, gray, 0);
             gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, gray, 0);
         glut.glutSolidSphere(yokohaba/5.0, 30, 20);
         double udexr=(double)(migiudexr*-0.1);
         double udeyr=(double)(migiudeyr*-0.1);
         double udezr=(double)(migiudezr*-0.1);
         if (isleft==1){
           udexr=(double)(hidariudexr*0.1);
           udeyr=(double)(hidariudeyr*0.1);
           udezr=(double)(hidariudezr*0.1);
         }

         gl.glRotated(udexr,1.0,0.0,0.0);
         gl.glRotated(udeyr,0.0,1.0,0.0);
         gl.glRotated(udezr,0.0,0.0,1.0);
         double idou5=-ninoudenagasa-yokohaba/16.0;
         if(isleft==1){idou5=-idou5;}
         gl.glTranslated(0.0,0.0,idou5);

         draw_ninoude(drawable,gl,glut);
         double idou6=-ninoudenagasa-yokohaba/4.0;
         if(isleft==1){idou6=-idou6;}
         gl.glTranslated(0.0,0.0,idou6);
         gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, gray, 0);
         gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE,white, 0);
         glut.glutSolidCube((float)(yokohaba/2.0));
         gl.glTranslated(0.0,0.0,-idou6);
         gl.glTranslated(0.0,0.0,-idou5);



         gl.glRotated(-udezr,0.0,0.0,1.0);
         gl.glRotated(-udeyr,0.0,1.0,0.0);
         gl.glRotated(-udexr,1.0,0.0,0.0);
         gl.glTranslated(0.0,0.0,-idou4);
         gl.glTranslated(0.0,0.0,-idou3);
         gl.glTranslated(0.0,0.0,-idou2);
        gl.glTranslated(0.0,-kadoububunnnotakasa,0.0);
         gl.glTranslated(0.0,0.0,-idou1);
    }

    public void draw_arm(GLAutoDrawable drawable, GL2 gl, GLUT glut){
        gl.glTranslated(0.0,0.0,tatehaba);
        draw_armkiban(drawable, gl, glut);

        gl.glTranslated(0.0,0.0,-yokohaba/50.0);
        draw_armkibanmizo(drawable,gl,glut);
        gl.glTranslated(0.0,0.0,yokohaba/50.0);

        gl.glTranslated(0.0,armkibantakasa-yokohaba/10.0,0.0);
        glut.glutSolidCube((float)(yokohaba/10.0));
        gl.glTranslated(0.0,-armkibantakasa+yokohaba/10.0,0.0);

        gl.glTranslated(0.0,-armkibantakasa+yokohaba/10.0,0.0);
        glut.glutSolidCube((float)(yokohaba/10.0));
        gl.glTranslated(0.0,armkibantakasa-yokohaba/10.0,0.0);



        gl.glTranslated(yokohaba/9.0,0.0,yokohaba/50.0);
        draw_armmizo(drawable,gl,glut);
        gl.glTranslated(-yokohaba/4.5,0.0,0.0);
        draw_armmizo(drawable,gl,glut);
        gl.glTranslated(yokohaba/9.0,0.0,-yokohaba/50.0);

        draw_armkadou(drawable,gl,glut,1);

        //右

        gl.glTranslated(0.0,0.0,-2*tatehaba);
        draw_armkiban(drawable, gl, glut);

        gl.glTranslated(0.0,0.0,yokohaba/50.0);
        draw_armkibanmizo(drawable,gl,glut);
        gl.glTranslated(0.0,0.0,-yokohaba/50.0);

        gl.glTranslated(0.0,armkibantakasa-yokohaba/10.0,0.0);
        glut.glutSolidCube((float)(yokohaba/10.0));
        gl.glTranslated(0.0,-armkibantakasa+yokohaba/10.0,0.0);

        gl.glTranslated(0.0,-armkibantakasa+yokohaba/10.0,0.0);
        glut.glutSolidCube((float)(yokohaba/10.0));
        gl.glTranslated(0.0,armkibantakasa-yokohaba/10.0,0.0);

        gl.glTranslated(yokohaba/9.0,0.0,-yokohaba/50.0);
        draw_armmizo(drawable,gl,glut);
        gl.glTranslated(-yokohaba/9.0,0.0,0.0);
        //draw_armmizo(drawable,gl,glut);
        gl.glTranslated(-yokohaba/9.0,0.0,0.0);
        draw_armmizo(drawable,gl,glut);
        gl.glTranslated(yokohaba/9.0,0.0,yokohaba/50.0);

        gl.glTranslated(0.0,0.0,yokohaba/40.0);
        draw_armmizo(drawable,gl,glut);
        gl.glTranslated(0.0,0.0,-yokohaba/40.0);

        draw_armkadou(drawable,gl,glut,0);

        gl.glTranslated(0.0,0.0,tatehaba);




    }

    public void normal(){
        inithyoujou();
        for(int yid=2;yid<5;yid++){
            for(int xid=3;xid<6;xid++){
                hyoujou[yid][xid]=1;
            }
            for(int xid=15;xid<18;xid++){
                hyoujou[yid][xid]=1;
            }
        }

        for(int xid=7;xid<14;xid++){
            hyoujou[9][xid]=1;
        }

    }

    public void symmetryhyoujou(int yid,int xid,int colorid){
        hyoujou[yid][xid]=colorid;
        hyoujou[yid][20-xid]=colorid;
    }

    public void smile(){
        inithyoujou();

        symmetryhyoujou(2,3,1);
        symmetryhyoujou(3,4,1);
        symmetryhyoujou(3,5,1);
        symmetryhyoujou(4,3,1);
        symmetryhyoujou(4,3,1);

        symmetryhyoujou(6,2,2);
        symmetryhyoujou(6,3,2);

        symmetryhyoujou(8,6,1);
        for(int i=7;i<11;i++) {
            symmetryhyoujou(9, i, 1);
        }

    }

    public void set_hyoujou(String char1,int xid,int colorid){
        if(char1=="a"){
            hyoujou[1][xid+3]=colorid;
            hyoujou[2][xid+2]=colorid;
            hyoujou[2][xid+4]=colorid;
            for(int i=3;i<10;i++) {
                hyoujou[i][xid + 1] = colorid;
                hyoujou[i][xid + 5] = colorid;
            }
            for(int i=2;i<5;i++){
                hyoujou[5][xid+i]=colorid;
            }
        }
        if(char1=="b"){
            for(int i=2;i<6;i++){
                hyoujou[1][xid+i]=colorid;
                hyoujou[4][xid+i]=colorid;
                hyoujou[9][xid+i]=colorid;
            }
            for(int i=2;i<9;i++){
                if(i!=4) {
                    hyoujou[i][xid + 1] = colorid;
                    hyoujou[i][xid + 5] = colorid;
                }
            }

        }
        if(char1=="c"){
            for(int i=2;i<5;i++){
                hyoujou[1][xid+i]=colorid;
                hyoujou[9][xid+i]=colorid;
            }
            hyoujou[2][xid+1]=colorid;
            hyoujou[2][xid+4]=colorid;
            hyoujou[8][xid+1]=colorid;
            hyoujou[8][xid+4]=colorid;

            for(int i=3;i<8;i++){
                hyoujou[i][xid+5]=colorid;
            }

        }
        if(char1=="k"){
            hyoujou[1][xid+1]=colorid;
            hyoujou[1][xid+2]=colorid;
            hyoujou[1][xid+5]=colorid;
            hyoujou[2][xid+2]=colorid;
            hyoujou[2][xid+5]=colorid;
            hyoujou[3][xid+3]=colorid;
            hyoujou[3][xid+5]=colorid;
            hyoujou[4][xid+3]=colorid;
            hyoujou[4][xid+5]=colorid;
            hyoujou[5][xid+4]=colorid;
            hyoujou[5][xid+5]=colorid;
            hyoujou[6][xid+3]=colorid;
            hyoujou[6][xid+5]=colorid;
            hyoujou[7][xid+2]=colorid;
            hyoujou[7][xid+5]=colorid;
            hyoujou[8][xid+2]=colorid;
            hyoujou[8][xid+5]=colorid;
            hyoujou[9][xid+1]=colorid;
            hyoujou[9][xid+5]=colorid;
        }
        if(char1=="o"){
            for(int i=2;i<5;i++) {
                hyoujou[1][xid+i]=colorid;
                hyoujou[9][xid+i]=colorid;
            }
            for(int i=2;i<9;i++){
                hyoujou[i][xid+1]=colorid;
                hyoujou[i][xid+5]=colorid;
            }
        }
    }

    public void draw_screen(GLAutoDrawable drawable, GL2 gl, GLUT glut){
        float haba=(float)1.8/(float)21.0;
        double xichi=tatehaba-haba;
        double yichi=atamatakasa-haba*2;
        gl.glTranslated(0.0,yichi,xichi);
        for(int yid=0;yid<11;yid++){
          for(int xid=0;xid<21;xid++){
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, black, 0);

            if(hyoujou[yid][xid]==1){
              gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, green, 0);
             }

             if(hyoujou[yid][xid]==2){
                gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, red, 0);
             }

            gl.glTranslated(0.0,-haba*yid,-haba *xid);
            glut.glutSolidCube(haba);
            gl.glTranslated(0.0,haba*yid,haba *xid);
          }
        }
        gl.glTranslated(0.0,-yichi,-xichi);
    }

    public void draw_light(GLAutoDrawable drawable, GL2 gl, GLUT glut,float[] signalcolor){

        for (int j = 0; j < 6; ++j) {//面を一個作る
            //ポリゴンの描写を始めるよ
            gl.glBegin(GL2.GL_POLYGON);
            //変数 normal[j] に設定されている 3 個の実数を、j 番目の四角形の法線ベクトルとして指定するよ
            gl.glNormal3dv(normal[j], 0);
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, black, 0);
            for (int i = 0; i < 4; ++i) {//頂点を決める
                double[] tyoutenlist={0,0,0};
                tyoutenlist[0]=vertex_light[face[j][i]][0];
                tyoutenlist[1]=vertex_light[face[j][i]][1];
                tyoutenlist[2]=vertex_light[face[j][i]][2];
                gl.glVertex3dv(tyoutenlist, 0);
            }
            gl.glEnd();
        }
         gl.glTranslated(0.0,0.0,tatehaba/50.0);
        for (int j = 0; j < 6; ++j) {//面を一個作る
            //ポリゴンの描写を始めるよ
            gl.glBegin(GL2.GL_POLYGON);
            //変数 normal[j] に設定されている 3 個の実数を、j 番目の四角形の法線ベクトルとして指定するよ
            gl.glNormal3dv(normal[j], 0);
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, silver, 0);
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, signalcolor, 0);
            for (int i = 0; i < 4; ++i) {//頂点を決める
                double[] tyoutenlist={0,0,0};
                tyoutenlist[0]=vertex_light[face[j][i]][0];
                tyoutenlist[1]=vertex_light[face[j][i]][1];
                tyoutenlist[2]=vertex_light[face[j][i]][2];
                gl.glVertex3dv(tyoutenlist, 0);
            }
            gl.glEnd();
        }
         gl.glTranslated(0.0,0.0,-tatehaba/50.0);
    }

    public void draw(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        GLUT glut = new GLUT();
        double takasa;
        takasa=0.26;

        gl.glTranslated(dx,dy,dz);
        gl.glRotated(((double)dr*-0.1),0.0,1.0,0.0);
        gl.glTranslated(transformx,transformy,transformz);
        //System.out.println(takasa);
        gl.glTranslated(-0.0,takasa,0.0);
        draw_foot(drawable,gl,glut);
        gl.glTranslated(0.0,-takasa,0.0);

        takasa-=0.01;
        takasa+=vertex_foot[3][1];
        takasa+=haratakasa;
        //System.out.println(takasa+" 1.35 "+vertex_foot[3][1]+" " +vertex_hara[1][1]);
        gl.glTranslated(0.0,takasa,0.0);
        draw_hara(drawable,gl,glut);
        gl.glTranslated(0.0,-takasa,0.0);

        takasa+=haratakasa;
        takasa+=munetakasa;
        //System.out.println(takasa+ " 2.25 "+vertex_hara[3][1]+" " +vertex_mune[1][1]);
        gl.glTranslated(0.0,takasa,0.0);
        draw_mune(drawable,gl,glut);
        gl.glTranslated(0.0,-takasa,0.0);

        gl.glTranslated(0.0,takasa+armkibantakasa/3.0,0.0);
        draw_arm(drawable,gl,glut);
        gl.glTranslated(0.0,-takasa-armkibantakasa/3.0,0.0);

        takasa+=munetakasa;
        takasa+=atamatakasa;
        //System.out.println(takasa+ " 2.65 "+vertex_mune[3][1]+" " +vertex_atama[1][1]);
        gl.glTranslated(0.0,takasa,0.0);
        draw_atama(drawable,gl,glut);
        gl.glTranslated(-yokohaba,0.0,0.0);
        draw_screen(drawable,gl,glut);
        gl.glTranslated(yokohaba,0.0,0.0);
        gl.glTranslated(0.0,-takasa,0.0);

        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, gray, 0);
        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, lightcolor, 0);
        takasa+=atamatakasa;
        gl.glTranslated(-yokohaba/2.0,takasa,-tatehaba/2.0);
        glut.glutSolidSphere(yokohaba/3.0,10,20);
        gl.glTranslated(yokohaba/2.0,-takasa,tatehaba/2.0);

        gl.glTranslated(0.0,takasa,tatehaba);
        gl.glTranslated(0.0,-atamatakasa/5.0,0.0);
        draw_light(drawable,gl,glut,signalcolor1);
        gl.glTranslated(0.0,atamatakasa/5.0,0.0);
        gl.glTranslated(0.0,-takasa,-tatehaba);

        gl.glTranslated(0.0,takasa,tatehaba);
  			gl.glTranslated(0.0,-atamatakasa/2.0,0.0);
  			draw_light(drawable,gl,glut,signalcolor2);
  			gl.glTranslated(0.0,atamatakasa/2.0,0.0);
  			gl.glTranslated(0.0,-takasa,-tatehaba);

        gl.glTranslated(0.0,takasa,tatehaba);
  			gl.glTranslated(0.0,-atamatakasa*0.8,0.0);
  			draw_light(drawable,gl,glut,signalcolor3);
  			gl.glTranslated(0.0,atamatakasa*0.8,0.0);
  			gl.glTranslated(0.0,-takasa,-tatehaba);
        calculateMovement();
    }



}
