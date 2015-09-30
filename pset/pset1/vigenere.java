public class vigenere {
	public static void main (String args[]) {
		String text = new String (args[0]);
		char bunchOfChars[] = text.toCharArray();
		//Input for the first argument
		for(int i = 0; i < bunchOfChars.length; i++) {
			String code = new String (args[1]);
			char newChars[] = code.toCharArray();
			//Input for the second argument
			int y = (int)bunchOfChars[i];
			int codeIndex = i % newChars.length;
			//Set the word counter with the modulo operator
			int totalShift = (int)newChars[codeIndex];
			totalShift -= 96;

			if (y > 64 && y < 91){
				y = y + totalShift;
					while (y > 90) {
						y -= 26;
					}
				//shift for the uppercase letters
			}
			if (y > 96 && y < 123) {
				y = y + totalShift;
					while ( y > 123) {
						y -= 26;
					}
				//shift for the lowercase letters

			} System.out.print((char)y);

		}
	}
}
