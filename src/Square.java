import java.awt.Graphics;

public class Square {
    int sizeOfSquare = 25;
    Square(){
    }
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
}
