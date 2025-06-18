/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
package org.eclipse.keypop.calypso.card.card;

import org.eclipse.keypop.calypso.card.GetDataTag;

/**
 * Calypso EF metadata.
 *
 * @since 1.0.0
 */
public interface FileHeader {

  /**
   * Gets the associated LID.
   *
   * @return The LID.
   * @since 1.0.0
   */
  short getLid();

  /**
   * Gets the DF status.
   *
   * @return Null if the status is not available (e.g. when the {@code FileHeader} is created
   *     following the response to a "Get Data" command with the {@link GetDataTag#EF_LIST} tag).
   * @since 1.0.0
   */
  Byte getDfStatus();

  /**
   * Gets the Elementary File type.
   *
   * @return A non-null file type.
   * @since 1.0.0
   */
  ElementaryFile.Type getEfType();

  /**
   * Gets the number of records :
   *
   * <ul>
   *   <li>For a "counter" file, the number of records is always 1.<br>
   *       Extra bytes (rest of the division of the file size by 3) aren't accessible.
   *   <li>For a "binary" file, the number of records is always 1.
   * </ul>
   *
   * @return The number of records.
   * @since 1.0.0
   */
  int getRecordsNumber();

  /**
   * Gets the size of a record :
   *
   * <ul>
   *   <li>For a "counter" file, the record size is the original size of the record #1.<br>
   *       Extra bytes (rest of the division of the file size by 3) aren't accessible.
   *   <li>For a "binary" file, the size of the record is corresponding to the file size.
   * </ul>
   *
   * @return The size of a record.
   * @since 1.0.0
   */
  int getRecordSize();

  /**
   * Gets a reference to the access conditions.
   *
   * @return An empty array if the access conditions are not available (e.g. when the {@code
   *     FileHeader} is created following the response to a "Get Data" command with the {@link
   *     GetDataTag#EF_LIST} tag).
   * @since 1.0.0
   */
  byte[] getAccessConditions();

  /**
   * Gets a reference to the keys indexes.
   *
   * @return An empty array if the key indexes are not available (e.g. when the {@code FileHeader}
   *     is created following the response to a "Get Data" command with the {@link
   *     GetDataTag#EF_LIST} tag).
   * @since 1.0.0
   */
  byte[] getKeyIndexes();

  /**
   * Gets the non-zero unique identifier of the shared data when the file data is shared.
   *
   * @return Zero if the file data is not shared or null if the information is not available (e.g.
   *     when the {@code FileHeader} is created following the response to a "Get Data" command with
   *     the {@link GetDataTag#EF_LIST} tag).
   * @since 1.0.0
   */
  Short getSharedReference();
}
