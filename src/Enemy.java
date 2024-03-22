import java.awt.Graphics;

public class Enemy {
    public int xPos;
    public int yPos;
    int speed;
    int sizeOfArc = 25;
    Enemy(int xPos, int yPos, int speed){
        this.xPos = xPos;
        this.yPos = yPos;
        this.speed = speed;
    }
    public void move(){
        if (xPos != 5*sizeOfArc && yPos == 5*sizeOfArc){
            xPos -= speed;
            return;
        }
        if (yPos != 10*sizeOfArc && xPos == 5*sizeOfArc){
            yPos += speed;
            return;
        }
        if (xPos != 26*sizeOfArc && yPos == 10*sizeOfArc){
            xPos += speed;
            return;
        }
        if (yPos != 20*sizeOfArc){
            yPos += speed;
            return;
        }
        if (xPos != 7*sizeOfArc){
            xPos -= speed;
            return;
        }
    }
    public void attack(Castle castle){
        if (xPos == 7*25 && yPos == 20*25){
            castle.health -= 1;
        }
    }
    public void draw(Graphics g){
        g.fillArc(xPos, yPos, sizeOfArc, sizeOfArc, 0, 360);
    }    
}
