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

import org.eclipse.keypop.calypso.card.WriteAccessLevel;
import org.eclipse.keypop.calypso.card.card.CalypsoCard;
import org.eclipse.keypop.calypso.card.card.CalypsoCardSelectionExtension;

/**
 * Contains operations common to all card transactions secured by "symmetric" key cryptographic
 * algorithms.
 *
 * <p>See {@link SecureTransactionManager} parent interface for more information and details of
 * available card operations.
 *
 * @param <T> The type of the lowest level child object.
 * @since 2.0.0
 */
public interface SecureSymmetricCryptoTransactionManager<
        T extends SecureSymmetricCryptoTransactionManager<T>>
    extends SecureTransactionManager<T> {

  /**
   * Schedules the execution of an "Open Secure Session" command.
   *
   * <p>The secure session will be opened with the provided {@link WriteAccessLevel} depending on
   * whether it is a personalization, reload or debit transaction profile.
   *
   * <p>Note that if the next prepared command is a "Read One Record" or "Read One Or More
   * Counters", then it will by default be merged with the "Open Secure Session" command for
   * optimization purposes except if the "pre-open" mode is active.
   *
   * <p>This mechanism may in some cases be incompatible with the security constraints and can be
   * disabled via the {@link SymmetricCryptoSecuritySetting#disableReadOnSessionOpening()} method.
   *
   * @param writeAccessLevel The write access level to be used.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided argument is null.
   * @throws IllegalStateException In the following cases:
   *     <ul>
   *       <li>No {@link SymmetricCryptoSecuritySetting} is available
   *       <li>A secure session opening is already prepared
   *       <li>A secure session is already opened
   *     </ul>
   *
   * @see CalypsoCardSelectionExtension#preparePreOpenSecureSession(WriteAccessLevel)
   * @since 1.6.0
   */
  T prepareOpenSecureSession(WriteAccessLevel writeAccessLevel);

  /**
   * Schedules the execution of a "SV Get" command to prepare an SV operation or simply retrieves
   * the current SV status.
   *
   * <p>Data will be available in {@link CalypsoCard} using the dedicated SV data management
   * methods.
   *
   * @param svOperation Informs about the nature of the intended operation: debit or reload.
   * @param svAction The type of action: DO a debit or a positive reload, UNDO an undebit or a
   *     negative reload.
   * @return The current instance.
   * @throws UnsupportedOperationException If the SV feature is not available for this card.
   * @throws IllegalArgumentException If one of the arguments is null.
   * @since 1.0.0
   */
  T prepareSvGet(SvOperation svOperation, SvAction svAction);

  /**
   * Schedules the execution of a "SV Reload" command to increase the current SV balance and using
   * the provided additional data.
   *
   * <p>Data will be available in {@link CalypsoCard} using the dedicated SV data management
   * methods.
   *
   * <p>Note: the key used is the reload key.
   *
   * @param amount The value to be reloaded, positive or negative integer in the range.
   *     -8388608..8388607
   * @param date 2-byte free value.
   * @param time 2-byte free value.
   * @param free 2-byte free value.
   * @return The current instance.
   * @throws IllegalArgumentException If one of the provided argument is out of range.
   * @throws IllegalStateException In one of the following cases:
   *     <ul>
   *       <li>Another SV command was already prepared inside the same secure session.
   *       <li>The SV command is not placed in the first position in the list of prepared commands.
   *       <li>The SV command does not follow a "SV Get" command.
   *       <li>The command and the SV operation are not consistent.
   *     </ul>
   *
   * @throws SessionBufferOverflowException If the command will overflow the modifications buffer
   *     size and the multiple session is not allowed.
   * @since 1.0.0
   */
  T prepareSvReload(int amount, byte[] date, byte[] time, byte[] free);

  /**
   * Schedules the execution of a "SV Reload" command to increase the current SV balance.
   *
   * <p>Data will be available in {@link CalypsoCard} using the dedicated SV data management
   * methods.
   *
   * <p>Note 1: the optional SV additional data are set to zero.
   *
   * <p>Note 2: the key used is the reload key.
   *
   * @param amount The value to be reloaded, positive integer in the range 0..8388607 for a DO.
   *     action, in the range 0..8388608 for an UNDO action.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided argument is out of range.
   * @throws IllegalStateException In one of the following cases:
   *     <ul>
   *       <li>Another SV command was already prepared inside the same secure session.
   *       <li>The SV command is not placed in the first position in the list of prepared commands.
   *       <li>The SV command does not follow a "SV Get" command.
   *       <li>The command and the SV operation are not consistent.
   *     </ul>
   *
   * @throws SessionBufferOverflowException If the command will overflow the modifications buffer
   *     size and the multiple session is not allowed.
   * @since 1.0.0
   */
  T prepareSvReload(int amount);

  /**
   * Schedules the execution of a "SV Debit" or "SV Undebit" command to increase the current SV
   * balance or to partially or totally cancels the last SV debit command and using the provided
   * additional data.
   *
   * <p>It consists in decreasing the current balance of the SV by a certain amount or canceling a
   * previous debit according to the type operation chosen in when invoking the previous SV Get
   * command.
   *
   * <p>Data will be available in {@link CalypsoCard} using the dedicated SV data management
   * methods.
   *
   * <p>Note 1: the key used is the debit key
   *
   * @param amount The amount to be subtracted or added, positive integer in the range 0..32767 when
   *     subtracted and 0..32768 when added.
   * @param date 2-byte free value.
   * @param time 2-byte free value.
   * @return The current instance.
   * @throws IllegalArgumentException If one of the provided argument is out of range.
   * @throws IllegalStateException In one of the following cases:
   *     <ul>
   *       <li>New value is negative and negative balances are not allowed.
   *       <li>Another SV command was already prepared inside the same secure session.
   *       <li>The SV command is not placed in the first position in the list of prepared commands.
   *       <li>The SV command does not follow a "SV Get" command.
   *       <li>The command and the SV operation are not consistent.
   *     </ul>
   *
   * @throws SessionBufferOverflowException If the command will overflow the modifications buffer
   *     size and the multiple session is not allowed.
   * @since 1.0.0
   */
  T prepareSvDebit(int amount, byte[] date, byte[] time);

  /**
   * Schedules the execution of a "SV Debit" or "SV Undebit" command to increase the current SV
   * balance or to partially or totally cancels the last SV debit command.
   *
   * <p>It consists in decreasing the current balance of the SV by a certain amount or canceling a
   * previous debit.
   *
   * <p>Data will be available in {@link CalypsoCard} using the dedicated SV data management
   * methods.
   *
   * <p>Note 1: the optional SV additional data are set to zero.
   *
   * <p>Note 2: the key used is the debit key.
   *
   * @param amount The amount to be subtracted or added, positive integer in the range 0..32767 when
   *     subtracted and 0..32768 when added.
   * @return The current instance.
   * @throws IllegalArgumentException If one of the provided argument is out of range.
   * @throws IllegalStateException In one of the following cases:
   *     <ul>
   *       <li>New value is negative and negative balances are not allowed.
   *       <li>Another SV command was already prepared inside the same secure session.
   *       <li>The SV command is not placed in the first position in the list of prepared commands.
   *       <li>The SV command does not follow a "SV Get" command.
   *       <li>The command and the SV operation are not consistent.
   *     </ul>
   *
   * @throws SessionBufferOverflowException If the command will overflow the modifications buffer
   *     size and the multiple session is not allowed.
   * @since 1.0.0
   */
  T prepareSvDebit(int amount);

  /**
   * Schedules the execution of an "Invalidate" command.
   *
   * <p>This command is usually executed within a secure session with the DEBIT key (depends on the
   * access rights given to this command in the file structure of the card).
   *
   * <p>The DF status will be available in {@link CalypsoCard} using the {@link
   * CalypsoCard#isDfInvalidated()} method.
   *
   * @throws IllegalStateException If the card is already invalidated.
   * @throws SessionBufferOverflowException If the command will overflow the modifications buffer
   *     size and the multiple session is not allowed.
   * @return The current instance.
   * @since 1.0.0
   */
  T prepareInvalidate();

  /**
   * Schedules the execution of a "Rehabilitate" command.
   *
   * <p>This command is usually executed within a secure session with the PERSONALIZATION key
   * (depends on the access rights given to this command in the file structure of the card).
   *
   * <p>The DF status will be available in {@link CalypsoCard} using the {@link
   * CalypsoCard#isDfInvalidated()} method.
   *
   * @return The current instance.
   * @throws IllegalStateException If the card is not invalidated.
   * @throws SessionBufferOverflowException If the command will overflow the modifications buffer
   *     size and the multiple session is not allowed.
   * @since 1.0.0
   */
  T prepareRehabilitate();

  /**
   * Schedules the execution of "Change Key" command to replace one of the current card keys with
   * another key present in the cryptographic module.
   *
   * <p>This command can be performed only out of a secure session.
   *
   * <p>The change key process transfers the key from the cryptographic module to the card. The new
   * key is diversified by the cryptographic module from a primary key and encrypted using the
   * indicated issuer key to secure the transfer to the card. All provided KIFs and KVCs must be
   * present in the cryptographic module.
   *
   * @param keyIndex The index of the key to be replaced (1 for the issuer key, 2 for the load key,
   *     3 for the debit key).
   * @param newKif The KIF of the new key.
   * @param newKvc The KVC of the new key.
   * @param issuerKif The KIF of the current card's issuer key.
   * @param issuerKvc The KVC of the current card's issuer key.
   * @return The current instance.
   * @throws UnsupportedOperationException If the Change Key command is not available for this card.
   * @throws IllegalArgumentException If the provided key index is out of range.
   * @throws IllegalStateException If the command is executed while a secure session is open.
   * @since 1.6.0
   */
  T prepareChangeKey(int keyIndex, byte newKif, byte newKvc, byte issuerKif, byte issuerKvc);
}
