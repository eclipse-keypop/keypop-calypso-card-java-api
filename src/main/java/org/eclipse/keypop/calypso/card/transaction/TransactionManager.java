/* ******************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.calypso.card.transaction;

import java.util.List;
import java.util.Map;
import org.eclipse.keypop.calypso.card.GetDataTag;
import org.eclipse.keypop.calypso.card.PutDataTag;
import org.eclipse.keypop.calypso.card.SelectFileControl;
import org.eclipse.keypop.calypso.card.card.CalypsoCard;
import org.eclipse.keypop.calypso.card.card.ElementaryFile;

/**
 * Contains operations common to all card transactions.
 *
 * <p>To exchange data with the card, it is first necessary to prepare the commands to be
 * transmitted to the card and then to process the prepared commands via the {@link
 * #processCommands(ChannelControl)} method.
 *
 * <p>The card commands preparation step makes it possible to group commands together in order to
 * minimize network data exchanges (especially useful in a distributed architecture).
 *
 * <p>The {@link CalypsoCard} object registered with the manager is updated during the transaction
 * after each data exchange with the card.
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
 * @param <T> The type of the lowest level child object.
 * @since 2.0.0
 */
public interface TransactionManager<T extends TransactionManager<T>> {

  /**
   * Schedules the execution of a "Select File" command to select an EF by its LID in the current
   * DF.
   *
   * <p>Data will be available in {@link CalypsoCard} using the {@link
   * CalypsoCard#getFileBySfi(byte)}/{@link CalypsoCard#getFileByLid(short)} and {@link
   * ElementaryFile#getHeader()} methods.
   *
   * <p>Caution: the command will fail if the selected file is not an EF.
   *
   * @param lid The LID of the EF to select.
   * @return The current instance.
   * @since 1.1.0
   */
  T prepareSelectFile(short lid);

  /**
   * Schedules the execution of a "Select File" command using a navigation selectFileControl defined
   * by the ISO standard.
   *
   * <p>Data will be available in {@link CalypsoCard} using the {@link ElementaryFile#getHeader()}
   * method.
   *
   * @param selectFileControl A {@link SelectFileControl} enum entry.
   * @return The current instance.
   * @throws IllegalArgumentException If selectFileControl is null.
   * @since 1.0.0
   */
  T prepareSelectFile(SelectFileControl selectFileControl);

  /**
   * Schedules the execution of one or more "Get Data" command to retrieve the data indicated by the
   * provided data type.
   *
   * <p>Data will be available in {@link CalypsoCard} using the {@link ElementaryFile#getHeader()}
   * or {@link CalypsoCard#getDirectoryHeader()} methods, depending on the provided tag.
   *
   * @param tag The data type.
   * @return The current instance.
   * @throws UnsupportedOperationException If the Get Data command with the provided tag is not
   *     supported.
   * @throws IllegalArgumentException If tag is null.
   * @since 1.0.0
   */
  T prepareGetData(GetDataTag tag);

  /**
   * Schedules the execution of one or more "Put Data" command to inject the provided data
   * associated with the provided data type.
   *
   * @param tag The data type.
   * @param data The data to inject.
   * @return The current instance.
   * @throws UnsupportedOperationException If the Put Data command with the provided tag is not
   *     supported.
   * @throws IllegalArgumentException If tag is null or data is empty.
   * @since 2.1.0
   */
  T preparePutData(PutDataTag tag, byte[] data);

