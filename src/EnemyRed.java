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
        speed = 25;
        color = "red";
    }
    public void draw(Graphics g){
        Image image = null;
        try {
            image = ImageIO.read(new File("cocodemon.png"));
        } catch (IOException e) {
            g.setColor(Color.RED);
            g.fillArc(xPos, yPos, sizeOfSquare, sizeOfSquare, 0, 360);
        }
        g.drawImage(image, xPos, yPos, sizeOfSquare, sizeOfSquare, null);
    }
}