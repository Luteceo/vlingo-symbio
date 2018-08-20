// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.symbio.projection.state;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.vlingo.symbio.Metadata;
import io.vlingo.symbio.State.TextState;
import io.vlingo.symbio.projection.Projectable;
import io.vlingo.symbio.projection.state.ProjectableTextState;

public class ProjectableTextStateTest {

  @Test
  public void testProjectableness() {
    final String textState = "test-state";
    final TextState state =
            new TextState("123", String.class, 1, textState, 1, Metadata.with("value", "op"));
    final Projectable projectable = new ProjectableTextState(state, "p123");

    assertEquals("op", projectable.becauseOf());
    assertEquals(textState, projectable.dataAsText());
    assertEquals("123", projectable.dataId());
    assertEquals(1, projectable.dataVersion());
    assertEquals("value", projectable.metadata());
    assertEquals("p123", projectable.projectionId());
    assertEquals(String.class.getName(), projectable.type());
    assertEquals(1, projectable.typeVersion());
  }

  @Test(expected = UnsupportedOperationException.class)
  public void testProjectableNotBytes() {
    final String textState = "test-state";
    final TextState state =
            new TextState("123", String.class, 1, textState, 1, Metadata.with("value", "op"));
    final Projectable projectable = new ProjectableTextState(state, "p123");
    projectable.dataAsBytes();
  }
}
