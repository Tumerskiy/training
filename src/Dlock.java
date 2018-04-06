import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Dlock {
    public static void setNode(HashMap<String,Node> graph, String a){
        if(graph.get(a)==null){
            Node aNode = new Node(a);
            graph.put(a,aNode);
        }
    }

    public static void setOut(HashMap<String,Node> graph, String a, String b){
        if (graph.get(a)==null){
            Node aNode = new Node(a);
            if (graph.get(b)==null){
                Node bNode = new Node(b);
                aNode.setOutgoing(bNode);
                graph.put(a,aNode);
                graph.put(b,bNode);
            } else{
                aNode.setOutgoing(graph.get(b));
                graph.put(a,aNode);
            }
        } else{
            if (graph.get(b)==null){
                Node bNode = new Node(b);
                graph.get(a).setOutgoing(bNode);
                graph.put(b,bNode);
            } else{
                graph.get(a).setOutgoing(graph.get(b));
            }
        }
    }

    public static void main(String[] args){
        try {
            String result = "No";
            BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
            HashMap<String, Node> graph = new HashMap<>();
            int n = Integer.parseInt(inReader.readLine());
            for (int i=0;i<n;i++){
                String inLine = inReader.readLine();
                String[] inSplit = inLine.split(" ");
                String process = inSplit[0];
                String aResource = inSplit[1];
                String cResource = inSplit[2];

                if(!cResource.equals("-1")){
                    if(!aResource.equals("-1")){
                        setOut(graph,process,cResource);
                        setOut(graph,aResource,process);
                    } else{
                        setOut(graph,process,cResource);
                    }
                } else{
                    if(!aResource.equals("-1")){
                        setOut(graph,aResource,process);
                    } else{
                        setNode(graph,process);
                    }
                }

            }

            for(String key: graph.keySet()){
                if (graph.get(key).checkLock(new ArrayList<Node>()).equals("Yes")){
                    result = "Yes";
                    break;
                }
            }
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
