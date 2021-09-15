import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;

public class View extends JFrame {
    int[] puzzle = {
            0, 1, 2,
            3, 4, 5,
            6, 7, 8
    };
    Node root;
    ArrayList<Node> solution;
    public Platno platno;
    public Controller controller;
    View(){
        super();
        setSize(317,500);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        platno = new Platno();
        controller = Controller.GetInstance();
        add(platno);


        root = new Node(puzzle);
        UninformedSearch ui = new UninformedSearch();
        solution = ui.BreadthFirstSearch(root);

//        if(solution.size() > 0){
//            Collections.reverse(solution);
//            controller.setSolution(solution);
//            for (int i = 0; i < solution.size(); i++) {
////                solution.get(i).PrintPuzzle();
//            }
//        }else{
//            System.out.println("No path to solution is found");
//        }

        JTextField pocet;


        JPanel tlacitka = new JPanel();
        tlacitka.setSize(317, 200);
        tlacitka.setLocation(0, 300);
        tlacitka.setLayout(null);
        add(tlacitka);

        JLabel text = new JLabel("Počet zamíchání: ");
        text.setSize(110,25);
        text.setLocation(20, 80);
        tlacitka.add(text);

        pocet = new JTextField("50");
        pocet.setSize(110,25);
        pocet.setLocation(20, 100);
        tlacitka.add(pocet);

        JButton zamichej = new JButton("Zamíchej");
        zamichej.setSize(110,25);
        zamichej.setLocation(20, 50);
        zamichej.addActionListener(e -> {
            for (int i = 0; i < Integer.parseInt(pocet.getText()); i++) {
                puzzle = controller.zamichej(puzzle);
                platno.pole = puzzle;
                platno.repaint();
            }
        });
        tlacitka.add(zamichej);

        JButton vyres = new JButton("Vyřeš");
        vyres.setSize(110,25);
        vyres.setLocation(160, 50);
        vyres.addActionListener(e -> {
            root = new Node(puzzle);
            solution = ui.BreadthFirstSearch(root);
            puzzle = solution.get(0).puzzle;
            Collections.reverse(solution);
            controller.setSolution(solution);
            platno.timer.start();
        });
        tlacitka.add(vyres);


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

}
