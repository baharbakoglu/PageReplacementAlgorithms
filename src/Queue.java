
class Queue
{
	private int size;
	private char[][] queuearr;
	private int first;
	private int last;
	private int valuenum;

	public Queue(int s)//define constructor
	{
		size = s;
		queuearr = new char[size][2];
		first = 0;
		last = -1;
		valuenum = 0;
	}
	public void add(char j, String s,char [] arr) // Add value in the end of the queue
	{
		int i=0;
		if(valuenum==size)
		{
			first=0;
			last=-1;
			valuenum=0;
		}
		++last;
		if(s.equals("SecondChance")){
			if(last==size)
			{last=0;}
			if(queuearr[last][0]!='1'){
				queuearr[last][1] = j;
				queuearr[last][0]='0';
				valuenum++;
			}else{
				while(queuearr[last][0]=='1')
				{
					arr[i]=queuearr[last][1];
					i++;
					queuearr[last][0]='0';
					++last;
					valuenum++;
					if(last==size)
					{last=0;}
				}
				if(queuearr[last][0]!='1'){
					queuearr[last][1] = j;
					queuearr[last][0]='0';
					valuenum++;
				}
			}
		}
		else {
			queuearr[last][1] = j;
			queuearr[last][0]='0';
			valuenum++;
		}
	}
	public char delete()//delete value
	{
		char temp = queuearr[first][1];
		first++;
		if(first==size) first=0;
		valuenum--;
		return temp;
	}
	public void list(WriteFile wf,char [] arr, String s)//list queue elements
	{
		int i;
		for(i=0; i<size ; i++)
		{
			wf.write(queuearr[i][1]);
			wf.write(" ");
		}
		if(s.equals("SecondChance")){
			if(arr[0]!=' '){
				wf.write("	 Second Chance");
			}
		}
		for(i=0;i<arr.length;i++){
			if(arr[i]!=' '){
				wf.write(" "+arr[i]);
				arr[i]=' ';
			}
		}
		wf.writeln("");
	}
	public int findvalue(char ch)//search value in queue array
	{
		for(int i=0; i<size ; i++)
		{
			if(queuearr[i][1]==ch)
			{
				queuearr[i][0]='1';
				return 1;
			}
		}
		return 0;
	}

}