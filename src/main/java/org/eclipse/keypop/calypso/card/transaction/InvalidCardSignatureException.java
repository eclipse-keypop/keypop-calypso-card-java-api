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
 * Indicates that the card signature is incorrect.
 *
 * <p>In the case of a card transaction secured by "symmetrical" cryptography (e.g. SAM), this
 * indicates that the card has correctly closed the secure session, but the card session is not
 * authentic because the MAC of the card is incorrect. This can happen in the following cases:
 *
 * <ul>
 *   <li>The "Digest Authenticate" command status is 6988h;
 *   <li>The "SV Check" command status is 6988h;
 * </ul>
 *
 * In the case of a card transaction secured by "asymmetrical" cryptography (e.g. PKI), this
 * indicates only that the card signature is incorrect.
 *
 * @since 1.2.0
 */
public final class InvalidCardSignatureException extends RuntimeException {

  /**
   * @param message The message to identify the exception context.
   * @since 1.2.0
   */
  public InvalidCardSignatureException(String message) {
    super(message);
  }

  /**
   * Encapsulates a lower level exception.
   *
   * @param message Message to identify the exception context.
   * @param cause The cause.
   * @since 1.2.0
   */
  public InvalidCardSignatureException(String message, Throwable cause) {
    super(message, cause);
  }
}
