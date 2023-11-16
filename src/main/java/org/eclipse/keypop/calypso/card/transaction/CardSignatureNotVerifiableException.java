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
 * Indicates that the card has correctly closed the secure session, but that it is impossible to
 * check the authenticity of the card session because the cryptographic module is no more available
 * (timeout, network problem, etc.).
 *
 * @since 1.2.0
 */
public final class CardSignatureNotVerifiableException extends RuntimeException {

  /**
   * @param message The message to identify the exception context.
   * @since 1.2.0
   */
  public CardSignatureNotVerifiableException(String message) {
    super(message);
  }

  /**
   * Encapsulates a lower level exception.
   *
   * @param message Message to identify the exception context.
   * @param cause The cause.
   * @since 1.2.0
   */
  public CardSignatureNotVerifiableException(String message, Throwable cause) {
    super(message, cause);
  }
}
