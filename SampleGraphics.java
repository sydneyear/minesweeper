import javax.swing.*;  // for JFrame
import java.awt.*;     // for Graphics and Container

public class SampleGraphics
{  
    public static void main (String[] args)
    {
        JFrame win;                 // JFrame Graphics setup
        Container contentPane;
        Graphics g;
      
        win = new JFrame("My First Graphics");  // window setup
        win.setSize(800,800);
        win.setLocation(100,100);
        win.setVisible(true);
      
        contentPane = win.getContentPane();   // activates graphics in window
        g = contentPane.getGraphics();
      
        try {Thread.sleep(400);} catch (Exception e) {}
      
/////////////////////////////////////////////////////////

        g.setColor(new Color(22,46,111));
        g.fillRect(0,0,800,800);   // background
///////////////////////////////////////////////////////////
        g.setColor(new Color(139,178,235));
      
        Polygon hex1 = new Polygon();
            hex1.addPoint(400,360);//top
            hex1.addPoint(435,380);
            hex1.addPoint(435,420);
            hex1.addPoint(400,440);//bottom
            hex1.addPoint(365,420);
            hex1.addPoint(365,380);
            g.fillPolygon(hex1);

        //Polygon hex2 = new Polygon();
            //hex2.addPoint(360,400);
            //hex2.addPoint(380,435);
            //hex2.addPoint(420,435);
            //hex2.addPoint(440,400);
            //hex2.addPoint(420,365);
            //hex2.addPoint(380,365);
            //g.drawPolygon(hex2);

        //Polygon hex3 = new Polygon();
            //hex3.addPoint(400,100);
            //hex3.addPoint(663,250);
            //hex3.addPoint(663,550);
            //hex3.addPoint(400,700);
            //hex3.addPoint(138,550);
            //hex3.addPoint(138,250);
            //g.drawPolygon(hex3);
        
        //Polygon hex4 = new Polygon();
            //hex4.addPoint(400,200);//top
            //hex4.addPoint(575,300);//upper rightt
            //hex4.addPoint(575,500);
            //hex4.addPoint(400,600);//bottom
            //hex4.addPoint(225,500);//bottom left
            //hex4.addPoint(225,300);
            //g.drawPolygon(hex4);

        //Polygon hex5 = new Polygon();
           // hex5.addPoint(400,300);//top
            //hex5.addPoint(488,350);//upper right
            //hex5.addPoint(488,450);
            //hex5.addPoint(400,500);//bottom
            //hex5.addPoint(313,450);//lower left
            //hex5.addPoint(313,350);
            //g.drawPolygon(hex5);

/////////////////////////////////////////////////////////////////////// big outer squares

        Polygon quad1 = new Polygon();
            quad1.addPoint(400,100);
            quad1.addPoint(450,150);
            quad1.addPoint(400,200);//bottom
            quad1.addPoint(350,150);
            g.fillPolygon(quad1);

        Polygon quad2 = new Polygon();
            quad2.addPoint(400,700);
            quad2.addPoint(450,650);
            quad2.addPoint(400,600);
            quad2.addPoint(350,650);
            g.fillPolygon(quad2);

        Polygon quad3 = new Polygon();
            quad3.addPoint(594,231);
            quad3.addPoint(663,250);//on big hex
            quad3.addPoint(648,319);
            quad3.addPoint(575,300);//on small hex
            g.fillPolygon(quad3);

        Polygon quad4 = new Polygon();
            quad4.addPoint(594,567);
            quad4.addPoint(663,550);//big hex
            quad4.addPoint(648,481);
            quad4.addPoint(575,500);//small hex
            g.fillPolygon(quad4);
        
        Polygon quad5 = new Polygon();
            quad5.addPoint(206,567);
            quad5.addPoint(137,550);//big hex
            quad5.addPoint(152,481);
            quad5.addPoint(225,500);//small hex
            g.fillPolygon(quad5);

        Polygon quad6 = new Polygon();
            quad6.addPoint(206,231);
            quad6.addPoint(137,250);//big hex 
            quad6.addPoint(152,319);
            quad6.addPoint(225,300);//small hex
            g.fillPolygon(quad6);


////////////////////////////////////////////////////////////////////////// big inner squares

        Polygon quad7 = new Polygon();
            quad7.addPoint(400,300);//top
            quad7.addPoint(430,330);//right
            quad7.addPoint(400,360);//bottom 
            quad7.addPoint(370,330);//left
            g.fillPolygon(quad7);

        Polygon quad8 = new Polygon();
            quad8.addPoint(400,440);//top
            quad8.addPoint(430,470);//right
            quad8.addPoint(400,500);//bottom 
            quad8.addPoint(370,470);//left
            g.fillPolygon(quad8);

        Polygon quad9 = new Polygon();
            quad9.addPoint(447,339);//top
            quad9.addPoint(488,350);//right big hex
            quad9.addPoint(477,392);//bottom 
            quad9.addPoint(435,380);//left small hex
            g.fillPolygon(quad9);

        Polygon quad10 = new Polygon();
            quad10.addPoint(477,408);//top
            quad10.addPoint(488,450);//right big hex
            quad10.addPoint(447,461);//bottom 
            quad10.addPoint(435,420);//left small hex
            g.fillPolygon(quad10);

        Polygon quad11 = new Polygon();
            quad11.addPoint(353,339);//top
            quad11.addPoint(312,350);//left big hex
            quad11.addPoint(323,392);//bottom 
            quad11.addPoint(365,380);//right small hex
            g.fillPolygon(quad11);

        Polygon quad12 = new Polygon();
            quad12.addPoint(321,408);//top
            quad12.addPoint(312,450);//left big hex
            quad12.addPoint(353,461);//bottom 
            quad12.addPoint(365,420);//right small hex
            g.fillPolygon(quad12);
        
///////////////////////////////////////////////////////////////////

        Polygon quad13 = new Polygon();//top
            quad13.addPoint(400,200);//top big hex
            quad13.addPoint(350,250);//left 
            quad13.addPoint(400,300);//bottom small hex
            quad13.addPoint(450,250);//right 
            g.fillPolygon(quad13);
        Polygon quad14 = new Polygon();//upper right
            quad14.addPoint(507,282);//top 
            quad14.addPoint(488,350);//left small hex
            quad14.addPoint(557,369);//bottom 
            quad14.addPoint(575,300);//right big hex
            g.fillPolygon(quad14);
        Polygon quad15 = new Polygon();//bottom right
            quad15.addPoint(507,518);//bottom 
            quad15.addPoint(488,450);//left small hex
            quad15.addPoint(557,431);//top 
            quad15.addPoint(575,500);//right big hex
            g.fillPolygon(quad15);
        Polygon quad16 = new Polygon();//bottom
            quad16.addPoint(400,600);//top big hex
            quad16.addPoint(350,550);//left 
            quad16.addPoint(400,500);//bottom small hex
            quad16.addPoint(450,550);//right 
            g.fillPolygon(quad16);
        Polygon quad17 = new Polygon();//upper left
            quad17.addPoint(293,282);//top 
            quad17.addPoint(312,350);//right small hex
            quad17.addPoint(243,369);//bottom 
            quad17.addPoint(225,300);//left big hex
            g.fillPolygon(quad17);
        Polygon quad18 = new Polygon();//bottom left
            quad18.addPoint(293,518);//bottom 
            quad18.addPoint(312,450);//right small hex
            quad18.addPoint(243,431);//top 
            quad18.addPoint(225,500);//left big hex
            g.fillPolygon(quad18);

////////////////////////////////////////////////////////////////

        //Polygon quad19 = new Polygon();
            //quad19.addPoint(400,290);//top big hex
            //quad19.addPoint(360,330);//left 
            //quad19.addPoint(400,370);//bottom small hex
            //quad19.addPoint(440,330);//right 
            //g.drawPolygon(quad19);

///////////////////////////////////////////////////////////////////

        g.setColor(new Color(22,46,111));

        Polygon star1 = new Polygon();
            star1.addPoint(400,360);//out top
            star1.addPoint(411,380);//in top right
            star1.addPoint(435,380);//o upper right
            star1.addPoint(423,400);//i
            star1.addPoint(435,420);
            star1.addPoint(411,420);//i
            star1.addPoint(400,440);//out bottom
            star1.addPoint(389,420);//i
            star1.addPoint(365,420);
            star1.addPoint(377,400);//i
            star1.addPoint(365,380); 
            star1.addPoint(389,380);//i
            g.fillPolygon(star1);

   
        //Polygon hex6 = new Polygon();
            //hex6.addPoint(410,383);//topright
            //hex6.addPoint(420,400);//right
            //hex6.addPoint(410,418);//bottomright
            //hex6.addPoint(390,418);//bottomleft
            //hex6.addPoint(380,400);//left
            //hex6.addPoint(390,383);//topleft
            //g.drawPolygon(hex6);




   }
}