import java.util.*;
import java.io.*;

public class CommonWords {

	private Map<String,Integer> map;

	public CommonWords(String bookFile) {
		map = new HashMap<String,Integer>();
		loadBook(bookFile);
		map = sortBook();
	}

	public void loadBook(String bookFile) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(bookFile));
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				String[] words = line.toLowerCase().split(" ");
				for (String word : words) {
					if (map.containsKey(word)) {
						int count = map.get(word);
						count++;
						map.put(word,count);
					}
					else {
						map.put(word,1);
					}
				}
			}
			sortBook();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	public Map<String,Integer> sortBook() {
		List<Map.Entry<String,Integer>> entries 
			= new ArrayList<Map.Entry<String,Integer>>(map.entrySet()); 
		Collections.sort(entries, new ValueComparator());
		Map<String,Integer> sortedMap = new LinkedHashMap<String,Integer>();
		for (Map.Entry<String,Integer> entry : entries) {
			sortedMap.put(entry.getKey(),entry.getValue());
		}
		return sortedMap;
	}

	public void printCommonWords(int k) {
		Set<String> keys = map.keySet();
		Iterator it = keys.iterator();
		for (int i = 0; i < k; i++) {
			String word = (String)it.next();
			System.out.println(word + ": " + map.get(word));
		}
	}

	public static void main(String args[]) {
		CommonWords cw = new CommonWords("Hamlet_WilliamShakespeare.txt");
		cw.printCommonWords(50);
	}
}

class ValueComparator implements Comparator<Map.Entry<String,Integer>> {
	public int compare(Map.Entry<String,Integer> e1, Map.Entry<String,Integer> e2) {
		if (e1.getValue() > e2.getValue()) {
			return -1;
		}
		else if (e1.getValue() < e2.getValue()) {
			return 1;
		}
		else {
			return 0;
		}
	}
}