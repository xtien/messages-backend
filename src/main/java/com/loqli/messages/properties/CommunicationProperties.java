/*
 * Zaphod Consulting BV demo notification system
 * Copyright (c) 2019, Zaphod Consulting BV, Christine Karman
 * mailto: christine AT christine DOT nl
 * This project is free software: you can redistribute it and/or modify it
 * under the terms of the Apache License, Version 2.0.
 * You can find a copy of the license at
 * http://www. apache.org/licenses/LICENSE-2.0.
 */

package com.loqli.messages.properties;

import com.loqli.messages.ServerConstants;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Properties;

public class CommunicationProperties {

    private static final Logger log = Logger.getLogger(CommunicationProperties.class);

    private static Properties properties;
    private static String pathString;
    private static FastDateFormat dateFormat = FastDateFormat.getInstance("yyyy/MM/dd hh:mm");

    private static boolean propertiesRead = false;

    public CommunicationProperties() {
        // empty, needed for deserialization
    }

    public static void init() {
        if (!propertiesRead) {
            readProperties();
            propertiesRead = true;
        }
    }

    private static void readProperties() {

        pathString = "/home/christine" + File.separator + ServerConstants.settings_properties_file;
        Path path = Paths.get(pathString);
        properties = new Properties();

        if (Files.exists(path)) {

            try {

                InputStream is = java.nio.file.Files.newInputStream(path);

                properties.load(is);

            } catch (IOException e) {
                log.error("Error reading properties", e);
            }
        }
        for (Object key : properties.keySet()) {
            log.debug("prop: " + (String) key + " " + properties.getProperty((String) key));
        }
    }

    public static boolean containsKey(Object key) {
        return properties.containsKey(key);
    }

    public static boolean hasProperty(Object key) {
        return containsKey(key);
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
