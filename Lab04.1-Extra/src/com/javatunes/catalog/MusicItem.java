/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog;

import java.sql.Date;

/**
 * An item for sale in the JavaTunes catalog.
 * The 'id' property is treated as a "primary key:"
 * - equals() and hashCode() are both based solely on id.
 * - Comparable is based on id, also -> natural order defined by increasing id.
 */
public class MusicItem
implements Comparable<MusicItem> {
    private Long id;
    private String title;
    private String artist;
    private Date releaseDate;
    private Double price;
    private MusicCategory musicCategory;

    public MusicItem(Long id) {
        this.id = id;
    }

    public MusicItem(Long id, String title, String artist, Date releaseDate, Double price, MusicCategory musicCategory) {
        this(id);
        setTitle(title);
        setArtist(artist);
        setReleaseDate(releaseDate);
        setPrice(price);
        setMusicCategory(musicCategory);
    }

    public MusicItem(Long id, String title, String artist, String releaseDate, Double price, MusicCategory musicCategory) {
        this(id, title, artist, Date.valueOf(releaseDate), price, musicCategory);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        setReleaseDate(Date.valueOf(releaseDate));
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public MusicCategory getMusicCategory() {
        return musicCategory;
    }

    public void setMusicCategory(MusicCategory musicCategory) {
        this.musicCategory = musicCategory;
    }

    @Override
    public boolean equals(Object compare) {
        boolean result = false;

        if (compare instanceof MusicItem) {
            MusicItem other = (MusicItem) compare;
            result = other.getId().equals(this.getId());
        }
        return result;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override  // interface Comparable
    public int compareTo(MusicItem other) {
        return this.getId().compareTo(other.getId());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " (id=" + getId() +
                ", title=" + getTitle() +
                ", artist=" + getArtist() +
                ", releaseDate=" + getReleaseDate() +
                ", price=" + getPrice() +
                ", musicCategory=" + getMusicCategory() + ")";
    }
}