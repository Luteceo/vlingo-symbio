package io.vlingo.xoom.symbio.store.object;

import io.vlingo.xoom.actors.Actor;
import io.vlingo.xoom.actors.DeadLetter;
import io.vlingo.xoom.actors.LocalMessage;
import io.vlingo.xoom.actors.Mailbox;
import io.vlingo.xoom.actors.Returns;
import io.vlingo.xoom.common.Completes;
import io.vlingo.xoom.common.SerializableConsumer;
import io.vlingo.xoom.symbio.Entry;
import io.vlingo.xoom.symbio.Metadata;
import io.vlingo.xoom.symbio.store.EntryReader;

public class ObjectStore__Proxy implements io.vlingo.xoom.symbio.store.object.ObjectStore {

  private static final String closeRepresentation1 = "close()";
  private static final String entryReaderRepresentation2 = "entryReader(java.lang.String)";
  private static final String queryObjectRepresentation3 = "queryObject(io.vlingo.xoom.symbio.store.object.QueryExpression, io.vlingo.xoom.symbio.store.object.ObjectStoreReader.QueryResultInterest, java.lang.Object)";
  private static final String queryObjectRepresentation4 = "queryObject(io.vlingo.xoom.symbio.store.object.QueryExpression, io.vlingo.xoom.symbio.store.object.ObjectStoreReader.QueryResultInterest)";
  private static final String queryAllRepresentation5 = "queryAll(io.vlingo.xoom.symbio.store.object.QueryExpression, io.vlingo.xoom.symbio.store.object.ObjectStoreReader.QueryResultInterest, java.lang.Object)";
  private static final String queryAllRepresentation6 = "queryAll(io.vlingo.xoom.symbio.store.object.QueryExpression, io.vlingo.xoom.symbio.store.object.ObjectStoreReader.QueryResultInterest)";
  private static final String persistRepresentation7 = "persist(io.vlingo.xoom.symbio.StateSources, long, io.vlingo.xoom.symbio.store.object.ObjectStoreWriter.PersistResultInterest)";
  private static final String persistRepresentation8 = "persist(io.vlingo.xoom.symbio.StateSources, long, io.vlingo.xoom.symbio.store.object.ObjectStoreWriter.PersistResultInterest, java.lang.Object)";
  private static final String persistRepresentation15 = "persist(io.vlingo.xoom.symbio.StateSources, io.vlingo.xoom.symbio.Metadata, long, io.vlingo.xoom.symbio.store.object.ObjectStoreWriter.PersistResultInterest, java.lang.Object)";
  private static final String persistRepresentation10 = "persist(io.vlingo.xoom.symbio.StateSources, io.vlingo.xoom.symbio.store.object.ObjectStoreWriter.PersistResultInterest)";
  private static final String persistRepresentation12 = "persist(io.vlingo.xoom.symbio.StateSources, io.vlingo.xoom.symbio.store.object.ObjectStoreWriter.PersistResultInterest, java.lang.Object)";
  private static final String persistAllRepresentation15 = "persistAll(java.util.Collection<io.vlingo.xoom.symbio.StateSources>, long, io.vlingo.xoom.symbio.store.object.ObjectStoreWriter.PersistResultInterest, java.lang.Object)";
  private static final String persistAllRepresentation16 = "persistAll(java.util.Collection<io.vlingo.xoom.symbio.StateSources>, long, io.vlingo.xoom.symbio.store.object.ObjectStoreWriter.PersistResultInterest)";
  private static final String persistAllRepresentation23 = "persistAll(java.util.Collection<io.vlingo.xoom.symbio.StateSources>, io.vlingo.xoom.symbio.Metadata, long, io.vlingo.xoom.symbio.store.object.ObjectStoreWriter.PersistResultInterest, java.lang.Object)";
  private static final String persistAllRepresentation18 = "persistAll(java.util.Collection<io.vlingo.xoom.symbio.StateSources>, io.vlingo.xoom.symbio.store.object.ObjectStoreWriter.PersistResultInterest)";
  private static final String persistAllRepresentation20 = "persistAll(java.util.Collection<io.vlingo.xoom.symbio.StateSources>, io.vlingo.xoom.symbio.store.object.ObjectStoreWriter.PersistResultInterest, java.lang.Object)";

