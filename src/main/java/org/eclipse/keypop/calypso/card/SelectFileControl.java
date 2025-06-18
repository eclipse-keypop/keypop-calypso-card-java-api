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
package org.eclipse.keypop.calypso.card;

/**
 * Enumeration of all expected behaviors of the selection command (see the specifics of this command
 * in the ISO7816-4 standard and the Calypso specification).
 *
 * @since 1.0.0
 */
public enum SelectFileControl {

  /**
   * The first EF of the current Calypso DF
   *
   * @since 1.0.0
   */
  FIRST_EF,

  /**
   * The next EF of the current Calypso DF
   *
   * @since 1.0.0
   */
  NEXT_EF,

  /**
   * The current Calypso DF
   *
   * @since 1.0.0
   */
  CURRENT_DF
}
