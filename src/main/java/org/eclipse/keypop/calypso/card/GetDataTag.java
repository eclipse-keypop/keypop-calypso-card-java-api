/* ******************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.calypso.card;

/**
 * Enumeration of all supported tags for the Get Data command.
 *
 * <p>May not be applicable to all products.
 *
 * @since 1.0.0
 */
public enum GetDataTag {

  /**
   * FCP for the current file, as returned by Select File.
   *
   * @since 1.0.0
   */
  FCP_FOR_CURRENT_FILE,
  /**
   * FCI for the current DF, as returned by Select Application.
   *
   * @since 1.0.0
   */
  FCI_FOR_CURRENT_DF,
  /**
   * List of EFs in the current DF.
   *
   * @since 1.1.0
   */
  EF_LIST,
  /**
   * Product traceability information.
   *
   * @since 1.1.0
   */
  TRACEABILITY_INFORMATION
}
