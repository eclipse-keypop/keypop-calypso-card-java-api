/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This file is part of Eclipse Keypop.
 *
 * Eclipse Keypop is free software: you can redistribute it and/or modify
 * it under the terms of the MIT License. A copy of the License is located at
 *
 * http://opensource.org/licenses/MIT
 ************************************************************************************** */
package org.eclipse.keypop.calypso.card.transaction;

/**
 * Defines the type Stored Value of action.
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
