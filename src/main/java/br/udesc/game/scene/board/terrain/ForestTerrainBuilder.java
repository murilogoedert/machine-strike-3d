package br.udesc.game.scene.board.terrain;

public class ForestTerrainBuilder implements ITerrainBuilder{

    @Override
    public Terrain getResult() {
        Terrain ForestTerrain = new Terrain(4);
        ForestTerrain.setPowerModifier(1);
        ForestTerrain.setTexture("src/main/resources/br/udesc/textures/forest.jpg");
        return ForestTerrain;
    }
    
}
