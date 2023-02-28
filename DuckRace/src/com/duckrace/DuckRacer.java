package com.duckrace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class DuckRacer {
//    Instance variables
    private int id;
    String name;
    int wins;
    private Collection<Reward> rewards = new ArrayList<>();



// Constructors
    public DuckRacer(int id, String name){
        this.id = id;
        setName(name);
    }






//    Business methods
    public void win(Reward reward){
        rewards.add(reward);
    }













//    Accessor methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return rewards.size();
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

//    O noes! We're creating a direct reference to our List<Reward>.
//    Create a live view of the actual list(but read only)
    public Collection<Reward> getRewards(){
        return Collections.unmodifiableCollection(rewards);
    }

    public void setRewards(Collection<Reward> rewards) {
        this.rewards = rewards;
    }

    public String toString(){
        return String.format("%s:\tId: %d,\t Name: %s,\t Wins: %d,\tRewards: %s",
                getClass().getSimpleName(), getId(), getName(), getWins(), getRewards());
    }
}