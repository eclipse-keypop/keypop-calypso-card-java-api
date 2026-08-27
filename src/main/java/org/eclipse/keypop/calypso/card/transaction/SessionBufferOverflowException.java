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
package org.eclipse.keypop.calypso.card.transaction;

/**
 * Indicates that the secure session cannot be performed atomically because the session buffer
 * capacity is not sufficient to handle all the prepared write commands.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#type_SessionBufferOverflowException">SessionBufferOverflowException</a>
 * for the normative contract.
 *
 * @since 1.2.0
 */
public final class SessionBufferOverflowException extends RuntimeException {

  /**
   * @param message The message to identify the exception context.
   * @since 1.2.0
   */
  public SessionBufferOverflowException(String message) {
    super(message);
  }
}
