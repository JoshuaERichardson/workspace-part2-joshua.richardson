/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.catalog;

import java.util.Collection;

public interface Catalog {
  public MusicItem findById(Long id);
  public Collection<MusicItem> findByKeyword(String keyword);
  public Collection<MusicItem> findByCategory(MusicCategory category);
  public int size();
  public Collection<MusicItem> getAll();
}