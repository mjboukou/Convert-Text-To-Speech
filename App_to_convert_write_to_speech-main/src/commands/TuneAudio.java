package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import text2speechapis.FreeTTSAdapter;

public class TuneAudio implements ActionListener {

	private Integer rate;
	private Integer pitch;
	private Integer volume;
	
	FreeTTSAdapter freetts = new FreeTTSAdapter();
	
	public TuneAudio(Integer rate, Integer pitch, Integer volume) {
		this.rate = rate;
		this.pitch = pitch;
		this.volume = volume;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		freetts.setRate(rate);
		freetts.setPitch(pitch);
		freetts.setVolume(volume);
		
	}

}
