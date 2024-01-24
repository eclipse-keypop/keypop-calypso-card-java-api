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

import org.eclipse.keypop.calypso.card.transaction.spi.CaCertificate;
import org.eclipse.keypop.calypso.card.transaction.spi.CaCertificateFactory;
import org.eclipse.keypop.calypso.card.transaction.spi.CardCertificateFactory;
import org.eclipse.keypop.calypso.card.transaction.spi.PcaCertificate;

/**
 * An interface for setting asymmetric crypto security settings. Provides methods to add PCA
 * certificate, CA certificate and their factories.
 *
 * @since 2.1.0
 */
public interface AsymmetricCryptoSecuritySetting {

  /**
   * Adds a PCA Certificate.
   *
   * @param pcaCertificate The PCA Certificate to add.
   * @return The current instance.
   * @since 2.1.0
   */
  AsymmetricCryptoSecuritySetting addPcaCertificate(PcaCertificate pcaCertificate);

  /**
   * Adds a CA Certificate.
   *
   * @param caCertificate The CA Certificate to add.
   * @return The current instance.
   * @since 2.1.0
   */
  AsymmetricCryptoSecuritySetting addCaCertificate(CaCertificate caCertificate);

  /**
   * Adds a CA Certificate factory.
   *
   * @param caCertificateFactory The CA Certificate factory to add.
   * @return The current instance.
   * @since 2.1.0
   */
  AsymmetricCryptoSecuritySetting addCaCertificateFactory(
      CaCertificateFactory caCertificateFactory);

  /**
   * Adds a Card Certificate factory.
   *
   * @param cardCertificateFactory The Card Certificate factory to add.
   * @return The current instance.
   * @since 2.1.0
   */
  AsymmetricCryptoSecuritySetting addCardCertificateFactory(
      CardCertificateFactory cardCertificateFactory);
}
