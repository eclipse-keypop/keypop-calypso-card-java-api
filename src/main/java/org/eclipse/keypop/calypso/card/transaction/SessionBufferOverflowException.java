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
