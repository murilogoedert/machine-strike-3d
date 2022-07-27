package br.udesc.game.scene.board.machines;

import java.io.File;

import com.interactivemesh.jfx.importer.obj.ObjModelImporter;

import br.udesc.game.GameController;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class MachineDeadState implements IMachineState{


    public MachineDeadState(Machine m){
        m.getChildren().clear();
        ObjModelImporter importer = new ObjModelImporter();

        
        try {
            String file = "src/main/resources/br/udesc/models/Tombstone_" + Math.round(Math.ceil(Math.random() * 3)) + ".obj";
            importer.read(new File(file));
            MeshView[] meshes = importer.getImport();
            m.setRotationAxis(Rotate.Y_AXIS);
            m.rotateProperty().set(90);
            m.getChildren().addAll(meshes);
            m.setScaleX(50);
            m.setScaleY(50);
            m.setScaleZ(50);
            m.translateYProperty().set(m.translateYProperty().get() - m.getBoundsInLocal().getHeight());

            FadeTransition fadeout = new FadeTransition(Duration.seconds(3), m);
            fadeout.setFromValue(1);
            fadeout.setToValue(0);
            fadeout.setOnFinished(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    GameController.getInstance().getGameBoard().getChildren().remove(m);
                    GameController.getInstance().getGameBoard().getMachines().remove(m);
                }
                
            });

            fadeout.play();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void attack(double points) {
        return;
    }
    
}
