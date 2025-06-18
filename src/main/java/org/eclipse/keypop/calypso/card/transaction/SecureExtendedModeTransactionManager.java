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
import org.eclipse.keypop.calypso.card.card.CalypsoCard;
import org.eclipse.keypop.reader.CardReader;

/**
 * Manager of card transactions secured by symmetric key cryptographic algorithms, adding additional
 * operations available only for "Calypso Prime Extended" products.
 *
 * <p>See {@link SecureSymmetricCryptoTransactionManager} parent interface for more information and
 * details of available card operations.
 *
 * <p>An instance of this interface can be obtained via the method {@link
 * CalypsoCardApiFactory#createSecureExtendedModeTransactionManager(CardReader, CalypsoCard,
 * SymmetricCryptoSecuritySetting)}.
 *
 * @since 2.0.0
 */
public interface SecureExtendedModeTransactionManager
    extends SecureSymmetricCryptoTransactionManager<SecureExtendedModeTransactionManager> {

  /**
   * Requests to mutually authenticate the card and the terminal before the secure session is
   * closed.
   *
   * <p>This ensures the authenticity of the card before sending sensitive commands.
   *
   * <p>The use of this feature will penalize the execution time of the secure session and should
   * therefore be used only for the case mentioned above. As a reminder, closing the secure session
   * also performs a mutual authentication of the card and the terminal.
   *
   * <p>When it is needed, it is advised to use this command only once at the beginning of the
   * secure session.
   *
   * @return The current instance.
   * @throws UnsupportedOperationException The "Manage Secure Session" command is not available for
   *     this context (Card and/or CRYPTOGRAPHIC MODULE does not support the extended mode).
   * @see SecureExtendedModeTransactionManager#prepareActivateEncryption()
   * @see SecureExtendedModeTransactionManager#prepareDeactivateEncryption()
   * @since 1.5.0
   */
  SecureExtendedModeTransactionManager prepareEarlyMutualAuthentication();

  /**
   * Requests the encryption of all following commands.
   *
   * <p>This ensures data confidentiality and prevents man-in-the-middle attacks.
   *
   * <p>The use of data encryption is resource intensive and increases transaction times. It is
   * therefore recommended to limit encryption to commands that require it.
   *
   * <p>Furthermore, if mutual authentication is also required, for performance reasons, it is
   * advised to place the prepareEarlyMutualAuthentication and prepareActivateEncryption calls
   * consecutively (in any order) for optimization purpose.
   *
   * <p>This command only makes sense in the context of a secure session.
   *
   * @return The current instance.
   * @throws UnsupportedOperationException The "Manage Secure Session" command is not available for
   *     this context (Card and/or cryptographic module does not support the extended mode).
   * @see SecureExtendedModeTransactionManager#prepareDeactivateEncryption()
   * @see SecureExtendedModeTransactionManager#prepareEarlyMutualAuthentication()
   * @since 1.5.0
   */
  SecureExtendedModeTransactionManager prepareActivateEncryption();

  /**
   * Requests to stop encryption for the following commands.
   *
   * <p>This restores the exchange operations with the card to its normal mode.
   *
   * <p>This command only makes sense in the context of a secure session in which encryption of
   * commands has been previously requested.
   *
   * <p>Note: the {@link SecureTransactionManager#prepareCloseSecureSession()} ()} method
   * automatically stops the encryption.
   *
   * @return The current instance.
   * @throws UnsupportedOperationException The "Manage Secure Session" command is not available for
   *     this context (Card and/or cryptographic module does not support the extended mode).
   * @see SecureExtendedModeTransactionManager#prepareActivateEncryption()
   * @see SecureExtendedModeTransactionManager#prepareEarlyMutualAuthentication()
   * @see SecureTransactionManager#prepareCloseSecureSession()
   * @since 1.5.0
   */
  SecureExtendedModeTransactionManager prepareDeactivateEncryption();
}
