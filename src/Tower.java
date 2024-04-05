import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;

public class Tower extends JComponent{
    int sizeOfSquare = 25;
    int cost = 25;
    int xPos, yPos, radiusX1, radiusX2, radiusY1, radiusY2; 
    public Tower(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
        radiusX1 = xPos+sizeOfSquare*2;
        radiusX2 = xPos-sizeOfSquare*2;
        radiusY1 = yPos+sizeOfSquare*2;
        radiusY2 = yPos-sizeOfSquare*2;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(xPos, yPos, sizeOfSquare, sizeOfSquare);
    }
    public boolean attack(Enemy enem){
        if ((enem.getxPos() <= radiusX1 && enem.getxPos() >= radiusX2) && (enem.getyPos() <= radiusY1 && enem.getyPos() >= radiusY2)){
            return true;
        }
        return false;
    }
    public int getCost(){
        return cost;
    }
}
