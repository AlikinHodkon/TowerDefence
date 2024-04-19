import java.awt.Color;
import java.awt.Graphics;

public class EnemyBlue extends Enemy{
    EnemyBlue(int xPos, int yPos, int health){
        this.xPos = xPos;
        this.yPos = yPos;
        this.health = health;
        sizeOfSquare = 25;
        speed = 25;
        color = "blue";
    }
    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.fillArc(xPos, yPos, sizeOfSquare, sizeOfSquare, 0, 360);
    }
}
