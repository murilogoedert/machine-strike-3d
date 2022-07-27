package br.udesc.game.scene.board.terrain;

import java.io.File;
import java.io.FileInputStream;

import br.udesc.game.common.Configs;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;

public class Terrain extends Box {

    private String texture;
    private int powerModifier;
    private Point3D surfacePoint;
    private double height;

    public Terrain(int height) {
        super(Configs.TERRAIN_SIZE, (height == 0 ? 1 : height) * 20, Configs.TERRAIN_SIZE);
        this.translateYProperty().set(-1 * (((height == 0 ? 1 : height) * 20) / 2));
        this.height = ((height == 0 ? 1 : height) * 20);
        this.setupSurfacePoint();
        this.setupAnimation();
    }


    public void setupSurfacePoint() {
        this.surfacePoint = new Point3D(this.translateXProperty().get(),
                this.getTranslateY() - this.height / 2, this.translateZProperty().get());
    }

    private void setupAnimation() {
        this.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                PhongMaterial m = (PhongMaterial) getMaterial();
                m.setDiffuseColor(Color.BLUEVIOLET);
            }

        });

        this.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                PhongMaterial m = (PhongMaterial) getMaterial();
                m.setDiffuseColor(Color.WHITE);
            }

        });
    }

    public Point3D getSurfacePoint(){
        return this.surfacePoint;
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
        }
        this.setMaterial(mat);

    }

}
