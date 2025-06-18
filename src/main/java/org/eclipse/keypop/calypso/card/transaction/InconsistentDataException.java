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
 * Indicates the detection of inconsistent data related to one of the following cases:
 *
 * <ul>
 *   <li>A de-synchronization of the APDU exchanges. This means that the number of APDU responses is
 *       different from the number of APDU requests.
 *   <li>An inconsistency in the card data. This can happen, for example, if the data read in
 *       session is different from the data read outside the session.
 * </ul>
 *
 * @since 1.2.0
 */
public final class InconsistentDataException extends RuntimeException {

  /**
   * @param message The message to identify the exception context.
   * @since 1.2.0
   */
  public InconsistentDataException(String message) {
    super(message);
  }
}
