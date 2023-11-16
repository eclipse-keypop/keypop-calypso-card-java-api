/* ******************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.calypso.card.transaction.spi;

/**
 * SPI provided by the crypto extension associated with the current transaction, enriching the card
 * transaction command set with specific crypto commands such as for example computation and
 * signature verification operations.
 *
 * @since 2.0.0
 */
public interface CardTransactionCryptoExtension {}
