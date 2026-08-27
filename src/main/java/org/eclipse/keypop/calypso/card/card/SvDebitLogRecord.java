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
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#type_SvDebitLogRecord">SvDebitLogRecord</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public interface SvDebitLogRecord {

  /**
   * Gets the raw data of the SV debit log record.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SvDebitLogRecord_getRawData">SvDebitLogRecord.getRawData</a>
   * for the normative contract.
   *
   * @return A byte array.
   * @since 1.0.0
   */
  byte[] getRawData();

  /**
   * Gets the debit date as an array of bytes
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SvDebitLogRecord_getDebitDate">SvDebitLogRecord.getDebitDate</a>
   * for the normative contract.
   *
   * @return A 2-byte byte array
   * @since 1.0.0
   */
  byte[] getDebitDate();

  /**
   * Gets the debit time as an array of bytes
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SvDebitLogRecord_getDebitTime">SvDebitLogRecord.getDebitTime</a>
   * for the normative contract.
   *
   * @return A 2-byte byte array
   * @since 1.0.0
   */
  byte[] getDebitTime();

  /**
   * Gets the debit amount value
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SvDebitLogRecord_getAmount">SvDebitLogRecord.getAmount</a>
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
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SvDebitLogRecord_getBalance">SvDebitLogRecord.getBalance</a>
   * for the normative contract.
   *
   * @return An int
   * @since 1.0.0
   */
  int getBalance();

  /**
   * Gets the KVC of the debit key (as given in the last SV Debit)
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SvDebitLogRecord_getKvc">SvDebitLogRecord.getKvc</a>
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
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SvDebitLogRecord_getSamId">SvDebitLogRecord.getSamId</a>
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
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SvDebitLogRecord_getSamTNum">SvDebitLogRecord.getSamTNum</a>
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
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SvDebitLogRecord_getSvTNum">SvDebitLogRecord.getSvTNum</a>
   * for the normative contract.
   *
   * @return An int
   * @since 1.0.0
   */
  int getSvTNum();
}
