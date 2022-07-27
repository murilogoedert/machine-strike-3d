package br.udesc.game.scene.board;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.udesc.game.common.Configs;
import br.udesc.game.scene.board.machines.Machine;
import br.udesc.game.scene.board.terrain.ITerrainBuilder;
import br.udesc.game.scene.board.terrain.Terrain;
import br.udesc.game.scene.board.terrain.TerrainBuilderDirector;
import javafx.animation.RotateTransition;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class GameBoard extends Group {

    private String instanceName;
    private Map<Point2D, Terrain> terrains;
    private List<Machine> machines;

    private final String BOARD_RESOURCE_BASE = "src/main/resources/br/udesc/boards/";

    public GameBoard(String instance) throws IOException, ClassNotFoundException {
        super();
        this.instanceName = instance;
        this.setRotationAxis(Rotate.Y_AXIS);
        this.terrains = new HashMap<>();
        this.machines = new ArrayList<>();
        createTerrain();

        this.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                flip();
            }
            
        });
    }

    private void createTerrain() throws IOException, ClassNotFoundException {
        File file = new File(BOARD_RESOURCE_BASE + instanceName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int currentX = 0;
        int currentZ = Configs.TERRAIN_SIZE * Configs.BOARD_SIZE;
        while ((line = br.readLine()) != null) {
            String[] terrains = line.split(" ");
            for (String terrainName : terrains) {
                TerrainBuilderDirector terrainBuilderDirector = new TerrainBuilderDirector(instanceTerrainBuilder(terrainName));
                Terrain terrain = terrainBuilderDirector.getResult();
                this.getChildren().add(terrain);
                terrain.translateXProperty().set(currentX);
                terrain.translateZProperty().set(currentZ);
                terrain.setupSurfacePoint();
                currentX += Configs.TERRAIN_SIZE;
                this.terrains.put(new Point2D((int)(currentX / Configs.TERRAIN_SIZE), (int)(currentZ / Configs.TERRAIN_SIZE)), terrain);
            }
            currentZ -= Configs.TERRAIN_SIZE;
            currentX = 0;
        }
        fr.close(); 
    }

    public void addMachine(Machine m, Point2D where){
        Terrain terrain = this.terrains.get(where);
        m.translateXProperty().set(terrain.getSurfacePoint().getX());
        m.translateZProperty().set(terrain.getSurfacePoint().getZ());
        m.translateYProperty().set(terrain.getSurfacePoint().getY() - m.getBoundsInLocal().getHeight());
        this.machines.add(m);
        this.getChildren().add(m);
    }

    public void flip(){
        if( rotateProperty().get() == 0){
            RotateTransition trans = new RotateTransition();
            trans.setDuration(Duration.seconds(1.2));
            trans.setNode(this);
            trans.setFromAngle(this.getRotate());
            trans.setToAngle(180);
            trans.play();
        }else{
            RotateTransition trans = new RotateTransition();
            trans.setDuration(Duration.seconds(1.2));
            trans.setNode(this);
            trans.setFromAngle(this.getRotate());
            trans.setToAngle(0);
            trans.play();
        }
    }

    public List<Machine> getMachines(){
        return this.machines;
    }

    /**
     * @param terrainName
     * @return
     */
    private ITerrainBuilder instanceTerrainBuilder(String terrainName) {
        try {
            String className = "br.udesc.game.scene.board.terrain." + terrainName.substring(0, 1).toUpperCase()
                    + terrainName.substring(1).toLowerCase() + "TerrainBuilder";
            final Class c = Class.forName(className);
            return (ITerrainBuilder) c.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
