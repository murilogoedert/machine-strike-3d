package br.udesc.game;

import br.udesc.game.scene.board.GameBoard;
import br.udesc.game.scene.board.machines.DarthVader;
import br.udesc.game.scene.board.machines.MachineDeadState;
import javafx.geometry.Point2D;

public class GameController {

    private static GameController instance;

    private GameBoard board;

    private GameController(){}

    public static GameController getInstance(){
        if(instance == null){
            instance = new GameController();
        }

        return instance;
    }

    public GameBoard getGameBoard(){
        return this.board;
    }

    public void setGameBoard(GameBoard board){
        this.board = board;
    }

    public void play(){

        DarthVader  vader = new  DarthVader();
        board.addMachine(vader, new Point2D(5, 5));
        vader.setState(new MachineDeadState(vader));

    }
    
}
