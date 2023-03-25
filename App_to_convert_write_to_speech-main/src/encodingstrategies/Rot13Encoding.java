package encodingstrategies;


public class Rot13Encoding extends TemplateEncoding implements EncodingStrategy {
	private char[] mapCharacter = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public char mapCharacter(char charInput) { 
		char convertedChar = charInput;
		boolean isUppercase = !(convertedChar == (Character.toLowerCase(convertedChar))); // check if the current letter is uppercase

		for (int i = 0; i < 26; i++) {
			if (Character.toLowerCase(charInput) == mapCharacter[i]) { // convert charInput into lower case 
				
				int convertedPositionInArray = i + 13; // ROT13 (add 13)

				if (convertedPositionInArray >= 26) { // if its over 'z' in the array, it resets it to 'a'
						convertedPositionInArray -= 26;
				}
				if (isUppercase) { // return character to uppercase
						convertedChar = Character.toUpperCase(mapCharacter[convertedPositionInArray]); // get character (uppercase)
				}
				else
						convertedChar = mapCharacter[convertedPositionInArray]; // get character (lowercase)
			}
		}
		return convertedChar;
	}

}
