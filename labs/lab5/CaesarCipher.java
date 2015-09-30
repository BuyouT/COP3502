import java.io.*;

public class CaesarCipher {
	public static void main(String[] args) {

		if (args.length != 3) {
			System.out.println("usage: java CaesarCipher <input file> <output file> <shift>");
		}

		String inputFile = args[0];
		String outputFile = args[1];
		int shift = Integer.parseInt(args[2]);
		
		try {
			BufferedReader input = new BufferedReader(new FileReader(inputFile));
			PrintWriter output = new PrintWriter(new FileWriter(outputFile));

			while(true) {
				String line = input.readLine();
				if (line == null) {
					break;
				}
				output.println(encode(line,shift));
			}

			input.close();
			output.close();
		} catch(IOException ex) {

		}
	}

	public static String encode(String text, int shift) {
		char[] textArray = text.toCharArray();
		shift = shift % 26;

		for (int i = 0; i < textArray.length; i++) {
			if (textArray[i] >= 'a' && textArray[i] <= 'z') {
				textArray[i] += shift;
				if (textArray[i] > 'z') {
					textArray[i] -= 26;
				}
			}

			if (textArray[i] >= 'A' && textArray[i] <= 'Z') {
				textArray[i] += shift;
				if (textArray[i] > 'Z') {
					textArray[i] -= 26;
				}
			}
		}

		return new String(textArray);
	}
}