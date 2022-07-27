package br.udesc.game.scene.board.terrain;

public class GrasslandTerrainBuilder implements ITerrainBuilder{

    @Override
    public Terrain getResult() {
        Terrain grasslandTerrain = new Terrain(3);
        grasslandTerrain.setPowerModifier(0);
        grasslandTerrain.setTexture("src/main/resources/br/udesc/textures/grassland.jpg");
        return grasslandTerrain;
    }
    
}
