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
