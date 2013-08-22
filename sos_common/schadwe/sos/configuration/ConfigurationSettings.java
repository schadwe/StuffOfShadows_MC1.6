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
    
    public static boolean FEAR_FROM_DARKNESS;
    public static String FEAR_FROM_DARKNESS_CONFIGNAME = "fearGainFromDarkness";
    public static final boolean FEAR_FROM_DARKNESS_DEFAULT = true;
    
    public static boolean FEAR_FROM_DAMAGE;
    public static String FEAR_FROM_DAMAGE_CONFIGNAME = "fearGainFromDamage";
    public static final boolean FEAR_FROM_DAMAGE_DEFAULT = true;
    
    // Fear Effects (Fear level that the effect activates)
    public static int FEAR_LEVEL_AUDIO_HALLUCINATIONS;
    public static String FEAR_LEVEL_AUDIO_HALLUCINATIONS_CONFIGNAME = "fearLevelAudioHallucinations";
    public static final int FEAR_LEVEL_AUDIO_HALLUCINATIONS_DEFAULT = 50;
    
    public static int FEAR_LEVEL_VISUAL_HALLUCINATIONS;
    public static String FEAR_LEVEL_VISUAL_HALLUCINATIONS_CONFIGNAME = "fearLevelVideoHallucinations";
    public static final int FEAR_LEVEL_VISUAL_HALLUCINATIONS_DEFAULT = 60;
    
    public static int FEAR_LEVEL_EFFICIENCY_REDUCTION;
    public static String FEAR_LEVEL_EFFICIENCY_REDUCTION_CONFIGNAME = "fearLevelEfficiencyReduction";
    public static final int FEAR_LEVEL_EFFICIENCY_REDUCTION_DEFAULT = 70;
    
    public static int FEAR_LEVEL_NAUSIA;
    public static String FEAR_LEVEL_NAUSIA_CONFIGNAME = "fearLevelNausia";
    public static final int FEAR_LEVEL_NAUSIA_DEFAULT = 80;
    
    public static int FEAR_LEVEL_CONFUSION;
    public static String FEAR_LEVEL_CONFUSION_CONFIGNAME = "fearLevelConfusion";
    public static final int FEAR_LEVEL_CONFUSION_DEFAULT = 90;
    
    // Block Settings
    public static final int DARKNESS_SPREAD_LEVELS = 1;
}
