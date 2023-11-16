/* ******************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.calypso.card.card;

import org.eclipse.keypop.calypso.card.CalypsoCardApiFactory;
import org.eclipse.keypop.calypso.card.GetDataTag;
import org.eclipse.keypop.calypso.card.SelectFileControl;
import org.eclipse.keypop.calypso.card.WriteAccessLevel;
import org.eclipse.keypop.reader.selection.spi.CardSelectionExtension;

/**
 * Extends the {@link CardSelectionExtension} interface of the "Keypop Reader API" to provide means
 * to define optional commands to be executed during the selection phase.
 *
 * <p>An instance of this interface can be obtained via the method {@link
 * CalypsoCardApiFactory#createCalypsoCardSelectionExtension()}.
 *
 * <p>Note 1: by default, the selection process ignores PRIME revision 3 cards that have been
 * invalidated. The {@link CalypsoCardSelectionExtension#acceptInvalidatedCard()} method must be
 * called to stop ignoring them.<br>
 * This feature does not apply to earlier revisions for which it is necessary to run a Select File
 * (DF) command to determine the invalidation status. In this case, the rejection or acceptance of
 * invalidated cards will have to be handled by the application.
 *
 * <p>Note 2: the APDU commands resulting from the invocation of the "prepare" methods shall be
 * compliant with the PRIME revision 3 cards.
 *
 * <p>For all "prepare" type commands, unless otherwise specified, here are the ranges of values
 * checked for the various parameters:
 *
 * <ul>
 *   <li>SFI: [0..30] (0 indicates the current EF)
 *   <li>Record number: [1..250]
 *   <li>Counter number: [1..83]
 *   <li>Counter value: [0..16777215]
 *   <li>Offset: [0..249] or [0..32767] for binary files (0 indicates the first byte)
 *   <li>Input data length: [1..250] or [1..32767] for binary files
 * </ul>
 *
 * @since 2.0.0
 */
public interface CalypsoCardSelectionExtension extends CardSelectionExtension {

  /**
   * Request to accept invalidated cards during the selection stage.
   *
   * <p>Caution: this functionality is operational only from PRIME revision 3 cards. Invalidated
   * cards are rejected by default.
   *
   * @return The current instance.
   * @since 1.0.0
   */
  CalypsoCardSelectionExtension acceptInvalidatedCard();

  /**
   * Adds a "Select File" command to select an EF by its LID in the current DF.
   *
   * <p>Caution 1: the resulting APDU command must be compliant with PRIME revision 3 cards.
   * Therefore, the command may be rejected by some earlier revision cards.
   *
   * <p>Caution 2: the command will fail if the selected file is not an EF.
   *
   * @param lid The LID of the EF to select.
   * @return The current instance.
   * @since 1.0.0
   */
  CalypsoCardSelectionExtension prepareSelectFile(short lid);

  /**
   * Adds a "Select File" command to select file according to the provided {@link SelectFileControl}
   * enum entry indicating the navigation case: FIRST, NEXT or CURRENT.
   *
   * <p>Caution: the resulting APDU command must be compliant with PRIME revision 3 cards.
   * Therefore, the command may be rejected by some earlier revision cards.
   *
   * @param selectControl A {@link SelectFileControl} enum entry.
   * @return The current instance.
   * @throws IllegalArgumentException If the argument is null.
   * @since 1.0.0
   */
  CalypsoCardSelectionExtension prepareSelectFile(SelectFileControl selectControl);

  /**
   * Adds a "Get Data" command to retrieve the data indicated by the provided tag.
   *
   * <p>This method can be used to obtain FCI information when it is not provided directly by the
   * select application (e.g. OMAPI case).
   *
   * <p>Caution: the resulting APDU command must be compliant with PRIME revision 3 cards.
   * Therefore, the command may be rejected by some earlier revision cards.
   *
   * @param tag The tag to use.
   * @return The current instance.
   * @throws IllegalArgumentException If tag is null.
   * @since 1.0.0
   */
  CalypsoCardSelectionExtension prepareGetData(GetDataTag tag);

  /**
   * Adds a "Read Records" command to read a single record from the indicated "linear" or "cyclic"
   * EF.
   *
   * <p>Once this command is processed, the result is available in {@link CalypsoCard} if the
   * requested file and record exist in the file structure of the card (best-effort mode).
   *
   * <p>Caution: the resulting APDU command is compliant with PRIME revision 3 cards. Therefore, the
   * command may be rejected by some earlier revision cards.
   *
   * @param sfi The SFI of the EF to read
   * @param recordNumber The record number to read.
   * @return The current instance.
   * @throws IllegalArgumentException If one of the provided argument is out of range.
   * @since 1.1.0
   */
  CalypsoCardSelectionExtension prepareReadRecord(byte sfi, int recordNumber);

