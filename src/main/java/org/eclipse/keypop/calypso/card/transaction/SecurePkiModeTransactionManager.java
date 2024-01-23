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

import org.eclipse.keypop.calypso.card.card.CalypsoCardSelectionExtension;

/**
 * The SecurePkiModeTransactionManager interface provides methods to manage transactions with secure
 * session in PKI mode.
 *
 * @since 2.1.0
 */
public interface SecurePkiModeTransactionManager
    extends TransactionManager<SecurePkiModeTransactionManager> {

  /**
   * Schedules the execution of an "Open Secure Session" command in PKI mode.
   *
   * <p>The secure session will be opened in PKI mode, only reads and writes to files with "always"
   * access conditions will be allowed.
   *
   * <p>Note that if the next prepared command is a "Read One Record" or "Read One Or More
   * Counters", then it will by default be merged with the "Open Secure Session" command for
   * optimization purposes except if the "pre-open" mode is active.
   *
   * @return The current instance.
   * @see CalypsoCardSelectionExtension#preparePreOpenSecureSessionInPkiMode()
   * @since 2.1.0
   */
  SecurePkiModeTransactionManager prepareOpenSecureSession();
}