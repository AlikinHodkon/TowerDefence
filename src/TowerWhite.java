import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TowerWhite extends Tower{
    public TowerWhite(int xPos, int yPos){
        sizeOfSquare = 25;
        cost = 100;
        this.xPos = xPos;
        this.yPos = yPos;
        radiusX1 = xPos+sizeOfSquare*2;
        radiusX2 = xPos-sizeOfSquare*2;
        radiusY1 = yPos+sizeOfSquare*2;
        radiusY2 = yPos-sizeOfSquare*2;
        color = "white";
        shoot = true;
        timer  = new Timer(150, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                shoot = true;
                timer.stop();
            }
    
        });
    }
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(xPos, yPos, sizeOfSquare, sizeOfSquare);
    }
    public boolean colorEquals(Enemy enem){
        return true;
    }
}