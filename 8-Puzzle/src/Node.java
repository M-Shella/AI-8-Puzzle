import java.util.ArrayList;
import java.util.Random;

public class Node {
    public ArrayList<Node> children = new ArrayList<>();
    public Node parent;
    public int[] puzzle = new int[9];
    public int x = 0;
    public int col = 3;
    public Random random;

    public Node(int[] p){
        random = new Random();
        SetPuzzle(p);
    }
    public void SetPuzzle(int[] p){
        for (int i = 0; i < puzzle.length; i++) {
            puzzle[i] = p[i];
        }
    }
    public void ExpandNode(){
        for (int i = 0; i < puzzle.length; i++) {
            if(puzzle[i] == 0){
                x = i;
            }
        }
        MoveToRight(puzzle, x);
        MoveToLeft(puzzle, x);
        MoveToUp(puzzle, x);
        MoveToDown(puzzle, x);
    }

    public void MoveToRight(int[] p, int i){
        if(i % col < col - 1){
            int[] pc = new int[9];
            CopyPuzzle(pc, p);

            int temp = pc[i + 1];
            pc[i+1] = pc[i];
            pc[i] = temp;

            Node child = new Node(pc);
            children.add(child);
            child.parent = this;
        }
    }
    public void MoveToLeft(int[] p, int i){
        if (i % col > 0){
            int[] pc = new int[9];
            CopyPuzzle(pc, p);

            int temp = pc[i - 1];
            pc[i-1] = pc[i];
            pc[i] = temp;

            Node child = new Node(pc);
            children.add(child);
            child.parent = this;
        }
    }
    public void MoveToUp(int[] p, int i){
        if(i - col >= 0){
            int[] pc = new int[9];
            CopyPuzzle(pc, p);

            int temp = pc[i - 3];
            pc[i-3] = pc[i];
            pc[i] = temp;

            Node child = new Node(pc);
            children.add(child);
            child.parent = this;
        }
    }
    public void MoveToDown(int[] p, int i){
        if(i + col < puzzle.length){
            int[] pc = new int[9];
            CopyPuzzle(pc, p);

            int temp = pc[i + 3];
            pc[i+3] = pc[i];
            pc[i] = temp;

            Node child = new Node(pc);
            children.add(child);
            child.parent = this;
        }
    }

    public void PrintPuzzle(){
        System.out.println("");
        int m = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(puzzle[m] + " ");
                m++;
            }
            System.out.println("");
        }
    }

    public boolean IsSamePuzzle(int[] p){
        boolean samePuzzle = true;
        for (int i = 0; i < p.length; i++) {
            if(puzzle[i] != p[i]) samePuzzle = false;
        }
        return samePuzzle;
    }

    public void CopyPuzzle(int[] a, int[] b){
        for (int i = 0; i < b.length; i++) {
            a[i] = b[i];
        }
    }

    public boolean GoalTest(){
        boolean isGoal = true;
        int m = puzzle[0];
        for (int i = 0; i < puzzle.length; i++) {
            if (m > puzzle[i]) isGoal = false;
            m = puzzle[i];
        }
        return isGoal;
    }
}
