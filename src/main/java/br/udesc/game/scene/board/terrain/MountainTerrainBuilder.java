package br.udesc.game.scene.board.terrain;

public class MountainTerrainBuilder implements ITerrainBuilder{

    @Override
    public Terrain getResult() {
        Terrain mountainTerrain = new Terrain(5);
        mountainTerrain.setPowerModifier(3);
        mountainTerrain.setTexture("src/main/resources/br/udesc/textures/mountain.png");
        return mountainTerrain;
    }
    
}
