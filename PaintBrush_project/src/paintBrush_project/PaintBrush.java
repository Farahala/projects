package paintBrush_project;

import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class PaintBrush extends Applet {

    Button redButton, greenButton, blueButton, ovalButton, lineButton, RecButton, penButton, clearButton, eraserButton;
    Checkbox filled, Dotted;
    Color c;

    Boolean ovalFlag = false;
    Boolean RecFlag = false;
    Boolean LineFlag = false;
    Boolean dottedfalge = false;
    Boolean penfalge = false;
    Boolean erase = false;

    int x1, x2, y1, y2;
    int lx1, ly1, lx2, ly2;
    int Rx1, Ry1, Rx2, Ry2;
    int height, width;
    int Rheight, Rwidth;

    ArrayList<Shape> points = new ArrayList<>();
    ArrayList<Line> FreeHand = new ArrayList<>();
    ArrayList<Line> Erase = new ArrayList<>();

    Line Pen = new Line();
       Line Eraser = new Line();

    Shape L = new Line();
    Shape O = new Oval();
    Shape R = new Rectangular();

    int select_shape;
    int sizze;
    //int erase;
    int oldx, oldy, newx, newy;
      int Eoldx, Eoldy, Enewx, Enewy;
    

    public void init() {
        c=Color.BLACK;
        // create all the buttons
        redButton = new Button("");
        greenButton = new Button("");
        blueButton = new Button("");
        redButton.setBackground(Color.RED);
        greenButton.setBackground(Color.GREEN);
        blueButton.setBackground(Color.BLUE);

        ovalButton = new Button("Oval");
        lineButton = new Button("Line");
        RecButton = new Button("Rectangle");
        penButton = new Button("Pen");
        filled = new Checkbox("FillColor");
        clearButton = new Button("Clear");
        eraserButton = new Button("Eraser");
        Dotted = new Checkbox("Dotted");
        sizze = 0;

        // add buttons
        add(redButton);
        add(greenButton);
        add(blueButton);
        add(ovalButton);
        add(lineButton);
        add(RecButton);
        add(penButton);
        add(filled);
        add(clearButton);
        add(eraserButton);
        add(Dotted);

        ovalButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                ovalFlag = true;
                RecFlag = false;
                LineFlag = false;
                erase = false;
                penfalge = false;
                //System.out.println("oval");

            }
        }
        );
        RecButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                RecFlag = true;
                LineFlag = false;
                ovalFlag = false;
                erase = false;
                penfalge = false;

            }
        });
        lineButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                LineFlag = true;
                ovalFlag = false;
                RecFlag = false;
                penfalge = false;
                erase = false;

                //System.out.println("line");
            }
        });

        penButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // if (e.getSource().equals(penButton))
                {
                    LineFlag = false;
                    ovalFlag = false;
                    RecFlag = false;
                    erase = false;
                    penfalge = true;
                }
            }
        });

        eraserButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    erase = true;
                    LineFlag = false;
                    ovalFlag = false;
                    RecFlag = false;
                    penfalge = false;
                }
            }
        });
        clearButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                {
                    sizze = 1;
                }
                repaint();
            }

        });

        // button action
        redButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                {
                    c = Color.RED;
                    repaint();
                }
            }
        });

        greenButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                {
                    c = Color.GREEN;
                    repaint();
                }
            }
        });

        blueButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                {
                    c = Color.BLUE;
                    repaint();
                }
            }
        });

        //  mouse lister
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                //if (dottedfalge==true)

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (ovalFlag == true) {
                    O = new Oval();
                    select_shape = 2;
                    O.setColor(c);
                    x1 = e.getX();
                    y1 = e.getY();
                   
                    O.setDotted(Dotted.getState());
                    O.setFilled(filled.getState());
                    // repaint();

                }
                //System.out.println("oval created");

                if (RecFlag == true) {
                    select_shape = 3;

                    R = new Rectangular();
                    R.setColor(c);
                    Rx1 = e.getX();
                    Ry1 = e.getY();
                  
                    R.setDotted(Dotted.getState());
                    R.setFilled(filled.getState());

                }
                if (LineFlag == true) {

                    select_shape = 1;
                    L = new Line();
                    lx1 = e.getX();
                    ly1 = e.getY();
                    L.setColor(c);

                   
                    //System.out.println("line created");
                    L.setDotted(Dotted.getState());
                    L.setFilled(filled.getState());

                }
                //pen//
                if (penfalge == true) {
                    Pen = new Line();

                    Pen.setColor(c);
                    oldx = e.getX();
                    oldy = e.getY();
                   

                }
                //erase//
                if (erase == true) {
                    Eraser  = new Line();

                    Eoldx = e.getX();
                    Eoldy = e.getY();
                  
                    Eraser.setColor(Color.WHITE);

                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {

                if (ovalFlag == true) {

                  
                    if (x2 > x1 && y1 > y2) {

                        O.setDim1(x1);
                        O.setDim2(y2);
                        O.setDim3(width);
                        O.setDim4(height);

                    }
                    if (x1 > x2 && y1 > y2) {

                        O.setDim1(x2);
                        O.setDim2(y2);
                        O.setDim3(width);
                        O.setDim4(height);
                        //   points.add(O);

                    }
                    if (x1 > x2 && y2 > y1) {

                        O.setDim1(x2);
                        O.setDim2(y1);
                        O.setDim3(width);
                        O.setDim4(height);
                        // points.add(O);

                    }
                    if (x2 > x1 && y2 > y1) {

                        O.setDim1(x1);
                        O.setDim2(y1);
                        O.setDim3(width);
                        O.setDim4(height);
                        //points.add(O);

                    }

                    points.add(O);
                    x1 = 0;
                    y1 = 0;

                    x2 = 0;
                    y2 = 0;
                    repaint();
                }
                if (RecFlag == true) {
                    if (Rx2 > Rx1 && Ry1 > Ry2) {

                        R.setDim1(Rx1);
                        R.setDim2(Ry2);
                        R.setDim3(Rwidth);
                        R.setDim4(Rheight);

                    }
                    if (Rx1 > Rx2 && Ry1 > Ry2) {

                        R.setDim1(Rx2);
                        R.setDim2(Ry2);
                        R.setDim3(Rwidth);
                        R.setDim4(Rheight);
                       
                    }
                    if (Rx1 > Rx2 && Ry2 > Ry1) {

                        R.setDim1(Rx2);
                        R.setDim2(Ry1);
                        R.setDim3(Rwidth);
                        R.setDim4(Rheight);
                       

                    }
                    if (Rx2 > Rx1 && Ry2 > Ry1) {

                        R.setDim1(Rx1);
                        R.setDim2(Ry1);
                        R.setDim3(Rwidth);
                        R.setDim4(Rheight);
                       

                    }

                    points.add(R);
                    Rx1 = 0;
                    Ry1 = 0;

                    Rx2 = 0;
                    Ry2 = 0;
                   
                    repaint();
                }

                if (LineFlag == true) {
                    L.setDim1(lx1);
                    L.setDim2(ly1);

                    L.setDim3(lx2);
                    L.setDim4(ly2);
                    points.add(L);
                    lx1 = 0;
                    ly1 = 0;

                    lx2 = 0;
                    ly2 = 0;
                    repaint();
                }
                if (penfalge == true) {
                    
                    oldx = 0;
                    oldy = 0;
                    newx = 0;
                    newy = 0;

                    repaint();
                }
                  if (erase == true) {
                  
                    Eoldx = 0;
                    Eoldy = 0;
                    Enewx = 0;
                    Enewy = 0;

                    repaint(); 
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                if (ovalFlag == true) {

                    x2 = e.getX();
                    y2 = e.getY();

                    if (x2 > x1 && y1 > y2) {
                        width = x2 - x1;
                        height = y1 - y2;

                    }
                    if (x1 > x2 && y1 > y2) {
                        width = x1 - x2;
                        height = y1 - y2;

                    }
                    if (x1 > x2 && y2 > y1) {

                        width = x1 - x2;
                        height = y2 - y1;

                    }
                    if (x2 > x1 && y2 > y1) {

                        width = x2 - x1;
                        height = y2 - y1;

                    }
                    
                    repaint();

                }
                if (RecFlag == true) {
                    
                    Rx2 = e.getX();
                    Ry2 = e.getY();

                    if (Rx2 > Rx1 && Ry1 > Ry2) {
                        Rwidth = Rx2 - Rx1;
                        Rheight = Ry1 - Ry2;

                    }
                    if (Rx1 > Rx2 && Ry1 > Ry2) {
                        Rwidth = Rx1 - Rx2;
                        Rheight = Ry1 - Ry2;

                    }
                    if (Rx1 > Rx2 && Ry2 > Ry1) {

                        Rwidth = Rx1 - Rx2;
                        Rheight = Ry2 - Ry1;

                    }
                    if (Rx2 > Rx1 && Ry2 > Ry1) {

                        Rwidth = Rx2 - Rx1;
                        Rheight = Ry2 - Ry1;

                    }
                    repaint();
                }
                if (LineFlag == true) {
                    lx2 = e.getX();
                    ly2 = e.getY();
                   
                    repaint();
                }
                if (penfalge == true) {
                    newx = e.getX();
                    newy = e.getY();
                    Pen.setDim1(oldx);
                    Pen.setDim2(oldy);
                    Pen.setDim3(newx);
                    Pen.setDim4(newy);
                    FreeHand.add(Pen);
                    points.add(Pen);
                    Pen = new Line();
                    Pen.setColor(c);
                    oldx = newx;
                    oldy = newy;
                    Pen.setDim1(oldx);
                    Pen.setDim2(oldy);
                    repaint();
                }
                if (erase == true) {
                    Enewx = e.getX();
                    Enewy = e.getY();
                    Eraser .setDim3(Enewx);
                    Eraser .setDim4(Enewy);
                   
                    points.add(Eraser );
                    Eraser = new Line();
                   Eraser .setColor(Color.WHITE);
                    Eoldx = Enewx;
                    Eoldy = Enewy;
                   Eraser .setDim1(Eoldx);
                    Eraser .setDim2(Eoldy);
                    repaint();
                }

            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });

    }

    @Override
    public void paint(Graphics g) {
      

        for (int i = 0; i < points.size(); i++) {

            /**
             * ********line************
             */
            
            if (points.get(i).getDotted() && (LineFlag == true || penfalge == true)) {
                points.get(i).Dotted(g);
               continue;
            }
            if ((LineFlag == true || penfalge == true)) {
                points.get(i).draw(g);

            }
            if (points.get(i).getFilled() && (LineFlag == true || penfalge == true)) {
                points.get(i).filled(g);
            }

            /**
             * ****************oval********************
             */
            if (points.get(i).getDotted() && ovalFlag == true) {
                points.get(i).Dotted(g);
                continue;
            }


            if (points.get(i).getFilled() && ovalFlag == true) {
                points.get(i).draw(g);
                points.get(i).filled(g);
                

            }

            if (ovalFlag == true) {
                points.get(i).draw(g);
            }

            /**
             * ****************Rec********************
             */
            if (points.get(i).getDotted() && RecFlag == true) {
                points.get(i).Dotted(g);

                continue;

            }

            if (points.get(i).getFilled() && RecFlag == true) {
                points.get(i).draw(g);
                points.get(i).filled(g);
            }
            
            if (RecFlag == true) {
                points.get(i).draw(g);
            }
            /**
             * **********erase*************
             */
             if (points.get(i).getDotted() &&erase == true) {
                   // points.get(i).filled(g);
                points.get(i).Dotted(g);

                continue;

            }
             else if (points.get(i).getFilled() && erase== true ) {
                points.get(i).draw(g);
                points.get(i).filled(g);
            }
              
           
              else   if (erase == true) {
                points.get(i).draw(g);

            }
        }
 /*************************************/
        
        /******line*****/
        if (lx1 != 0 && lx2 != 0 && ly1 != 0 && ly2 != 0) {
             g.setColor(c);

            g.drawLine(lx1, ly1, lx2, ly2);
        }
        /*********Easer********/
         if (Eoldx != 0 && Enewx != 0 && Eoldy != 0 && Enewy != 0) {
             g.setColor(Color.WHITE);
            g.drawLine(Eoldx, Eoldy, Enewx, Enewy);
       }
         /*******freehand***********/
        if (oldx != 0 && newx != 0 && oldy != 0 && newy != 0) {
             g.setColor(c);
            g.drawLine(oldx, oldy, newx, newy);
        }
        /******Rectangle*******/
        if (Rx1 != 0 && Rx2 != 0 && Ry1 != 0 && Ry2 != 0) {
             g.setColor(c);
            if (Rx2 > Rx1 && Ry1 > Ry2) {
             
                   
                g.drawRect(Rx1, Ry2, Rwidth, Rheight);
            }
            if (Rx1 > Rx2 && Ry1 > Ry2) {
                g.drawRect(Rx2, Ry2, Rwidth, Rheight);

            }
            if (Rx1 > Rx2 && Ry2 > Ry1) {
                g.drawRect(Rx2, Ry1, Rwidth, Rheight);

            }
            if (Rx2 > Rx1 && Ry2 > Ry1) {
                g.drawRect(Rx1, Ry1, Rwidth, Rheight);

            }

        }
        /**oval**/
        if (x1 != 0 && x2 != 0 && y1 != 0 && y2 != 0) {
             g.setColor(c);
            if (x2 > x1 && y1 > y2) {
                g.drawOval(x1, y2, width, height);

            }
            if (x1 > x2 && y1 > y2) {
                g.drawOval(x2, y2, width, height);

            }
            if (x1 > x2 && y2 > y1) {
                g.drawOval(x2, y1, width, height);

            }
            if (x2 > x1 && y2 > y1) {
                g.drawOval(x1, y1, width, height);

            }

        }
/*************clear****************/
        if (sizze == 1) {
            Dimension size = this.getSize();
            g.clearRect(0, 0, size.width, size.height);
            points.clear();
            FreeHand.clear();
            sizze = 0;

        }
    }

    
}
