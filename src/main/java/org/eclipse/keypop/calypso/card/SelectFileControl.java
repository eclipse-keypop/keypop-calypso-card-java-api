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
package org.eclipse.keypop.calypso.card;

/**
 * Enumeration of all expected behaviors of the selection command (see the specifics of this command
 * in the ISO7816-4 standard and the Calypso specification).
 *
 * @since 1.0.0
 */
public enum SelectFileControl {

  /**
   * The first EF of the current Calypso DF
   *
   * @since 1.0.0
   */
  FIRST_EF,

  /**
   * The next EF of the current Calypso DF
   *
   * @since 1.0.0
   */
  NEXT_EF,

  /**
   * The current Calypso DF
   *
   * @since 1.0.0
   */
  CURRENT_DF
}
