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
 * Calypso Elementary File.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#type_ElementaryFile">ElementaryFile</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public interface ElementaryFile {

  /**
   * Gets the associated SFI.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_ElementaryFile_getSfi">ElementaryFile.getSfi</a>
   * for the normative contract.
   *
   * @return The SFI.
   * @since 1.0.0
   */
  byte getSfi();

  /**
   * Gets the file header.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_ElementaryFile_getHeader">ElementaryFile.getHeader</a>
   * for the normative contract.
   *
   * @return Null if header is not yet set.
   * @since 1.0.0
   */
  FileHeader getHeader();

  /**
   * Gets the file data.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_ElementaryFile_getData">ElementaryFile.getData</a>
   * for the normative contract.
   *
   * @return A non-null data reference.
   * @since 1.0.0
   */
  FileData getData();

  /**
   * The different types of EF.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#type_Type">ElementaryFile.Type</a>
   * for the normative contract.
   *
   * @since 1.0.0
   */
  enum Type {
    /**
     * A "linear" EF is made of 1 to several records.
     *
     * @since 1.0.0
     */
    LINEAR,
    /**
     * A "binary" EF contains a single continuous sequence of data bytes from byte #0 (first byte)
     * to byte #N−1 (last byte, for a "binary" file of N bytes).
     *
     * @since 1.0.0
     */
    BINARY,
    /**
     * A "cyclic" EF is made of 1 to several records organized in a cycle, from the most recent
     * (record #1) to the oldest.
     *
     * @since 1.0.0
     */
    CYCLIC,
    /**
     * A Counters EF is made of a single record containing an ordered sequence of K counters of
     * three bytes each, from counter #1 (bytes at offsets 0, 1 and 2 of the record) to counter #K.
     *
     * @since 1.0.0
     */
    COUNTERS,
    /**
     * A Simulated "counter" EF is a "linear" file with a single record.<br>
     * Simulated Counter EFs are present for compatibility with the Calypso Revision 2 access to
     * simulated individual counters.
     *
     * @since 1.0.0
     */
    SIMULATED_COUNTERS
  }
}
