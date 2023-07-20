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

import java.security.cert.X509Certificate;
import org.eclipse.keypop.calypso.card.CalypsoCardApiFactory;
import org.eclipse.keypop.calypso.card.transaction.spi.AsymmetricCryptoTransactionManagerFactory;

/**
 * Security setting for a Calypso card transaction secured by "asymmetric" key cryptographic
 * algorithms (e.g. PKI).
 *
 * <p>An instance of this interface can be obtained via the method {@link
 * CalypsoCardApiFactory#createAsymmetricCryptoSecuritySetting(AsymmetricCryptoTransactionManagerFactory)}.
 *
 * @since 2.0.0
 */
public interface AsymmetricCryptoSecuritySetting {

  /**
   * TODO
   *
   * @param publicKey
   * @return The current instance.
   * @since 2.0.0
   */
  AsymmetricCryptoSecuritySetting setAuthorityPublicKey(byte[] publicKey);

  /**
   * TODO
   *
   * @param certificate
   * @return The current instance.
   * @since 2.0.0
   */
  AsymmetricCryptoSecuritySetting setAuthorityCertificate(X509Certificate certificate);

  /**
   * TODO
   *
   * @return The current instance.
   * @since 2.0.0
   */
  AsymmetricCryptoSecuritySetting enableUnsignedPublicKeyUsage();
}