  /**
   * Schedules the execution of a "Read Records" command to read a single record from the indicated
   * EF.
   *
   * <p>Data will be available in {@link CalypsoCard} using the dedicated file and data management
   * methods.
   *
   * <p>Depending on whether we are inside a secure session, there are two types of behavior
   * following this command:
   *
   * <ul>
   *   <li>Outside a secure session (best effort mode): the following "process" command will not
   *       fail whatever the existence of the targeted file or record (the {@link CalypsoCard}
   *       object may not be filled).
   *   <li>Inside a secure session in contactless mode (strict mode): the following "process"
   *       command will fail if the targeted file or record does not exist (the {@link CalypsoCard}
   *       object is always filled or an exception is raised when the reading failed).
   * </ul>
   *
   * <p><b>This method should not be used inside a secure session in contact mode</b> because
   * additional exchanges with the card will be operated and will corrupt the security of the
   * session. Instead, use the method {@link #prepareReadRecords(byte, int, int, int)} for this case
   * and provide valid parameters.
   *
   * @param sfi The SFI of the EF to read.
   * @param recordNumber The record to read.
   * @return The current instance.
   * @throws IllegalArgumentException If one of the provided arguments is out of range.
   * @throws IllegalStateException If this method is called inside a secure session in contact mode.
   * @since 1.1.0
   */
  T prepareReadRecord(byte sfi, int recordNumber);

  /**
   * Schedules the execution of a "Read Records" command to read one or more records from the
   * indicated EF.
   *
   * <p>Data will be available in {@link CalypsoCard} using the dedicated file and data management
   * methods.
   *
   * <p>Depending on whether we are inside a secure session, there are two types of behavior
   * following this command:
   *
   * <ul>
   *   <li>Outside a secure session (best effort mode): the following "process" command will not
   *       fail whatever the existence of the targeted file or record (the {@link CalypsoCard}
   *       object may not be filled).
   *   <li>Inside a secure session (strict mode): the following "process" command will fail if the
   *       targeted file or record does not exist (the {@link CalypsoCard} object is always filled
   *       or an exception is raised when the reading failed).<br>
   *       Invalid parameters could lead to additional exchanges with the card and thus corrupt the
   *       security of the session.
   * </ul>
   *
   * @param sfi The SFI of the EF.
   * @param fromRecordNumber The number of the first record to read.
   * @param toRecordNumber The number of the last record to read.
   * @param recordSize The record length.
   * @return The current instance.
   * @throws IllegalArgumentException If one of the provided argument is out of range.
   * @since 1.1.0
   */
  T prepareReadRecords(byte sfi, int fromRecordNumber, int toRecordNumber, int recordSize);

  /**
   * Schedules the execution of one or multiple "Read Record Multiple" commands to read all or parts
   * of multiple records of the indicated EF.
   *
   * <p>Data will be available in {@link CalypsoCard} using the dedicated file and data management
   * methods.
   *
   * <p>Depending on whether we are inside a secure session, there are two types of behavior
   * following this command:
   *
   * <ul>
   *   <li>Outside a secure session (best effort mode): the following "process" command will not
   *       fail whatever the existence of the targeted file or the validity of the offset and number
   *       of bytes to read (the {@link CalypsoCard} object may not be filled).
   *   <li>Inside a secure session (strict mode): the following "process" command will fail if the
   *       targeted file does not exist or if the offset and number of bytes to read are not valid
   *       (the {@link CalypsoCard} object is always filled or an exception is raised when the
   *       reading failed).<br>
   *       Invalid parameters could lead to additional exchanges with the card and thus corrupt the
   *       security of the session.
   * </ul>
   *
   * @param sfi The SFI of the EF.
   * @param fromRecordNumber The number of the first record to read.
   * @param toRecordNumber The number of the last record to read.
   * @param offset The offset in the records where to start reading (0 indicates the first byte).
   * @param nbBytesToRead The number of bytes to read from each record.
   * @return The current instance.
   * @throws UnsupportedOperationException If this command is not supported by this card.
   * @throws IllegalArgumentException If one of the provided argument is out of range.
   * @since 1.1.0
   */
  T prepareReadRecordsPartially(
      byte sfi, int fromRecordNumber, int toRecordNumber, int offset, int nbBytesToRead);

