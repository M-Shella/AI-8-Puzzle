import java.util.ArrayList;

public class UninformedSearch {
    public UninformedSearch(){
    }
    public ArrayList<Node> BreadthFirstSearch(Node root){
        ArrayList<Node> PathToSolution = new ArrayList<>();
        ArrayList<Node> OpenList = new ArrayList<>();
        ArrayList<Node> ClosedList = new ArrayList<>();

        OpenList.add(root);
        boolean goalFound = false;

        while(!OpenList.isEmpty() && !goalFound){
            Node currentNode = OpenList.get(0);
            ClosedList.add(currentNode);
            OpenList.remove(0);

            currentNode.ExpandNode();
//            currentNode.PrintPuzzle();
            for (int i = 0; i < currentNode.children.size(); i++) {
                Node currentChild = currentNode.children.get(i);
                if (currentChild.GoalTest()){
                    System.out.println("Goal found");
                    goalFound = true;
                    PathTrace(PathToSolution, currentChild);
                }
                if(!Contains(OpenList, currentChild) && !Contains(ClosedList, currentChild)){
                    OpenList.add(currentChild);
                }
            }
        }
        return PathToSolution;
    }
    public void PathTrace(ArrayList<Node> path, Node n){
        System.out.println("Tracing path..");
        Node current = n;
        path.add(current);
        while (current.parent != null){
            current = current.parent;
            path.add(current);
        }
    }

    public static boolean Contains(ArrayList<Node> list, Node c){
        boolean contains = false;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).IsSamePuzzle(c.puzzle))contains = true;
        }
        return contains;
    }
}
