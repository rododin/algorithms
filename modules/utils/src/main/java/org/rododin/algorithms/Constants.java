/*
 * Constants.java
 */

package org.rododin.algorithms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Introduces some global constants to be used throughout the whole project..
 * @author Rod Odin
 */
public interface Constants
{
  public static final Logger Log      = LogManager.getLogger(Constants.class.getPackage().getName()              );
  public static final Logger LogAll   = LogManager.getLogger(Constants.class.getPackage().getName() + ".LogAll"  );
  public static final Logger LogTrace = LogManager.getLogger(Constants.class.getPackage().getName() + ".LogTrace");
  public static final Logger LogDebug = LogManager.getLogger(Constants.class.getPackage().getName() + ".LogDebug");
  public static final Logger LogInfo  = LogManager.getLogger(Constants.class.getPackage().getName() + ".LogInfo" );
  public static final Logger LogWarn  = LogManager.getLogger(Constants.class.getPackage().getName() + ".LogWarn" );
  public static final Logger LogError = LogManager.getLogger(Constants.class.getPackage().getName() + ".LogError");
  public static final Logger LogFatal = LogManager.getLogger(Constants.class.getPackage().getName() + ".LogFatal");
  public static final Logger LogOff   = LogManager.getLogger(Constants.class.getPackage().getName() + ".LogOff"  );
}
