
public class listBinTreeNode {
	private String chStr;
	private int prob;
	private listBinTreeNode next;
	private listBinTreeNode left;
	private listBinTreeNode right;
	
	public listBinTreeNode(String chStr, int prob){
		this.chStr = chStr;
		this.prob = prob;
	}
	
	public listBinTreeNode(){
		this.prob = 0;
		this.chStr = null;
		this.next = null;
		this.left = null;
		this.right = null;
	}
	
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
	public listBinTreeNode getNext() {
		return next;
	}
	public void setNext(listBinTreeNode next) {
		this.next = next;
	}
	public listBinTreeNode getLeft() {
		return left;
	}
	public void setLeft(listBinTreeNode left) {
		this.left = left;
	}
	public listBinTreeNode getRight() {
		return right;
	}
	public void setRight(listBinTreeNode right) {
		this.right = right;
	}
	
	public void printNode(listBinTreeNode T){
		
		if(T!=null){
			
		
		System.out.println("T's chStr:"+T.getChStr());
		System.out.println("T's prob:"+T.getProb());
		
	
		 if( T.getNext()==null){
			System.out.println("T's Next chStr:NULL");
		 }
		 if(T.getNext()!=null){
			System.out.println("T's Next chStr:"+T.getNext().getChStr());
		 }
		 if(T.getLeft()==null ){
			System.out.println("T's Left chStr:NULL");
		 }
		 if(T.getLeft()!=null){
			System.out.println("T's Left chStr:"+T.getLeft().getChStr());
		 }
		 if(T.getRight()==null ){
			System.out.println("T's Right chStr:NULL");
		 }
		 if(T.getRight()!=null){
			System.out.println("T's Right chStr:"+T.getRight().getChStr());
		 }
		 
		}
	}
}
