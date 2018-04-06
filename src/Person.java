public class Person {
	public String name;
	private Person parent;
	private Person leftChild;
	private Person rigthChild;
	public boolean full = false;
	
	public Person(String name) {
		this.name = name; 
	}
	public Person getLeftChild() {
		return this.leftChild;
	}
	public Person getRigthChild() {
		return this.rigthChild;
	}
	public void setParent(Person parent) {
		this.parent = parent;
	}

	public void setChild(Person child) {
		if (this.leftChild == null) {
			this.leftChild = child;
			child.setParent(this);
		} else if (this.rigthChild == null) {
			this.rigthChild = child;
			child.setParent(this);
			this.full = true;
		}
	}

	public void setDescendant(Person desc) {
		if (this.name.equals(desc.name)) {
			this.setChild(desc.leftChild);
			return;
		}
		else if (this.leftChild != null && this.leftChild.name.equals(desc.name)){
			this.leftChild.setChild(desc.getLeftChild());
			return;
		}
		else if (this.rigthChild != null && this.rigthChild.name.equals(desc.name)){
			this.rigthChild.setChild(desc.getLeftChild());
			return;
		}else {
			if (this.leftChild != null) {
				this.leftChild.setDescendant(desc);
			}
			if (this.rigthChild != null) {
				this.rigthChild.setDescendant(desc);
			}
		}
	}
	
	public boolean isChild(String childName) {
		return ((this.leftChild!=null&&this.leftChild.name.equals(childName)) || (this.rigthChild!=null&&this.rigthChild.name.equals(childName)));
	}
	
	public boolean isParent(String parentName) {
		return (this.parent!=null&&this.parent.name.equals(parentName));
	}
	
	public boolean isSibling(String siblingName) {
		return ((this.parent!=null&&this.parent.getLeftChild()!=null&&this.parent.getLeftChild().name.equals(siblingName)) || (this.parent!=null&&this.parent.getRigthChild()!=null&&this.parent.getRigthChild().name.equals(siblingName)));
	}
	
	public boolean isDescendant(String descName) {
		if (this.leftChild==null && this.rigthChild==null) {
			return false;
		}
		if ((this.leftChild!=null&&this.leftChild.name.equals(descName)) || (this.rigthChild!=null&&this.rigthChild.name.equals(descName))) {
			return true;
		} else {
			boolean res = false;
			if (this.leftChild!=null&&this.leftChild.isDescendant(descName)){
				res = true;
			}
			if (this.rigthChild!=null&&this.rigthChild.isDescendant(descName)){
				res = true;
			}
			return res;
		}
	}
	
	public Person getPerson(String personName) {
		if (this.name.equals(personName)){
			return this;
		}
		if (this.leftChild !=null && this.leftChild.name.equals(personName)) {
			return leftChild;
		} else if (this.rigthChild!=null && this.rigthChild.name.equals(personName)) {
			return rigthChild;
		} else {
			Person person1 = null;
			Person person2 = null;
			if (this.leftChild !=null) {
				person1 = (leftChild.getPerson(personName));
			}
			if (this.rigthChild !=null) {
				person2 = (rigthChild.getPerson(personName));
			}
			if (person1 != null) {
				return person1;
			} 
			if (person2 !=null ){
				return person2;
			}
			return null;
		}
	}
	public static String traverse(Person root, String res){
		res=root.name;
		if (root.getLeftChild()!=null){
			//res+=" "+root.getLeftChild().name;
			res += " "+traverse(root.getLeftChild(), res);
		}
		if (root.getRigthChild()!=null){
			//res+=" "+root.getRigthChild().name;
			res += " "+traverse(root.getRigthChild(), res);
		}
//		if (root.getLeftChild()!=null) {
//			res += traverse(root.getLeftChild(), res);
//		}
//		if(root.getRigthChild()!=null){
//			res += " "+traverse(root.getRigthChild(), res);
//		}
		return res;
	}
}
