import java.awt.Color;
import java.awt.Graphics;

public class EnemyRed extends Enemy {
    EnemyRed(int xPos, int yPos, int health){
        this.xPos = xPos;
        this.yPos = yPos;
        this.health = health;
        sizeOfSquare = 25;
        speed = 25;
        color = "red";
    }
    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillArc(xPos, yPos, sizeOfSquare, sizeOfSquare, 0, 360);
    }
}