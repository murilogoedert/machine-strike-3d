package br.udesc.game.scene.board.machines;

import java.io.File;

import com.interactivemesh.jfx.importer.obj.ObjModelImporter;

import javafx.scene.Group;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;

abstract public class Machine extends Group {

    private IMachineState state;

    private double lifePoints = 10;

    public Machine(){
        this.setRotationAxis(Rotate.Y_AXIS);
        ObjModelImporter importer = new ObjModelImporter();
        try {
            importer.read(new File(this.getModelPath()));
            MeshView[] meshes = importer.getImport();
            this.getChildren().addAll(meshes);
            this.setScaleX(this.getScale());
            this.setScaleY(this.getScale());
            this.setScaleZ(this.getScale());
        } catch (Exception e) {
        }
        this.state = new MachineAliveState(this);
        this.setupEvents();
    }

    public void setState(IMachineState state){
        this.state = state;
    }

    public IMachineState getState(){
        return this.state;
    }

    private void setupEvents(){
        
    }


    public void turnAround(){
        if(this.rotateProperty().get() == 0){
            this.rotateProperty().set(180);
        }else{
            this.rotateProperty().set(0);
        }
    }

    public abstract String getModelPath();

    public abstract double getScale();

    public abstract double getAtackPoints();

    public void attack(double ammount){
        this.state.attack(ammount);
    }

    public double getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(double lifePoints) {
        this.lifePoints = lifePoints;
    }
    
}
