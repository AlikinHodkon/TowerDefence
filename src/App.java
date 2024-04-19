import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class App{
    static boolean isRedPressed = false;
    static boolean isBluePressed = false;
    static boolean isPurplePressed = false;
    static boolean isWhitePressed = false;
    public static void main(String[] args) throws Exception {
        int boardWidth = 800;
        int boardHeight = 600;

        JFrame frame = new JFrame("TowerDefence");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight); 
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Money money = new Money(75);
        TowerDefenceFields tw = new TowerDefenceFields(boardHeight, boardWidth, money);
        frame.add(tw);
        money.changeMoney();
        money.setBackground(Color.BLACK);
        money.setForeground(Color.RED);
        tw.add(money);
        JButton buttonRed = new JButton("TowerRed");
        tw.add(buttonRed);
        ActionListener twaRed = new TowerButtonRedAction();
        buttonRed.addActionListener(twaRed);
        JButton buttonBlue = new JButton("TowerBlue");
        tw.add(buttonBlue);
        ActionListener twaBlue = new TowerButtonBlueAction();
        buttonBlue.addActionListener(twaBlue);
        JButton buttonPurple = new JButton("TowerPurple");
        tw.add(buttonPurple);
        ActionListener twaPurple = new TowerButtonPurpleAction();
        buttonPurple.addActionListener(twaPurple);
        JButton buttonWhite = new JButton("TowerWhite");
        tw.add(buttonWhite);
        ActionListener twaWhite = new TowerButtonWhiteAction();
        buttonWhite.addActionListener(twaWhite);         
        MouseClickAction mouse = new MouseClickAction(tw, money);
        tw.addMouseListener(mouse);
        frame.pack();
    }

    static public boolean getisRedPressed(){
        return isRedPressed;
    }

    static public void setisRedPressed(boolean newPressed){
        isRedPressed = newPressed;
    }
    static public boolean getisBluePressed(){
        return isBluePressed;
    }

    static public void setisBluePressed(boolean newPressed){
        isBluePressed = newPressed;
    }
    static public boolean getisPurplePressed(){
        return isPurplePressed;
    }

    static public void setisPurplePressed(boolean newPressed){
        isPurplePressed = newPressed;
    }
    static public boolean getisWhitePressed(){
        return isWhitePressed;
    }

    static public void setisWhitePressed(boolean newPressed){
        isWhitePressed = newPressed;
    }
}

class MouseClickAction implements MouseListener{
    Money money;
    TowerDefenceFields tw;
    MouseClickAction(TowerDefenceFields tw, Money money){
        this.tw = tw;
        this.money = money;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (money.getMoney() >= 25){
            Tower tower;
            if (App.getisRedPressed()){
                tower = new TowerRed(x, y);
                money.setMoney(money.getMoney()-tower.getCost());
                money.changeMoney();
                tw.towers.add(tower);
                tw.repaint();
            } else if (App.getisBluePressed()){
                tower = new TowerBlue(x, y);
                money.setMoney(money.getMoney()-tower.getCost());
                money.changeMoney();
                tw.towers.add(tower);
                tw.repaint();
            } else if (App.getisPurplePressed()){
                tower = new TowerPurple(x, y);
                money.setMoney(money.getMoney()-tower.getCost());
                money.changeMoney();
                tw.towers.add(tower);
                tw.repaint();
            } else if (money.getMoney() >= 100){
                if (App.getisWhitePressed()){
                    tower = new TowerWhite(x, y);
                    money.setMoney(money.getMoney()-tower.getCost());
                    money.changeMoney();
                    tw.towers.add(tower);
                    tw.repaint();
                }
            }
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
class TowerButtonRedAction implements ActionListener{ 
public void actionPerformed(ActionEvent event)
    {
        if (!App.getisRedPressed()){
            App.setisRedPressed(true);
            App.setisBluePressed(false);
            App.setisPurplePressed(false);
            App.setisWhitePressed(false);
        }else{
            App.setisRedPressed(false);
        }
    }      
}
class TowerButtonBlueAction implements ActionListener{ 
public void actionPerformed(ActionEvent event)
    {
        if (!App.getisBluePressed()){
            App.setisBluePressed(true);
            App.setisRedPressed(false);
            App.setisPurplePressed(false);
            App.setisWhitePressed(false);
        }else{
            App.setisBluePressed(false);
        }
    }      
}
class TowerButtonPurpleAction implements ActionListener{ 
public void actionPerformed(ActionEvent event)
    {
        if (!App.getisPurplePressed()){
            App.setisPurplePressed(true);
            App.setisRedPressed(false);
            App.setisBluePressed(false);
            App.setisWhitePressed(false);
        }else{
            App.setisPurplePressed(false);
        }
    }      
}
class TowerButtonWhiteAction implements ActionListener{ 
public void actionPerformed(ActionEvent event)
    {
        if (!App.getisWhitePressed()){
            App.setisWhitePressed(true);
            App.setisRedPressed(false);
            App.setisBluePressed(false);
            App.setisPurplePressed(false);
        }else{
            App.setisWhitePressed(false);
        }
    }      
}