  /**
   * Schedules the execution of one or multiple "Read Binary" commands to read all or part of the
   * indicated "binary" EF.
   *
   * <p>Data will be available in {@link CalypsoCard} using the dedicated file and data management
   * methods.
   *
   * <p>Depending on whether we are inside a secure session, there are two types of behavior
   * following this command:
   *
   * <ul>
   *   <li>Outside a secure session (best effort mode): the following "process" command will not
   *       fail whatever the existence of the targeted file or the validity of the offset and number
   *       of bytes to read (the {@link CalypsoCard} object may not be filled).
   *   <li>Inside a secure session (strict mode): the following "process" command will fail if the
   *       targeted file does not exist or if the offset and number of bytes to read are not valid
   *       (the {@link CalypsoCard} object is always filled or an exception is raised when the
   *       reading failed).<br>
   *       Invalid parameters could lead to additional exchanges with the card and thus corrupt the
   *       security of the session.
   * </ul>
   *
   * @param sfi The SFI of the EF.
   * @param offset The offset (0 indicates the first byte).
   * @param nbBytesToRead The number of bytes to read.
   * @return The current instance.
   * @throws UnsupportedOperationException If this command is not supported by this card.
   * @throws IllegalArgumentException If one of the provided argument is out of range.
   * @since 1.1.0
   */
  T prepareReadBinary(byte sfi, int offset, int nbBytesToRead);

  /**
   * Schedules the execution of a "Read Records" command to reads a record of the indicated EF,
   * which should be a "counter" file.
   *
   * <p>The record will be read up to the counter location indicated in parameter.<br>
   * Thus, all previous counters will also be read.
   *
   * <p>Data will be available in {@link CalypsoCard} using the dedicated file and data management
   * methods.
   *
   * <p>Depending on whether we are inside a secure session, there are two types of behavior
   * following this command:
   *
   * <ul>
   *   <li>Outside a secure session (best effort mode): the following "process" command will not
   *       fail whatever the existence of the targeted file or counter (the {@link CalypsoCard}
   *       object may not be filled).
   *   <li>Inside a secure session (strict mode): the following "process" command will fail if the
   *       targeted file or counter does not exist (the {@link CalypsoCard} object is always filled
   *       or an exception is raised when the reading failed).<br>
   *       Invalid parameters could lead to additional exchanges with the card and thus corrupt the
   *       security of the session.
   * </ul>
   *
   * @param sfi The SFI of the EF.
   * @param nbCountersToRead The number of counters to read.
   * @return The current instance.
   * @throws IllegalArgumentException If one of the provided argument is out of range.
   * @since 1.1.0
   */
  T prepareReadCounter(byte sfi, int nbCountersToRead);

  /**
   * Schedules the execution of a "Search Record Multiple" command to search data in the records of
   * the indicated EF, from a given record to the last record of the file. It will return the list
   * of record numbers containing these data, and if requested it will read the first record
   * content.
   *
   * <p>The command is only possible with a "linear", "cyclic", Counters or Simulated "counter" EF.
   *
   * <p>The command searches if the given data are present in the records of the file. During the
   * search, an optional mask is applied. The mask allows to specify precisely the bits to be taken
   * into account in the comparison.
   *
   * <p>See {@link SearchCommandData} class for a description of the parameters.
   *
   * <p>Once this command is processed, the result is available in the provided input/output {@link
   * SearchCommandData} object, and the content of the first matching record in {@link CalypsoCard}
   * if requested.
   *
   * <p>Depending on whether we are inside a secure session, there are two types of behavior
   * following this command:
   *
   * <ul>
   *   <li>Outside a secure session (best effort mode): the following "process" command will not
   *       fail whatever the existence of the targeted file or the validity of the record number and
   *       offset (the {@link SearchCommandData} and {@link CalypsoCard} objects may not be
   *       updated).
   *   <li>Inside a secure session (strict mode): the following "process" command will fail if the
   *       targeted file does not exist or if the record number and the offset are not valid (the
   *       {@link SearchCommandData} and {@link CalypsoCard} objects are always filled or an
   *       exception is raised when the reading failed).
   * </ul>
   *
   * @param data The input/output data containing the parameters of the command.
   * @return The current instance.
   * @throws UnsupportedOperationException If the "Search Record Multiple" command is not available
   *     for this card.
   * @throws IllegalArgumentException If the input data is inconsistent.
   * @see SearchCommandData
   * @since 1.1.0
   */
  T prepareSearchRecords(SearchCommandData data);

