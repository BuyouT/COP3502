public class caesar {
	public static void main (String args[]) {
		String text = new String (args[0]);
		char bunchOfChars[] = text.toCharArray();
		//Input for the first argument
		for(int i = 0; i < bunchOfChars.length; i++) {
			//loop that deals with every character
				int num = Integer.parseInt(args[1]);
				int y = (int)bunchOfChars[i];
				//Input for the second argument
				int totalShift = (y + num);
				if (y == 32) {
					System.out.print((char)y);
					//Keeps the space unshifted
				}
				else if (y != 32) {
					if (y < 91) {
						while (totalShift > 90) {
							totalShift -= 26;
						}
						System.out.print((char)totalShift);
						//Deals with shifting the uppercases
					}
					else if (y >= 97) {
					while (totalShift > 122) {
						totalShift -= 26;
					}
					System.out.print((char)totalShift);
					//Deals with shifting the lowercases
				}
			}
		}
	}
}