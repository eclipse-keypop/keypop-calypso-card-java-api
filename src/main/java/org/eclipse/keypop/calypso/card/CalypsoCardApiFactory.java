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
package org.eclipse.keypop.calypso.card;

import org.eclipse.keypop.calypso.card.card.CalypsoCard;
import org.eclipse.keypop.calypso.card.card.CalypsoCardSelectionExtension;
import org.eclipse.keypop.calypso.card.transaction.AsymmetricCryptoSecuritySetting;
import org.eclipse.keypop.calypso.card.transaction.FreeTransactionManager;
import org.eclipse.keypop.calypso.card.transaction.SearchCommandData;
import org.eclipse.keypop.calypso.card.transaction.SecureExtendedModeTransactionManager;
import org.eclipse.keypop.calypso.card.transaction.SecurePkiModeTransactionManager;
import org.eclipse.keypop.calypso.card.transaction.SecureRegularModeTransactionManager;
import org.eclipse.keypop.calypso.card.transaction.SymmetricCryptoSecuritySetting;
import org.eclipse.keypop.calypso.card.transaction.spi.AsymmetricCryptoTransactionManagerFactory;
import org.eclipse.keypop.calypso.card.transaction.spi.SymmetricCryptoTransactionManagerFactory;
import org.eclipse.keypop.reader.CardReader;

/**
 * Calypso Card API Factory.
 *
 * @since 2.0.0
 */
public interface CalypsoCardApiFactory {

  /**
   * Returns a new instance of {@link CalypsoCardSelectionExtension}.
   *
   * @return A new instance of {@link CalypsoCardSelectionExtension}.
   * @since 2.0.0
   */
  CalypsoCardSelectionExtension createCalypsoCardSelectionExtension();

  /**
   * Returns a new instance of {@link SymmetricCryptoSecuritySetting}.
   *
   * @param cryptoTransactionManagerFactory The factory of the crypto manager to be used.
   * @return A new instance of {@link SymmetricCryptoSecuritySetting}.
   * @throws IllegalArgumentException If the factory is null or invalid.
   * @since 2.0.0
   */
  SymmetricCryptoSecuritySetting createSymmetricCryptoSecuritySetting(
      SymmetricCryptoTransactionManagerFactory cryptoTransactionManagerFactory);

  /**
   * Returns a new instance of {@link AsymmetricCryptoSecuritySetting}.
   *
   * @param cryptoTransactionManagerFactory The factory of the crypto manager to be used.
   * @return A new instance of {@link AsymmetricCryptoSecuritySetting}.
   * @throws IllegalArgumentException If the factory is null or invalid.
   * @since 2.0.0
   */
  AsymmetricCryptoSecuritySetting createAsymmetricCryptoSecuritySetting(
      AsymmetricCryptoTransactionManagerFactory cryptoTransactionManagerFactory);

  /**
   * Returns a new instance of {@link FreeTransactionManager}.
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
   * @param cardReader The card reader to be used.
   * @param card The selected card on which to operate the transaction.
   * @param securitySetting The security setting to be used.
   * @return A new instance of {@link SecurePkiModeTransactionManager}.
   * @throws IllegalArgumentException If one of the parameters is null.
   * @since 2.0.0
   */
  SecurePkiModeTransactionManager createSecurePkiModeTransactionManager(
      CardReader cardReader, CalypsoCard card, AsymmetricCryptoSecuritySetting securitySetting);

  /**
   * Returns a new instance of {@link SearchCommandData}.
   *
   * @return A new instance of {@link SearchCommandData}.
   * @since 2.0.0
   */
  SearchCommandData createSearchCommandData();
}
