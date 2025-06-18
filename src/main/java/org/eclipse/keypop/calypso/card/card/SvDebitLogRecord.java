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
package org.eclipse.keypop.calypso.card.card;

/**
 * Record of a Stored Value debit log.
 *
 * @since 1.0.0
 */
public interface SvDebitLogRecord {

  /**
   * Gets the raw data of the SV debit log record.
   *
   * @return A byte array.
   * @since 1.0.0
   */
  byte[] getRawData();

  /**
   * Gets the debit date as an array of bytes
   *
   * @return A 2-byte byte array
   * @since 1.0.0
   */
  byte[] getDebitDate();

  /**
   * Gets the debit time as an array of bytes
   *
   * @return A 2-byte byte array
   * @since 1.0.0
   */
  byte[] getDebitTime();

  /**
   * Gets the debit amount value
   *
   * @return An int
   * @since 1.0.0
   */
  int getAmount();

  /**
   * Gets the SV balance value
   *
   * @return An int
   * @since 1.0.0
   */
  int getBalance();

  /**
   * Gets the KVC of the debit key (as given in the last SV Debit)
   *
   * @return A byte
   * @since 1.0.0
   */
  byte getKvc();

  /**
   * Gets the SAM ID as an array of bytes
   *
   * @return A 4-byte byte array
   * @since 1.0.0
   */
  byte[] getSamId();

  /**
   * Gets the SAM transaction number value as an int
   *
   * @return An int
   * @since 1.0.0
   */
  int getSamTNum();

  /**
   * Gets the SV transaction number value as an int
   *
   * @return An int
   * @since 1.0.0
   */
  int getSvTNum();
}
