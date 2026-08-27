/* **************************************************************************************
 * Copyright (c) 2024 Calypso Networks Association https://calypsonet.org/
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

import org.eclipse.keypop.calypso.card.transaction.spi.CaCertificate;
import org.eclipse.keypop.calypso.card.transaction.spi.CaCertificateParser;
import org.eclipse.keypop.calypso.card.transaction.spi.CardCertificateParser;
import org.eclipse.keypop.calypso.card.transaction.spi.PcaCertificate;

/**
 * Security setting for a Calypso card transaction secured by "asymmetric" key cryptographic
 * algorithms (PKI).
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#type_AsymmetricCryptoSecuritySetting">AsymmetricCryptoSecuritySetting</a>
 * for the normative contract.
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
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_AsymmetricCryptoSecuritySetting_addPcaCertificate">AsymmetricCryptoSecuritySetting.addPcaCertificate</a>
   * for the normative contract.
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
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_AsymmetricCryptoSecuritySetting_addCaCertificate">AsymmetricCryptoSecuritySetting.addCaCertificate</a>
   * for the normative contract.
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
   * Registers a CA certificate parser.
   *
   * <p>The parser provides the means to build a {@link CaCertificate} from the raw data read from
   * the card.
   *
   * <p>This parser will only be used if the CA certificate is not already available.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_AsymmetricCryptoSecuritySetting_addCaCertificateParser">AsymmetricCryptoSecuritySetting.addCaCertificateParser</a>
   * for the normative contract.
   *
   * @param caCertificateParser The CA certificate parser to add.
   * @return The current instance.
   * @throws IllegalArgumentException If the argument is null or invalid.
   * @throws IllegalStateException If a parser associated with the same certificate type is already
   *     registered.
   * @since 2.1.0
   */
  AsymmetricCryptoSecuritySetting addCaCertificateParser(CaCertificateParser caCertificateParser);

  /**
   * Registers a card certificate parser.
   *
   * <p>The parser provides the means to build a card certificate from the raw data read from the
   * card.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_AsymmetricCryptoSecuritySetting_addCardCertificateParser">AsymmetricCryptoSecuritySetting.addCardCertificateParser</a>
   * for the normative contract.
   *
   * @param cardCertificateParser The card certificate parser to add.
   * @return The current instance.
   * @throws IllegalArgumentException If the argument is null or invalid.
   * @throws IllegalStateException If a parser associated with the same certificate type is already
   *     registered.
   * @since 2.1.0
   */
  AsymmetricCryptoSecuritySetting addCardCertificateParser(
      CardCertificateParser cardCertificateParser);

  /**
   * Sets the maximum duration of an open PKI secure session, in milliseconds, for cards whose CSN
   * is greater than or equal to the provided value, applied to every application DF.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_AsymmetricCryptoSecuritySetting_assignOpenSecureSessionMaxDuration_allDf">AsymmetricCryptoSecuritySetting.assignOpenSecureSessionMaxDuration</a>
   * for the normative contract.
   *
   * @param csnMin The lowest card serial number the setting applies to.
   * @param maxDuration The maximum duration of an open secure session, in milliseconds.
   * @return The current instance.
   * @since 3.0.0
   */
  AsymmetricCryptoSecuritySetting assignOpenSecureSessionMaxDuration(long csnMin, long maxDuration);

  /**
   * Sets the maximum duration of an open PKI secure session, in milliseconds, for cards whose CSN
   * is greater than or equal to the provided value and whose application DF matches the provided
   * name.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-card-uml-api/3.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCard_v3.0.0-SNAPSHOT.html#op_AsymmetricCryptoSecuritySetting_assignOpenSecureSessionMaxDuration_byDf">AsymmetricCryptoSecuritySetting.assignOpenSecureSessionMaxDuration</a>
   * for the normative contract.
   *
   * @param csnMin The lowest card serial number the setting applies to.
   * @param dfName The application DF name the setting applies to.
   * @param maxDuration The maximum duration of an open secure session, in milliseconds.
   * @return The current instance.
   * @since 3.0.0
   */
  AsymmetricCryptoSecuritySetting assignOpenSecureSessionMaxDuration(
      long csnMin, byte[] dfName, long maxDuration);
}