  private final Actor actor;
  private final Mailbox mailbox;

  public ObjectStore__Proxy(final Actor actor, final Mailbox mailbox) {
    this.actor = actor;
    this.mailbox = mailbox;
  }

  @Override
  public void close() {
    send(ObjectStore__Proxy.closeRepresentation1, ObjectStore::close);
  }

  @Override
  public Completes<EntryReader<? extends Entry<?>>> entryReader(final String arg0) {
    if (!actor.isStopped()) {
      final SerializableConsumer<ObjectStore> consumer = (actor) -> actor.entryReader(arg0);
      final Completes<EntryReader<? extends Entry<?>>> completes = Completes.using(actor.scheduler());
      if (mailbox.isPreallocated()) { mailbox.send(actor, ObjectStore.class, consumer, Returns.value(completes), entryReaderRepresentation2); }
      else { mailbox.send(new LocalMessage<ObjectStore>(actor, ObjectStore.class, consumer, Returns.value(completes), entryReaderRepresentation2)); }
      return completes;
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, entryReaderRepresentation2));
    }
    return null;
  }

  @Override
  public void queryObject(final io.vlingo.xoom.symbio.store.QueryExpression arg0,
          final io.vlingo.xoom.symbio.store.object.ObjectStoreReader.QueryResultInterest arg1, final java.lang.Object arg2) {
    final SerializableConsumer<ObjectStore> consumer = (actor) -> actor.queryObject(arg0, arg1, arg2);
    send(ObjectStore__Proxy.queryObjectRepresentation3, consumer);
  }

  @Override
  public void queryObject(final io.vlingo.xoom.symbio.store.QueryExpression arg0,
          final io.vlingo.xoom.symbio.store.object.ObjectStoreReader.QueryResultInterest arg1) {
    final SerializableConsumer<ObjectStore> consumer = (actor) -> actor.queryObject(arg0, arg1);
    send(ObjectStore__Proxy.queryObjectRepresentation4, consumer);
  }

  @Override
  public void queryAll(final io.vlingo.xoom.symbio.store.QueryExpression arg0,
          final io.vlingo.xoom.symbio.store.object.ObjectStoreReader.QueryResultInterest arg1, final java.lang.Object arg2) {
    final SerializableConsumer<ObjectStore> consumer = (actor) -> actor.queryAll(arg0, arg1, arg2);
    send(ObjectStore__Proxy.queryAllRepresentation5, consumer);
  }

  @Override
  public void queryAll(final io.vlingo.xoom.symbio.store.QueryExpression arg0,
          final io.vlingo.xoom.symbio.store.object.ObjectStoreReader.QueryResultInterest arg1) {
    final SerializableConsumer<ObjectStore> consumer = (actor) -> actor.queryAll(arg0, arg1);
    send(ObjectStore__Proxy.queryAllRepresentation6, consumer);
  }

  @Override
  public <T extends StateObject, E> void persist(final StateSources<T,E> arg0, final long arg1,
          final io.vlingo.xoom.symbio.store.object.ObjectStoreWriter.PersistResultInterest arg2) {
    final SerializableConsumer<ObjectStore> consumer = (actor) -> actor.persist(arg0, arg1, arg2);
    send(ObjectStore__Proxy.persistRepresentation7, consumer);
  }

  @Override
  public <T extends StateObject,E> void persist(final StateSources<T,E> arg0, final long arg1,
          final io.vlingo.xoom.symbio.store.object.ObjectStoreWriter.PersistResultInterest arg2, final java.lang.Object arg3) {
    final SerializableConsumer<ObjectStore> consumer = (actor) -> actor.persist(arg0, arg1, arg2, arg3);
    send(ObjectStore__Proxy.persistRepresentation8, consumer);
  }

  @Override
  public <T extends StateObject, E> void persist(final StateSources<T,E> arg0, final Metadata arg1,
          final long arg2, final PersistResultInterest arg3, final Object arg4) {
    final SerializableConsumer<ObjectStore> consumer = (actor) -> actor
            .persist(arg0, arg1, arg2, arg3, arg4);
    send(ObjectStore__Proxy.persistRepresentation15, consumer);
  }

  @Override
  public <T extends StateObject, E> void persist(final StateSources<T,E> arg0,
          final io.vlingo.xoom.symbio.store.object.ObjectStoreWriter.PersistResultInterest arg1) {
    final SerializableConsumer<ObjectStore> consumer = (actor) -> actor.persist(arg0, arg1);
    send(ObjectStore__Proxy.persistRepresentation10, consumer);
  }

  @Override
  public <T extends StateObject, E> void persist(final StateSources<T,E> arg0,
          final io.vlingo.xoom.symbio.store.object.ObjectStoreWriter.PersistResultInterest arg1, final java.lang.Object arg2) {
    final SerializableConsumer<ObjectStore> consumer = (actor) -> actor.persist(arg0, arg1, arg2);
    send(ObjectStore__Proxy.persistRepresentation12, consumer);
  }

  @Override
  public <T extends StateObject, E> void persistAll(final java.util.Collection<StateSources<T,E>> arg0, final long arg1,
          final io.vlingo.xoom.symbio.store.object.ObjectStoreWriter.PersistResultInterest arg2, final java.lang.Object arg3) {
    final SerializableConsumer<ObjectStore> consumer = (actor) -> actor.persistAll(arg0, arg1, arg2, arg3);
    send(ObjectStore__Proxy.persistAllRepresentation15, consumer);
  }

  @Override
  public <T extends StateObject, E> void persistAll(final java.util.Collection<StateSources<T,E>> arg0, final long arg1,
          final io.vlingo.xoom.symbio.store.object.ObjectStoreWriter.PersistResultInterest arg2) {
    final SerializableConsumer<ObjectStore> consumer = (actor) -> actor.persistAll(arg0, arg1, arg2);
    send(ObjectStore__Proxy.persistAllRepresentation16, consumer);
  }

  @Override
  public <T extends StateObject, E> void persistAll(final java.util.Collection<StateSources<T,E>> arg0,
          final Metadata arg1, final long arg2, final PersistResultInterest arg3, final Object arg4) {
    final SerializableConsumer<ObjectStore> consumer = (actor) -> actor.persistAll(arg0, arg1, arg2, arg3, arg4);
    send(ObjectStore__Proxy.persistAllRepresentation23, consumer);
  }

  @Override
  public <T extends StateObject, E> void persistAll(final java.util.Collection<StateSources<T,E>> arg0,
          final io.vlingo.xoom.symbio.store.object.ObjectStoreWriter.PersistResultInterest arg1) {
    final SerializableConsumer<ObjectStore> consumer = (actor) -> actor.persistAll(arg0, arg1);
    send(ObjectStore__Proxy.persistAllRepresentation18, consumer);
  }

  @Override
  public <T extends StateObject, E> void persistAll(final java.util.Collection<StateSources<T,E>> arg0,
          final io.vlingo.xoom.symbio.store.object.ObjectStoreWriter.PersistResultInterest arg1, final java.lang.Object arg2) {
    final SerializableConsumer<ObjectStore> consumer = (actor) -> actor.persistAll(arg0, arg1, arg2);
    send(ObjectStore__Proxy.persistAllRepresentation20, consumer);
  }

  private void send(final String representation, final SerializableConsumer<ObjectStore> consumer) {
    if (!actor.isStopped()) {
      if (mailbox.isPreallocated()) {
        mailbox.send(actor, ObjectStore.class, consumer, null, representation);
      } else {
        mailbox.send(new LocalMessage<>(actor, ObjectStore.class, consumer, representation));
      }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, representation));
    }
  }
}
