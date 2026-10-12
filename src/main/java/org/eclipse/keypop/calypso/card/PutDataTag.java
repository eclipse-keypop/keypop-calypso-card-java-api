/* **************************************************************************************
 * Copyright (c) 2024 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
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
  CA_CERTIFICATE,
  /**
   * New AID of the current application (tag 4Fh).
   *
   * <p>The data is the new AID value (5 to 16 bytes).
   *
   * <p>The new AID applies to the next selections of the application. It does not change the DF
   * name already known by the {@link org.eclipse.keypop.calypso.card.card.CalypsoCard} object.
   *
   * @since 2.3.0
   */
  APPLICATION_AID,
  /**
   * Link of the current application to a Stored Value application of the same card (tag D0h).
   *
   * <p>The data is the AID of the Stored Value application to link (5 to 16 bytes), or an empty
   * array to cancel the existing link.
   *
   * @since 2.3.0
   */
  STORED_VALUE_LINK
}
