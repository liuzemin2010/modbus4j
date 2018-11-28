/*
    Copyright (C) 2006-2009 Serotonin Software Technologies Inc.
 	@author Matthew Lohbihler
 */
package com.net4iot.oss.modbus4j.sero.io;

/**
 * @author Matthew Lohbihler
 */
public interface LineHandler {
    public void handleLine(String line);

    public void done();
}
