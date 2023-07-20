/*
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This file is part of Eclipse Keypop.
 *
 * Eclipse Keypop is free software: you can redistribute it and/or modify
 * it under the terms of the MIT License. A copy of the License is located at
 *
 * http://opensource.org/licenses/MIT
 */
package org.eclipse.keypop.calypso.card.card;

/**
 * Record of a Stored Value load log.
 *
 * @since 1.0.0
 */
public interface SvLoadLogRecord {

  /**
   * Gets the raw data of the SV load log record.
   *
   * @return A byte array.
   * @since 1.0.0
   */
  byte[] getRawData();

  /**
   * Gets the load date as an array of bytes
   *
   * @return A 2-byte byte array
   * @since 1.0.0
   */
  byte[] getLoadDate();

  /**
   * Gets the load time as an array of bytes
   *
   * @return A 2-byte byte array
   * @since 1.0.0
   */
  byte[] getLoadTime();

  /**
   * Gets the load amount value
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
   * Gets the free bytes as an array of bytes
   *
   * @return A 2-byte byte array
   * @since 1.0.0
   */
  byte[] getFreeData();

  /**
   * Gets the KVC of the load key (as given in the last SV Reload)
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
