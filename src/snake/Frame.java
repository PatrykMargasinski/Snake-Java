/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;
import java.awt.Color;
import javax.swing.JFrame;
/**
 *
 * @author student
 */
public class Frame extends JFrame{

    public Frame(){
        Panel p=new Panel();
        this.add(p);
        this.setVisible(true);
        this.setTitle("Snake");
        this.addKeyListener(p);
        this.setSize(550,550);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        Frame f=new Frame();
    }
    
}
