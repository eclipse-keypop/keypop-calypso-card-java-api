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

import org.eclipse.keypop.calypso.card.CalypsoCardApiFactory;
import org.eclipse.keypop.calypso.card.WriteAccessLevel;
import org.eclipse.keypop.calypso.card.transaction.spi.SymmetricCryptoCardTransactionManagerFactory;

/**
 * Security setting for a Calypso card transaction secured by "symmetric" key cryptographic
 * algorithms (e.g. SAM).
 *
 * <p>An instance of this interface can be obtained via the method {@link
 * CalypsoCardApiFactory#createSymmetricCryptoSecuritySetting(SymmetricCryptoCardTransactionManagerFactory)}.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#type_SymmetricCryptoSecuritySetting">SymmetricCryptoSecuritySetting</a>
 * for the normative contract.
 *
 * @since 2.0.0
 */
public interface SymmetricCryptoSecuritySetting {

  /**
   * Enables multiple session mode to allow more changes to the card than the session buffer can
   * handle.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SymmetricCryptoSecuritySetting_enableMultipleSession">SymmetricCryptoSecuritySetting.enableMultipleSession</a>
   * for the normative contract.
   *
   * @return The current instance.
   * @since 1.0.0
   */
  SymmetricCryptoSecuritySetting enableMultipleSession();

  /**
   * Enables the ratification mechanism to handle the early removal of the card preventing the
   * terminal from receiving the acknowledgement of the session closing.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SymmetricCryptoSecuritySetting_enableRatificationMechanism">SymmetricCryptoSecuritySetting.enableRatificationMechanism</a>
   * for the normative contract.
   *
   * @return The current instance.
   * @since 1.0.0
   */
  SymmetricCryptoSecuritySetting enableRatificationMechanism();

  /**
   * Enables the PIN transmission in plain text.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SymmetricCryptoSecuritySetting_enablePinPlainTransmission">SymmetricCryptoSecuritySetting.enablePinPlainTransmission</a>
   * for the normative contract.
   *
   * @return The current instance.
   * @since 1.0.0
   */
  SymmetricCryptoSecuritySetting enablePinPlainTransmission();

  /**
   * Enables the retrieval of both loading and debit log records.
   *
   * <p>The default value is false.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SymmetricCryptoSecuritySetting_enableSvLoadAndDebitLog">SymmetricCryptoSecuritySetting.enableSvLoadAndDebitLog</a>
   * for the normative contract.
   *
   * @return The current instance.
   * @since 1.0.0
   */
  SymmetricCryptoSecuritySetting enableSvLoadAndDebitLog();

  /**
   * Allows the SV balance to become negative.
   *
   * <p>The default value is false.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SymmetricCryptoSecuritySetting_authorizeSvNegativeBalance">SymmetricCryptoSecuritySetting.authorizeSvNegativeBalance</a>
   * for the normative contract.
   *
   * @return The current instance.
   * @since 1.0.0
   */
  SymmetricCryptoSecuritySetting authorizeSvNegativeBalance();

  /**
   * Disables the automatic merging of the "Open Secure Session" command with a possible "Read
   * Record" command.
   *
   * <p>By default, this optimization is performed when the command that follows the session opening
   * is a "Read Record" command.
   *
   * <p>This mechanism may in some cases be incompatible with the security requirements.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SymmetricCryptoSecuritySetting_disableReadOnSessionOpening">SymmetricCryptoSecuritySetting.disableReadOnSessionOpening</a>
   * for the normative contract.
   *
   * @return The current instance.
   * @since 1.6.0
   */
  SymmetricCryptoSecuritySetting disableReadOnSessionOpening();

  /**
   * Defines for a given write access level the KIF value to use for cards that only provide KVC.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SymmetricCryptoSecuritySetting_assignKif">SymmetricCryptoSecuritySetting.assignKif</a>
   * for the normative contract.
   *
   * @param writeAccessLevel The write access level.
   * @param kvc The card's KVC value.
   * @param kif The KIF value to use.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided writeAccessLevel is null.
   * @since 1.0.0
   */
  SymmetricCryptoSecuritySetting assignKif(WriteAccessLevel writeAccessLevel, byte kvc, byte kif);

  /**
   * Defines for a given write access level the default KIF value to use when it could not be
   * determined by any other means.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SymmetricCryptoSecuritySetting_assignDefaultKif">SymmetricCryptoSecuritySetting.assignDefaultKif</a>
   * for the normative contract.
   *
   * @param writeAccessLevel The write access level.
   * @param kif The KIF value to use.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided writeAccessLevel is null.
   * @since 1.0.0
   */
  SymmetricCryptoSecuritySetting assignDefaultKif(WriteAccessLevel writeAccessLevel, byte kif);

  /**
   * Defines for a given write access level the KVC value to use for cards that do not provide KVC.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SymmetricCryptoSecuritySetting_assignDefaultKvc">SymmetricCryptoSecuritySetting.assignDefaultKvc</a>
   * for the normative contract.
   *
   * @param writeAccessLevel The session level.
   * @param kvc The KVC to use.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided writeAccessLevel is null.
   * @since 1.0.0
   */
  SymmetricCryptoSecuritySetting assignDefaultKvc(WriteAccessLevel writeAccessLevel, byte kvc);

  /**
   * Adds an authorized session key defined by its KIF and KVC values.
   *
   * <p>By default, all keys are accepted. <br>
   * If at least one key is added using this method, then only authorized keys will be accepted.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SymmetricCryptoSecuritySetting_addAuthorizedSessionKey">SymmetricCryptoSecuritySetting.addAuthorizedSessionKey</a>
   * for the normative contract.
   *
   * @param kif The KIF value.
   * @param kvc The KVC value.
   * @return The current instance.
   * @since 1.0.0
   */
  SymmetricCryptoSecuritySetting addAuthorizedSessionKey(byte kif, byte kvc);

