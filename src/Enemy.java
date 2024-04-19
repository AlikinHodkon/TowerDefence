import java.awt.Graphics;

public abstract class Enemy extends GameObject implements Killable{
    int xPos, yPos;
    String color;
    int speed;
    int health;
    public void move(){
        if (xPos != 5*sizeOfSquare && yPos == 5*sizeOfSquare){
            xPos -= speed;
            return;
        }
        if (yPos != 10*sizeOfSquare && xPos == 5*sizeOfSquare){
            yPos += speed;
            return;
        }
        if (xPos != 26*sizeOfSquare && yPos == 10*sizeOfSquare){
            xPos += speed;
            return;
        }
        if (yPos != 20*sizeOfSquare){
            yPos += speed;
            return;
        }
        if (xPos != 7*sizeOfSquare){
            xPos -= speed;
            return;
        }
    }
    public void attack(Castle castle){
        if (xPos == 7*25 && yPos == 20*25){
            castle.setHealth(castle.getHealth()-1);
        }
    }
    public int getxPos(){
        return xPos;
    }
    public int getyPos(){
        return yPos;
    }
    public String getColor(){
        return color;
    }
    public int getHealth(){
        return health;
    } 
    public void setHealth(int health){
        this.health = health;
    }
    public boolean isDead(){
        if (health <= 0) return true;
        else return false;
    }
    public abstract void draw(Graphics g);
}
