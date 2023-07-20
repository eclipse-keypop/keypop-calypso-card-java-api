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
 * Manager of card transactions secured by "symmetric" key cryptographic algorithms, compatible with
 * all Calypso products.
 *
 * <p>See {@link SecureSymmetricCryptoTransactionManager} parent interface for more information and
 * details of available card operations.
 *
 * <p>An instance of this interface can be obtained via the method {@link
 * CalypsoCardApiFactory#createSecureStandardModeTransactionManager(CardReader, CalypsoCard,
 * SymmetricCryptoSecuritySetting)}.
 *
 * @since 2.0.0
 */
public interface SecureStandardModeTransactionManager
    extends SecureSymmetricCryptoTransactionManager<SecureStandardModeTransactionManager> {}
