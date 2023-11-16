/* ******************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.calypso.card.transaction;

/**
 * Indicates that the card is revoked.
 *
 * @since 1.0.0
 */
public final class CardRevokedException extends RuntimeException {

  /**
   * @param message The message to identify the exception context.
   * @since 1.0.0
   */
  public CardRevokedException(String message) {
    super(message);
  }
}
