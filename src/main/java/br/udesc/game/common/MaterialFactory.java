package br.udesc.game.common;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;

public class MaterialFactory {

    public static PhongMaterial newMaterial(Color fill){
        return new PhongMaterial(fill);
    }
    
}
