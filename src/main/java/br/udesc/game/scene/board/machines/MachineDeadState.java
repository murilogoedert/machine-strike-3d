package br.udesc.game.scene.board.machines;

import java.io.File;

import com.interactivemesh.jfx.importer.obj.ObjModelImporter;

import br.udesc.game.GameController;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
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


            ScaleTransition trans = new ScaleTransition(Duration.seconds(3));
            trans.setDelay(Duration.seconds(2));
            trans.setNode(m);
            trans.setFromX(50);
            trans.setFromY(50);
            trans.setFromZ(50);

            trans.setToX(0);
            trans.setToY(0);
            trans.setToZ(0);

            trans.setOnFinished(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    GameController.getInstance().getGameBoard().getChildren().remove(m);
                    GameController.getInstance().getGameBoard().getMachines().remove(m);
                }
                
            });

            trans.play();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void attack(double points) {
        return;
    }
    
}
