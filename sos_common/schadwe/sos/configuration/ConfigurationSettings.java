package schadwe.sos.configuration;

/**
 * Stuff Of Shadows
 * 
 * ConfigurationsSetting
 * 
 * @author schadwe
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ConfigurationSettings {
    // Fear Mechanism
	public static int FEAR_TICK_TIMING;
    public static String FEAR_TICK_TIMING_CONFIGNAME = "fearTickTiming";
    public static final int FEAR_TICK_TIMING_DEFAULT = 100;
    
    public static boolean FEAR_FROM_DAMAGE;
    public static String FEAR_FROM_DAMAGE_CONFIGNAME = "fearGainFromDamage";
    public static final boolean FEAR_FROM_DAMAGE_DEFAULT = true;
}
