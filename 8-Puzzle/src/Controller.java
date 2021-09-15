import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Controller {
    private static Controller instance;
    public static Controller GetInstance() {
        if (instance == null) instance = new Controller();
        return instance;
    }

    Random random;
    ArrayList<Node> solution;

    public Controller() {
        random = new Random();
    }

    public ArrayList<Node> getSolution() {
        return solution;
    }

    public void setSolution(ArrayList<Node> solution) {
        this.solution = solution;
    }
    int x;
    public int[] zamichej(int[] puzzle){
        int[] pc = puzzle;
        int help = random.nextInt(4)+1;
        for (int i = 0; i < puzzle.length; i++) {
            if(puzzle[i] == 0){
                x = i;
            }
        }
        if (help == 1 && x % 3 < 3 - 1){
            //prava
            int temp = pc[x + 1];
            pc[x+1] = pc[x];
            pc[x] = temp;
        }

        if (help == 2 && x % 3 > 0){
            //leva
            int temp = pc[x - 1];
            pc[x-1] = pc[x];
            pc[x] = temp;
        }

        if (help == 3 && x - 3 >= 0){
            int temp = pc[x - 3];
            pc[x-3] = pc[x];
            pc[x] = temp;
        };

        if(help == 4 && x + 3 < puzzle.length){
            //dolu
            int temp = pc[x + 3];
            pc[x+3] = pc[x];
            pc[x] = temp;

        }
        return pc;
    }
}
