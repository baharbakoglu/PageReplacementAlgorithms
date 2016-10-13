import java.util.Scanner;


public class Main {

	public static void main (String[] args){
		FileRead fr = new FileRead();
		WriteFile wf = new WriteFile();
		Scanner input;
		String tempstring;//for nextLine function
		String[] array;//for split function
		String Searchstructure=null, setreplacement=null;
		char[] characters= new char [5000];
		char[] arr=new char[10];
		int queuesize=0, i, count=0;
		char newvalue;
		Queue q;
		LinkedList list = new LinkedList();
		wf.openWFile("output.txt");//open output file in order to write

		for(i=0;i<5000;i++){
			characters[i]=' ';
		}
		for(i=0;i<10;i++){
			arr[i]=' ';
		}
		i=0;
		input = fr.openFile("input.txt");//open file
		System.out.println();
		while(input.hasNext()){

			tempstring = input.nextLine();//read line
			array = tempstring.split(" ");//part according to space
			if(array[0].equals("SetMemory"))
			{
				queuesize = Integer.parseInt(array[1]);
				wf.writeln("Memory "+array[1]);
			}

			if(array[0].equals("setSearchStructure"))
			{
				Searchstructure = array[1];
				if(array[1].equals("BinaryTree")||array[1].equals("BinarySearch"))
				{
					wf.writeln("Binary Search Tree");
				}
				else if(array[1].equals("UnorderedList"))
				{
					wf.writeln("Unordered Linked List");
				}
			}
			if(array[0].equals("setReplacement"))
			{
				setreplacement = array[1];
				if(array[1].equals("FIFO"))
				{
					wf.writeln("FIFO Page Replacement");
				}
				else if(array[1].equals("SecondChance"))
				{
					wf.writeln("Second Chance Page Replacement");
				}
			}
			if(array[0].equals("Read"))
			{
				newvalue = array[1].charAt(0);
				characters[i]=newvalue;
				i++;
			}

		}
		q = new Queue (queuesize);//create new Queue
		Tree theTree = new Tree();//create new Tree
		wf.writeln("");
		if(Searchstructure.equals("BinaryTree")||Searchstructure.equals("BinarySearch"))
		{//if search structure is equal binary search tree
			for(i=0;i<5000;i++){
				if(characters[i]!=' '){
					if(q.findvalue(characters[i])==1){
						wf.write("          	 ");
						q.list(wf,arr,setreplacement);
					}
					else{   //add character in queue and tree
						q.add(characters[i],setreplacement,arr);
						theTree.add(characters[i]);
						wf.write("Page Fault	 ");
						count++;
						q.list(wf,arr,setreplacement);
					}
				}
			}
		}
		else if(Searchstructure.equals("UnorderedList"))
		{//if search structure is equal unordered list
			for(i=0;i<5000;i++){
				if(characters[i]!=' '){
					if(list.search(characters[i],queuesize)==1){
						q.findvalue(characters[i]);
						wf.write("          	 ");
						q.list(wf,arr,setreplacement);
					}
					else{
                                                //add character in queue and linkedlist
						q.add(characters[i],setreplacement,arr);
						list.addvalue(characters[i]);
						wf.write("Page Fault	 ");
						q.list(wf,arr,setreplacement);
						count++;
					}
				}
			}
		}
		wf.writeln(count);
                fr.closeFile(input);//close input file
                wf.closeWFile();//close output file




	}



}
