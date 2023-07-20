/*
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This file is part of Eclipse Keypop.
 *
 * Eclipse Keypop is free software: you can redistribute it and/or modify
 * it under the terms of the MIT License. A copy of the License is located at
 *
 * http://opensource.org/licenses/MIT
 */
package org.eclipse.keypop.calypso.card.transaction;

import org.eclipse.keypop.calypso.card.CalypsoCardApiFactory;
import org.eclipse.keypop.calypso.card.card.CalypsoCard;
import org.eclipse.keypop.reader.CardReader;

/**
 * Manager of card transactions secured by asymmetric key cryptographic algorithms, compatible only
 * with "Calypso Prime PKI" products.
 *
 * <p>See {@link SecureTransactionManager} parent interface for more information and details of
 * available card operations.
 *
 * <p>An instance of this interface can be obtained via the method {@link
 * CalypsoCardApiFactory#createSecurePkiModeTransactionManager(CardReader, CalypsoCard,
 * AsymmetricCryptoSecuritySetting)}.
 *
 * @since 2.0.0
 */
public interface SecurePkiModeTransactionManager
    extends SecureTransactionManager<SecurePkiModeTransactionManager> {

  /**
   * Schedules the execution of an "Open Secure Session" command in PKI mode.
   *
   * <p>Note that if the next prepared command is a "Read One Record" or "Read One Or More
   * Counters", then it will by default be merged with the "Open Secure Session" command for
   * optimization purposes except if the "pre-open" mode is active.
   *
   * @return The current instance.
   * @throws IllegalStateException In the following cases:
   *     <ul>
   *       <li>No {@link AsymmetricCryptoSecuritySetting} is available
   *       <li>A secure session opening is already prepared
   *       <li>A secure session is already opened
   *     </ul>
   *     //@see CalypsoCardSelectionExtension#preparePreOpenSecureSessionInPkiMode() TODO
   * @since 2.0.0
   */
  SecurePkiModeTransactionManager prepareOpenSecureSession();
}
