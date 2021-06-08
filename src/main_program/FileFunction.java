package main_program;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class FileFunction {
	private String path;
	private File file;

	public FileFunction(String path){
		super();
		this.path = path;
		this.file = new File(path);
		
	}

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
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
