package br.udesc.game.scene.board.terrain;

public class ChasmTerrainBuilder implements ITerrainBuilder{

    @Override
    public Terrain getResult() {
        Terrain chasmTerrain = new Terrain(1);
        chasmTerrain.setPowerModifier(-2);
        chasmTerrain.setTexture("src/main/resources/br/udesc/textures/chasm.jpg");
        return chasmTerrain;
    }
    
}
