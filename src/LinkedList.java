
public class LinkedList {
	
	public Node first;
	
	public LinkedList ()//create an empty linked list
	{
		first = null;
	}
	
	public void addvalue(char ch)//add value in linkedlist's first element
	{
		Node n = new Node(ch);
		n.next = first;
		first =  n;
	}
	public int search(char ch,int searchsize){//search element in linked list
		int i=0;
		Node current=first;
		while((current!=null)&&(i<searchsize))
		{
			if(current.value==ch)
			{
				return 1;
			}
			else 
				current = current.next;
		   		i++;
		}
		return 0;
        }
}
