

import java.io.File;
import java.util.Scanner;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class SCAN_CONVERSION_LINE_DRAWING implements GLEventListener{
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
	   	  
	      
	      SCAN_CONVERSION_LINE_DRAWING l = new SCAN_CONVERSION_LINE_DRAWING();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 400);
	      
	      final JFrame frame = new JFrame ("straight Line");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
	      
	   }
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
       	  //gl.glBegin (GL2.GL_POINTS);//static field
       	  try {
       		Double[]ad=new Double[8];
       		int c=0;
      		Scanner r=new Scanner(new File("lab03input"));
            System.out.println("print");
            while(r.hasNext()){
      			Double i=r.nextDouble();
      			System.out.println(i);
      			ad[c]=i;
      			c++;
      		}
            //-----------------------------------------------------
            System.out.println("For line one");
            Double x=ad[3]-ad[1];
      		System.out.println("up = "+x);
      		Double y=ad[2]-ad[0];
      		System.out.println("Down = "+y);
      		Double m=x/y;
      		System.out.println("Slope = "+m);
      		if(ad[2]<ad[0]){
      			for(Double count=ad[2];count>=ad[0];count=count-0.01){
          			//System.out.println("count = "+count);
          			if(m>0){
          				//gl.glBegin (GL2.GL_POINTS);
          				ad[0]=ad[0]-0.001;
              			ad[1]=ad[1]-0.001;
              			gl.glVertex2d(ad[0],ad[1]);
              			System.out.println("condition for m=1 and x= "+ad[0]);
              			System.out.println("condition for m=1 and y= "+ad[1]);
              			//gl.glEnd();
              		}else if(m<0){
              			//gl.glBegin (GL2.GL_POINTS);
              			ad[0]=ad[0]+0.001;
              			ad[1]=ad[1]+0.001;
              			gl.glVertex2d(ad[0],ad[1]);
              			System.out.println("condition for m=-1 and x= "+ad[0]);
              			System.out.println("condition for m=-1 and y= "+ad[1]);
              			//gl.glEnd();
              		}else if(m==0.0){
              			//gl.glBegin (GL2.GL_POINTS);
              			ad[0]=ad[0]+0.001;
              			gl.glVertex2d(ad[0],ad[1]);
              			System.out.println("condition for m=0 and x= "+ad[0]);
              			System.out.println("condition for m=0 and y= "+ad[1]);
              			//gl.glEnd();
              		}else if(m.isInfinite()){
              			//gl.glBegin (GL2.GL_POINTS);
              			ad[1]=ad[1]+0.001;
              			gl.glVertex2d(ad[0],ad[1]);
              			System.out.println("condition for m=infinte and x= "+ad[0]);
              			System.out.println("condition for m=infinte and y= "+ad[1]);
              			//gl.glEnd();
              		}else{
              			System.out.println("For any other slope declare invalid");
              		}
          		}
      			
      		}else{
      			for(Double count=ad[0];count<=ad[2];count=count+0.01){
      				if(m>1){
          				m=m/10;
          			}
          			//System.out.println("count = "+count);
          			if(m>0){
          				gl.glBegin (GL2.GL_POINTS);
          				ad[0]=ad[0]+0.01;
              			ad[1]=ad[1]+0.01;
              			gl.glVertex2d(ad[0],ad[1]);
              			System.out.println("condition for m=1 and x= "+ad[0]);
              			System.out.println("condition for m=1 and y= "+ad[1]);
              			gl.glEnd();
              		}else if(m<0){
              			gl.glBegin (GL2.GL_POINTS);
              			ad[0]=ad[0]-0.001;
              			ad[1]=ad[1]-0.001;
              			gl.glVertex2d(ad[0],ad[1]);
              			System.out.println("condition for m=-1 and x= "+ad[0]);
              			System.out.println("condition for m=-1 and y= "+ad[1]);
              			gl.glEnd();
              		}else if(m==0.0){
              			gl.glBegin (GL2.GL_POINTS);
              			ad[0]=ad[0]+0.01;
              			gl.glVertex2d(ad[0],ad[1]);
              			System.out.println("condition for m=0 and x= "+ad[0]);
              			System.out.println("condition for m=0 and y= "+ad[1]);
              			gl.glEnd();
              		}else if(m.isInfinite()){
              			gl.glBegin (GL2.GL_POINTS);
              			ad[1]=ad[1]+0.01;
              			gl.glVertex2d(ad[0],ad[1]);
              			System.out.println("condition for m=infinte and x= "+ad[0]);
              			System.out.println("condition for m=infinte and y= "+ad[1]);
              			gl.glEnd();
              		}else{
              			System.out.println("For any other slope declare invalid");
              		}
          		}
      			
      		}
      		gl.glEnd();
      		
      	//-----------------------------------------------------
            System.out.println("For line two");
            Double xl2=ad[7]-ad[5];
      		System.out.println("up = "+xl2);
      		Double yl2=ad[6]-ad[4];
      		System.out.println("Down = "+yl2);
      		Double ml2=xl2/yl2;
      		System.out.println("Slope for line two = "+ml2);
      		gl.glBegin (GL2.GL_POINTS);
      		for(Double count=ad[4];count<=ad[6];count=count+0.01){
      			//System.out.println("count = "+count);
      			if(ml2>1){
      				ml2=ml2/10;
      			}
      			if(ml2>0){
      				gl.glBegin (GL2.GL_POINTS);
      				ad[4]=ad[4]+0.01;
          			ad[5]=ad[5]+0.01;
          			gl.glVertex2d(ad[4],ad[5]);
          			System.out.println("condition for m=1 and x= "+ad[4]);
          			System.out.println("condition for m=1 and y= "+ad[5]);
          			gl.glEnd();
          		}else if(ml2<0){
          			gl.glBegin (GL2.GL_POINTS);
          			ad[4]=ad[4]-0.01;
          			ad[5]=ad[5]-0.01;
          			gl.glVertex2d(ad[4],ad[5]);
          			System.out.println("condition for m=-1 and x= "+ad[4]);
          			System.out.println("condition for m=-1 and y= "+ad[5]);
          			gl.glEnd();
          		}else if(ml2==0.0){
          			gl.glBegin (GL2.GL_POINTS);
          			ad[4]=ad[4]+0.01;
          			gl.glVertex2d(ad[4],ad[5]);
          			System.out.println("condition for m=0 and x= "+ad[4]);
          			System.out.println("condition for m=0 and y= "+ad[5]);
          			gl.glEnd();
          		}else if(ml2.isInfinite()){
          			gl.glBegin (GL2.GL_POINTS);
          			ad[5]=ad[5]+0.01;
          			gl.glVertex2d(ad[4],ad[5]);
          			System.out.println("condition for m=infinte and x= "+ad[4]);
          			System.out.println("condition for m=infinte and y= "+ad[5]);
          			gl.glEnd();
          		}else{
          			System.out.println("For any other slope declare invalid");
          		}
      		}
      		
		} catch (Exception e) {
			// TODO: handle exception
		}
          gl.glEnd();
          
      
   }
   
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }

   
   public void init(GLAutoDrawable drawable) {
      // method body
	   //4. drive the display() in a loop
	    }
   
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
   }
   //end of main
}//end of classimport javax.media.opengl.GL2;

