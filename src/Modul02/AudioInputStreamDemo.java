package Modul02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class AudioInputStreamDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String audioFile = "/home/alfa/NetBeansProjects/Sister/src/modul02/movinout.wav";
        InputStream in = new FileInputStream(audioFile);

        AudioStream audioStream = new AudioStream(in);

        AudioPlayer.player.start(audioStream);
    }
}
