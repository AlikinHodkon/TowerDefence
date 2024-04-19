import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TowerRed extends Tower{
    public TowerRed(int xPos, int yPos){
        sizeOfSquare = 25;
        cost = 25;
        this.xPos = xPos;
        this.yPos = yPos;
        radiusX1 = xPos+sizeOfSquare*2;
        radiusX2 = xPos-sizeOfSquare*2;
        radiusY1 = yPos+sizeOfSquare*2;
        radiusY2 = yPos-sizeOfSquare*2;
        color = "red";
        shoot = true;
        timer = new Timer(150, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                shoot = true;
                timer.stop();
            }
    
        });
    }
    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(xPos, yPos, sizeOfSquare, sizeOfSquare);
    }
    public boolean colorEquals(Enemy enem){
        if (color.equals(enem.getColor())) return true;
        else return false;
    }
}