package encodingstrategies;



public class StrategiesFactory{

		
	public EncodingStrategy createStrategy(String arg) {
		if(arg.equals("Rot13"))
			return new Rot13Encoding();
		if(arg.equals("AtBash"))
			return new AtBashEncoding();
		return null;
		
	}

} 
