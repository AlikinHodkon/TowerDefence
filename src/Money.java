import javax.swing.JTextPane;

public class Money extends JTextPane{
    int money = 50;
    Money(){super();}
    public void changeMoney(){
        setText("Money: "+getMoney());
    }
    public int getMoney(){
        return money;
    }
    public void setMoney(int money){
        this.money = money;
    }
}
