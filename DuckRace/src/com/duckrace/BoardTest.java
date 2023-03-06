package com.duckrace;
import static com.duckrace.Reward.*;

class BoardTest {

    public static void main(String[] args) {
        Board board = new Board();
        board.dumpStudentIdMap();

        System.out.println();

        board.update(2, Reward.PRIZES);
        board.update(1,DEBIT_CARD);
        board.update(9, PRIZES);
        board.update(2,DEBIT_CARD);
        board.update(9, PRIZES);


        board.show();
        board.dumpStudentIdMap();


    }

}