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
 * Defines the type of Stored Value operation to be performed.
 *
 * @since 1.0.0
 */
public enum SvOperation {
  /**
   * Increase the balance of the stored value
   *
   * @since 1.0.0
   */
  RELOAD,
  /**
   * Decrease the balance of the stored value
   *
   * @since 1.0.0
   */
  DEBIT
}
