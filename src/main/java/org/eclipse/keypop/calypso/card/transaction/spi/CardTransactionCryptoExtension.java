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
package org.eclipse.keypop.calypso.card.transaction.spi;

/**
 * SPI provided by the crypto extension associated with the current transaction, enriching the card
 * transaction command set with specific crypto commands such as for example computation and
 * signature verification operations.
 *
 * @since 2.0.0
 */
public interface CardTransactionCryptoExtension {}
