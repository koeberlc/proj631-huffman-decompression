package main_program;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;



public class Frequency {
	
	private FileFunction file;
	private List<String> frequencyDict;
	private int nbChar = 0;
	
	public Frequency(FileFunction file) {
		super();
		this.file = file;
		this.frequencyDict = this.file.FileReader(true);
		this.initNbChar();
	}
	

	public List<String> getFrequencyDict() {
		return frequencyDict;
	}

	public void setFrequencyDict(List<String> frequencyDict) {
		this.frequencyDict = frequencyDict;
		this.initNbChar();
	}

	public FileFunction getFile() {
		return file;
	}

	public void setFile(FileFunction file) {
		this.file = file;
	}

	public int getNbChar() {
		return nbChar;
	}

	public void setNbChar(int nbChar) {
		this.nbChar = nbChar;
	}
	
	public void initNbChar() {
		nbChar = 0;
		for(String v : frequencyDict) {
			nbChar += Integer.parseInt(v.substring(2));
		}
	}
	
}
