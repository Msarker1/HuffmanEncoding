import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;


public class Project_3 {
	
	public static void main(String [] args){
		
		if(args.length<6){
			System.out.println("ERROR WITH ARGUMENTS. * EXAMPLE ARGUMENTS * : java FILE INPUT-FILE OUTPUT-FILE...");
		}
			FileOutputStream output1 = null;
			FileOutputStream output2 = null;
			FileOutputStream output3 = null;
			FileOutputStream output4 = null;
			FileOutputStream output5 = null;
			try {
				output1 = new FileOutputStream(args[1]); // char-code
				output2 = new FileOutputStream(args[2]); // pre-order
				output3 = new FileOutputStream(args[3]); // in-order
				output4 = new FileOutputStream(args[4]); //post-order
				output5 = new FileOutputStream(args[5]);// debug
			} catch (FileNotFoundException e) {
					
				e.printStackTrace();
			}
	     
			HuffmanLinkedList n = new HuffmanLinkedList();
			HuffmanBinaryTree T = new HuffmanBinaryTree();
			
			PrintStream print5 = new PrintStream(output5);
			System.setOut(print5);
			System.out.println("DEBUG-PURPOSE");
			System.out.println("//LINKEDLIST-CONSTRUCTION-PRINTLIST");
			
			n.constructHuffmanLList(args);
			System.out.println();
			System.out.println("//BINARYTREE-CONSTRUCTION-PRINTLIST & PRINT NODE");
			T.constructHuffmanBinTree(n);
			try {
				output5.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			PrintStream print1 = new PrintStream(output1);
			System.setOut(print1);
			System.out.println("CHAR CODE PAIR");
			T.constructCharCode(T.getRoot(),"");
			try {
				output1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			PrintStream print2 = new PrintStream(output2);
			System.setOut(print2);
			System.out.println("PRE-ORDER");
			T.preOderTraversal(T.getRoot());
			try {
				output2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			PrintStream print3 = new PrintStream(output3);
			System.setOut(print3);
			System.out.println("IN-ORDER");
			T.inOderTraversal(T.getRoot());
			try {
				output3.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	
			PrintStream print4 = new PrintStream(output4);
			System.setOut(print4);
			System.out.println("POST-ORDER");
			T.postOderTraversal(T.getRoot());
			try {
				output4.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}

}
