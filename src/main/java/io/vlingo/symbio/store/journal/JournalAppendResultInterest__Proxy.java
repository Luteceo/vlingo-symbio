// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.symbio.store.journal;

import io.vlingo.actors.Actor;
import io.vlingo.actors.DeadLetter;
import io.vlingo.actors.LocalMessage;
import io.vlingo.actors.Mailbox;
import io.vlingo.symbio.store.journal.Journal.AppendResultInterest;

public class JournalAppendResultInterest__Proxy<ST> implements io.vlingo.symbio.store.journal.Journal.AppendResultInterest<ST> {

  private static final String appendResultedInRepresentation1 = "appendResultedIn(io.vlingo.common.Outcome<io.vlingo.symbio.store.StorageException, io.vlingo.symbio.store.Result>, java.lang.String, int, io.vlingo.symbio.Source<S>, java.util.Optional<ST>, java.lang.Object)";
  private static final String appendAllResultedInRepresentation2 = "appendAllResultedIn(io.vlingo.common.Outcome<io.vlingo.symbio.store.StorageException, io.vlingo.symbio.store.Result>, java.lang.String, int, java.util.List<io.vlingo.symbio.Source<S>>, java.util.Optional<ST>, java.lang.Object)";

  private final Actor actor;
  private final Mailbox mailbox;

  public JournalAppendResultInterest__Proxy(final Actor actor, final Mailbox mailbox){
    this.actor = actor;
    this.mailbox = mailbox;
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public <S>void appendResultedIn(io.vlingo.common.Outcome<io.vlingo.symbio.store.StorageException, io.vlingo.symbio.store.Result> arg0, java.lang.String arg1, int arg2, io.vlingo.symbio.Source<S> arg3, java.util.Optional<ST> arg4, java.lang.Object arg5) {
    if (!actor.isStopped()) {
      final java.util.function.Consumer<AppendResultInterest> consumer = (actor) -> actor.appendResultedIn(arg0, arg1, arg2, arg3, arg4, arg5);
      if (mailbox.isPreallocated()) { mailbox.send(actor, AppendResultInterest.class, consumer, null, appendResultedInRepresentation1); }
      else { mailbox.send(new LocalMessage<AppendResultInterest>(actor, AppendResultInterest.class, consumer, appendResultedInRepresentation1)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, appendResultedInRepresentation1));
    }
  }
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public <S>void appendAllResultedIn(io.vlingo.common.Outcome<io.vlingo.symbio.store.StorageException, io.vlingo.symbio.store.Result> arg0, java.lang.String arg1, int arg2, java.util.List<io.vlingo.symbio.Source<S>> arg3, java.util.Optional<ST> arg4, java.lang.Object arg5) {
    if (!actor.isStopped()) {
      final java.util.function.Consumer<AppendResultInterest> consumer = (actor) -> actor.appendAllResultedIn(arg0, arg1, arg2, arg3, arg4, arg5);
      if (mailbox.isPreallocated()) { mailbox.send(actor, AppendResultInterest.class, consumer, null, appendAllResultedInRepresentation2); }
      else { mailbox.send(new LocalMessage<AppendResultInterest>(actor, AppendResultInterest.class, consumer, appendAllResultedInRepresentation2)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, appendAllResultedInRepresentation2));
    }
  }
}
