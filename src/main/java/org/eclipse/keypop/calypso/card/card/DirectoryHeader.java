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
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#type_DirectoryHeader">DirectoryHeader</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public interface DirectoryHeader {

  /**
   * Gets the associated LID.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_DirectoryHeader_getLid">DirectoryHeader.getLid</a>
   * for the normative contract.
   *
   * @return The LID.
   * @since 1.0.0
   */
  short getLid();

  /**
   * Gets the DF status.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_DirectoryHeader_getDfStatus">DirectoryHeader.getDfStatus</a>
   * for the normative contract.
   *
   * @return The DF status byte.
   * @since 1.0.0
   */
  byte getDfStatus();

  /**
   * Gets a reference to access conditions.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_DirectoryHeader_getAccessConditions">DirectoryHeader.getAccessConditions</a>
   * for the normative contract.
   *
   * @return A not empty byte array.
   * @since 1.0.0
   */
  byte[] getAccessConditions();

  /**
   * Gets a reference to keys indexes.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_DirectoryHeader_getKeyIndexes">DirectoryHeader.getKeyIndexes</a>
   * for the normative contract.
   *
   * @return A not empty byte array.
   * @since 1.0.0
   */
  byte[] getKeyIndexes();

  /**
   * Gets the KIF associated to the provided write access level.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_DirectoryHeader_getKif">DirectoryHeader.getKif</a>
   * for the normative contract.
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
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_DirectoryHeader_getKvc">DirectoryHeader.getKvc</a>
   * for the normative contract.
   *
   * @param writeAccessLevel The write access level (should be not null).
   * @return The KVC value.
   * @throws IllegalArgumentException if writeAccessLevel is null.
   * @since 1.0.0
   */
  byte getKvc(WriteAccessLevel writeAccessLevel);
}
