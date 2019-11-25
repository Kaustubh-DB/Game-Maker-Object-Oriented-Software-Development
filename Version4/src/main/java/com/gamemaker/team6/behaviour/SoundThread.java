package com.gamemaker.team6.behaviour;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import org.apache.log4j.Logger;
public class SoundThread extends Thread {
	private String filename; // The name of the file to play
	private final static Logger logger = Logger.getLogger(SoundThread.class);
	SoundThread(String fname) {
		filename = fname;
	}
	
	public void run() {
		logger.info("Entering the Sound run method\n");

		AudioInputStream stream = null;
		Clip clip = null;
		try {
			logger.info("Getting the sound File, and reading sound files");
			File file = new File(filename);
			stream = AudioSystem.getAudioInputStream(file);
			AudioFormat format = stream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
			clip.setLoopPoints(0, clip.getFrameLength());
			clip.close();
			stream.close();
		} catch (Exception e) {
			logger.error("Error while getting sound files" + e.getMessage()	);

		} finally {

		}
	}
}
