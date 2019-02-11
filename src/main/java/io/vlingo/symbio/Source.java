// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.symbio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.vlingo.common.version.SemanticVersion;

/**
 * Abstract base of any concrete type that is a source of truth. The concrete
 * type is represented by the {@code T} parameter and is also extends me.
 * @param <T> the type of source of truth
 */
public abstract class Source<T> {
  public final long dateTimeSourced;
  public final int sourceTypeVersion;

  /**
   * Answer an instance of the {@code NullSource<T>}.
   * @return {@code Source<T>}
   */
  public static <T> Source<T> nulled() {
    return new NullSource<T>();
  }

  /**
   * Answer a {@code List<Source<T>>} of the array of {@code sources}.
   * @param sources the varargs of {@code Source<T>}
   * @param <T> the concrete type of Source
   * @return {@code List<Source<T>>}
   */
  @SafeVarargs
  public static <T> List<Source<T>> all(final Source<T>... sources) {
    return Arrays.asList(sources);
  }

  /**
   * Answer a {@code List<Source<T>>} of the pre-existing {@code List<Source<T>>} of {@code sources}.
   * @param sources the {@code List<Source<T>>} of elements to answer as a new {@code List<Source<T>>}
   * @param <T> type
   * @return {@code List<Source<T>>}
   */
  public static <T> List<Source<T>> all(final List<Source<T>> sources) {
    final List<Source<T>> all = new ArrayList<>(sources.size());

    for (final Source<T> source : sources) {
      if (!source.isNull()) {
        all.add(source);
      }
    }
    return all;
  }

  /**
   * Answer an empty {@code List<Source<T>>}.
   * @return {@code List<Source<T>>}
   */
  public static <T> List<Source<T>> none() {
    return Collections.emptyList();
  }

  /**
   * Answer whether or not I am a Null Object, which is by default {@code false}.
   * @return boolean
   */
  public boolean isNull() {
    return false;
  }

  /**
   * Answer my type name, which is the simple name of my concrete {@code Class<T>}.
   * @return String
   */
  public String typeName() {
    return getClass().getSimpleName();
  }

  /**
   * Construct my default state.
   */
  protected Source() {
    this(SemanticVersion.toValue(1, 0, 0));
  }

  /**
   * Construct my default state.
   * @param sourceTypeVersion the int type version of my concrete extender
   */
  protected Source(final int sourceTypeVersion) {
    assert (sourceTypeVersion < 1);
    this.dateTimeSourced = System.currentTimeMillis();
    this.sourceTypeVersion = sourceTypeVersion;
  }

  /**
   * Null Object pattern for {@code Source<T>} instances.
   * @param <T> the concrete type of Source
   */
  private static class NullSource<T> extends Source<T> {
    /**
     * Answer true that I am a {@code NullSource<T>}.
     */
    @Override
    public boolean isNull() {
      return true;
    }
  }
}
