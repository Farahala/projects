
package paintBrush_project;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;


 class Rectangular extends Shape {

    public Rectangular() {
    }

    @Override
    public void draw(Graphics g) {
       
        g.setColor(colored);
        g.drawRect(getDim1(), getDim2(), getDim3(), getDim4());
      
    }

    @Override
    public void filled(Graphics g) {
        g.setColor(colored);
        g.fillRect(getDim1(), getDim2(), getDim3(), getDim4());
       
    }
    public void Dotted(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g.create();
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);
        g2d.setColor(colored);
        g2d.drawRect(getDim1(), getDim2(), getDim3(), getDim4());
        //draw(g);
        g2d.dispose();
    }
    
}