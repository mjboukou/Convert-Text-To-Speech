package encodingstrategies;


public class AtBashEncoding extends TemplateEncoding implements EncodingStrategy {
	
	
	private char[] mapCharacter = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	private char[] ConvertMapCharacter = { 'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j',
			'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a' };
	
	
	public char mapCharacter(char charInput) {
		char convertedChar = charInput;
		boolean isUppercase = !(convertedChar == (Character.toLowerCase(convertedChar))); // check if the current letter is uppercase

		for (int i = 0; i < 26; i++) {
			if (Character.toLowerCase(charInput) == mapCharacter[i]) { // convert charInput into lower case
																		
				if (isUppercase) { // return character to uppercase
						convertedChar = Character.toUpperCase(ConvertMapCharacter[i]); // get character (uppercase)
				}
				else
						convertedChar = ConvertMapCharacter[i]; // get character (lowercase)
			}
		}
		return convertedChar;
	}

}