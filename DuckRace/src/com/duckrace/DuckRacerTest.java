package com.duckrace;
import static com.duckrace.Reward.*;

class DuckRacerTest {
    public static void main(String[] args) {
        DuckRacer racer5 = new DuckRacer(5, "Chris");

        System.out.println(racer5);

        racer5.win(DEBIT_CARD);
        racer5.win(DEBIT_CARD);
        racer5.win(DEBIT_CARD);
        racer5.win(PRIZES);


    }
}