  /**
   * Adds one or multiple "Read Binary" commands to read all or part of the indicated "binary" EF.
   *
   * <p>Once this command is processed, the result is available in {@link CalypsoCard} if the
   * requested file exist in the file structure of the card and if the offset and number of bytes to
   * read are valid (best-effort mode).
   *
   * <p>Caution: the resulting APDU command is compliant with PRIME revision 3 cards. Therefore, the
   * command may be rejected by some earlier revision cards.
   *
   * @param sfi The SFI of the EF.
   * @param offset The offset (0 indicates the first byte).
   * @param nbBytesToRead The number of bytes to read.
   * @return The current instance.
   * @throws IllegalArgumentException If one of the provided argument is out of range.
   * @since 1.7.0
   */
  CalypsoCardSelectionExtension prepareReadBinary(byte sfi, int offset, int nbBytesToRead);

  /**
   * Adds a "Read Records" command to read a part of a record of the indicated EF, which should be a
   * counter file.
   *
   * <p>The record will be read up to the counter location indicated in parameter.<br>
   * Thus, all previous counters will also be read.
   *
   * <p>Once this command is processed, the result is available in {@link CalypsoCard} if the
   * requested file and the counter number exist in the file structure of the card (best-effort
   * mode).
   *
   * <p>Caution: the resulting APDU command is compliant with PRIME revision 3 cards. Therefore, the
   * command may be rejected by some earlier revision cards.
   *
   * @param sfi The SFI of the EF.
   * @param nbCountersToRead The number of counters to read.
   * @return The current instance.
   * @throws IllegalArgumentException If one of the provided argument is out of range.
   * @since 1.7.0
   */
  CalypsoCardSelectionExtension prepareReadCounter(byte sfi, int nbCountersToRead);

  /**
   * Adds a specific "Open Secure Session" command to attempt a secure session pre-opening. For
   * cards that support this feature, this optimizes future exchanges with the card in the case of
   * secure sessions intended to be executed in a single step.
   *
   * <p>The objective of the pre-opening is to allow the grouping of all the commands of a secure
   * session. This functionality is only relevant in the case of a distributed system where the
   * ticketing processing is done remotely in order to allow a complete secure session to be carried
   * out in a single exchange between the server and the terminal.
   *
   * <p>This mechanism is based on the anticipation of the APDU responses of the card.
   *
   * <p>In order to achieve the objective of a single exchange, it is essential to read locally
   * beforehand (out of session) all the data that will have to be read in session. If not,
   * additional exchanges will be made.
   *
   * <p>Then, the remote ticketing processing must prepare all the commands of the session (from
   * opening to closing) before executing it.
   *
   * <p>Example:
   *
   * <pre>{@code
   * transaction
   *   .prepareOpenSecureSession(...)
   *   .prepare...
   *   [...]
   *   .prepare...
   *   .prepareCloseSecureSession()
   *   .processCommands(...);
   * }</pre>
   *
   * Caution: this feature will be ineffective in the following cases:
   *
   * <ul>
   *   <li>the card or the cryptographic module does not support the extended mode
   *   <li>the session contains commands that necessarily require exchanges with the card during the
   *       session (e.g. PIN, Stored Value, encryption, early mutual authentication, data not
   *       previously read outside the session)
   *   <li>the session is opened with an access level different from the pre-opening one
   *   <li>an intermediate "processCommand(...)" call has been made
   *   <li>the session uses asymmetric cryptography
   * </ul>
   *
   * @param writeAccessLevel The write access level.
   * @return The current instance.
   * @throws IllegalArgumentException If writeAccessLevel is null.
   * @throws IllegalStateException If "Pre-Open" command is already prepared.
   * @since 1.7.0
   */
  CalypsoCardSelectionExtension preparePreOpenSecureSession(WriteAccessLevel writeAccessLevel);

  /**
   * Adds a specific "Open Secure Session" command to attempt a secure session pre-opening in PKI
   * mode. For cards that support this feature, this optimizes future exchanges with the card in the
   * case of secure sessions intended to be executed in a single step.
   *
   * <p>The objective of the pre-opening is to allow the grouping of all the commands of a secure
   * session. This functionality is only relevant in the case of a distributed system where the
   * ticketing processing is done remotely in order to allow a complete secure session to be carried
   * out in a single exchange between the server and the terminal.
   *
   * <p>This mechanism is based on the anticipation of the APDU responses of the card.
   *
   * <p>In order to achieve the objective of a single exchange, it is essential to read locally
   * beforehand (out of session) all the data that will have to be read in session. If not,
   * additional exchanges will be made.
   *
   * <p>Then, the remote ticketing processing must prepare all the commands of the session (from
   * opening to closing) before executing it.
   *
   * <p>Example:
   *
   * <pre>{@code
   * transaction
   *   .preparePreOpenSecureSessionInPkiMode(...)
   *   .prepare...
   *   [...]
   *   .prepare...
   *   .prepareCloseSecureSession()
   *   .processCommands(...);
   * }</pre>
   *
   * Caution: this feature will be ineffective in the following cases:
   *
   * <ul>
   *   <li>the card or the cryptographic module does not support the PKI mode
   *   <li>an intermediate "processCommand(...)" call has been made
   *   <li>the session uses symmetric cryptography
   * </ul>
   *
   * @return The current instance.
   * @throws IllegalArgumentException If writeAccessLevel is null.
   * @throws IllegalStateException If "Pre-Open" command is already prepared.
   * @since 2.0.0
   */
  // CalypsoCardSelectionExtension preparePreOpenSecureSessionInPkiMode();
}
