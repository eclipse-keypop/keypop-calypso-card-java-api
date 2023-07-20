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

import org.eclipse.keypop.calypso.card.transaction.spi.CardTransactionCryptoExtension;

/**
 * Contains operations common to all card transactions secured by cryptographic algorithms.
 *
 * <p>See {@link TransactionManager} parent interface for more information and details of others
 * available card operations.
 *
 * @param <T> The type of the lowest level child object.
 * @since 2.0.0
 */
public interface SecureTransactionManager<T extends SecureTransactionManager<T>>
    extends TransactionManager<T> {

  /**
   * Returns the associated {@link CardTransactionCryptoExtension} instance.
   *
   * @param cryptoExtensionClass The class of the crypto extension.
   * @param <E> The generic type of the expected crypto extension.
   * @return A non-null {@link CardTransactionCryptoExtension}.
   * @throws IllegalArgumentException If the provided class is null.
   * @since 2.0.0
   */
  <E extends CardTransactionCryptoExtension> E getCryptoExtension(Class<E> cryptoExtensionClass);

  /**
   * Schedules the execution of a "Close Secure Session" command.
   *
   * <p>The ratification mechanism is disabled by default but can be enabled via the {@link
   * SymmetricCryptoSecuritySetting#enableRatificationMechanism()} method.
   *
   * <p>In this case, a ratification command is added after the "Close Secure Session" command when
   * the communication is done in contactless mode.
   *
   * @return The current instance.
   * @throws IllegalStateException In the following cases:
   *     <ul>
   *       <li>No secure session is opened and no secure session opening is prepared
   *       <li>A secure session closing is already prepared
   *       <li>A secure session canceling is prepared
   *     </ul>
   *
   * @since 1.6.0
   */
  T prepareCloseSecureSession();

  /**
   * Schedules the execution of a special "Close Secure Session" command in order to abort the
   * current secure session.
   *
   * <p>This command will be executed in safe mode and will not raise any exceptions.
   *
   * @return The current instance.
   * @since 1.6.0
   */
  T prepareCancelSecureSession();
}
