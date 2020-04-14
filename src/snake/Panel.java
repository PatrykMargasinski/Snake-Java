/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author student
 */
public class Panel extends JPanel implements ActionListener, KeyListener
{
    Random gen = new Random();
    int x=500,y=500,punkty=0,time=500;
    boolean entryForKey=true;
    char direction='d';
    Square apple=new Square(100,100,50);
    ArrayList <Square> c;
    Timer t;
    int r,g,b;
    public Panel()
    {
        //this.setOpaque(true);
        this.setFocusable(false);
        this.setVisible(true);
        this.setSize(x,y);
        this.t=new Timer(time,this);
        this.t.start();
        c=new ArrayList<>();
        c.add(new Square(0,0,50));
        c.add(new Square(0,0,50));
        this.r=0;this.g=0;this.b=0;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        digestion();
        move();
        defeat();
        HaveIApple();
        this.repaint();

    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        char a=e.getKeyChar();
        if(entryForKey==true)
        switch(a)
        {
            case 'a':
                if(direction!='d')
                {
                    direction=a;
                }  
            break;
            case 's':
                if(direction!='w')
                {
                    direction=a;
                }  
            break;
            case 'd':
                if(direction!='a')
                {
                    direction=a;
                }  
            break;
            case 'w':
                if(direction!='s')
                {
                    direction=a;
                }  
            break;
        }
        entryForKey=false;
    }
    @Override
    protected void paintComponent(Graphics gr)
    {
        gr.setColor(Color.gray);
        gr.fillRect(0,0,x,y);
        (c.get(0)).paintSquare((Graphics2D)gr,200,0,0);
        apple.paintSquare((Graphics2D)gr,255,215,0);
        for(int i=1;i<c.size();i++)
        if(c.get(i).digest==true) (c.get(i)).paintSquare((Graphics2D)gr,0,0,0);
        else (c.get(i)).paintSquare((Graphics2D)gr,0,200,0);
    }
    void move()
    {
        entryForKey=true;
        switch(direction)
        {
            case 'w':
                c.add(0,new Square(c.get(0).x,c.get(0).y-50,50));
            break;
            case 'a':
                c.add(0,new Square(c.get(0).x-50,c.get(0).y,50));
            break;
            case 's':
                c.add(0,new Square(c.get(0).x,c.get(0).y+50,50));
            break;
            case 'd':
                c.add(0,new Square(c.get(0).x+50,c.get(0).y,50));
            break;
        }
        c.remove(c.size()-1);
    }
    void defeat()
    {
        if(((c.get(0)).x==500||(c.get(0)).y==500||(c.get(0)).x==-50||(c.get(0)).y==-50))
        {
            JOptionPane.showMessageDialog(null,"Ilosc punktow: "+punkty ,"Wpadłeś w płot", JOptionPane.ERROR_MESSAGE);    
            System.exit(0);
        }
        else if(samoboj())
        {
            JOptionPane.showMessageDialog(null,"Ilosc punktow: "+punkty ,"Samobój", JOptionPane.ERROR_MESSAGE);    
            System.exit(0);
        }
    }
    void HaveIApple()
    {
        if(c.get(0).x==apple.x&&c.get(0).y==apple.y)
        {
            punkty++;
            if(punkty%3==0&&time!=100){time-=100;t.setDelay(time);}
            c.get(0).digest=true;
            while(checking()){}
            
        }
    }
    boolean checking()
    {
            apple.x=gen.nextInt(10)*50;
            apple.y=gen.nextInt(10)*50;
        for(int i=0;i<c.size()-1;i++)
        {
            if(c.get(i).x==apple.x&&c.get(i).y==apple.y) return true;
        }
        return false;
    }
    boolean samoboj()
    {
        for(int i=1;i<c.size();i++)
        {
            if(c.get(0).x==c.get(i).x&&c.get(0).y==c.get(i).y)
            {
                return true;
            }
        }
        return false;
    }
    void digestion()
    {
        for(int i=0;i<c.size();i++)
        {
            System.out.println(i+": "+c.get(i).digest);
        }
        if(c.get(c.size()-1).digest==true)
        {
            c.get(c.size()-1).digest=false;
            c.add(new Square(c.get(0).x,c.get(0).y,50));
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
            }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
