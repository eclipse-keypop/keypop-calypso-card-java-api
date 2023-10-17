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
