package br.udesc.game.scene.board.machines;


public class DarthVader extends Machine{

    @Override
    public String getModelPath() {
        return "src/main/resources/br/udesc/models/DarthVader.obj";
    }

    @Override
    public double getScale() {
        return 5;
    }

    @Override
    public double getAtackPoints() {
        return 3;
    }
    
}
