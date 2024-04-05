import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class App{
    static boolean isPressed = false;
    public static void main(String[] args) throws Exception {
        int boardWidth = 800;
        int boardHeight = 600;

        JFrame frame = new JFrame("TowerDefence");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight); 
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Money money = new Money();
        TowerDefenceFields tw = new TowerDefenceFields(boardHeight, boardWidth, money);
        frame.add(tw);
        money.changeMoney();
        money.setBackground(Color.BLACK);
        money.setForeground(Color.RED);
        tw.add(money);
        JButton button = new JButton("Tower");
        tw.add(button);
        ActionListener twa = new TowerButtonAction();
        button.addActionListener(twa);
        class MouseClickAction implements MouseListener{

            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                if (getisPressed() && money.getMoney() >= 25){
                    Tower tower = new Tower(x, y);
                    money.setMoney(money.getMoney()-tower.getCost());
                    money.changeMoney();
                    tw.add(tower);
                    tw.towers.add(tower);
                    tw.repaint();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        }
        MouseClickAction mouse = new MouseClickAction();
        tw.addMouseListener(mouse);
        frame.pack();
    }

    static public boolean getisPressed(){
        return isPressed;
    }

    static public void setisPressed(boolean newPressed){
        isPressed = newPressed;
    }
}

class TowerButtonAction implements ActionListener{ 
public void actionPerformed(ActionEvent event)
    {
        if (!App.getisPressed()){
            App.setisPressed(true);
        }else{
            App.setisPressed(false);
        }
    }      
}

