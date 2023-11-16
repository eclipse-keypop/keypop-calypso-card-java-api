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
 * Indicates that an error occurred when computing a crypto operation.
 *
 * @since 2.0.0
 */
public final class CryptoException extends RuntimeException {

  /**
   * Encapsulates a lower level exception.
   *
   * @param message Message to identify the exception context.
   * @param cause The cause.
   * @since 2.0.0
   */
  public CryptoException(String message, Throwable cause) {
    super(message, cause);
  }
}
