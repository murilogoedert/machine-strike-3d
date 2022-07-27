package br.udesc.game.scene.board.machines;


public class Batman extends Machine{

    @Override
    public String getModelPath() {
        return "src/main/resources/br/udesc/models/Batman.obj";
    }

    @Override
    public double getScale() {
        return 5;
    }

    @Override
    public double getAtackPoints() {
        return 3;
    }

    @Override
    public double getLifePoints() {
        return 10;
    }
    
}
