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
   * <p>This method performs various checks to ensure the integrity and validity of the provided PCA
   * certificate. These checks include verifying the certificate's signature to ensure it is
   * self-signed, checking the validity period to ensure the certificate is not expired or
   * prematurely valid, and confirming the authenticity of the issuer and subject details.
   * Additionally, it checks for compliance with relevant constraints or extensions that may be
   * necessary for PCA certificates.
   *
   * @param pcaCertificate The PCA certificate to add. Must be a valid, self-signed certificate.
   * @return The current instance.
   * @throws IllegalArgumentException If the argument is null or invalid.
   * @throws IllegalStateException If the contained public key has already been registered.
   * @throws InvalidCertificateException If the check of the provided certificate failed.
   * @since 2.1.0
   */
  AsymmetricCryptoSecuritySetting addPcaCertificate(PcaCertificate pcaCertificate);

  /**
   * Registers a CA certificate.
   *
   * <p>Preloading a CA certificate avoids having to read it from the card.
   *
   * <p>This method performs various checks to ensure the integrity and validity of the provided CA
   * certificate. These checks include verifying the certificate's signature using the issuer's
   * public key, checking the validity period to ensure the certificate is not expired or
   * prematurely valid, and confirming the authenticity of the issuer and subject details.
   * Additionally, it checks for compliance with relevant constraints or extensions that may be
   * necessary for CA certificates.
   *
   * <p>Please note that the issuer's certificate must be loaded first.
   *
   * @param caCertificate The CA certificate to add. Must be a valid, signed certificate.
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
