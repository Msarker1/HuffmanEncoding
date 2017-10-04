import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class HuffmanLinkedList {
	private listBinTreeNode listHead;
	private listBinTreeNode oldListHead;
	private listBinTreeNode dummy;
	private int Size;
	
	public HuffmanLinkedList(){
		this.dummy  = null;
		this.oldListHead = null;
		this.Size = 0;
		this.listHead = dummy;
		
	}
	
	public listBinTreeNode getListHead() {
		return listHead;
	}


	public void setListHead(listBinTreeNode listHead) {
		this.listHead = listHead;
	}


	public listBinTreeNode getDummy() {
		return dummy;
	}


	public void setDummy(listBinTreeNode dummy) {
		this.dummy = dummy;
	}

	public listBinTreeNode getOldListHead() {
		return oldListHead;
	}


	public void setOldListHead(listBinTreeNode oldListHead) {
		this.oldListHead = oldListHead;
	}
	
	
	public void constructHuffmanLList(String [] args){
		
		Scanner inFile = null;
		listBinTreeNode dummy = new listBinTreeNode("dummy",0);
		
        listHead = dummy;
    
        try {
            inFile = new Scanner(new FileReader(args[0]));
            while(inFile.hasNext()){
            	String chStr = inFile.next();	
            	int  prob = inFile.nextInt();
            		listBinTreeNode spot = findSpot(prob,listHead);
            		listBinTreeNode newNode = new listBinTreeNode(chStr,prob);
            		listInsert(spot,newNode);
            		printList(listHead);
            		System.out.println();
            	
            }
        } catch (IOException ioException) {
            System.err.println("Cannot open file.");

        }
        inFile.close();
		
		
	}
	
	public listBinTreeNode findSpot(int prob, listBinTreeNode list){
		listBinTreeNode n = list;
		while(n!=null){
			
			if(n.getProb()<= prob && n.getNext()==null)
				break;
			else if(n.getProb()>prob){
				n= listHead;
				break;
			}
				
			else if(n.getProb()<=prob && n.getNext().getProb()>=prob)
				break;
			n=n.getNext();
				
		}
		return n;
		
		
	}
	
	public void listInsert(listBinTreeNode spot,listBinTreeNode newNode){
		newNode.setNext(spot.getNext());
		spot.setNext(newNode);
		Size++;
	}
	
	
	
	public void printList(listBinTreeNode list){
		listBinTreeNode n = list;
		
		while(n!=null){
			if(n.getNext()==null){
				System.out.print("("+n.getChStr() +"," + n.getProb() +","+ "NULL" +")" + "-->" +"NULL");
				
			}
			else{
				System.out.print("("+n.getChStr() +","+ n.getProb() + ","+ n.getNext().getChStr()+")" + "-->" );
			}
			n=n.getNext();
		}
	}

	public int getSize() {
		return Size;
	}

	


	
}
