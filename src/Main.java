//Óscar García Sahuquillo
import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JavaSwing1 n = new JavaSwing1();
        JFrame P1 = new JFrame("Puerto1");
        P1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        P1.getContentPane().add(n.getHUB());
        P1.pack();
        P1.setVisible(true);
    }
}
