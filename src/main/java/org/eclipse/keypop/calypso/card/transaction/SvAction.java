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
 * Defines the type Stored Value of action.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#type_SvAction">SvAction</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public enum SvAction {
  /**
   * In the case of a {@link SvOperation#RELOAD}, loads a positive amount; in the case of a {@link
   * SvOperation#DEBIT}, debits a positive amount
   *
   * @since 1.0.0
   */
  DO,
  /**
   * In the case of a {@link SvOperation#RELOAD}, loads a negative amount; in the case of a {@link
   * SvOperation#DEBIT}, cancels, totally or partially, a previous debit.
   *
   * @since 1.0.0
   */
  UNDO
}
