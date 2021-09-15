import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Platno extends JPanel {
    Controller controller;
    Timer timer;
    int[] pole = {
            0, 1, 2,
            3, 4, 5,
            6, 7, 8
    };
    int x;
    public Platno() {
        super();
        this.setSize(301, 301);
        this.setLocation(0, 0);
        controller = Controller.GetInstance();
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (x < controller.getSolution().size()-1){
                    x++;
                    pole = controller.getSolution().get(x).puzzle;
                    repaint();
                }else{
                    x=0;
                    timer.stop();
                }
            }
        };
        timer = new Timer(500 ,taskPerformer);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        g.drawRect(0,0,100, 100);
        g.drawRect(100,0,100, 100);
        g.drawRect(200,0,100, 100);
        g.drawRect(0,100,100, 100);
        g.drawRect(100,100,100, 100);
        g.drawRect(200,100,100, 100);
        g.drawRect(0,200,100, 100);
        g.drawRect(100,200,100, 100);
        g.drawRect(200,200,100, 100);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 120));



//        for (int i = 0; i < controller.getSolution().size(); i++) {
//            controller.getSolution().get(i).PrintPuzzle();
//            System.out.println("-----------------------------------------------------------");
//            controller.getSolution().get(0).PrintPuzzle();
//            System.out.println("-----------------------------------------------------------");
//        }
//        System.out.println("-----------------------------------------------------------");
        g.drawString(String.valueOf(pole[0]),17,92);
        g.drawString(String.valueOf(pole[1]),117,92);
        g.drawString(String.valueOf(pole[2]),217,92);
        g.drawString(String.valueOf(pole[3]),17,192);
        g.drawString(String.valueOf(pole[4]),117,192);
        g.drawString(String.valueOf(pole[5]),217,192);
        g.drawString(String.valueOf(pole[6]),17,292);
        g.drawString(String.valueOf(pole[7]),117,292);
        g.drawString(String.valueOf(pole[8]),217,292);
    }
}
