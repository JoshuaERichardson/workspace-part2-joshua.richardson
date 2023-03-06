package com.crunch;

import java.util.Comparator;

class Radish implements Comparable<Radish>{
    private String color;
    private double size;
    private double tailLength;
    private int sprouts;


    public Radish (String color, double size, double tailLength, int sprouts) {
        setColor(color);
        setSize(size);
        setTailLength(tailLength);
        setSprouts(sprouts);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public int getSprouts() {
        return sprouts;
    }

    public void setSprouts(int sprouts) {
        this.sprouts = sprouts;
    }

    @Override
    public int compareTo(Radish that) {
        return Double.compare(this.getSize(), that.getSize());
    }

    @Override
    public String toString(){
        return String.format("%s: color=%s, size=%s, tailLength=%s, sprouts=%s",
                getClass().getSimpleName(), getColor(), getSize(), getTailLength(), getSprouts());
    }

    /*
     * INNER NESTED CLASSES
     */
    static class RadishColorComparator implements Comparator<Radish> {
        @Override
        public int compare(Radish radish1, Radish radish2) {
            return radish1.getColor().compareTo(radish2.getColor());
        }
    }

}