package main_program;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <b>Class FileFuncion</b>
 * <p>
 * Global file management
 * </p>
 */
public class FileFunction {
	private String path;
	private File file;

	/**
	 * @param path (<i>type: String</i>): the path to the file to which we want to perform various actions
	 * 
	 * <p>
	 * Constructor
	 * </p>
	 */
	public FileFunction(String path){
		super();
		this.path = path;
		this.file = new File(path);
		
	}

	/**
	 * @return path
	 * 
	 * <i>Path getter</i>
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path
	 * 
	 * <p>Path setter</p>
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	
	/**
	 * @param text (<i>type: String</i>): the text content to write into the current file
	 * 
	 * <p>This method write a text passed in parameter into the current file</p>
	 */
	public void FileWriter(String text) {
		try {
			  file.createNewFile();
			  FileWriter myWriter = new FileWriter(file);
			  myWriter.write(text);
			  myWriter.close();
		      System.out.println("Le texte a bien été écrit");
		      
		      Desktop d = Desktop.getDesktop();
		      d.open(file);
		      
		    } catch (IOException e) {
		      System.out.println("Une erreur c'est produit");
		      e.printStackTrace();
		    }
	}
	
	/**
	 * @return text (<i>type: String</i>)
	 * 
	 * <p>This method return the entire text into the current file</p>
	 */
	public String FileReader() {
		String text = "";
		try {
			Scanner myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				text += myReader.nextLine();
			}
			myReader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Une erreur c'est produit");
			e.printStackTrace();
		}
		return text;
	}
	
	/**
	 * @param minusLine (<i>type: boolean</i>): if we don't want to keep the first line
	 * @return list (<i>type: List<\String></i>): a list of string containing a character with its frequency
	 * 
	 * <p>This method write for each line a string which will be added in a list.</p>
	 */
	public List<String> FileReader(boolean minusLine) {
		List<String> list = new ArrayList<String>();
		try {
			Scanner myReader = new Scanner(file);
			if(minusLine) {
				myReader.nextLine();
			}
			while (myReader.hasNextLine()) {
				list.add(myReader.nextLine());
			}
			myReader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Une erreur c'est produit");
			e.printStackTrace();
		}
		return list;
	}
	
	
}
