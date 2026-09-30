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
package org.eclipse.keypop.calypso.card;

import org.eclipse.keypop.calypso.card.card.CalypsoCard;
import org.eclipse.keypop.calypso.card.card.CalypsoCardSelectionExtension;
import org.eclipse.keypop.calypso.card.transaction.*;
import org.eclipse.keypop.calypso.card.transaction.spi.AsymmetricCryptoCardTransactionManagerFactory;
import org.eclipse.keypop.calypso.card.transaction.spi.SymmetricCryptoCardTransactionManagerFactory;
import org.eclipse.keypop.reader.CardReader;

/**
 * Calypso Card API Factory.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#type_CalypsoCardApiFactory">CalypsoCardApiFactory</a>
 * for the normative contract.
 *
 * @since 2.0.0
 */
public interface CalypsoCardApiFactory {

  /**
   * Returns a new instance of {@link CalypsoCardSelectionExtension}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_CalypsoCardApiFactory_createCalypsoCardSelectionExtension">CalypsoCardApiFactory.createCalypsoCardSelectionExtension</a>
   * for the normative contract.
   *
   * @return A new instance of {@link CalypsoCardSelectionExtension}.
   * @since 2.0.0
   */
  CalypsoCardSelectionExtension createCalypsoCardSelectionExtension();

  /**
   * Returns a new instance of {@link SymmetricCryptoSecuritySetting}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_CalypsoCardApiFactory_createSymmetricCryptoSecuritySetting">CalypsoCardApiFactory.createSymmetricCryptoSecuritySetting</a>
   * for the normative contract.
   *
   * @param cryptoCardTransactionManagerFactory The factory of the crypto card transaction manager
   *     to be used.
   * @return A new instance of {@link SymmetricCryptoSecuritySetting}.
   * @throws IllegalArgumentException If the factory is null or invalid.
   * @since 2.0.0
   */
  SymmetricCryptoSecuritySetting createSymmetricCryptoSecuritySetting(
      SymmetricCryptoCardTransactionManagerFactory cryptoCardTransactionManagerFactory);

  /**
   * Returns a new instance of {@link AsymmetricCryptoSecuritySetting}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_CalypsoCardApiFactory_createAsymmetricCryptoSecuritySetting">CalypsoCardApiFactory.createAsymmetricCryptoSecuritySetting</a>
   * for the normative contract.
   *
   * @param cryptoCardTransactionManagerFactory The factory of the crypto card transaction manager
   *     to be used.
   * @return A new instance of {@link AsymmetricCryptoSecuritySetting}.
   * @throws IllegalArgumentException If the factory is null or invalid.
   * @since 2.1.0
   */
  AsymmetricCryptoSecuritySetting createAsymmetricCryptoSecuritySetting(
      AsymmetricCryptoCardTransactionManagerFactory cryptoCardTransactionManagerFactory);

  /**
   * Returns a new instance of {@link FreeTransactionManager}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_CalypsoCardApiFactory_createFreeTransactionManager">CalypsoCardApiFactory.createFreeTransactionManager</a>
   * for the normative contract.
   *
   * @param cardReader The card reader to be used.
   * @param card The selected card on which to operate the transaction.
   * @return A new instance of {@link FreeTransactionManager}.
   * @throws IllegalArgumentException If one of the parameters is null.
   * @since 2.0.0
   */
  FreeTransactionManager createFreeTransactionManager(CardReader cardReader, CalypsoCard card);

  /**
   * Returns a new instance of {@link SecureRegularModeTransactionManager}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_CalypsoCardApiFactory_createSecureRegularModeTransactionManager">CalypsoCardApiFactory.createSecureRegularModeTransactionManager</a>
   * for the normative contract.
   *
   * @param cardReader The card reader to be used.
   * @param card The selected card on which to operate the transaction.
   * @param securitySetting The security setting to be used.
   * @return A new instance of {@link SecureRegularModeTransactionManager}.
   * @throws IllegalArgumentException If one of the parameters is null.
   * @since 2.0.0
   */
  SecureRegularModeTransactionManager createSecureRegularModeTransactionManager(
      CardReader cardReader, CalypsoCard card, SymmetricCryptoSecuritySetting securitySetting);

  /**
   * Returns a new instance of {@link SecureExtendedModeTransactionManager}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_CalypsoCardApiFactory_createSecureExtendedModeTransactionManager">CalypsoCardApiFactory.createSecureExtendedModeTransactionManager</a>
   * for the normative contract.
   *
   * @param cardReader The card reader to be used.
   * @param card The selected card on which to operate the transaction.
   * @param securitySetting The security setting to be used.
   * @return A new instance of {@link SecureExtendedModeTransactionManager}.
   * @throws IllegalArgumentException If one of the parameters is null.
   * @since 2.0.0
   */
  SecureExtendedModeTransactionManager createSecureExtendedModeTransactionManager(
      CardReader cardReader, CalypsoCard card, SymmetricCryptoSecuritySetting securitySetting);

  /**
   * Returns a new instance of {@link SecurePkiModeTransactionManager}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_CalypsoCardApiFactory_createSecurePkiModeTransactionManager">CalypsoCardApiFactory.createSecurePkiModeTransactionManager</a>
   * for the normative contract.
   *
   * @param cardReader The card reader to be used.
   * @param card The selected card on which to operate the transaction.
   * @param securitySetting The security setting to be used.
   * @return A new instance of {@link SecurePkiModeTransactionManager}.
   * @throws IllegalArgumentException If one of the parameters is null.
   * @since 2.1.0
   */
  SecurePkiModeTransactionManager createSecurePkiModeTransactionManager(
      CardReader cardReader, CalypsoCard card, AsymmetricCryptoSecuritySetting securitySetting);

  /**
   * Returns a new instance of {@link SearchCommandData}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_CalypsoCardApiFactory_createSearchCommandData">CalypsoCardApiFactory.createSearchCommandData</a>
   * for the normative contract.
   *
   * @return A new instance of {@link SearchCommandData}.
   * @since 2.0.0
   */
  SearchCommandData createSearchCommandData();
}
