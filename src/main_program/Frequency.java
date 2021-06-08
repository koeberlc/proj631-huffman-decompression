package main_program;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;



/**
 * <b>Class Frequency</b>
 * 
 * <p>Global method related to frequencies</p>
 *
 */
public class Frequency {
	
	private FileFunction file;
	private List<String> frequencyDict;
	private int nbChar = 0;
	
	/**
	 * @param file (<i>type: FileFunction</i>): File lexicon related to the compressed file
	 * 
	 * <p>Constructor</p>
	 */
	public Frequency(FileFunction file) {
		super();
		this.file = file;
		this.frequencyDict = this.file.FileReader(true);
		this.initNbChar();
	}
	

	/**
	 * @return frequencyDict (<i>type: List<\String></i>): a list of string containing a character with its frequency
	 * 
	 * <p>FequencyDict getter</p>
	 */
	public List<String> getFrequencyDict() {
		return frequencyDict;
	}

	/**
	 * @param frequencyDict (<i>type: List<\String></i>): a list of string containing a character with its frequency
	 * 
	 * <p>FequencyDict setter : set the value of frequencyDict and initialize the number of character in the text</p>
	 */
	public void setFrequencyDict(List<String> frequencyDict) {
		this.frequencyDict = frequencyDict;
		this.initNbChar();
	}

	/**
	 * @return file (<i>type: File</i>): File lexicon related to the compressed file 
	 * 
	 * <p>File getter</p>
	 */
	public FileFunction getFile() {
		return file;
	}

	/**
	 * @param file (<i>type: File</i>): File lexicon related to the compressed file
	 * 
	 * <p>File setter</p>
	 */
	public void setFile(FileFunction file) {
		this.file = file;
	}

	/**
	 * @return nbChar(<i>type: int</i>): number of character in the original text
	 * 
	 * <p>NbChar getter</p>
	 */
	public int getNbChar() {
		return nbChar;
	}

	/**
	 * @param nbChar(<i>type: int</i>): number of character in the original text
	 * 
	 * <p>NbChar setter</p>
	 */
	public void setNbChar(int nbChar) {
		this.nbChar = nbChar;
	}
	
	/**
	 * <p>Initialize the number of character according to the frequencyDict</p>
	 */
	public void initNbChar() {
		nbChar = 0;
		for(String v : frequencyDict) {
			nbChar += Integer.parseInt(v.substring(2));
		}
	}
	
}
