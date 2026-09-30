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
 * Manager of card transactions secured by symmetric key cryptographic algorithms, compatible with
 * all Calypso products.
 *
 * <p>See {@link SecureSymmetricCryptoTransactionManager} parent interface for more information and
 * details of available card operations.
 *
 * <p>An instance of this interface can be obtained via the method {@link
 * CalypsoCardApiFactory#createSecureRegularModeTransactionManager(CardReader, CalypsoCard,
 * SymmetricCryptoSecuritySetting)}.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#type_SecureRegularModeTransactionManager">SecureRegularModeTransactionManager</a>
 * for the normative contract.
 *
 * @since 2.0.0
 */
public interface SecureRegularModeTransactionManager
    extends SecureSymmetricCryptoTransactionManager<SecureRegularModeTransactionManager> {}
