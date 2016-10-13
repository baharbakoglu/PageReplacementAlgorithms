import java.io.*;

public class WriteFile {
	
	private PrintWriter file=null;

	//The Class is used for writing a file
	
	//write string
	public void write(String str) {
		file.print(str);
	}
	//write character
	public void write(char value) {
		file.print(value);
	}
	//write string
	public void writeln(String str) {
		file.println(str);
	}
	//write character
	public void writeln(char value) {
		file.println(value);	
	}
	//write number
	public void writeln(int value) {
		file.println(value);	
	}
	//open output file
	public void openWFile(String fileName){
			try{
				file = new PrintWriter(new FileOutputStream(fileName), true);
		    }catch ( FileNotFoundException fileNotFoundException ){
		           System.err.println( "Error opening file." );
		           System.exit( 1 );
		    } 
	}
		
	//close output file
	public void closeWFile(){
		if ( file != null ){
				 file.close();
		}
	}
 
			
	
}
