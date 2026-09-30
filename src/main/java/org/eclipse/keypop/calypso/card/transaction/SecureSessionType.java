/* **************************************************************************************
 * Copyright (c) 2026 Calypso Networks Association https://calypsonet.org/
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
 * Cryptographic nature of a Calypso secure session, as opposed to its application mode (Regular /
 * Extended), which is given by the sub-type of {@link TransactionManager} instantiated.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#type_SecureSessionType">SecureSessionType</a>
 * for the normative contract.
 *
 * @since 3.0.0
 */
public enum SecureSessionType {

  /**
   * PSO/SAM sessions, Regular and Extended modes.
   *
   * @since 3.0.0
   */
  SYMMETRIC,

  /**
   * PKI mode.
   *
   * @since 3.0.0
   */
  ASYMMETRIC
}
