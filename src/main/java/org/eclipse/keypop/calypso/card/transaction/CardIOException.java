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
 * Indicates a communication error with the card (e.g. card removal, etc.).
 *
 * @since 1.0.0
 */
public final class CardIOException extends RuntimeException {

  /**
   * @param message The message to identify the exception context.
   * @since 1.0.0
   */
  public CardIOException(String message) {
    super(message);
  }

  /**
   * Encapsulates a lower level exception.
   *
   * @param message Message to identify the exception context.
   * @param cause The cause.
   * @since 1.0.0
   */
  public CardIOException(String message, Throwable cause) {
    super(message, cause);
  }
}
