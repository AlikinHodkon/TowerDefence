import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class TowerDefenceFields extends JPanel implements ActionListener {
    private int sizeOfSquare = 25;
    private int progressHealth = 1;
    private int kills = 0;
    private int boardHeight;


    private Road road;
    private Money money;
    private Timer gameloop;

    private ArrayList<Enemy> enemy = new ArrayList<>(1); 

    private ArrayList<Tower> towers = new ArrayList<>();

    private Castle castle;

    TowerDefenceFields(int boardHeight, int boardWidth, Money money){
        this.money = money;
        this.boardHeight = boardHeight;
        
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.BLACK);

        road = new Road();

        castle = new Castle(3);

        enemy.add(new EnemyRed(32*sizeOfSquare, 5*sizeOfSquare, progressHealth));
        gameloop = new Timer(100, this);
        gameloop.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        // Сетка
        // for (int i = 0; i < boardWidth/sizeOfSquare; i++){
        //     g.drawLine(i*sizeOfSquare, 0, i*sizeOfSquare, boardHeight);
        //     g.drawLine(0, i*sizeOfSquare, boardWidth, i*sizeOfSquare);
        // }

        road.draw(g);

        if (!enemy.isEmpty()){
            for (Enemy enem : enemy) {
                enem.draw(g);
            }
        }

        castle.draw(g);

        if (!towers.isEmpty()){
            for (Tower t : towers) {
                t.draw(g);
            }
        }

        if (!gameloop.isRunning()){
            g.setColor(new Color(180, 0, 0));
            g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 140));
            g.drawString("Game Over", sizeOfSquare+12, boardHeight/2);
        }

    }

    public void towersAdd(Tower tower){
        towers.add(tower);
    }

    public boolean getGameLoopStatus(){
        return gameloop.isRunning();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!enemy.isEmpty()){
            for (Enemy enem : enemy) {
                enem.move();
                enem.attack(castle);
            }
        }
        if (castle.isDead()){
            gameloop.stop();
            repaint();
        }
        if (!towers.isEmpty() && !enemy.isEmpty()){
            boolean kill = false;
            for (Tower t : towers) {
                for (Enemy enem : enemy) {
                    if (t.attack(enem)){
                        enem.setHealth(enem.getHealth()-1);
                        if (enem.isDead()){
                            enemy.remove(enem);
                            kill = true;
                            kills++;
                            if (kills % 30 == 0) progressHealth++;
                            break;
                        }
                    }
                }
                if (kill){
                    kill = false;
                    money.setMoney(money.getMoney()+5);
                    money.changeMoney();
                    if (enemy.size() < 30){
                        switch ((int)(Math.random() * 6)+1) {
                            case 1:
                                enemy.add(new EnemyRed(32*sizeOfSquare, 5*sizeOfSquare, progressHealth));
                                break;
                            case 2:
                                enemy.add(new EnemyBlue(32*sizeOfSquare, 5*sizeOfSquare, progressHealth));
                                break;
                            case 3:
                                enemy.add(new EnemyPurple(32*sizeOfSquare, 5*sizeOfSquare, progressHealth));
                                break;
                            case 4:
                                enemy.add(new EnemyRed(32*sizeOfSquare, 5*sizeOfSquare, progressHealth));
                                enemy.add(new EnemyRed(32*sizeOfSquare, 5*sizeOfSquare, progressHealth));
                                break;
                            case 5:
                                enemy.add(new EnemyBlue(32*sizeOfSquare, 5*sizeOfSquare, progressHealth));
                                enemy.add(new EnemyBlue(32*sizeOfSquare, 5*sizeOfSquare, progressHealth));
                                break;
                            case 6:
                                enemy.add(new EnemyPurple(32*sizeOfSquare, 5*sizeOfSquare, progressHealth));
                                enemy.add(new EnemyPurple(32*sizeOfSquare, 5*sizeOfSquare, progressHealth));
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        repaint();
    }
}