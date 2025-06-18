/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
package org.eclipse.keypop.calypso.card.card;

import org.eclipse.keypop.calypso.card.WriteAccessLevel;

/**
 * Calypso DF metadata.
 *
 * @since 1.0.0
 */
public interface DirectoryHeader {

  /**
   * Gets the associated LID.
   *
   * @return The LID.
   * @since 1.0.0
   */
  short getLid();

  /**
   * Gets the DF status.
   *
   * @return The DF status byte.
   * @since 1.0.0
   */
  byte getDfStatus();

  /**
   * Gets a reference to access conditions.
   *
   * @return A not empty byte array.
   * @since 1.0.0
   */
  byte[] getAccessConditions();

  /**
   * Gets a reference to keys indexes.
   *
   * @return A not empty byte array.
   * @since 1.0.0
   */
  byte[] getKeyIndexes();

  /**
   * Gets the KIF associated to the provided write access level.
   *
   * @param writeAccessLevel The write access level (should be not null).
   * @return The KIF value.
   * @throws IllegalArgumentException if writeAccessLevel is null.
   * @since 1.0.0
   */
  byte getKif(WriteAccessLevel writeAccessLevel);

  /**
   * Gets the KVC associated to the provided write access level.
   *
   * @param writeAccessLevel The write access level (should be not null).
   * @return The KVC value.
   * @throws IllegalArgumentException if writeAccessLevel is null.
   * @since 1.0.0
   */
  byte getKvc(WriteAccessLevel writeAccessLevel);
}
