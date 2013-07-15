package schadwe.sos.core.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import schadwe.sos.lib.Reference;

import cpw.mods.fml.common.FMLLog;

/**
 * Stuff Of Shadows
 * 
 * LogHelper
 * 
 * @author schadwe
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class LogHelper {

    private static Logger sosLogger = Logger.getLogger(Reference.MOD_ID);

    public static void init() {
        sosLogger.setParent(FMLLog.getLogger());
    }

    public static void log(Level logLevel, String message) {
        sosLogger.log(logLevel, message);
    }
    
}
