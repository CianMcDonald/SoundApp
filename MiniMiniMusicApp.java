import javax.sound.midi.*;

public class MiniMiniMusicApp {
    public static void main(String[] args) {
        MiniMiniMusicApp mini1 = new MiniMiniMusicApp();
	mini1.play();
    }

    public void play(){
        
	try {
	    // create a sequencer
	    Sequencer player = MidiSystem.getSequencer();
	    player.open();

	    Sequence seq = new Sequence(Sequence.PPQ, 4);

	    Track track = seq.createTrack();

	    ShortMessage note1 = new ShortMessage();
	    note1.setMessage(144, 1, 44, 100);
	    MidiEvent noteOn = new MidiEvent(note1,1);
	    track.add(noteOn);

	    ShortMessage note2 = new ShortMessage();
	    note2.setMessage(128, 1, 44, 100);
	    MidiEvent noteOff = new MidiEvent(note2, 16);
	    track.add(noteOff);

	    player.setSequence(seq);

	    player.start();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    
    }
}
