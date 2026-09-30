/* **************************************************************************************
 * Copyright (c) 2024 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
package org.eclipse.keypop.calypso.card.transaction;

/**
 * Manager of card transactions secured by asymmetric key cryptographic algorithms, compatible with
 * Calypso cards in PKI mode.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#type_SecurePkiModeTransactionManager">SecurePkiModeTransactionManager</a>
 * for the normative contract.
 *
 * @since 2.1.0
 */
public interface SecurePkiModeTransactionManager
    extends SecureTransactionManager<SecurePkiModeTransactionManager> {

  /**
   * Schedules the execution of an "Open Secure Session" command in PKI mode.
   *
   * <p>Note that if the next prepared command is a "Read One Record" or "Read One Or More
   * Counters", then it will by default be merged with the "Open Secure Session" command for
   * optimization purposes.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SecurePkiModeTransactionManager_prepareOpenSecureSession">SecurePkiModeTransactionManager.prepareOpenSecureSession</a>
   * for the normative contract.
   *
   * @return The current instance.
   * @since 2.1.0
   */
  SecurePkiModeTransactionManager prepareOpenSecureSession();
}
