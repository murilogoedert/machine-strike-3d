package br.udesc.game.scene.board.terrain;

import java.io.File;
import java.io.FileInputStream;

import br.udesc.game.common.Configs;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class Terrain extends Box{

    private String texture;
    private int powerModifier;

    public Terrain(int height){
        super(Configs.TERRAIN_SIZE, (height == 0 ? 1 : height)  * 20, Configs.TERRAIN_SIZE);
        this.translateYProperty().set( - 1 * (((height == 0 ? 1 : height)  * 20) / 2));
    }

    public int getPowerModifier() {
        return powerModifier;
    }

    public void setPowerModifier(int powerModifier) {
        this.powerModifier = powerModifier;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
        PhongMaterial mat = new PhongMaterial();
        try {
            mat.setDiffuseMap(new Image(new FileInputStream(new File(this.texture))));
            
        } catch (Exception e) {
            e.printStackTrace();
            //TODO: handle exception
        }
        this.setMaterial(mat);
        
    }
    


}
