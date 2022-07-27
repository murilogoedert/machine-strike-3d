package br.udesc.game.scene.board.terrain;

public class MarshTerrainBuilder implements ITerrainBuilder {

    @Override
    public Terrain getResult() {
        Terrain marshTerrain = new Terrain(2);
        marshTerrain.setPowerModifier(-1);
        marshTerrain.setTexture("src/main/resources/br/udesc/textures/marsh.jpg");
        return marshTerrain;
    }
    
}
