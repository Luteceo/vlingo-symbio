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

public class ObjectStateStore__Proxy implements io.vlingo.symbio.store.state.ObjectStateStore {

  private static final String writeRepresentation1 = "write(io.vlingo.symbio.State.io.vlingo.symbio.State.ObjectState<java.lang.Object>, io.vlingo.symbio.store.state.StateStore.io.vlingo.symbio.store.state.StateStore.WriteResultInterest<io.vlingo.symbio.State.io.vlingo.symbio.State.ObjectState<java.lang.Object>>, java.lang.Object)";
  private static final String writeRepresentation2 = "write(io.vlingo.symbio.State.io.vlingo.symbio.State.ObjectState<java.lang.Object>, io.vlingo.symbio.store.state.StateStore.io.vlingo.symbio.store.state.StateStore.WriteResultInterest<io.vlingo.symbio.State.io.vlingo.symbio.State.ObjectState<java.lang.Object>>)";
  private static final String readRepresentation3 = "read(java.lang.String, java.lang.Class<?>, io.vlingo.symbio.store.state.StateStore.io.vlingo.symbio.store.state.StateStore.ReadResultInterest<io.vlingo.symbio.State.io.vlingo.symbio.State.ObjectState<java.lang.Object>>, java.lang.Object)";
  private static final String readRepresentation4 = "read(java.lang.String, java.lang.Class<?>, io.vlingo.symbio.store.state.StateStore.io.vlingo.symbio.store.state.StateStore.ReadResultInterest<io.vlingo.symbio.State.io.vlingo.symbio.State.ObjectState<java.lang.Object>>)";

  private final Actor actor;
  private final Mailbox mailbox;

  public ObjectStateStore__Proxy(final Actor actor, final Mailbox mailbox){
    this.actor = actor;
    this.mailbox = mailbox;
  }

  public void write(io.vlingo.symbio.State.ObjectState<java.lang.Object> arg0, io.vlingo.symbio.store.state.StateStore.WriteResultInterest<io.vlingo.symbio.State.ObjectState<java.lang.Object>> arg1, java.lang.Object arg2) {
    if (!actor.isStopped()) {
      final java.util.function.Consumer<ObjectStateStore> consumer = (actor) -> actor.write(arg0, arg1, arg2);
      if (mailbox.isPreallocated()) { mailbox.send(actor, ObjectStateStore.class, consumer, null, writeRepresentation1); }
      else { mailbox.send(new LocalMessage<ObjectStateStore>(actor, ObjectStateStore.class, consumer, writeRepresentation1)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, writeRepresentation1));
    }
  }
  public void write(io.vlingo.symbio.State.ObjectState<java.lang.Object> arg0, io.vlingo.symbio.store.state.StateStore.WriteResultInterest<io.vlingo.symbio.State.ObjectState<java.lang.Object>> arg1) {
    if (!actor.isStopped()) {
      final java.util.function.Consumer<ObjectStateStore> consumer = (actor) -> actor.write(arg0, arg1);
      if (mailbox.isPreallocated()) { mailbox.send(actor, ObjectStateStore.class, consumer, null, writeRepresentation2); }
      else { mailbox.send(new LocalMessage<ObjectStateStore>(actor, ObjectStateStore.class, consumer, writeRepresentation2)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, writeRepresentation2));
    }
  }
  public void read(java.lang.String arg0, java.lang.Class<?> arg1, io.vlingo.symbio.store.state.StateStore.ReadResultInterest<io.vlingo.symbio.State.ObjectState<java.lang.Object>> arg2, java.lang.Object arg3) {
    if (!actor.isStopped()) {
      final java.util.function.Consumer<ObjectStateStore> consumer = (actor) -> actor.read(arg0, arg1, arg2, arg3);
      if (mailbox.isPreallocated()) { mailbox.send(actor, ObjectStateStore.class, consumer, null, readRepresentation3); }
      else { mailbox.send(new LocalMessage<ObjectStateStore>(actor, ObjectStateStore.class, consumer, readRepresentation3)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, readRepresentation3));
    }
  }
  public void read(java.lang.String arg0, java.lang.Class<?> arg1, io.vlingo.symbio.store.state.StateStore.ReadResultInterest<io.vlingo.symbio.State.ObjectState<java.lang.Object>> arg2) {
    if (!actor.isStopped()) {
      final java.util.function.Consumer<ObjectStateStore> consumer = (actor) -> actor.read(arg0, arg1, arg2);
      if (mailbox.isPreallocated()) { mailbox.send(actor, ObjectStateStore.class, consumer, null, readRepresentation4); }
      else { mailbox.send(new LocalMessage<ObjectStateStore>(actor, ObjectStateStore.class, consumer, readRepresentation4)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, readRepresentation4));
    }
  }
}
