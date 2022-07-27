package br.udesc.game.scene.board.machines;

public class MachineAliveState implements IMachineState{

    private Machine machine;

    public MachineAliveState(Machine machine){
        this.machine = machine;
    }

    @Override
    public void attack(double points) {
        this.machine.setLifePoints(this.machine.getLifePoints() - points);
        if(this.machine.getLifePoints() <= 0){
            this.machine.setState(new MachineDeadState(this.machine));
        }
    }
    
}
