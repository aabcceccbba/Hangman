/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class HangmanLexicon {
	
	ArrayList<String> list = new ArrayList<>();
	Set<String> set = new HashSet<>();
	
	public HangmanLexicon() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"words.txt"));
			String line = reader.readLine();
			while (line != null) {
				if(!set.contains(line))
					list.add(line);
//				System.out.println(line);
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return list.size();
	}
	
	/** Returns the word at the specified index. 
	 * @throws Exception */
	public String getWord(int index) throws Exception {
		return list.get(index);
//		switch (index) {
//			case 0: return "BUOY";
//			case 1: return "COMPUTER";
//			case 2: return "CONNOISSEUR";
//			case 3: return "DEHYDRATE";
//			case 4: return "FUZZY";
//			case 5: return "HUBBUB";
//			case 6: return "KEYHOLE";
//			case 7: return "QUAGMIRE";
//			case 8: return "SLITHER";
//			case 9: return "ZIRCON";
//			default: throw new Exception("getWord: Illegal index");
//		}
	};
}
