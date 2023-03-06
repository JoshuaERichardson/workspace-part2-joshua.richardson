package com.duckrace;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data 
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 * 
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 * 
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

class Board {
    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap  = new TreeMap<>();


    /*
     * Updates the board (racerMap) by making a DuckRacer win.
     * This could mean fetching an existing DuckRacer from racerMap,
     * or we might need to create a new DuckRacer, put it in the map,
     * and then make it win.
     */
    public void update(int id, Reward reward){
        DuckRacer racer;
        if(racerMap.containsKey(id)){
            racer = racerMap.get(id);
        } else {
            racer = new DuckRacer(id,studentIdMap.get(id));  // create new
            racerMap.put(id, racer);
        }
        racer.win(reward);
    }

    public void show(){
        Collection<DuckRacer> allRacers = racerMap.values();
        System.out.printf("| %-10s | %-4s | %-15s", "Name:", "Wins", "Rewards");
        System.out.println();
        for(DuckRacer racer : allRacers){
            System.out.printf("| %-10s | %-4s | %-15s\n",
                    racer.getName(),
                    racer.getWins(),
                    racer.getRewards());
        }
    }


//    FOR TESTING ONLY.  REMOVE
    void dumpStudentIdMap(){
        System.out.println(studentIdMap);
    }



    /*
     * Populates studentIdMap from file conf/student-ids.csv
     */
    private Map<Integer, String> loadStudentIdMap(){
        Map<Integer, String> result = new HashMap<>();
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Path.of("conf/student-ids.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(var line : Objects.requireNonNull(lines)){
            String[] split = line.split(",");
            result.put(Integer.valueOf(split[0]), split[1]);
        }
        return result;
    }

}