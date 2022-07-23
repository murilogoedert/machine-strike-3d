package br.udesc.game.scene.board.terrain;

public class HillTerrainBuilder implements ITerrainBuilder{

    @Override
    public Terrain getResult() {
        Terrain hillTerrain = new Terrain(4);
        hillTerrain.setPowerModifier(2);
        hillTerrain.setTexture("src/main/resources/br/udesc/textures/hill.png");
        return hillTerrain;
    }
    
}
