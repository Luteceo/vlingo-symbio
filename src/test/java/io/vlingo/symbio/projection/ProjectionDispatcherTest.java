// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.symbio.projection;

import org.junit.After;
import org.junit.Before;

import io.vlingo.actors.Actor;
import io.vlingo.actors.Definition;
import io.vlingo.actors.Protocols;
import io.vlingo.actors.World;
import io.vlingo.symbio.store.state.Entity1;
import io.vlingo.symbio.store.state.Entity2;
import io.vlingo.symbio.store.state.StateStore;
import io.vlingo.symbio.store.state.StateStore.Dispatcher;
import io.vlingo.symbio.store.state.StateStore.DispatcherControl;
import io.vlingo.symbio.store.state.StateTypeStateStoreMap;
import io.vlingo.symbio.store.state.inmemory.InMemoryTextStateStoreActor;

public abstract class ProjectionDispatcherTest {
  protected Dispatcher dispatcher;
  protected DispatcherControl dispatcherControl;
  protected ProjectionDispatcher projectionDispatcher;
  protected StateStore store;
  protected World world;

  @Before
  public void setUp() {
    world = World.start("test-store", true);

    final Protocols dispatcherProtocols =
            world.actorFor(
                    Definition.has(projectionDispatcherClass(), Definition.NoParameters),
                    new Class<?>[] { dispatcherInterfaceClass(), ProjectionDispatcher.class });

    final Protocols.Two<Dispatcher, ProjectionDispatcher> dispatchers = Protocols.two(dispatcherProtocols);
    dispatcher = dispatchers.p1();
    projectionDispatcher = dispatchers.p2();

    final Protocols storeProtocols =
            world.actorFor(
                    Definition.has(InMemoryTextStateStoreActor.class, Definition.parameters(dispatcher)),
                    new Class<?>[] { stateStoreInterfaceClass(), DispatcherControl.class });

    final Protocols.Two<StateStore, DispatcherControl> storeWithControl = Protocols.two(storeProtocols);
    store = storeWithControl.p1();
    dispatcherControl = storeWithControl.p2();

    StateTypeStateStoreMap.stateTypeToStoreName(Entity1.class, Entity1.class.getSimpleName());
    StateTypeStateStoreMap.stateTypeToStoreName(Entity2.class, Entity2.class.getSimpleName());
  }

  @After
  public void tearDown() {
    world.terminate();
  }

  protected abstract Class<? extends Dispatcher> dispatcherInterfaceClass();
  protected abstract Class<? extends Actor> projectionDispatcherClass();
  protected abstract Class<? extends StateStore> stateStoreInterfaceClass();

  @SuppressWarnings("unchecked")
  protected <T> T store() {
    return (T) store;
  }
}
