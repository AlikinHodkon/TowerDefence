import java.awt.Color;
import java.awt.Graphics;

public class Road extends GameObject{
    int sizeOfSquare;
    Road(){ sizeOfSquare = 25;}
    public void drawWayVertical(Graphics g, int startX, int fromY, int toY){
        for (int i = fromY; i < toY; i++){
            g.fillRect(startX*sizeOfSquare, i*sizeOfSquare, sizeOfSquare, sizeOfSquare);
        }
    }
    public void drawWayHorizontal(Graphics g, int startY, int fromX, int toX){
        for (int i = fromX; i < toX; i++){
            g.fillRect(i*sizeOfSquare, startY*sizeOfSquare, sizeOfSquare, sizeOfSquare);
        }
    }
    public void draw(Graphics g){
        g.setColor(Color.YELLOW);
        drawWayHorizontal(g, 5, 5, 32);
        drawWayVertical(g, 5, 6, 10);
        drawWayHorizontal(g, 10, 5, 26);
        drawWayVertical(g, 26, 10, 20);
        drawWayHorizontal(g, 20, 8, 27);
    }
}
