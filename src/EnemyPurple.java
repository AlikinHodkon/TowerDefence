import java.awt.Color;
import java.awt.Graphics;

public class EnemyPurple extends Enemy{
    EnemyPurple(int xPos, int yPos, int health){
        this.xPos = xPos;
        this.yPos = yPos;
        this.health = health;
        sizeOfSquare = 25;
        speed = 25;
        color = "purple";
    }
    public void draw(Graphics g){
        g.setColor(new Color(160,32,240));
        g.fillArc(xPos, yPos, sizeOfSquare, sizeOfSquare, 0, 360);
    }
}
