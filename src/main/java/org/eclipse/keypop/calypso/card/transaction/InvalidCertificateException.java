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
 * Indicates that the certificate is invalid.
 *
 * <p>This exception is thrown when a certificate fails validation checks. This includes issues with
 * the certificate's signature validity, as well as problems with other essential fields of the
 * certificate, such as the validity period, issuer and subject details, and any relevant
 * constraints or extensions. It signifies that the certificate does not conform to the expected
 * standards and requirements, either due to incorrect signing, expiration, revocation, or other
 * compliance failures.
 *
 * @since 2.1.0
 */
public final class InvalidCertificateException extends RuntimeException {

  /**
   * @param message The message to identify the exception context.
   * @since 2.1.0
   */
  public InvalidCertificateException(String message) {
    super(message);
  }

  /**
   * Encapsulates a lower level exception.
   *
   * @param message Message to identify the exception context.
   * @param cause The cause.
   * @since 2.1.0
   */
  public InvalidCertificateException(String message, Throwable cause) {
    super(message, cause);
  }
}
