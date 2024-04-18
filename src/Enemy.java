import java.awt.Graphics;

public abstract class Enemy {
    int xPos;
    int yPos;
    int speed;
    int sizeOfArc;
    String color;
    public abstract void move();
    public abstract void attack(Castle castle);
    public abstract void draw(Graphics g);
    public abstract int getxPos();
    public abstract int getyPos();
    public abstract String getColor();   
}
