import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class TowerDefenceFields extends JPanel implements ActionListener {
    int boardWidth;
    int boardHeight;
    int sizeOfSquare = 25;

    Square sqr;

    Timer gameloop;

    Random random;

    ArrayList<Enemy> enemy = new ArrayList<>(1); 

    public ArrayList<Tower> towers = new ArrayList<>();

    Castle castle;

    TowerDefenceFields(int boardHeight, int boardWidth){
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;

        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.BLACK);

        sqr = new Square();

        castle = new Castle(3);

        enemy.add(new Enemy(32*sizeOfSquare, 5*sizeOfSquare, sizeOfSquare));
        gameloop = new Timer(100, this);
        gameloop.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        for (int i = 0; i < boardWidth/sizeOfSquare; i++){
            g.drawLine(i*sizeOfSquare, 0, i*sizeOfSquare, boardHeight);
            g.drawLine(0, i*sizeOfSquare, boardWidth, i*sizeOfSquare);
        }
        
        g.setColor(Color.YELLOW);

        sqr.drawWayHorizontal(g, 5, 5, 32);
        sqr.drawWayVertical(g, 5, 6, 10);
        sqr.drawWayHorizontal(g, 10, 5, 26);
        sqr.drawWayVertical(g, 26, 10, 20);
        sqr.drawWayHorizontal(g, 20, 8, 27);

        g.setColor(Color.BLUE);
        if (!enemy.isEmpty()){
            for (Enemy enem : enemy) {
                enem.draw(g);
            }
        }
        g.setColor(Color.GREEN);
        castle.draw(g);
        if (!towers.isEmpty()){
            for (Tower t : towers) {
                t.draw(g);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!enemy.isEmpty()){
            for (Enemy enem : enemy) {
                enem.move();
                enem.attack(castle);
            }
        }
        if (castle.health == 0){
            gameloop.stop();
        }
        if (!towers.isEmpty() && !enemy.isEmpty()){
            for (Tower t : towers) {
                for (Enemy enem : enemy) {
                    int n = 0;
                    if (t.attack(enem)){
                        enemy.remove(n);
                        break;
                        //Проблема в изменении длины списка
                    }
                    n++;
                }
            }
        }
        repaint();
    }
}

class Square{
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