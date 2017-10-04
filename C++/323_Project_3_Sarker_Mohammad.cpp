#include <iostream>
#include <fstream>
using namespace std;

class listBinTreeNode{
	private:
		string chStr;
		int Prob;
		listBinTreeNode* next;
		listBinTreeNode* left;
		listBinTreeNode* right;
		
	public:
		listBinTreeNode(string chstr, int prob){
			chStr = chstr;
			Prob = prob;
		}
		
		listBinTreeNode(){
			Prob = 0;
			chStr = "";
			next = NULL;
			left = NULL;
			right = NULL;
		}
		
		string getchStr(){
			return chStr;
		}
		
		void setchStr(string chstr){
			chStr = chstr;
		}
		
		int getProb(){
			return Prob;
		}
		
		void setProb(int prob){
			Prob = prob;
		}
		
		listBinTreeNode* getNext(){
			return next;
		}
		
		void setNext(listBinTreeNode* n){
			next = n;
		}
		
		listBinTreeNode* getLeft(){
			return left;
		}
		
		void setLeft(listBinTreeNode* n){
			left = n;
		}
		
			listBinTreeNode* getRight(){
			return right;
		}
		
		void setRight(listBinTreeNode* n){
			right = n;
		}
	
		void printNode(listBinTreeNode* T, ofstream& output){
			if(T != NULL){
		
				output<<"T's chStr:"<<T->getchStr()<<"\n";
				output<<"T's prob:"<<T->getProb() << "\n";
				
				if(T->getNext()==NULL){
					output<<"T's Next chStr:NULL"<<"\n";
				}
				if(T->getNext()!=NULL){
					output<<"T's Next chStr:"<<T->getNext()->getchStr()<<"\n";
				}
				if(T->getLeft()==NULL ){
					output<<"T's Left chStr:NULL"<<"\n";
		 		}
		 		if(T->getLeft()!=NULL){
					output<<"T's Left chStr:"<<T->getLeft()->getchStr()<<"\n";
				 }
				if(T->getRight()==NULL ){
					output<<"T's Right chStr:NULL"<<"\n";
		 		}
		 		if(T->getRight()!=NULL){
					output<<"T's Right chStr:"<<T->getRight()->getchStr()<<"\n";
				 }
		}
 		
	}
};

class HuffmanLinkedList {
	private:
		listBinTreeNode* ListHead;
 		listBinTreeNode* OldListHead;
	 	listBinTreeNode* Dummy;
	 	int Size;
	 	
	public:
	 	HuffmanLinkedList(){
			Dummy = NULL;
			OldListHead = NULL;
			Size = 0;
			ListHead = Dummy;
		}
		listBinTreeNode* getListHead() {
			return ListHead;
		}

		void setListHead(listBinTreeNode* listHead) {
			ListHead = listHead;
		}

		listBinTreeNode* getDummy() {
			return Dummy;
		}

		void setDummy(listBinTreeNode* dummy) {
			Dummy = dummy;
		}

		listBinTreeNode* getOldListHead() {
			return OldListHead;
		}


		void setOldListHead(listBinTreeNode* oldListHead) {
			OldListHead = oldListHead;
		}
		
		
		void constructHuffmanLList(char* argv[],ofstream &output6){
		
			ifstream inFile;
			string chStr;
			int prob;
			listBinTreeNode* dummy = new listBinTreeNode("dummy",0);
        	ListHead = dummy;
    
        	inFile.open(argv[1]);
        	while(inFile>>chStr >> prob){
				listBinTreeNode* spot = findSpot(prob,ListHead);
				listBinTreeNode* newNode = new listBinTreeNode(chStr,prob);
				listInsert(spot,newNode);
				printList(ListHead,output6);
				output6<<"\n";           
            	
     		}
       		 inFile.close();
		}
		
		
		
		listBinTreeNode* findSpot(int prob, listBinTreeNode* list){
			listBinTreeNode* n = list;
			while(n!=NULL){
			
			if(n->getProb()<= prob && n->getNext()==NULL)
				break;
			else if(n->getProb()>prob){
				n=ListHead;
				break;
			}
				
			else if(n->getProb()<=prob && n->getNext()->getProb()>=prob)
				break;
			n=n->getNext();
				
			}
			return n;	
		
		}
	
	 	void listInsert(listBinTreeNode* spot,listBinTreeNode* newNode){
			newNode->setNext(spot->getNext());
			spot->setNext(newNode);
			Size++;
		}
	
	 	bool isEmpty(){
			return Size==0;
		}
	
		 void printList(listBinTreeNode* list,ofstream& output6){
			listBinTreeNode* n = list;
	
			while(n!=NULL){
				if(n->getNext()==NULL){
					output6<<"("<<n->getchStr() <<","<< n->getProb() <<"," <<"NULL" <<")" <<"-->" <<"NULL";
				
				}
				else{
					output6<<"("<<n->getchStr() <<","<< n->getProb() << ","<< n->getNext()->getchStr()<<")" <<"-->" ;
				}
				n=n->getNext();
			}
		}

