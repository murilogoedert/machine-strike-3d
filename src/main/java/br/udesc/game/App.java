package br.udesc.game;

import com.interactivemesh.jfx.importer.obj.ObjModelImporter;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.stage.Stage;

public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {

		arg0.setFullScreen(true);
		final PerspectiveCamera camera = new PerspectiveCamera();
		camera.setTranslateZ(10);
		camera.translateYProperty().set(-120);
		
		Group mainGroup = new Group();
		
		mainGroup.getChildren().add(createTestPlayer(10, "src/main/resources/br/udesc/models/Batman.obj", 150, 150));
		mainGroup.getChildren().add(createTestPlayer(10, "src/main/resources/br/udesc/models/Cloud.obj", 400, 150));
		mainGroup.getChildren().add(createTestPlayer(10, "src/main/resources/br/udesc/models/Aerith.obj", 600, 150));
		mainGroup.getChildren().add(createTestPlayer(10, "src/main/resources/br/udesc/models/DarthVader.obj", 900, 150));
		mainGroup.getChildren().add(createTestPlayer(10, "src/main/resources/br/udesc/models/DeadPool.obj", 1200, 150));
		mainGroup.getChildren().add(createTestPlayer(10, "src/main/resources/br/udesc/models/Flash.obj", 1450, 150));
		mainGroup.getChildren().add(createTestPlayer(10, "src/main/resources/br/udesc/models/Hulk.obj", 1800, 150));
		mainGroup.getChildren().add(createTestPlayer(10, "src/main/resources/br/udesc/models/IronMan.obj", 150, 550));
		mainGroup.getChildren().add(createTestPlayer(0.8, "src/main/resources/br/udesc/models/IronManFoda.obj", 400, 550));
		mainGroup.getChildren().add(createTestPlayer(10, "src/main/resources/br/udesc/models/Skeleton.obj", 650, 550));
		mainGroup.getChildren().add(createTestPlayer(10, "src/main/resources/br/udesc/models/SpiderMan.obj", 850, 550));
		
		Scene scene = new Scene(mainGroup, 1920, 1080, true);
		scene.setFill(Color.GREY);
		scene.setCamera(camera);


		arg0.setScene(scene);
		arg0.show();

	}

	private static Group createTestPlayer(double scale, String texture, double x, double y) {
		ObjModelImporter importer = new ObjModelImporter();
		importer.read(texture);

		Group sceneGroup = new Group();
		for (MeshView view : importer.getImport()) {
			sceneGroup.getChildren().add(view);
		}

		importer.close();

		sceneGroup.translateXProperty().set(x);
		sceneGroup.translateYProperty().set(y);
		sceneGroup.setRotationAxis(new Point3D(0, 1, 0));
		sceneGroup.scaleXProperty().set(scale);
		sceneGroup.scaleYProperty().set(scale);
		sceneGroup.scaleZProperty().set(scale);

		new AnimationTimer() {

			@Override
			public void handle(long now) {
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						sceneGroup.rotateProperty().set(sceneGroup.rotateProperty().get() + 1.5);
					}
				});
			}
		}.start();
		
		return sceneGroup;
		
	}

}