  /**
   * Schedules the execution of a "Verify Pin" command without PIN presentation in order to get the
   * attempt counter.
   *
   * <p>The PIN status will be available in {@link CalypsoCard} using the {@link
   * CalypsoCard#getPinAttemptRemaining()} and {@link CalypsoCard#isPinBlocked()} methods.
   *
   * @return The current instance.
   * @throws UnsupportedOperationException If the PIN feature is not available for this card.
   * @since 1.0.0
   */
  T prepareCheckPinStatus();

  /**
   * Schedules the execution of an "Append Record" command to adds the data provided in the
   * indicated "cyclic" file.
   *
   * <p>A new record is added, the oldest record is deleted.
   *
   * <p>Data will be available in {@link CalypsoCard} using the dedicated file and data management
   * methods.
   *
   * @param sfi The sfi to select.
   * @param recordData The new record data to write.
   * @return The current instance.
   * @throws IllegalArgumentException If one of the provided argument is out of range.
   * @throws SessionBufferOverflowException If the command will overflow the modifications buffer
   *     size and the multiple session is not allowed.
   * @since 1.0.0
   */
  T prepareAppendRecord(byte sfi, byte[] recordData);

  /**
   * Schedules the execution of an "Update Record" command to overwrites the target file's record
   * contents with the provided data.
   *
   * <p>If the input data is shorter than the record size, only the first bytes will be overwritten.
   *
   * <p>Data will be available in {@link CalypsoCard} using the dedicated file and data management
   * methods.
   *
   * @param sfi The sfi to select.
   * @param recordNumber The record to update.
   * @param recordData The new record data. If length {@code <} RecSize, bytes beyond length are.
   *     left unchanged.
   * @return The current instance.
   * @throws IllegalArgumentException If one of the provided argument is out of range.
   * @throws SessionBufferOverflowException If the command will overflow the modifications buffer
   *     size and the multiple session is not allowed.
   * @since 1.0.0
   */
  T prepareUpdateRecord(byte sfi, int recordNumber, byte[] recordData);

  /**
   * Schedules the execution of a "Write Record" command to updates the target file's record
   * contents with the result of a binary OR between the existing data and the provided data.
   *
   * <p>If the input data is shorter than the record size, only the first bytes will be overwritten.
   *
   * <p>Data will be available in {@link CalypsoCard} using the dedicated file and data management
   * methods.
   *
   * @param sfi The sfi to select.
   * @param recordNumber The record to write.
   * @param recordData The data to overwrite in the record. If length {@code <} RecSize, bytes.
   *     beyond length are left unchanged.
   * @return The current instance.
   * @throws IllegalArgumentException If one of the provided argument is out of range.
   * @throws SessionBufferOverflowException If the command will overflow the modifications buffer
   *     size and the multiple session is not allowed.
   * @since 1.0.0
   */
  T prepareWriteRecord(byte sfi, int recordNumber, byte[] recordData);

  /**
   * Schedules the execution of one or multiple "Update Binary" command to replace the indicated
   * data of a "binary" file with the new data given from the indicated offset.
   *
   * <p>The data of the file before the offset and after the data given are left unchanged.
   *
   * <p>Data will be available in {@link CalypsoCard} using the dedicated file and data management
   * methods.
   *
   * @param sfi The SFI of the EF to select.
   * @param offset The offset (0 indicates the first byte).
   * @param data The new data.
   * @return The current instance.
   * @throws UnsupportedOperationException If this command is not supported by this card.
   * @throws IllegalArgumentException If one of the provided argument is out of range.
   * @throws SessionBufferOverflowException If the command will overflow the modifications buffer
   *     size and the multiple session is not allowed.
   * @since 1.1.0
   */
  T prepareUpdateBinary(byte sfi, int offset, byte[] data);

