import javax.swing.*;

import java.awt.Graphics;

public abstract class Tower extends GameObject{
    int cost;
    int radiusX1, radiusX2, radiusY1, radiusY2;
    Timer timer; 
    boolean shoot;
    int xPos, yPos;
    String color;
    public abstract void draw(Graphics g);
    public boolean attack(Enemy enem){
        if ((enem.getxPos() <= radiusX1 && enem.getxPos() >= radiusX2) && (enem.getyPos() <= radiusY1 && enem.getyPos() >= radiusY2) && colorEquals(enem) && shoot){
            shoot = false;
            timer.start();
            return true;
        }
        return false;
    }
    public int getCost(){
        return cost;
    }
    public abstract boolean colorEquals(Enemy enem);
}
