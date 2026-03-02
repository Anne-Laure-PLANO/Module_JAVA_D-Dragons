package dungeonanddragons.board;

import dungeonanddragons.entity.entityliving.enemy.Enemy;

import java.util.List;

public class Board {
    private int boardLength;
    private int[] board ;


    public void initBoard (int boardLength){
        this.boardLength = boardLength;
        this.board = new int[boardLength];

        for (int i=0 ; i < boardLength ; i++){
            this.board[i] = i + 1 ;
        }


    }


    public int getBoardLength() {
        return boardLength;
    }


}