  /**
   * Schedules the execution of one or multiple "Write Binary" commands to write over the indicated
   * data of a "binary" file. The new data will be the result of a binary OR operation between the
   * existing data and the data given in the command from the indicated offset.
   *
   * <p>The data of the file before the offset and after the data given are left unchanged.
   *
   * <p>Data will be available in {@link CalypsoCard} using the dedicated file and data management
   * methods.
   *
   * @param sfi The SFI of the EF to select.
   * @param offset The offset (0 indicates the first byte).
   * @param data The data to write over the existing data.
   * @return The current instance.
   * @throws UnsupportedOperationException If this command is not supported by this card.
   * @throws IllegalArgumentException If one of the provided argument is out of range.
   * @throws SessionBufferOverflowException If the command will overflow the modifications buffer
   *     size and the multiple session is not allowed.
   * @since 1.1.0
   */
  T prepareWriteBinary(byte sfi, int offset, byte[] data);

  /**
   * Schedules the execution of an "Increase" command to increase the target counter.
   *
   * <p>If several counters of the same file have to be incremented at the same time of the
   * transaction, it is recommended to use the method {@link #prepareIncreaseCounters(byte, Map)}
   * for optimization reasons.
   *
   * <p>Data will be available in {@link CalypsoCard} using the dedicated file and data management
   * methods.
   *
   * @param sfi SFI of the EF to select.
   * @param counterNumber The number of the counter (must be zero in case of a simulated counter).
   * @param incValue Value to add to the counter (defined as a positive int {@code <=} 16777215
   *     [FFFFFFh])
   * @return The current instance.
   * @throws IllegalArgumentException If one of the provided argument is out of range.
   * @throws SessionBufferOverflowException If the command will overflow the modifications buffer
   *     size and the multiple session is not allowed.
   * @since 1.0.0
   */
  T prepareIncreaseCounter(byte sfi, int counterNumber, int incValue);

  /**
   * Schedules the execution of an "Increase Multiple" command or multiple "Increase" commands to
   * increase multiple target counters at the same time.
   *
   * <p>The decision to execute one or the other command is made according to the type of card.
   *
   * <p>Data will be available in {@link CalypsoCard} using the dedicated file and data management
   * methods.
   *
   * @param sfi SFI of the EF to select.
   * @param counterNumberToIncValueMap The map containing the counter numbers to be incremented and
   *     their associated increment values.
   * @return The current instance.
   * @throws IllegalArgumentException If one of the provided argument is out of range or if the map
   *     is null or empty.
   * @throws SessionBufferOverflowException If the command will overflow the modifications buffer
   *     size and the multiple session is not allowed.
   * @since 1.1.0
   */
  T prepareIncreaseCounters(byte sfi, Map<Integer, Integer> counterNumberToIncValueMap);

  /**
   * Schedules the execution of a "Decrease" command to decrease the target counter.
   *
   * <p>If several counters of the same file have to be decremented at the same time of the
   * transaction, it is recommended to use the method {@link #prepareDecreaseCounters(byte, Map)}
   * for optimization reasons.
   *
   * <p>Data will be available in {@link CalypsoCard} using the dedicated file and data management
   * methods.
   *
   * @param sfi SFI of the EF to select.
   * @param counterNumber The number of the counter (must be zero in case of a simulated counter).
   * @param decValue Value to subtract to the counter (defined as a positive int {@code <=} 16777215
   *     [FFFFFFh])
   * @return The current instance.
   * @throws IllegalArgumentException If one of the provided argument is out of range.
   * @throws SessionBufferOverflowException If the command will overflow the modifications buffer
   *     size and the multiple session is not allowed.
   * @since 1.0.0
   */
  T prepareDecreaseCounter(byte sfi, int counterNumber, int decValue);

