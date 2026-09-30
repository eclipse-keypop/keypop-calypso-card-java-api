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
 * Record of a Stored Value load log.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#type_SvLoadLogRecord">SvLoadLogRecord</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public interface SvLoadLogRecord {

  /**
   * Gets the raw data of the SV load log record.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SvLoadLogRecord_getRawData">SvLoadLogRecord.getRawData</a>
   * for the normative contract.
   *
   * @return A byte array.
   * @since 1.0.0
   */
  byte[] getRawData();

  /**
   * Gets the load date as an array of bytes
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SvLoadLogRecord_getLoadDate">SvLoadLogRecord.getLoadDate</a>
   * for the normative contract.
   *
   * @return A 2-byte byte array
   * @since 1.0.0
   */
  byte[] getLoadDate();

  /**
   * Gets the load time as an array of bytes
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SvLoadLogRecord_getLoadTime">SvLoadLogRecord.getLoadTime</a>
   * for the normative contract.
   *
   * @return A 2-byte byte array
   * @since 1.0.0
   */
  byte[] getLoadTime();

  /**
   * Gets the load amount value
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SvLoadLogRecord_getAmount">SvLoadLogRecord.getAmount</a>
   * for the normative contract.
   *
   * @return An int
   * @since 1.0.0
   */
  int getAmount();

  /**
   * Gets the SV balance value
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SvLoadLogRecord_getBalance">SvLoadLogRecord.getBalance</a>
   * for the normative contract.
   *
   * @return An int
   * @since 1.0.0
   */
  int getBalance();

  /**
   * Gets the free bytes as an array of bytes
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SvLoadLogRecord_getFreeData">SvLoadLogRecord.getFreeData</a>
   * for the normative contract.
   *
   * @return A 2-byte byte array
   * @since 1.0.0
   */
  byte[] getFreeData();

  /**
   * Gets the KVC of the load key (as given in the last SV Reload)
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SvLoadLogRecord_getKvc">SvLoadLogRecord.getKvc</a>
   * for the normative contract.
   *
   * @return A byte
   * @since 1.0.0
   */
  byte getKvc();

  /**
   * Gets the SAM ID as an array of bytes
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SvLoadLogRecord_getSamId">SvLoadLogRecord.getSamId</a>
   * for the normative contract.
   *
   * @return A 4-byte byte array
   * @since 1.0.0
   */
  byte[] getSamId();

  /**
   * Gets the SAM transaction number value as an int
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SvLoadLogRecord_getSamTNum">SvLoadLogRecord.getSamTNum</a>
   * for the normative contract.
   *
   * @return An int
   * @since 1.0.0
   */
  int getSamTNum();

  /**
   * Gets the SV transaction number value as an int
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SvLoadLogRecord_getSvTNum">SvLoadLogRecord.getSvTNum</a>
   * for the normative contract.
   *
   * @return An int
   * @since 1.0.0
   */
  int getSvTNum();
}
