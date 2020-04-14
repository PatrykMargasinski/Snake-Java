/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**
 *
 * @author student
 */
public class Square {
    int x,y,d;
    boolean digest;

    public Square(int x, int y, int d)
    {
        this.x=x;
        this.y=y;
        this.d=d;
        this.digest=false;
    }
    
    public void paintSquare(Graphics2D gr,int r,int g, int b)
    {

        gr.setColor(new Color(r,g,b));
        //gr.fillOval(x, y, d, d);
        gr.fillRect(x, y, d-5, d-5);
    }

    void paintSquare(Graphics2D graphics2D) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void paintSquare(Graphics2D graphics2D, int r, Graphics g, int b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
