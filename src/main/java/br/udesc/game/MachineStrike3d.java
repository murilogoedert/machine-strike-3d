package br.udesc.game;

import br.udesc.game.scene.board.GameBoard;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.DepthTest;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MachineStrike3d extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        final GameBoard board = new GameBoard("board1.txt");
        board.setRotationAxis(new Point3D(0, 1, 0));
        Scene scene = new Scene(board, 1920, 1080, true, SceneAntialiasing.BALANCED);
        scene.setFill(Color.BLACK);
    
        new AnimationTimer() {

            @Override
            public void handle(long now) {
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        
                        board.setRotate(board.getRotate() + 0.1);
                    }
                    
                });
                
            }
            
        }.start();

        primaryStage.setScene(scene);
        
        Camera c = new PerspectiveCamera();
        c.setDepthTest(DepthTest.ENABLE);
        c.setRotationAxis(new Point3D(1, 0, 0));
        c.setRotate(-50);
        
        c.translateYProperty().set(-1000);
        c.translateXProperty().set(-400);
        c.translateZProperty().set(220);
        scene.setCamera(c);
        
        primaryStage.setFullScreen(true);
        primaryStage.show();    
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
