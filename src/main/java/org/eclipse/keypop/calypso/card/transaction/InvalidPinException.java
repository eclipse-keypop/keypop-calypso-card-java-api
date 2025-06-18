/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
package org.eclipse.keypop.calypso.card.transaction;

/**
 * Indicates that the provided PIN is invalid.
 *
 * @since 2.0.0
 */
public final class InvalidPinException extends RuntimeException {

  /**
   * @param message The message to identify the exception context.
   * @since 2.0.0
   */
  public InvalidPinException(String message) {
    super(message);
  }

  /**
   * Encapsulates a lower level exception.
   *
   * @param message Message to identify the exception context.
   * @param cause The cause.
   * @since 2.0.0
   */
  public InvalidPinException(String message, Throwable cause) {
    super(message, cause);
  }
}
