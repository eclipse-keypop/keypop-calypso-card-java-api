/* ******************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.calypso.card.transaction;

/**
 * Indicates that the secure session cannot be performed atomically because the session buffer
 * capacity is not sufficient to handle all the prepared write commands.
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
