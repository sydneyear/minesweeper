import javax.swing.*;  // for JFrame
import java.awt.*;     // for Graphics and Container
import java.awt.event.*;//for mouse listener
public class Board 
{
    private static JFrame mL;
    private static Container contentPane;
    private static Graphics g;

    public static void main(String[] args)
    {
        mL=new MyMouseListener();
        
        mL.setSize(900,725);  
        mL.setLayout(null);  
        mL.setVisible(true);     

        contentPane=mL.getContentPane();
        g=contentPane.getGraphics();

        try {Thread.sleep(400);} catch (Exception e) {}
        
        g.setColor(new Color(232, 97, 142));//background color (dark pink)odd+even
        g.fillRect(0,0,900,700);   // background

        g.setColor(new Color(240, 117, 158));//squares (light pink) odd+odd,even+even
        for(int i =0;i<900;i+=100)
        {
            for(int j=0;j<700;j+=100)
            {
                g.fillRect(i,j,50,50); 
            }
        }
        for(int i =50;i<900;i+=100)
        {
            for(int j=50;j<700;j+=100)
            {
                g.fillRect(i,j,50,50); 
            }
        }
    }
  
}