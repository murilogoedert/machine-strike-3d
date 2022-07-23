package br.udesc.game.scene.board.terrain;

public class TerrainBuilderDirector implements ITerrainBuilder{

    private ITerrainBuilder builder;

    public TerrainBuilderDirector(ITerrainBuilder builder){
        this.builder = builder;
    }

    @Override
    public Terrain getResult() {
        return this.builder.getResult();
    }

    
}
