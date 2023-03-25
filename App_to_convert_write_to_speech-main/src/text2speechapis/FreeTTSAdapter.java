package text2speechapis;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class FreeTTSAdapter implements TextToSpeechAPI {
	
	private Voice freettsVoice;
	private VoiceManager freettsVm;
	
	public FreeTTSAdapter() {
		
		this.freettsVm=VoiceManager.getInstance();
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		this.freettsVoice=freettsVm.getVoice("kevin16");
		this.freettsVoice.allocate();
	}
	
	@Override
	public void play(String text) {
		freettsVoice.speak(text);		
	}

	@Override
	public void setVolume(int volume) {
		freettsVoice.setVolume(volume);
	}

	@Override
	public void setPitch(int pitch) {
		freettsVoice.setPitch(pitch);
	}

	@Override
	public void setRate(int rate) {
		freettsVoice.setRate(rate);	
	}
}
