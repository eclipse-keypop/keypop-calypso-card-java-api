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

import java.util.List;
import org.eclipse.keypop.calypso.card.CalypsoCardApiFactory;
import org.eclipse.keypop.calypso.card.card.CalypsoCard;

/**
 * Contains the input/output data of the {@link
 * TransactionManager#prepareSearchRecords(SearchCommandData)} method.
 *
 * <p>An instance of this interface can be obtained via the method {@link
 * CalypsoCardApiFactory#createSearchCommandData()}.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#type_SearchCommandData">SearchCommandData</a>
 * for the normative contract.
 *
 * @since 1.1.0
 */
public interface SearchCommandData {

  /**
   * Sets the SFI of the EF in which the search is to be performed.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SearchCommandData_setSfi">SearchCommandData.setSfi</a>
   * for the normative contract.
   *
   * @param sfi The SFI of the EF.
   * @return The current instance.
   * @since 1.1.0
   */
  SearchCommandData setSfi(byte sfi);

  /**
   * Sets the number of the record where the search should begin.
   *
   * <p>By default, the search will begin from the first record.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SearchCommandData_startAtRecord">SearchCommandData.startAtRecord</a>
   * for the normative contract.
   *
   * @param recordNumber The number of the record where the search should begin.
   * @return The current instance.
   * @since 1.1.0
   */
  SearchCommandData startAtRecord(int recordNumber);

  /**
   * Sets the offset in number of bytes from which the analysis should be performed within a record.
   *
   * <p>By default, the analysis will start at the beginning of the record (offset 0).
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SearchCommandData_setOffset">SearchCommandData.setOffset</a>
   * for the normative contract.
   *
   * @param offset The offset.
   * @return The current instance.
   * @since 1.1.0
   */
  SearchCommandData setOffset(int offset);

  /**
   * Allows the command to analyze the data present at the given offset, and repeatedly at each
   * following offset, until the end of the record is reached. The last offset is less or equal than
   * ((record size) − (length of the search data)).
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SearchCommandData_enableRepeatedOffset">SearchCommandData.enableRepeatedOffset</a>
   * for the normative contract.
   *
   * @return The current instance.
   * @since 1.1.0
   */
  SearchCommandData enableRepeatedOffset();

  /**
   * Sets the data to search.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SearchCommandData_setSearchData">SearchCommandData.setSearchData</a>
   * for the normative contract.
   *
   * @param data The data to search.
   * @return The current instance.
   * @since 1.1.0
   */
  SearchCommandData setSearchData(byte[] data);

  /**
   * Sets the mask of bits to take into account during the comparison (padded right with FFh if
   * absent or incomplete).
   *
   * <p>Requirement: The length of the mask must be <b>less or equal</b> than the length of the data
   * to search.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SearchCommandData_setMask">SearchCommandData.setMask</a>
   * for the normative contract.
   *
   * @param mask The mask.
   * @return The current instance.
   * @since 1.1.0
   */
  SearchCommandData setMask(byte[] mask);

  /**
   * Requests to fetch the content of the first matching record into the {@link CalypsoCard}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SearchCommandData_fetchFirstMatchingResult">SearchCommandData.fetchFirstMatchingResult</a>
   * for the normative contract.
   *
   * @return The current instance.
   * @since 1.1.0
   */
  SearchCommandData fetchFirstMatchingResult();

  /**
   * Returns a list containing the numbers of the records who has matched.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SearchCommandData_getMatchingRecordNumbers">SearchCommandData.getMatchingRecordNumbers</a>
   * for the normative contract.
   *
   * @return An empty list if no record has matched or if the command has not yet been processed.
   * @since 1.1.0
   */
  List<Integer> getMatchingRecordNumbers();
}
