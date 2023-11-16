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
 * Indicates a communication error with the crypto module (e.g. timeout with the reader or the
 * computing unit, network error, etc.).
 *
 * @since 2.0.0
 */
public final class CryptoIOException extends RuntimeException {

  /**
   * Encapsulates a lower level exception.
   *
   * @param message Message to identify the exception context.
   * @param cause The cause.
   * @since 1.0.0
   */
  public CryptoIOException(String message, Throwable cause) {
    super(message, cause);
  }
}
