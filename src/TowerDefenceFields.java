import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.*;

public class TowerDefenceFields extends JPanel implements ActionListener {
    private int sizeOfSquare = 25;
    private int progressHealth = 1;
    private int kills = 0;
    private int boardHeight;
    private int score, bestScore;

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
        
        try{
            File maxScore = new File("Score.bin");
            FileInputStream inputStream = new FileInputStream(maxScore);
            byte[] previousScore = new byte[1064];
            int bytesRead;
            while ((bytesRead = inputStream.read(previousScore)) != -1) {
                bestScore = Integer.parseInt(new String(previousScore, 0, bytesRead));    
            }
            inputStream.close();
        }catch(Exception e){
            bestScore = 0;
        }

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

        g.setColor(Color.YELLOW);
        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
        g.drawString("Money: "+money.getMoney(), 315, 70);

        g.setColor(Color.WHITE);
        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
        g.drawString("Score: "+score, 115, 70);

        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
        g.drawString("Best Score: "+bestScore, 515, 70);

        if (!gameloop.isRunning()){
            g.setColor(new Color(180, 0, 0));
            g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 140));
            g.drawString("Game Over", sizeOfSquare+12, boardHeight/2);
            money.setMoney(0);
            if (score > bestScore){
                File maxScore = new File("Score.bin");
                try{
                    maxScore.createNewFile();
                    FileOutputStream outputStream = new FileOutputStream(maxScore);
                    byte[] buffer = Integer.toString(score).getBytes();
                    outputStream.write(buffer);
                    outputStream.close();
                }catch(Exception e){
                    return;
                }
            }
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
                        enem.changeColor();
                        enem.setHealth(enem.getHealth()-1);
                        if (enem.isDead()){
                            enemy.remove(enem);
                            kill = true;
                            kills++;
                            score+=50;
                            if (kills % 75 == 0) progressHealth++;
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