
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class FileRead {

	// The Class is used for reading a file

	// enable user to open file
	public Scanner openFile(String file) {
		Scanner input;
		try {
			input = new Scanner(new File(file));
			return input;
		} catch (FileNotFoundException fileNotFoundException) {
			System.err.println("Error opening file.");
			System.exit(1);
		}
		return null;
	}

	// close file
	public void closeFile(Scanner input) {
		if (input != null) {
			input.close();
		}
	}
		

}