  /**
   * Schedules the execution of a "Decrease Multiple" command or multiple "Decrease" commands to
   * decrease multiple target counters at the same time.
   *
   * <p>The decision to execute one or the other command is made according to the type of card.
   *
   * <p>Data will be available in {@link CalypsoCard} using the dedicated file and data management
   * methods.
   *
   * @param sfi SFI of the EF to select.
   * @param counterNumberToDecValueMap The map containing the counter numbers to be decremented and
   *     their associated decrement values.
   * @return The current instance.
   * @throws IllegalArgumentException If one of the provided argument is out of range or if the map
   *     is null or empty.
   * @throws SessionBufferOverflowException If the command will overflow the modifications buffer
   *     size and the multiple session is not allowed.
   * @since 1.1.0
   */
  T prepareDecreaseCounters(byte sfi, Map<Integer, Integer> counterNumberToDecValueMap);

  /**
   * Schedules the execution of an "Increase" or "Decrease" command to set the value of the target
   * counter.
   *
   * <p>The operation (Increase or Decrease) is selected according to whether the difference between
   * the current value and the desired value is negative (Increase) or positive (Decrease).
   *
   * <p>Data will be available in {@link CalypsoCard} using the dedicated file and data management
   * methods.
   *
   * <p>Note: it is assumed here that:<br>
   *
   * <ul>
   *   <li>the counter value has been read before,
   *   <li>the type of session (and associated access rights) is consistent with the requested
   *       operation: reload session if the counter is to be incremented, debit if it is to be
   *       decremented.<br>
   *       No control is performed on this point by this method; the closing of the session will
   *       determine the success of the operation..
   * </ul>
   *
   * @param counterNumber {@code >=} 1: Counters file, number of the counter. 0: Simulated "counter"
   *     file.
   * @param sfi SFI of the EF to select.
   * @param newValue The desired value for the counter (defined as a positive int {@code <=}
   *     16777215 [FFFFFFh])
   * @return The current instance.
   * @throws IllegalArgumentException If one of the provided argument is out of range.
   * @throws IllegalStateException If the current counter value is unknown.
   * @throws SessionBufferOverflowException If the command will overflow the modifications buffer
   *     size and the multiple session is not allowed.
   * @since 1.0.0
   */
  T prepareSetCounter(byte sfi, int counterNumber, int newValue);

  /**
   * Schedules the execution of "Read Records" commands to read all SV logs.
   *
   * <p>Note: this method requires that the selected application is of type Store Value (file
   * structure 20h).
   *
   * <p>The SV transaction logs are contained in two files with fixed identifiers:
   *
   * <ul>
   *   <li>The file whose SFI is 14h contains 1 record containing the unique reload log.
   *   <li>The file whose SFI is 15h contains 3 records containing the last three debit logs.
   * </ul>
   *
   * <p>Data will be available in {@link CalypsoCard} in raw format using the dedicated file and
   * data management methods or in the form of dedicated objects using the {@link
   * CalypsoCard#getSvLoadLogRecord()} and {@link CalypsoCard#getSvDebitLogAllRecords()} methods.
   *
   * @return The current instance.
   * @throws UnsupportedOperationException If the SV feature is not available for this card.
   * @since 1.0.0
   */
  T prepareSvReadAllLogs();

