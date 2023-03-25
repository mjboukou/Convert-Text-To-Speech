package text2speechapis;



public class TextToSpeechAPIFactory {
	
	
	public TextToSpeechAPI createTTSAPI(String arg){

		if(arg.equals("freeTTS"))
			return new FreeTTSAdapter();
		if(arg.equals("fake"))
			return new FakeTextToSpeechAPI();
		return null;
	}
	

}
