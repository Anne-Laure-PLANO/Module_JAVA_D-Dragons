package dungeonanddragons;

public class Board {
    private int boardLength;


    public Board(int boardLength){
        this.boardLength = boardLength;
    }

    public void initBoard (){

    }

    public int getBoardLength() {
        return boardLength;
    }

    public void setBoardLength(int boardLength) {
        this.boardLength = boardLength;
    }
}
