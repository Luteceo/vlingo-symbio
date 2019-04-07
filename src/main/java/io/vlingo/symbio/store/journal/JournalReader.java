// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.symbio.store.journal;

import io.vlingo.symbio.Entry;
import io.vlingo.symbio.store.EntryReader;

/**
 * The reader for a given {@code Journal<T>}, which is provided by its {@code journalReader()}.
 * This reads sequentially over all {@code Entry<T>} instances in the entire journal, from the
 * first written {@code Entry<T>} to the current last written {@code Entry<T>}, and is prepared to read
 * all newly appended {@code Entry<T>} instances beyond that point when they become available.
 *
 * @param <T> the concrete type of {@code Entry<T>} stored and read, which maybe be String, byte[], or Object
 */
public interface JournalReader<T extends Entry<?>> extends EntryReader<T> { }
