package br.udesc.game.scene;

import java.io.File;
import java.util.HashMap;

import javafx.scene.media.Media;

public class MediaLibrary {

    private static final String MEDIA_ROOT = "src/main/resources/br/udesc/sounds/";

    private static MediaLibrary instance;

    private HashMap<String, Media> medias;

    private MediaLibrary() {
        this.medias = new HashMap<>();
    }

    public static MediaLibrary getInstance() {
        if (instance == null) {
            instance = new MediaLibrary();
        }
        return instance;
    }

    public Media getSound(String soundName) {
        if (this.medias.containsKey(soundName)) {
            return this.medias.get(soundName);
        } else {
            Media sound = new Media(new File(MEDIA_ROOT + soundName).toURI().toString());
            this.medias.put(soundName, sound);
            return sound;
        }
    }

}
