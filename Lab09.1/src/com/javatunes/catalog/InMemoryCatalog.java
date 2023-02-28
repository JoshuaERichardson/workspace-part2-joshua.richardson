/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class InMemoryCatalog implements Catalog {
	
	private List<MusicItem> catalogData = Arrays.asList(
	             /* id    title                        artist                       releaseDate  price  musicCategory */
	  new MusicItem(1L,  "Diva",                      "Annie Lennox",              "1992-01-04", 13.99, MusicCategory.POP),
	  new MusicItem(2L,  "Dream of the Blue Turtles", "Sting",                     "1985-02-05", 14.99, MusicCategory.POP),
	  new MusicItem(3L,  "Trouble is...",             "Kenny Wayne Shepherd Band", "1997-08-08", 14.99, MusicCategory.BLUES),
	  new MusicItem(4L,  "Lie to Me",                 "Jonny Lang",                "1997-08-26", 17.97, MusicCategory.BLUES),
	  new MusicItem(5L,  "Little Earthquakes",        "Tori Amos",                 "1992-01-18", 14.99, MusicCategory.ALTERNATIVE),
	  new MusicItem(6L,  "Seal",                      "Seal",                      "1991-08-18", 17.97, MusicCategory.POP),
	  new MusicItem(7L,  "Ian Moore",                 "Ian Moore",                 "1993-12-05",  9.97, MusicCategory.CLASSICAL),
	  new MusicItem(8L,  "So Much for the Afterglow", "Everclear",                 "1997-01-19", 13.99, MusicCategory.ROCK),
	  new MusicItem(9L,  "Surfacing",                 "Sarah McLachlan",           "1997-12-04", 17.97, MusicCategory.ALTERNATIVE),
	  new MusicItem(10L, "Hysteria",                  "Def Leppard",               "1987-06-20", 17.97, MusicCategory.ROCK),
	  new MusicItem(11L, "A Life of Saturdays",       "Dexter Freebish",           "2000-12-06", 16.97, MusicCategory.RAP),
	  new MusicItem(12L, "Human Clay",                "Creed",                     "1999-10-21", 18.97, MusicCategory.ROCK),
	  new MusicItem(13L, "My, I'm Large",             "Bobs",                      "1987-02-20", 11.97, MusicCategory.COUNTRY),
	  new MusicItem(14L, "So",                        "Peter Gabriel",             "1986-10-03", 17.97, MusicCategory.POP),
	  new MusicItem(15L, "Big Ones",                  "Aerosmith",                 "1994-05-08", 18.97, MusicCategory.ROCK),
	  new MusicItem(16L, "90125",                     "Yes",                       "1983-10-16", 11.97, MusicCategory.ROCK),
	  new MusicItem(17L, "1984",                      "Van Halen",                 "1984-08-19", 11.97, MusicCategory.ROCK),
	  new MusicItem(18L, "Escape",                    "Journey",                   "1981-02-25", 11.97, MusicCategory.CLASSIC_ROCK)
	);
	
	@Override
	public MusicItem findById(Long id) {
		// declare return value
		MusicItem result = null;

		// iterate through the catalog, looking for an ID match
		for (MusicItem item : catalogData) {
			if (item.getId().equals(id)) {
				result = item;    // assign to return value
				break;            // found it - stop looping
			}
		}
		return result;
	}		

	@Override
	public Collection<MusicItem> findByKeyword(String keyword) {
		// declare return value
		Collection<MusicItem> result = new ArrayList<>();

		// remove case sensitivity
		keyword = keyword.toLowerCase();

		// iterate through the catalog, looking for a keyword match
		for (MusicItem item : catalogData) {
			if (item.getTitle().toLowerCase().contains(keyword) ||
					item.getArtist().toLowerCase().contains(keyword)) {
				result.add(item);
			}
		}
		return result;
	}
	
	@Override
	public Collection<MusicItem> findByCategory(MusicCategory category) {
		// declare return value
		Collection<MusicItem> result = new ArrayList<>();

		// iterate through the catalog, looking for a category match
		for (MusicItem item : catalogData) {
			if (item.getMusicCategory() == category) {
				result.add(item);
			}
		}
		return result;
	}	
	
	@Override
	public int size() {
		return catalogData.size();
	}
	
	@Override
	public Collection<MusicItem> getAll() {
		return Collections.unmodifiableCollection(catalogData);
	}	
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + catalogData;
	}	
}