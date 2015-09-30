import java.util.*;
import java.io.*;

public class AnagramConstructor {
	private Map<String,List<String>> anagrams;
	
	public AnagramConstructor(String dictionaryFile) {
		loadMap(dictionaryFile);
	}

	public void loadMap(String dictionaryFile) {
		anagrams = new HashMap<String,List<String>>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(dictionaryFile));
			while(true) {
				String line = br.readLine();
				if (line==null) {
					break;
				}
				String alphaLine = alphabetize(line);
				if (anagrams.containsKey(alphaLine)) {
					List<String> list = anagrams.get(alphaLine);
					list.add(line);
					anagrams.put(alphaLine, list);
				}
				else {
					List<String> list = new ArrayList<String>();
					list.add(line);
					anagrams.put(alphaLine, list);
				}
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	public String alphabetize(String word) {
		char[] charWord = word.toCharArray();
		Arrays.sort(charWord);
		return new String(charWord);
	}

	public void printWord(String word) {
		List<String> list = anagrams.get(alphabetize(word));
		System.out.println(list);
	}

	public static void main(String[] args) {
		AnagramConstructor ac = new AnagramConstructor("dictionary.txt");
		Scanner sc = new Scanner(System.in);
		System.out.print("Give me a word: ");
		String word = sc.next();
		System.out.println();
		ac.printWord(word);

	}
}