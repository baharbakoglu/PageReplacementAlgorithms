public class Tree
{
	private TreeNode root;
	
 public Tree()//constructor
 { 
	root = null; 
 }

 public TreeNode getRoot()//return root
 { 
	 return root; 
 }
 
 public int preOrder(TreeNode localRoot, char ch)//search value in tree with preorder
 {
	 if(localRoot!=null)
	 {
		 if(localRoot.data==ch)
		 {
                	 return 1;
		 }
                 if(localRoot.data<ch){
                    preOrder(localRoot.leftChild,ch);
                 }
                 if(localRoot.data>ch){
                    preOrder(localRoot.rightChild,ch);
                 }
	 }
	 return 0;
 }

 public void add(char newdata)//add value in Tree
 {
	 TreeNode newNode = new TreeNode();
	 newNode.data = newdata;
	 newNode.control=0;
	 if(root==null)
		 root = newNode;
	 else
	 {
		 TreeNode current = root;
		 TreeNode parent;
		 while(true)
		 {
			 parent = current;
			 if(newdata<current.data)
			 {
				 current = current.leftChild;
				 if(current==null)
				 {
					 parent.leftChild=newNode;
					 return;
				 }
			 } else
			 {
				 current = current.rightChild;
				 if(current==null)
				 {
					 parent.rightChild=newNode;
					 return;
				 }
			 }
		 } 
	 } 
 	} 
 }