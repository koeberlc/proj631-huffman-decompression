package main_program;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;



public class Frequency {
	
	private FileFunction file;
	private Hashtable<String,String> frequencyDict = new Hashtable<String,String>();
	private int nbChar = 0;
	
	public Frequency(FileFunction file) {
		super();
		this.file = file;
		this.frequencyDict = this.file.FrequencyReader();
		this.initNbChar();
	}
	

	public Hashtable<String, String> getFrequencyDict() {
		return frequencyDict;
	}

	public void setFrequencyDict(Hashtable<String, String> frequencyDict) {
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
		for(String v : frequencyDict.values()) {
			nbChar += Integer.parseInt(v);
		}
	}
	
}
