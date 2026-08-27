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

import org.eclipse.keypop.calypso.card.WriteAccessLevel;

/**
 * Immutable snapshot of the current secure session state, captured at the moment of the call to
 * {@link TransactionManager#getSecureSessionStatus()} and not reflecting subsequent changes.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#type_SecureSessionStatus">SecureSessionStatus</a>
 * for the normative contract.
 *
 * @since 3.0.0
 */
public interface SecureSessionStatus {

  /**
   * Returns whether a secure session is open at the snapshot moment.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SecureSessionStatus_isOpen">SecureSessionStatus.isOpen</a>
   * for the normative contract.
   *
   * @return True if a secure session is open.
   * @since 3.0.0
   */
  boolean isOpen();

  /**
   * Returns the cryptographic nature of the session.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SecureSessionStatus_getType">SecureSessionStatus.getType</a>
   * for the normative contract.
   *
   * @return A non-null value.
   * @since 3.0.0
   */
  SecureSessionType getType();

  /**
   * Returns the write access level requested at session opening.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SecureSessionStatus_getWriteAccessLevel">SecureSessionStatus.getWriteAccessLevel</a>
   * for the normative contract.
   *
   * @return Null in PKI mode ({@link SecureSessionType#ASYMMETRIC}), where session opening does not
   *     take a write access level.
   * @since 3.0.0
   */
  WriteAccessLevel getWriteAccessLevel();
}
