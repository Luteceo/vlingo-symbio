// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.symbio.store.state;

import io.vlingo.symbio.store.state.StateStore.ReadResultInterest;

/**
 * Defines the reader of the {@code StateStore}.
 */
public interface StateStoreReader {
  /**
   * Read the state identified by {@code id} and dispatch the result to the {@code interest}.
   * @param id the String unique identity of the state to read
   * @param type the {@code Class<?>} type of the state to read
   * @param interest the ReadResultInterest to which the result is dispatched
   */
  default void read(final String id, final Class<?> type, final ReadResultInterest interest) {
    read(id, type, interest, null);
  }

  /**
   * Read the state identified by {@code id} and dispatch the result to the {@code interest}.
   * @param id the String unique identity of the state to read
   * @param type the {@code Class<?>} type of the state to read
   * @param interest the ReadResultInterest to which the result is dispatched
   * @param object an Object that will be sent to the ReadResultInterest when the read has succeeded or failed
   */
  void read(final String id, final Class<?> type, final ReadResultInterest interest, final Object object);
}