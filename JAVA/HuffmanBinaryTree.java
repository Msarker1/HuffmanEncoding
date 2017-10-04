
public class HuffmanBinaryTree {
	class charInfo{
		private String chStr;
		private int prob;
		private String code;
		
		public String getChStr() {
			return chStr;
		}
		public void setChStr(String chStr) {
			this.chStr = chStr;
		}
		public int getProb() {
			return prob;
		}
		public void setProb(int prob) {
			this.prob = prob;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		
	}
	
	private listBinTreeNode Root;
	
	
	public HuffmanBinaryTree() {
		this.Root = null;
	}

	public listBinTreeNode getRoot() {
		return Root;
	}

	public void setRoot(listBinTreeNode root) {
		Root = root;
	}
	
	public void constructHuffmanBinTree(HuffmanLinkedList l){
		listBinTreeNode dummy = new listBinTreeNode();
		l.setOldListHead(dummy);
		l.getOldListHead().setNext((l.getListHead().getNext()));
		
		while(l.getListHead().getNext().getNext()!=null){
			listBinTreeNode spot = new listBinTreeNode();
			listBinTreeNode newNode = new listBinTreeNode();
			if(l.getListHead().getNext().getNext()==null){
				newNode.setProb(l.getListHead().getNext().getProb());
				newNode.setChStr(l.getListHead().getNext().getChStr());
		
			}
			else{
				newNode.setProb(l.getListHead().getNext().getProb()+l.getListHead().getNext().getNext().getProb());
				newNode.setChStr(l.getListHead().getNext().getChStr()+l.getListHead().getNext().getNext().getChStr());
				newNode.setLeft(l.getListHead().getNext());
				newNode.setRight(l.getListHead().getNext().getNext());
			}
			System.out.println();
			
			l.setListHead(l.getListHead().getNext().getNext());
			l.setOldListHead(l.getListHead());
	
			spot=l.findSpot(newNode.getProb(),l.getOldListHead());
			l.listInsert(spot, newNode);
			
			newNode.printNode(newNode);
			l.printList(l.getOldListHead().getNext());
			Root = newNode;
		}
	}

	public void preOderTraversal(listBinTreeNode T){
		
		if(T !=null){
			System.out.println();
			T.printNode(T);
			preOderTraversal(T.getLeft());
			preOderTraversal(T.getRight());
		}
	}
	public void inOderTraversal(listBinTreeNode T){
		if(T != null){
			
			inOderTraversal(T.getLeft());
			System.out.println();
			T.printNode(T);
			inOderTraversal(T.getRight());
		}
	}
	public void postOderTraversal(listBinTreeNode T){
		if(T != null){
			postOderTraversal(T.getLeft());
			postOderTraversal(T.getRight());
			System.out.println();
			T.printNode(T);
		}
	}
	public boolean isLeaf(listBinTreeNode n){
		return n.getLeft()== null && n.getRight() == null;
	}

	public void constructCharCode(listBinTreeNode T ,String code){
		
		if(T == null){
			System.out.println("this is an empty tree");
			return;
		}
		else if(isLeaf(T)){
			
			System.out.println("<"+T.getChStr()+ " " + code+">");
			
		}
		else{
			constructCharCode(T.getLeft(),code+"0");
			constructCharCode(T.getRight(),code+"1");
		}
		
}}	
