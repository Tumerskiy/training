import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Ftree {
	private static Person root;
	private static String res = "";
	public static void main(String[] args) {
		try {
		BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
		int inNum = Integer.parseInt(inReader.readLine());
		String rootString = inReader.readLine();
		root = new Person(rootString.split(" ")[0]);

		Person rootLeftChild = new Person(rootString.split(" ")[1]);
		root.setChild(rootLeftChild);
		
		for (int i=1;i<inNum;i++) {
			String personLine = inReader.readLine();
			Person parent = new Person(personLine.split(" ")[0]);
			Person child = new Person(personLine.split(" ")[1]);
			parent.setChild(child);
			root.setDescendant(parent);
		}
		
		int qNum = Integer.parseInt(inReader.readLine());
		for (int i=0;i<qNum;i++) {
			String qLine = inReader.readLine();
			String rel = qLine.split(" ")[1];
			if(rel.equals("child")) {
                if (root.getPerson(qLine.split(" ")[2]) != null && root.getPerson(qLine.split(" ")[2]).isChild(qLine.split(" ")[0])) {
                    res += "T";
                } else {
                    res += "F";
                }
            }
			else if(rel.equals("parent")){
			    if(root.getPerson(qLine.split(" ")[2])!=null && root.getPerson(qLine.split(" ")[2]).isParent(qLine.split(" ")[0])){
				res+="T";
			} else {
				res+="F";
			}}

            else if(rel.equals("sibling")) {
                if (root.getPerson(qLine.split(" ")[2]) != null && root.getPerson(qLine.split(" ")[2]).isSibling(qLine.split(" ")[0])) {
                    res += "T";
                } else {
                    res += "F";
                }
            }
            else if(rel.equals("descendant")) {
                if (root.getPerson(qLine.split(" ")[2]) != null && root.getPerson(qLine.split(" ")[2]).isDescendant(qLine.split(" ")[0])) {
                    res += "T";
                } else {
                    res += "F";
                }
            }
            else if(rel.equals("ancestor")){ if(root.getPerson(qLine.split(" ")[0])!=null && root.getPerson(qLine.split(" ")[0]).isDescendant(qLine.split(" ")[2])){
				res+="T";
			} else {
				res+="F";
			}
			}



		}

		} catch (Exception e) {
			e.printStackTrace();
		}
		//res+="\n";
		System.out.println(res);
		String traverse=Person.traverse(root,"");
        System.out.println(traverse);
	}
}