  /**
   * Adds an authorized Stored Value key defined by its KIF and KVC values.
   *
   * <p>By default, all keys are accepted. <br>
   * If at least one key is added using this method, then only authorized keys will be accepted.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SymmetricCryptoSecuritySetting_addAuthorizedSvKey">SymmetricCryptoSecuritySetting.addAuthorizedSvKey</a>
   * for the normative contract.
   *
   * @param kif The KIF value.
   * @param kvc The KVC value.
   * @return The current instance.
   * @since 1.0.0
   */
  SymmetricCryptoSecuritySetting addAuthorizedSvKey(byte kif, byte kvc);

  /**
   * Sets the KIF/KVC pair of the PIN verification ciphering key.
   *
   * <p>The default value for both KIF and KVC is 0.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SymmetricCryptoSecuritySetting_setPinVerificationCipheringKey">SymmetricCryptoSecuritySetting.setPinVerificationCipheringKey</a>
   * for the normative contract.
   *
   * @param kif The KIF value.
   * @param kvc The KVC value.
   * @return The current instance.
   * @since 1.0.0
   */
  SymmetricCryptoSecuritySetting setPinVerificationCipheringKey(byte kif, byte kvc);

  /**
   * Sets the KIF/KVC pair of the PIN modification ciphering key.
   *
   * <p>The default value for both KIF and KVC is 0.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SymmetricCryptoSecuritySetting_setPinModificationCipheringKey">SymmetricCryptoSecuritySetting.setPinModificationCipheringKey</a>
   * for the normative contract.
   *
   * @param kif The KIF value.
   * @param kvc The KVC value.
   * @return The current instance.
   * @since 1.0.0
   */
  SymmetricCryptoSecuritySetting setPinModificationCipheringKey(byte kif, byte kvc);

  /**
   * Prepares the cryptographic module for the next transaction by anticipating all security context
   * configuration operations.
   *
   * <p>This feature is only useful if the currently allocated cryptographic module will be used for
   * the next transaction. It is particularly relevant to optimize the transaction time in a
   * ticketing context of user card validation.
   *
   * <p>For this optimization to be effective, it is necessary to call this method at the very end
   * of the current transaction, i.e. <u>after</u> having notified the user of the access right
   * (e.g. after opening the gate).
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SymmetricCryptoSecuritySetting_initCryptoContextForNextTransaction">SymmetricCryptoSecuritySetting.initCryptoContextForNextTransaction</a>
   * for the normative contract.
   *
   * @throws CryptoException If an error occurred when computing a crypto operation.
   * @throws CryptoIOException If a communication error with the crypto module (e.g. timeout with
   *     the reader or the computing unit, network error, etc.).
   * @since 2.0.0
   */
  void initCryptoContextForNextTransaction();

  /**
   * Sets the maximum duration of an open secure session, in milliseconds, for cards whose CSN is
   * greater than or equal to the provided value, applied to every application DF.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SymmetricCryptoSecuritySetting_assignOpenSecureSessionMaxDuration_allDf">SymmetricCryptoSecuritySetting.assignOpenSecureSessionMaxDuration</a>
   * for the normative contract.
   *
   * @param csnMin The lowest card serial number the setting applies to.
   * @param maxDuration The maximum duration of an open secure session, in milliseconds.
   * @return The current instance.
   * @since 3.0.0
   */
  SymmetricCryptoSecuritySetting assignOpenSecureSessionMaxDuration(long csnMin, long maxDuration);

  /**
   * Sets the maximum duration of an open secure session, in milliseconds, for cards whose CSN is
   * greater than or equal to the provided value and whose application DF matches the provided name.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SymmetricCryptoSecuritySetting_assignOpenSecureSessionMaxDuration_byDf">SymmetricCryptoSecuritySetting.assignOpenSecureSessionMaxDuration</a>
   * for the normative contract.
   *
   * @param csnMin The lowest card serial number the setting applies to.
   * @param dfName The application DF name the setting applies to.
   * @param maxDuration The maximum duration of an open secure session, in milliseconds.
   * @return The current instance.
   * @since 3.0.0
   */
  SymmetricCryptoSecuritySetting assignOpenSecureSessionMaxDuration(
      long csnMin, byte[] dfName, long maxDuration);

  /**
   * Sets the maximum duration of a stored value operation, in milliseconds, for cards whose CSN is
   * greater than or equal to the provided value, applied to every application DF.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SymmetricCryptoSecuritySetting_assignSvOperationMaxDuration_allDf">SymmetricCryptoSecuritySetting.assignSvOperationMaxDuration</a>
   * for the normative contract.
   *
   * @param csnMin The lowest card serial number the setting applies to.
   * @param maxDuration The maximum duration of a stored value operation, in milliseconds.
   * @return The current instance.
   * @since 3.0.0
   */
  SymmetricCryptoSecuritySetting assignSvOperationMaxDuration(long csnMin, long maxDuration);

  /**
   * Sets the maximum duration of a stored value operation, in milliseconds, for cards whose CSN is
   * greater than or equal to the provided value and whose application DF matches the provided name.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_SymmetricCryptoSecuritySetting_assignSvOperationMaxDuration_byDf">SymmetricCryptoSecuritySetting.assignSvOperationMaxDuration</a>
   * for the normative contract.
   *
   * @param csnMin The lowest card serial number the setting applies to.
   * @param dfName The application DF name the setting applies to.
   * @param maxDuration The maximum duration of a stored value operation, in milliseconds.
   * @return The current instance.
   * @since 3.0.0
   */
  SymmetricCryptoSecuritySetting assignSvOperationMaxDuration(
      long csnMin, byte[] dfName, long maxDuration);
}
