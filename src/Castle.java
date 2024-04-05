import java.awt.Graphics;

public class Castle{
    int health = 1;
    int sizeOfSquare = 25;
    Castle(int health){
        this.health = health;
    }
    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public void draw(Graphics g){
       g.fillRect(5*sizeOfSquare, 19*sizeOfSquare, sizeOfSquare*3, sizeOfSquare*3);
    }
}