import java.util.*;
import java.io.*;

public class CharFrequencyProfiler {
	HashMap<Character,Integer> charCounts = new HashMap<Character,Integer>();

	public CharFrequencyProfiler() {
		
	}

	public void addText(String filename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));

			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				line = line.toLowerCase();
				//System.out.println(line);
				for (int i=0; i < line.length(); i++) {
					char c = line.charAt(i);
					if (Character.isLetter(c)) {
						if (!charCounts.containsKey(c)) {
							charCounts.put(c,1);
						}
						else {
							int count = charCounts.get(c);
							count++;
							charCounts.put(c,count);
						}
					}
				}

			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	public void printProfile() {
		Set<Character> keys = charCounts.keySet();
		int totalChars = 0;
		for (char k : keys) {
			totalChars += charCounts.get(k);
		}
		for (char k : keys) {
			int count = charCounts.get(k);
			System.out.println(k + ": " + (double)count*100/totalChars);
		}
	}

	public char getMaxKey() {
		Set<Character> keys = charCounts.keySet();
		char maxKey = 'a';
		int maxValue = 0;
		for (char k : keys) {
			if (charCounts.get(k) > maxValue) {
				maxKey = k;
				maxValue = charCounts.get(k);
			}
		}
		return maxKey;
	}

	public static void main(String[] args) {
		CharFrequencyProfiler english = new CharFrequencyProfiler();
		english.addText("MobyDick_HermanMelville.txt");
		english.addText("Hamlet_WilliamShakespeare.txt");
		english.addText("LeavesOfGrass_WaltWhitman.txt");
		english.addText("OriginOfSpecies_CharlesDarwin.txt");
		english.addText("TheWasteland_TSEliot.txt");
		english.addText("Ulysses_JamesJoyce.txt");
		english.addText("WealthOfNations_AdamSmith.txt");
		english.printProfile();

		CharFrequencyProfiler encoded = new CharFrequencyProfiler();
		encoded.addText("JuliusCaesar_WilliamShakespeare_encoded.txt");
		encoded.printProfile();

		int shift = (int)encoded.getMaxKey() - (int)english.getMaxKey();
		if (shift < 0) {
			shift += 26;
		}
		System.out.println("The most frequent English letter is " + english.getMaxKey());
		System.out.println("The most frequent encoded letter is " + encoded.getMaxKey());
		System.out.println("The shift is: " + shift);
	}
}


