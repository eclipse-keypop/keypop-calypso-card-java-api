/* ******************************************************************************
 * Copyright (c) 2024 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.calypso.card.transaction;

import org.eclipse.keypop.calypso.card.GetDataTag;

/**
 * Manager of PKI personalization transactions
 *
 * @since 2.1.0
 */
public interface PkiPersonalizationTransactionManager
    extends TransactionManager<PkiPersonalizationTransactionManager> {

  /**
   * Schedules the execution of a "Generate Asymmetric Key Pair" command.
   *
   * <p>After the execution, the generated key pair will be stored internally into the card. The
   * public part can be retrieved via {@link #prepareGetData(GetDataTag)}.
   *
   * @return The current instance.
   * @since 2.1.0
   */
  PkiPersonalizationTransactionManager prepareGenerateAsymmetricKeyPair();

  /**
   * Schedules the execution of a "Put Data" command with the appropriate tag to load the provided
   * card certificate.
   *
   * @param cardCert the card certificate to be loaded
   * @return The current instance.
   * @throws IllegalArgumentException If the provided argument is null or invalid.
   * @since 2.1.0
   */
  PkiPersonalizationTransactionManager prepareLoadCardCert(byte[] cardCert);

  /**
   * Schedules the execution of a "Put Data" command with the appropriate tag to load the provided
   * CA certificate.
   *
   * @param caCert the CA certificate to be loaded
   * @return The current instance.
   * @throws IllegalArgumentException If the provided argument is null or invalid.
   * @since 2.1.0
   */
  PkiPersonalizationTransactionManager prepareLoadCaCert(byte[] caCert);
}
