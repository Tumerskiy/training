import java.util.ArrayList;

public class Node {
    private String id;
    private ArrayList<Node> outgoing = new ArrayList<>();

    public Node(String id) {
        this.id = id;
    }

    public void setOutgoing(Node n){
        this.outgoing.add(n);
    }

    public String checkLock(ArrayList<Node> checkedNodes){
        String result = "No";
        for (Node checked : checkedNodes){
            if (checked==this){
                return "Yes";
            }
        }
        for (Node node : outgoing){
            checkedNodes.add(this);
            result =  node.checkLock(checkedNodes);
            if (result.equals("Yes")){
                break;
            }
        }
        return result;
    }
}
