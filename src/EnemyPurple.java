import java.awt.Color;
import java.awt.Graphics;

public class EnemyPurple extends Enemy{
    EnemyPurple(int xPos, int yPos, int health){
        this.xPos = xPos;
        this.yPos = yPos;
        this.health = health+1;
        sizeOfSquare = 25;
        speed = 25;
        color = "purple";
        this.colorCode = new Color(160,32,240);
    }
    public void draw(Graphics g){
        g.setColor(new Color(160,32,240));
        g.fillArc(xPos, yPos, sizeOfSquare, sizeOfSquare, 0, 360);
    }
    public void changeColor(){
        try{
            colorCode = new Color(160-160/health,32-32/health,240-240/health);
        }catch(Exception e){
            colorCode = new Color(0, 0, 0);
        }
    }
}
