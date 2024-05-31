import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EnemyRed extends Enemy {
    EnemyRed(int xPos, int yPos, int health){
        this.xPos = xPos;
        this.yPos = yPos;
        this.health = health;
        sizeOfSquare = 25;
        speed = 35;
        color = "red";
        this.colorCode = new Color(255, 0, 0);
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
            if (yPos == 495){ 
                yPos += 5;
                return;
            }            
            yPos += speed;
            return;
        }
        if (xPos != 7*sizeOfSquare && yPos == 500){
            System.out.println(xPos);
            if (xPos == 195){
                xPos -= 20;
                return;
            }
            xPos -= speed;
            return;
        }
    }
    public void draw(Graphics g){
        Image image = null;
        try {
            image = ImageIO.read(new File("cocodemon.png"));
        } catch (IOException e) {
            g.setColor(colorCode);
            g.fillArc(xPos, yPos, sizeOfSquare, sizeOfSquare, 0, 360);
        }
        g.drawImage(image, xPos, yPos, sizeOfSquare, sizeOfSquare, null);
    }
    public void changeColor(){
        try{
            colorCode = new Color(255-255/health, 0, 0);
        }catch(Exception e){
            colorCode = new Color(0, 0, 0);
        }
    }
}