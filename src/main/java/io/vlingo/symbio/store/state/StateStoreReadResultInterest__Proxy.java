// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.symbio.store.state;

import io.vlingo.actors.Actor;
import io.vlingo.actors.DeadLetter;
import io.vlingo.actors.LocalMessage;
import io.vlingo.actors.Mailbox;
import io.vlingo.symbio.store.state.StateStore.ReadResultInterest;

public class StateStoreReadResultInterest__Proxy<R extends io.vlingo.symbio.State<?>> implements io.vlingo.symbio.store.state.StateStore.ReadResultInterest<R> {

  private static final String readResultedInRepresentation1 = "readResultedIn(io.vlingo.common.Outcome<io.vlingo.symbio.store.StorageException, io.vlingo.symbio.store.Result>, java.lang.String, R, java.lang.Object)";

  private final Actor actor;
  private final Mailbox mailbox;

  public StateStoreReadResultInterest__Proxy(final Actor actor, final Mailbox mailbox){
    this.actor = actor;
    this.mailbox = mailbox;
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void readResultedIn(io.vlingo.common.Outcome<io.vlingo.symbio.store.StorageException, io.vlingo.symbio.store.Result> arg0, java.lang.String arg1, R arg2, java.lang.Object arg3) {
    if (!actor.isStopped()) {
      final java.util.function.Consumer<ReadResultInterest> consumer = (actor) -> actor.readResultedIn(arg0, arg1, arg2, arg3);
      if (mailbox.isPreallocated()) { mailbox.send(actor, ReadResultInterest.class, consumer, null, readResultedInRepresentation1); }
      else { mailbox.send(new LocalMessage<ReadResultInterest>(actor, ReadResultInterest.class, consumer, readResultedInRepresentation1)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, readResultedInRepresentation1));
    }
  }
}
