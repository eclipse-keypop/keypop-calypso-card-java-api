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
package org.eclipse.keypop.calypso;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.eclipse.keypop.calypso.card.CalypsoCardApiProperties;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalypsoCardApiPropertiesTest {

  private static String libVersion;

  @BeforeClass
  public static void beforeClass() throws Exception {
    InputStream inputStream = new FileInputStream("gradle.properties");
    try {
      Properties properties = new Properties();
      properties.load(inputStream);
      libVersion = properties.getProperty("version");
    } finally {
      inputStream.close();
    }
  }

  @Test
  public void versionIsCorrectlyWritten() {
    String apiVersion = CalypsoCardApiProperties.VERSION;
    assertThat(apiVersion).matches("\\d+\\.\\d+");
    assertThat(libVersion).startsWith(apiVersion);
  }
}
