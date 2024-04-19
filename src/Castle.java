import java.awt.Color;
import java.awt.Graphics;

public class Castle extends GameObject implements Killable{
    int health;
    Castle(int health){
        this.health = health;
        sizeOfSquare = 25;
    }
    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public boolean isDead(){
        if (health == 0) return true;
        else return false;
    }
    public void draw(Graphics g){
       g.setColor(Color.GREEN);
       g.fillRect(5*sizeOfSquare, 19*sizeOfSquare, sizeOfSquare*3, sizeOfSquare*3);
    }
}