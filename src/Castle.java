import java.awt.Graphics;

public class Castle{
    public int health = 3;
    int sizeOfSquare = 25;
    public Castle(int health){
        this.health = health;
    }
    public void draw(Graphics g){
       g.fillRect(5*sizeOfSquare, 19*sizeOfSquare, sizeOfSquare*3, sizeOfSquare*3);
    }
}