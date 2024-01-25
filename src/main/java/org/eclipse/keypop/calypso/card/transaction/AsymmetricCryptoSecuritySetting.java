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
 * Security setting for a Calypso card transaction secured by "asymmetric" key cryptographic
 * algorithms (PKI).
 *
 * @since 2.1.0
 */
public interface AsymmetricCryptoSecuritySetting {

  /**
   * Registers a self-signed PCA certificate.
   *
   * @param pcaCertificate The PCA certificate to add.
   * @return The current instance.
   * @throws IllegalArgumentException If the argument is null or invalid.
   * @throws IllegalStateException If the contained public key already been registered.
   * @throws InvalidCertificateException If the check of the provided certificate failed.
   * @since 2.1.0
   */
  AsymmetricCryptoSecuritySetting addPcaCertificate(PcaCertificate pcaCertificate);

  /**
   * Registers a CA certificate.
   *
   * <p>Preloading a CA certificate avoids having to read it from the card.
   *
   * <p>Please note: the certificate signature is systematically verified using the issuer's public
   * key. The issuer's certificate must be loaded first.
   *
   * @param caCertificate The CA certificate to add.
   * @return The current instance.
   * @throws IllegalArgumentException If the argument is null or invalid.
   * @throws IllegalStateException If the contained public key already been registered.
   * @throws InvalidCertificateException If the check of the provided certificate failed.
   * @see #addPcaCertificate(PcaCertificate)
   * @since 2.1.0
   */
  AsymmetricCryptoSecuritySetting addCaCertificate(CaCertificate caCertificate);

  /**
   * Registers a CA certificate factory.
   *
   * <p>The factory provides the means to build a {@link CaCertificate} from the raw data read from
   * the card.
   *
   * <p>This factory will only be used if the CA certificate is not already available.
   *
   * @param caCertificateFactory The CA certificate factory to add.
   * @return The current instance.
   * @throws IllegalArgumentException If the argument is null or invalid.
   * @throws IllegalStateException If the associated certificate type is already registered.
   * @since 2.1.0
   */
  AsymmetricCryptoSecuritySetting addCaCertificateFactory(
      CaCertificateFactory caCertificateFactory);

  /**
   * Registers a card certificate factory.
   *
   * <p>The factory provides the means to build a card certificate from the raw data read from the
   * card.
   *
   * @param cardCertificateFactory The card certificate factory to add.
   * @return The current instance.
   * @throws IllegalArgumentException If the argument is null or invalid.
   * @throws IllegalStateException If the associated certificate type is already registered.
   * @since 2.1.0
   */
  AsymmetricCryptoSecuritySetting addCardCertificateFactory(
      CardCertificateFactory cardCertificateFactory);
}
