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
        checkedNodes.add(this);
        for (Node node : outgoing){
            result =  node.checkLock(checkedNodes);

            if (result.equals("Yes")){
                break;
            }
        }
        checkedNodes.remove(this);
        return result;
    }
}
