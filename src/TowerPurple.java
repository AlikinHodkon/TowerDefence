import java.awt.Color;
import java.awt.Graphics;

public class TowerPurple extends Tower{
    int sizeOfSquare;
    int cost;
    int xPos, yPos, radiusX1, radiusX2, radiusY1, radiusY2; 
    String color;
    public TowerPurple(int xPos, int yPos){
        sizeOfSquare = 25;
        cost = 5;
        this.xPos = xPos;
        this.yPos = yPos;
        radiusX1 = xPos+sizeOfSquare*2;
        radiusX2 = xPos-sizeOfSquare*2;
        radiusY1 = yPos+sizeOfSquare*2;
        radiusY2 = yPos-sizeOfSquare*2;
        color = "purple";
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        g.setColor(new Color(160,32,240));
        g.fillRect(xPos, yPos, sizeOfSquare, sizeOfSquare);
    }
    public boolean attack(Enemy enem){
        if ((enem.getxPos() <= radiusX1 && enem.getxPos() >= radiusX2) && (enem.getyPos() <= radiusY1 && enem.getyPos() >= radiusY2) && colorEquals(enem)){
            return true;
        }
        return false;
    }
    public int getCost(){
        return cost;
    }
    public boolean colorEquals(Enemy enem){
        if (color.equals(enem.getColor())) return true;
        else return false;
    }
}