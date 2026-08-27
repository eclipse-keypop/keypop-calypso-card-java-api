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
 * Indicates that the file selection failed because it was not found. This can happen in the
 * following cases:
 *
 * <ul>
 *   <li>The "Select File" card command status is 6A82h;
 * </ul>
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#type_SelectFileException">SelectFileException</a>
 * for the normative contract.
 *
 * @since 1.4.0
 */
public final class SelectFileException extends RuntimeException {

  /**
   * Encapsulates a lower level exception.
   *
   * @param message Message to identify the exception context.
   * @param cause The cause.
   * @since 1.4.0
   */
  public SelectFileException(String message, Throwable cause) {
    super(message, cause);
  }
}
