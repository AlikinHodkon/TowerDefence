import java.awt.Color;
import java.awt.Graphics;

public class EnemyBlue extends Enemy{
    EnemyBlue(int xPos, int yPos, int health){
        this.xPos = xPos;
        this.yPos = yPos;
        this.health = health+2;
        sizeOfSquare = 25;
        speed = 15;
        color = "blue";
        this.colorCode = new Color(0, 0, 255);
    }
    public void move(){
        if (xPos > 5*sizeOfSquare && yPos == 5*sizeOfSquare){
            if (xPos+(sizeOfSquare-speed) == 5*sizeOfSquare) { 
                xPos += sizeOfSquare-speed; 
                return;
            }
            xPos -= speed;
            return;
        }
        if (yPos != 250 && xPos == 5*sizeOfSquare){
            if (yPos == 230){ 
                yPos += 20;
                return;
            }
            yPos += speed;
            return;
        }
        if (xPos < 26*sizeOfSquare && yPos == 250){
            xPos += speed;
            return;
        }
        if (yPos != 500){
            if (yPos == 490){ 
                yPos += 10;
                return;
            }            
            yPos += speed;
            return;
        }
        if (xPos != 7*sizeOfSquare && yPos == 500){
            if (xPos == 185){
                xPos -= 10;
                return;
            }
            xPos -= speed;
            return;
        }
    }
    public void draw(Graphics g){
        g.setColor(colorCode);
        g.fillArc(xPos, yPos, sizeOfSquare, sizeOfSquare, 0, 360);
    }
    public void changeColor(){
        try{
            colorCode = new Color(0, 0, 255-255/health);
        }catch(Exception e){
            colorCode = new Color(0, 0, 0);
        }
    }
}
