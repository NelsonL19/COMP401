package media;

import java.net.URL;
import javax.swing.*;
import javax.sound.sampled.*;



public class GameMusic {

    public static void main(String[] args) throws Exception {
        URL soundFile = new URL("https://dl.dropboxusercontent.com/s/hhxhzsqitu2b6t8/PlacetheSushi1.wav?dl=00");
        Clip musicFile = AudioSystem.getClip();
        AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
        musicFile.open(ais);
        musicFile.loop(Clip.LOOP_CONTINUOUSLY);
       
    }
}


//Thanks to StackOverflow and Oracle's documentation on JavaSound'
//This file plays music using a URL .WAV file, and plays it continuously
//https://www.dl-sounds.com/royalty-free/category/game-film/video-game/?_sfm_media_type=Loop&_sfm_media_file_type=WAV&_sfm_bpm=0+1000