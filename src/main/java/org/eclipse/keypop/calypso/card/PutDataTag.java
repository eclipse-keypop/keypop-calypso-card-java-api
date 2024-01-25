/* ******************************************************************************
 * Copyright (c) 2024 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.calypso.card;

/**
 * Enumeration of all input data types.
 *
 * <p>May not be applicable to all products.
 *
 * @since 2.1.0
 */
public enum PutDataTag {

  /**
   * Card key pair.
   *
   * @since 2.1.0
   */
  CARD_KEY_PAIR,
  /**
   * Card certificate.
   *
   * @since 2.1.0
   */
  CARD_CERTIFICATE,
  /**
   * Certification Authority (CA) certificate.
   *
   * @since 2.1.0
   */
  CA_CERTIFICATE
}
