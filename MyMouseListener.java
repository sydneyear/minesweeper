import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;  
import java.util.ArrayList;

public class MyMouseListener extends JFrame implements MouseListener//https://www.javatpoint.com/java-mouselistener
{
    private int[][] board=new int[14][18];
    private int[][] flags = new int[14][18];
    private static boolean doneFirstClick;
    private ArrayList<JLabel> numbers = new ArrayList<JLabel>();
    private int index=0;
    //private int numOfMines;
    //private int numOfDigs;
    private boolean playing;
    
    public MyMouseListener()
    {
      addMouseListener(this); 
      board=numGen(mineGen(board));
      doneFirstClick=false;
      playing=true;

    }
    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) 
    {
        //System.out.println("Clicked");
        Point point = e.getLocationOnScreen();
        Container contentPane = getContentPane();
        Graphics g=contentPane.getGraphics();
        g.setColor(new Color(230, 90, 140));
        double x=point.getX();
        double y=point.getY();
        int row=getRow(y);
        int col=getCol(x);
        //System.out.println("numOfDigs="+numOfDigs);
        //System.out.println("numOfMines="+numOfMines);  
        if(playing)
        {
            if(e.getButton() == MouseEvent.BUTTON1) //https://www.javacodex.com/More-Examples/2/6 for distinguishing right and left click
            {
                //System.out.println("Left Click!");
                if(!doneFirstClick && board[row][col]!=0)
                {
                    System.out.println("new board");
                    board=numGen(mineGen(board));
                    mouseClicked(e);
                }
                else if(!doneFirstClick && board[row][col]==0)
                {
                    drawEmptyField(row,col);
                    doneFirstClick=true;
                    //System.out.println("doneFirstClick=true");
                }
                else if(flags[row][col]==-1){}//do nothing
                else if(doneFirstClick && board[row][col]==-1)//game over
                {
                    //g.fillRect(0,0,900,700);   // background
                    for(int i=0;i<numbers.size();i++)
                    {
                        remove(numbers.get(i));
                    }
                    g.setColor(new Color(219, 59, 91));//red
                    g.fillRect(col*50,row*50,50,50);
                    JLabel label = new JLabel();
                    label.setBounds(0,0,900,720);
                    add(label);
                    label.setText("Game over");
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    label.setFont(new Font("Serif",Font.BOLD,20));
                    label.setBackground(new Color(57, 219, 119));
                    label.setOpaque(true);

                    //System.out.println("Game Over");
                    playing=false;
                }
                else 
                {
                    drawSquare(row,col);
                }
                
            }
            if(e.getButton() == MouseEvent.BUTTON2) 
            {
                //System.out.println("Middle Click!");
                //if()
                //drawAround(row,col);
            }
            if(e.getButton() == MouseEvent.BUTTON3) 
            {
                //System.out.println("Right Click!");
                if(board[row][col]!=-2)
                {
                    if(flags[row][col]!=-1)
                    {
                        flags[row][col]=-1;
                        g.setColor(new Color(145, 217, 230));
                        g.fillRect(col*50+10,row*50+20,5,20);
                        Polygon flag = new Polygon();
                        flag.addPoint(col*50+10,row*50+10);
                        flag.addPoint(col*50+40,row*50+20);
                        flag.addPoint(col*50+10,row*50+30);
                        g.fillPolygon(flag);

                    }
                    else
                    {
                        flags[row][col]=0;
                        if(row%2==col%2)
                        {
                            g.setColor(new Color(240, 117, 158));//light pink
                            g.fillRect(col*50,row*50,50,50);
                        }
                        else
                        {
                            g.setColor(new Color(232, 97, 142));//dark pink
                            g.fillRect(col*50,row*50,50,50);
                        }
                    }
                }
            }
        }
        printArray(board);
        System.out.println();
        boolean done = true;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]>=0)
                {
                    done=false;
                    System.out.print("error at: "+i+","+j);
                }

            }
        }
        if(done)//you win
        {
            g.setColor(new Color(219, 59, 91));
            g.fillRect(col*50,row*50,50,50);
            JLabel label = new JLabel();
            label.setBounds(0,0,900,720);
            add(label);
            label.setText("You Win!!");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Serif",Font.BOLD,20));
            label.setBackground(new Color(57, 219, 119));
            label.setOpaque(true);
            playing=false;
            System.out.println("win");

        }
    }
    
    public int getRow(double y)//ranges from 1-14
    {
        int row=0;
        boolean stop = false;
        for(int j=45;j<745;j+=50)//goes through every row
        {
                for(int h=j;h<j+50;h++)//y
                {
                    if(y==h)
                    {
                        //System.out.println("point "+y+"clicked at row "+row);  
                        stop=true;
                        break;
                    }
                }
                if(stop)
                    break;
        row++;
        }
        return row;
    }

    public int getCol(double x)//ranges from 1-18
    {
        int col=0;
        boolean stop = false;       
        for(int i =0;i<900;i+=50)// goes through every col
        {
            for(int k=i;k<i+50;k++)//x
            {
                if(x==k)
                    {
                        //System.out.println("clicked at col "+col);  
                        stop=true;
                        break;
                    }
            }
            if(stop)
                break;
        col++;
        }
        return col;
    }

    public int[][] numGen(int[][] array)//THE MINE GEN IS BROKEN
    {
        for(int i=0;i<array.length;i++)
        {
            for(int j=0;j<array[0].length;j++)
            {
                if(array[i][j]==-1)
                {
                    if(i>0)//i-1
                    {
                        if(array[i-1][j]!=-1)
                        array[i-1][j]+=1;
                    }
                    if(i<array.length-1)//i+1
                    {
                        if(array[i+1][j]!=-1)
                        array[i+1][j]+=1;
                    }
                    if(j>0)//j-1
                    {
                        if(array[i][j-1]!=-1)
                        array[i][j-1]+=1;
                    }
                    if(i>0&&j>0)//i-1
                    {
                        if(array[i-1][j-1]!=-1)
                        array[i-1][j-1]+=1;
                    }
                    if(i<array.length-1&&j>0)//i+1
                    {
                        if(array[i+1][j-1]!=-1)
                            array[i+1][j-1]+=1;
                    }
                    if(j<array[0].length-1)//j+1
                    {
                        if(array[i][j+1]!=-1)
                            array[i][j+1]+=1;
                    }
                    if(i>0&&j<array[0].length-1)//i-1
                    {
                        if(array[i-1][j+1]!=-1)
                            array[i-1][j+1]+=1;
                    }
                    if(i<array.length-1&&j<array[0].length-1)//i+1
                    {
                        if(array[i+1][j+1]!=-1)
                            array[i+1][j+1]+=1;
                    }
                        
                        
                    
                }
            }
        }
        //printArray(array);
        return array;
    }

    public int[][] mineGen(int[][] array)
    {
        int count=0;
        for(int i=0;i<array.length;i++)
        {
            for(int j=0;j<array[0].length;j++)
            {
                int random=(int)(Math.random()*6)-1;
                if(random==-1)
                {
                    array[i][j]=random;
                    count++;
                }
                else
                {
                    array[i][j]=0;
                }
            }
        }
        printArray(array);
        return array;
    }

    public void drawEmptyField(int row, int col)
    {
        drawSquare(row,col);
        drawAround(row,col);
        System.out.println("drawnEmptyField");
    }
    public void drawAround(int row, int col)
    {
        if(col<17)
        {
            drawSquare(row,col+1);
            //drawAround(row,col+1);
        }
        if(col>0)
        {
            drawSquare(row,col-1);
            //drawAround(row,col-1);

        }
        if(row<13)
        {
            drawSquare(row+1,col);
            //drawAround(row+1,col);

        }
        if(row>0)
        {
            drawSquare(row-1,col);
            //drawAround(row-1,col);

        }
        if(col<17&&row<13)
        {
            drawSquare(row+1,col+1);
            //drawAround(row+1,col+1);

        }
        if(col>0&&row>0)
        {
            drawSquare(row-1,col-1);
            //drawAround(row-1,col-1);

        }
        if(row<13&&col>0)
        {
            drawSquare(row+1,col-1);
            //drawAround(row+1,col-1);

        }
        if(row>0&&col<17)
        {
            drawSquare(row-1,col+1);
            //drawAround(row-1,col+1);

        }
        //System.out.println("drawn around");
        //printArray(board);
    }

    public void drawSquare(int row, int col)//draws the num in the square
    {
        Container contentPane = getContentPane();
        Graphics g=contentPane.getGraphics();
        if(board[row][col]==0)
        {
            if(row%2==col%2)//light color
            {
                g.setColor(new Color(57, 219, 119));
            }
            else//dark color
            {
                g.setColor(new Color(34, 199, 97));
            }
            g.fillRect(col*50,row*50,50,50);
            //draw empty square
            board[row][col]=-2;
            drawAround(row,col);
        }
        else if(board[row][col]>0)
        {
            numbers.add(new JLabel());
            numbers.get(index).setBounds(col*50, row*50, 50, 50);
            numbers.get(index).setHorizontalAlignment(SwingConstants.CENTER);
            numbers.get(index).setFont(new Font("Serif",Font.BOLD,20));
            //numbers.get(index).setForeground(Color.WHITE);
            if(row%2==col%2)//light color
            {
                numbers.get(index).setBackground(new Color(57, 219, 119));
                numbers.get(index).setOpaque(true);
            }
            else//dark color
            {
                numbers.get(index).setBackground(new Color(34, 199, 97));
                numbers.get(index).setOpaque(true);
            }

            add(numbers.get(index));
            switch(board[row][col])
            {
                case 1:
                    numbers.get(index).setText("1");
                    break;
                case 2:
                    numbers.get(index).setText("2");
                    break;
                case 3:
                    numbers.get(index).setText("3");
                    break;
                case 4:
                    numbers.get(index).setText("4");
                    break;
                case 5:
                    numbers.get(index).setText("5");
                    break;
                case 6:
                    numbers.get(index).setText("6");
                    break;
            }
            index++;
            board[row][col]=-2;
        }
        
    }

    public void printArray(int[][] array)
    {
        for(int i=0;i<array.length;i++)
        {
            for(int j=0;j<array[0].length;j++)
            {
                System.out.print(array[i][j]+",");
            }
            System.out.println();
        }
    }

   
    
}