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
package org.eclipse.keypop.calypso.card;

/**
 * Enumeration of the write access levels for the Calypso card Secure Session.
 *
 * <p>Each level induces the use of one of the 3 session key levels.
 *
 * @since 1.0.0
 */
public enum WriteAccessLevel {

  /**
   * For personalization, load and debit operations.
   *
   * <p>The "issuer key" will be used.
   *
   * @since 1.0.0
   */
  PERSONALIZATION,

  /**
   * For load and debit operations only.
   *
   * <p>The "load key" will be used.
   *
   * @since 1.0.0
   */
  LOAD,

  /**
   * For debit operations only.
   *
   * <p>The "debit key" will be used.
   *
   * @since 1.0.0
   */
  DEBIT
}
