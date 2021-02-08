import javax.sound.midi.*;

public class MiniMusicApp {
    public static void main(String[] args) {
        MiniMusicApp mini1 = new MiniMusicApp();
	if (args.length < 2) {
	    System.out.println("Don't forget the instrument and note args");
	} else {
	    int instrument = Integer.parseInt(args[0]);
	    int note = Integer.parseInt(args[1]);
	    mini1.play(instrument, note);
	}
    }

    public void play(int instrument, int note){
        
	try {
	    // create a sequencer
	    Sequencer player = MidiSystem.getSequencer();
	    player.open();

	    Sequence seq = new Sequence(Sequence.PPQ, 4);

	    Track track = seq.createTrack();

	    MidiEvent event = null;

            ShortMessage first = new ShortMessage();
	    first.setMessage(192, 1, instrument, 0);
	    MidiEvent changeInstrument = new MidiEvent (first, 1);
	    track.add(changeInstrument);

	    ShortMessage note1 = new ShortMessage();
	    note1.setMessage(144, 1, note, 100);
	    MidiEvent noteOn = new MidiEvent(note1,1);
	    track.add(noteOn);

	    ShortMessage note2 = new ShortMessage();
	    note2.setMessage(128, 1, note, 100);
	    MidiEvent noteOff = new MidiEvent(note2, 16);
	    track.add(noteOff);

	    player.setSequence(seq);

	    player.start();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    
    }
}
