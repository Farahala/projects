
package paintBrush_project;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;


 public abstract class Shape  {
   private int Dim1 , Dim2 , Dim3 ,Dim4;
    protected Boolean dotted=false , filled =false;
    protected Color colored ;
   // int cnt=0;

    public Shape() {
        Dim1= Dim2 =Dim3 =Dim4=0;
        colored=Color.BLACK;
    }

    public void setDim1(int Dim1) {
        this.Dim1 = Dim1;
    }

    public void setDim2(int Dim2) {
        this.Dim2 = Dim2;
    }

    public void setDim3(int Dim3) {
        this.Dim3 = Dim3;
    }

    public void setDim4(int Dim4) {
        this.Dim4 = Dim4;
    }

    public int getDim1() {
        return Dim1;
    }

    public int getDim2() {
        return Dim2;
    }

    public int getDim3() {
        return Dim3;
    }

    public int getDim4() {
        return Dim4;
    }
    public void setDotted(Boolean d)
    { 
         dotted=d;
    }
     public boolean getDotted()
    { 
         return dotted;
    }
    public void setFilled( Boolean f)
    {filled=f;}
     public boolean getFilled()
    { 
        return filled;
    }
     public void setColor(Color c)
     {  colored=c;
     }
      public Color getColor()
     {  return colored;
     }
   // public Color SetColor()
   public abstract void draw (Graphics g);
     public abstract void filled (Graphics g);
     public abstract void Dotted(Graphics g);

     
      
    
}
