/*
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This file is part of Eclipse Keypop.
 *
 * Eclipse Keypop is free software: you can redistribute it and/or modify
 * it under the terms of the MIT License. A copy of the License is located at
 *
 * http://opensource.org/licenses/MIT
 */
package org.eclipse.keypop.calypso.card.transaction;

/**
 * Indicates that the file selection failed because it was not found. This can happen in the
 * following cases:
 *
 * <ul>
 *   <li>The "Select File" card command status is 6A82h;
 * </ul>
 *
 * @since 1.4.0
 */
public final class SelectFileException extends RuntimeException {

  /**
   * Encapsulates a lower level exception.
   *
   * @param message Message to identify the exception context.
   * @param cause The cause.
   * @since 1.4.0
   */
  public SelectFileException(String message, Throwable cause) {
    super(message, cause);
  }
}
