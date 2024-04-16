import javax.swing.*;

import java.awt.Graphics;

public abstract class Tower extends JComponent{
    int sizeOfSquare;
    int cost;
    int xPos, yPos, radiusX1, radiusX2, radiusY1, radiusY2;
    String color; 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    public abstract void draw(Graphics g);
    public abstract boolean attack(Enemy enem);
    public abstract int getCost();
    public abstract boolean colorEquals(Enemy enem);
}
