package br.udesc.game;

import br.udesc.game.common.Configs;
import br.udesc.game.scene.board.GameBoard;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.AmbientLight;
import javafx.scene.Camera;
import javafx.scene.DepthTest;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MachineStrike3d extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        final GameBoard board = new GameBoard("board1.txt");
        board.setRotationAxis(new Point3D(0, 1, 0));
        Scene scene = new Scene(board, 1920, 1080, true, SceneAntialiasing.BALANCED);
        scene.setFill(Color.BLACK);
        primaryStage.setScene(scene);

        Camera c = new PerspectiveCamera();
        c.setDepthTest(DepthTest.ENABLE);
        c.setRotationAxis(new Point3D(1, 0, 0));
        c.setRotate(-50);

        AmbientLight mainLight = new AmbientLight(Color.LIGHTGRAY);
        board.getChildren().add(mainLight);
        
        PointLight l = new PointLight(Color.LIGHTBLUE);
        l.translateYProperty().set(-1800);
        board.getChildren().add(l);

        c.translateXProperty()
                .set(board.translateXProperty().get() - ((Configs.BOARD_SIZE * Configs.TERRAIN_SIZE) / 2.7));
        c.translateZProperty().set(400);
        c.translateYProperty().set(-1000);

        scene.setCamera(c);

        primaryStage.setFullScreen(true);
        primaryStage.show();

        GameController controller = GameController.getInstance();
        controller.setGameBoard(board);
        controller.play();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
