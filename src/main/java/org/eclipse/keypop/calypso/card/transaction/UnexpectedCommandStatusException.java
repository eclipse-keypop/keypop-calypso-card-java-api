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
 * Indicates that an unexpected command status was returned by the card or the cryptographic module.
 *
 * <p>This can occur if the card or the cryptographic module is not Calypso compliant or if the card
 * has refused the secure session closing.
 *
 * <p>For this last case, this is usually due to an incorrect cryptographic module signature, or
 * that the secure session has been altered by other APDU commands that would have interfered with
 * it.
 *
 * <p>If a secure session was open, the card discarded all data by cancelling all updates except for
 * PIN verification attempts.
 *
 * @since 1.2.0
 */
public final class UnexpectedCommandStatusException extends RuntimeException {

  /**
   * @param message Message to identify the exception context.
   * @param cause The cause.
   * @since 1.2.0
   */
  public UnexpectedCommandStatusException(String message, Throwable cause) {
    super(message, cause);
  }
}
