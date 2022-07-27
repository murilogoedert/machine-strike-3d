package br.udesc.game.scene;

import javafx.scene.media.MediaPlayer;

abstract public class SoundPlayer {

    public MediaPlayer getMediaPlayer(){
        String[] sounds = this.getSounds();
        String sound = sounds[(int) (Math.random() * (sounds.length))];
        MediaPlayer player = new MediaPlayer(MediaLibrary.getInstance().getSound(sound));
        player.setVolume(0.2);
        return player;
    }
    
    protected abstract String[] getSounds();

    
}
