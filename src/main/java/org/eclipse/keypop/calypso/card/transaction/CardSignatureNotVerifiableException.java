/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This file is part of Eclipse Keypop.
 *
 * Eclipse Keypop is free software: you can redistribute it and/or modify
 * it under the terms of the MIT License. A copy of the License is located at
 *
 * http://opensource.org/licenses/MIT
 ************************************************************************************** */
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
