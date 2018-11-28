package com.net4iot.oss.modbus4j.sero.timer;

/**
 * An interface to abstract the source of current time away from System. This allows code to run in simulations where
 * the time is controlled explicitly.
 * 
 * @author Matthew Lohbihler
 */
public interface TimeSource {
    long currentTimeMillis();
}
