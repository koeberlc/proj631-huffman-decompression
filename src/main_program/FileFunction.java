package main_program;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class FileFunction {
	private String path;
	private File file;

	public FileFunction(String path) {
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
		      FileWriter myWriter = new FileWriter(file);
		      myWriter.write(text);
		      myWriter.close();
		      System.out.println("Le texte a bien été écrit");
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
	
	public Hashtable FrequencyReader() {
		Hashtable<String,String> list_dict = new Hashtable<String,String>();
		try {
			Scanner myReader = new Scanner(file);
			myReader.nextLine();
			while (myReader.hasNextLine()) {
				String text = myReader.nextLine();
				list_dict.put(text.split(" ")[0], text.split(" ")[1]);
			}
			myReader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Une erreur c'est produit");
			e.printStackTrace();
		}
		return list_dict;
	}
}