  /**
   * Schedules the execution of a "Verify PIN" command in order to authenticate the cardholder
   * and/or unlock access to certain card files.
   *
   * <p>This command can be performed both in and out of a secure session. The PIN code can be
   * transmitted in plain text or encrypted according to the parameter set in {@link
   * SymmetricCryptoSecuritySetting}.
   *
   * <p>The PIN status will be available in {@link CalypsoCard} using the {@link
   * CalypsoCard#getPinAttemptRemaining()} and {@link CalypsoCard#isPinBlocked()} methods.
   *
   * @param pin The PIN code value (4-byte long byte array).
   * @return The current instance.
   * @throws UnsupportedOperationException If the PIN feature is not available for this card.
   * @throws IllegalArgumentException If the provided argument is out of range.
   * @since 1.6.0
   */
  T prepareVerifyPin(byte[] pin);

  /**
   * Schedules the execution of a "Change PIN" command to replace the current PIN with the new value
   * provided.
   *
   * <p>This command can be performed only out of a secure session. The new PIN code can be
   * transmitted in plain text or encrypted according to the parameter set in {@link
   * SymmetricCryptoSecuritySetting}.
   *
   * <p>When the PIN is transmitted plain, this command must be preceded by a successful Verify PIN
   * command (see {@link #prepareVerifyPin(byte[])}).
   *
   * <p>The PIN status will be available in {@link CalypsoCard} using the {@link
   * CalypsoCard#getPinAttemptRemaining()} and {@link CalypsoCard#isPinBlocked()} methods.
   *
   * @param newPin The new PIN code value (4-byte long byte array).
   * @return The current instance.
   * @throws UnsupportedOperationException If the PIN feature is not available for this card.
   * @throws IllegalArgumentException If the provided argument is out of range.
   * @throws IllegalStateException If the command is executed while a secure session is open.
   * @since 1.6.0
   */
  T prepareChangePin(byte[] newPin);

  /**
   * Schedules the execution of a "Generate Asymmetric Key Pair" command.
   *
   * <p>After the execution, the generated key pair will be stored internally into the card. The
   * public part can be retrieved via {@link #prepareGetData(GetDataTag)}.
   *
   * @return The current instance.
   * @since 2.1.0
   */
  T prepareGenerateAsymmetricKeyPair();

  /**
   * Processes all previously prepared commands and closes the physical channel if requested.
   *
   * <p>All APDUs corresponding to the prepared commands are sent to the card, their responses are
   * retrieved and used to update the {@link CalypsoCard} associated with the transaction.
   *
   * <p>For write commands, the {@link CalypsoCard} is updated only when the command is successful.
   *
   * <p>The process is interrupted at the first failed command.
   *
   * @param channelControl Policy for managing the physical channel after executing commands to the
   *     card.
   * @return The current instance.
   * @throws ReaderIOException If a communication error with the card reader or the cryptographic
   *     module reader occurs.
   * @throws CardIOException If a communication error with the card occurs.
   * @throws CryptoIOException If a communication error with the cryptographic module occurs.
   * @throws CryptoException If an error with the cryptographic module occurs.
   * @throws UnexpectedCommandStatusException If a command returns an unexpected status.
   * @throws InconsistentDataException If inconsistent data have been detected.
   * @throws UnauthorizedKeyException If the card requires an unauthorized session key.
   * @throws CardSignatureNotVerifiableException If a secure session is open and multiple session
   *     mode is enabled and an intermediate session is correctly closed but the cryptographic
   *     module is no longer available to verify the card MAC.
   * @throws InvalidCardSignatureException If the card signature is incorrect. In the case of a card
   *     transaction secured by "symmetrical" cryptography (e.g. SAM), this indicates that the card
   *     has correctly closed the secure session, but the card session is not authentic because the
   *     MAC of the card is incorrect.
   * @throws SelectFileException If a "Select File" prepared card command indicated that the file
   *     was not found.
   * @since 1.6.0
   */
  T processCommands(ChannelControl channelControl);

  /**
   * Returns the audit data of the transaction containing all APDU exchanges with the card and the
   * cryptographic module.
   *
   * @return An empty list if there is no audit data.
   * @since 1.2.0
   */
  List<byte[]> getTransactionAuditData();
}
