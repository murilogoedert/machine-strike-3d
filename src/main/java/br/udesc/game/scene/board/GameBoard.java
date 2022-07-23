package br.udesc.game.scene.board;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import br.udesc.game.common.Configs;
import br.udesc.game.scene.board.terrain.ITerrainBuilder;
import br.udesc.game.scene.board.terrain.Terrain;
import br.udesc.game.scene.board.terrain.TerrainBuilderDirector;
import javafx.scene.Group;

public class GameBoard extends Group {

    private String instanceName;

    private final String BOARD_RESOURCE_BASE = "src/main/resources/br/udesc/boards/";

    public GameBoard(String instance) throws IOException, ClassNotFoundException {
        super();
        this.instanceName = instance;
        createTerrain();
    }

    private void createTerrain() throws IOException, ClassNotFoundException {
        File file = new File(BOARD_RESOURCE_BASE + instanceName);
        FileReader fr = new FileReader(file); // reads the file
        BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
        String line;
        int currentX = 0;
        int currentZ = 0;
        while ((line = br.readLine()) != null) {
            String[] terrains = line.split(" ");
            for (String terrainName : terrains) {
                TerrainBuilderDirector terrainBuilderDirector = new TerrainBuilderDirector(instanceTerrainBuilder(terrainName));
                Terrain terrain = terrainBuilderDirector.getResult();
                terrain.translateXProperty().set(currentX);
                // terrain.translateYProperty().set(-200);
                terrain.translateZProperty().set(currentZ);

                this.getChildren().add(terrain);
                currentX += Configs.TERRAIN_SIZE;
            }
            currentZ += Configs.TERRAIN_SIZE;
            currentX = 0;
        }
        fr.close(); // closes the stream and release the resources
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