		int getSize() {
			return Size;
		}

};
class HuffmanBinaryTree {
	public:
		class charInfo{
			string charString;
			int probability;
			string code;
		};
	
	private:
		listBinTreeNode* Root;
	public:		
		HuffmanBinaryTree(){
			Root = NULL;
			
		}
		
		listBinTreeNode* getRoot(){
			return Root;
		}
		
		void setRoot(listBinTreeNode* n){
			Root = n;
		}
		
		
		
		void constructHuffmanBinTree(HuffmanLinkedList* l, ofstream& output6){
			listBinTreeNode* dummy = new listBinTreeNode();
			l->setOldListHead(dummy);
			l->getOldListHead()->setNext((l->getListHead()->getNext()));
		

			while(l->getListHead()->getNext()->getNext()!=NULL){
				listBinTreeNode* spot = new listBinTreeNode();
				listBinTreeNode* newNode = new listBinTreeNode();
				if(l->getListHead()->getNext()->getNext()==NULL){
					newNode->setProb(l->getListHead()->getNext()->getProb());
					newNode->setchStr(l->getListHead()->getNext()->getchStr());
		
				}
				
				else{
					newNode->setProb(l->getListHead()->getNext()->getProb()+l->getListHead()->getNext()->getNext()->getProb());
					newNode->setchStr(l->getListHead()->getNext()->getchStr()+l->getListHead()->getNext()->getNext()->getchStr());
					newNode->setLeft(l->getListHead()->getNext());
					newNode->setRight(l->getListHead()->getNext()->getNext());
				
				}
			
			
				output6<<"\n";
				l->setListHead(l->getListHead()->getNext()->getNext());
				l->setOldListHead(l->getListHead());
		
				spot=l->findSpot(newNode->getProb(),l->getOldListHead());
				l->listInsert(spot, newNode);
			
				newNode->printNode(newNode,output6);
				l->printList(l->getOldListHead()->getNext(),output6);
				Root = newNode;
			
			}
		
		}
		
	 	void preOderTraversal(listBinTreeNode* T, ofstream& output3){
			if(T !=NULL){
				output3<<"\n";
				T->printNode(T,output3);
				preOderTraversal(T->getLeft(),output3);
				preOderTraversal(T->getRight(),output3);
			}
		}
		
		void inOderTraversal(listBinTreeNode* T,ofstream& output4){
			if(T !=NULL){
				inOderTraversal(T->getLeft(),output4);
				output4<<"\n";
				T->printNode(T,output4);
				inOderTraversal(T->getRight(),output4);
			}
		}
		void postOderTraversal(listBinTreeNode* T,ofstream& output5){
			if(T !=NULL){
				
				postOderTraversal(T->getLeft(),output5);
				postOderTraversal(T->getRight(),output5);
				output5<<"\n";
				T->printNode(T,output5);
			}
		}
	
	 	bool isLeaf(listBinTreeNode* n){
			return n->getLeft()== NULL && n->getRight() == NULL;
		}

	 	void constructCharCode(listBinTreeNode*T, string code, ofstream& output2){
			if(T == NULL){
				output2<<"this is an empty tree" <<"\n";
				return;
			}
			else if(isLeaf(T)){
			
				output2<<"<"<<T->getchStr()<< " " << code<<">" <<"\n";
			
			}
			else{
				constructCharCode(T->getLeft(),code+"0",output2);
				constructCharCode(T->getRight(),code+"1",output2);
			}
		
		}
		
		
};






int main(int argc, char** argv) {
		if(argc<7){
			cout<<"ERROR WITH ARGUMENTS. * EXAMPLE ARGUMENTS * : File.exe INPUT-FILE OUTPUT-FILE...";
			exit(1);
		}

		HuffmanLinkedList l;
		HuffmanBinaryTree T;
		ofstream output2;
		ofstream output3;
		ofstream output4;
		ofstream output5;
		ofstream output6;
		
		output6.open(argv[6]);
		output6<<"DEBUG-PURPOSE"<<"\n";
		output6<<"//LINKEDLIST-CONSTRUCTION-PRINTLIST"<<"\n";
		l.constructHuffmanLList(argv,output6);
		output6<<"\n";
		output6<<"//BINARYTREE-CONSTRUCTION-PRINTLIST & PRINT NODE" <<"\n";
		T.constructHuffmanBinTree(&l,output6);
		output6.close();
		
		output2.open(argv[2]);
		output2<<"CHAR CODE PAIR"<<"\n";
		T.constructCharCode(T.getRoot(),"",output2);
		output2.close();
		
		output3.open(argv[3]);
		output3<<"PRE-ORDER"<<"\n";
		T.preOderTraversal(T.getRoot(),output3);
		output3.close();
		
		output4.open(argv[4]);
		output4<<"IN-ORDER"<<"\n";
		T.inOderTraversal(T.getRoot(),output4);
		output4.close();
		
		output5.open(argv[5]);
		output5<<"POST-ORDER"<<"\n";
		T.postOderTraversal(T.getRoot(),output5);
		output5.close();
		
	
}


