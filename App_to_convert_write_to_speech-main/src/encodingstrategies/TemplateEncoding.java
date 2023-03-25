package encodingstrategies;

public abstract class TemplateEncoding implements EncodingStrategy{
	
	public String encode(String s) {
		String output = "";
		char[] splitedS = s.toCharArray();
		for(int i=0;i<splitedS.length;i++) {
			char c =splitedS[i];
			if(Character.isLetter(c))
				output += mapCharacter(c);
			else
				output += c;
		}
		
		return output;
	}
	
	public abstract char mapCharacter(char c);

}
