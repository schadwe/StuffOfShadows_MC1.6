package schadwe.sos.configuration;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import schadwe.sos.lib.BlockIds;
import schadwe.sos.lib.ItemIds;
import schadwe.sos.lib.Reference;
import schadwe.sos.lib.Strings;
import cpw.mods.fml.common.FMLLog;
//import java.util.logging.Level;
//import cpw.mods.fml.common.FMLLog;

/**
 * Stuff Of Shadows
 * 
 * ConfigurationHandler
 * 
 * @author schadwe
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ConfigurationHandler {
    
    public static Configuration configuration;

    public static final String CATEGORY_KEYBIND = "keybindings";
    public static final String CATEGORY_GRAPHICS = "graphics";
    public static final String CATEGORY_AUDIO = "audio";
    public static final String CATEGORY_FEAR_PROPERTIES = "Fear" + Configuration.CATEGORY_SPLITTER + "properties";
    public static final String CATEGORY_FEAR_EFFECTS = "Fear" + Configuration.CATEGORY_SPLITTER + "effects";
    public static final String CATEGORY_DURABILITY = Configuration.CATEGORY_ITEM + Configuration.CATEGORY_SPLITTER + "durability";
    
    public static void init(File configFile) {

        configuration = new Configuration(configFile);

        try {
            configuration.load();

            // Block configs
            BlockIds.SHADOW_STONE = configuration.getBlock(Strings.SHADOW_STONE_NAME, BlockIds.SHADOW_STONE_DEFAULT).getInt(BlockIds.SHADOW_STONE_DEFAULT);
            BlockIds.SHADOW_CUBE = configuration.getBlock(Strings.SHADOW_CUBE_NAME, BlockIds.SHADOW_CUBE_DEFAULT).getInt(BlockIds.SHADOW_CUBE_DEFAULT);
            BlockIds.DARKNESS = configuration.getBlock(Strings.DARKNESS_NAME, BlockIds.DARKNESS_DEFAULT).getInt(BlockIds.DARKNESS_DEFAULT);
            
            // Item configs
            ItemIds.SHADOW_DUST = configuration.getItem(Strings.SHADOW_DUST_NAME, ItemIds.SHADOW_DUST_DEFAULT).getInt(ItemIds.SHADOW_DUST_DEFAULT);

            // Fear properties configs
            configuration.addCustomCategoryComment(CATEGORY_FEAR_PROPERTIES, "Custom Fear mechanism properties");
            ConfigurationSettings.FEAR_TICK_TIMING = configuration.get(CATEGORY_FEAR_PROPERTIES, ConfigurationSettings.FEAR_TICK_TIMING_CONFIGNAME, ConfigurationSettings.FEAR_TICK_TIMING_DEFAULT).getInt(ConfigurationSettings.FEAR_TICK_TIMING_DEFAULT);
            ConfigurationSettings.FEAR_FROM_DARKNESS = configuration.get(CATEGORY_FEAR_PROPERTIES, ConfigurationSettings.FEAR_FROM_DARKNESS_CONFIGNAME, ConfigurationSettings.FEAR_FROM_DARKNESS_DEFAULT).getBoolean(ConfigurationSettings.FEAR_FROM_DARKNESS_DEFAULT);
            ConfigurationSettings.FEAR_FROM_DAMAGE = configuration.get(CATEGORY_FEAR_PROPERTIES, ConfigurationSettings.FEAR_FROM_DAMAGE_CONFIGNAME, ConfigurationSettings.FEAR_FROM_DAMAGE_DEFAULT).getBoolean(ConfigurationSettings.FEAR_FROM_DAMAGE_DEFAULT);
            
            // Fear effects configs
            configuration.addCustomCategoryComment(CATEGORY_FEAR_EFFECTS, "Effects threshold at fear level (cumulative)");
            ConfigurationSettings.FEAR_LEVEL_AUDIO_HALLUCINATIONS = configuration.get(CATEGORY_FEAR_EFFECTS, ConfigurationSettings.FEAR_LEVEL_AUDIO_HALLUCINATIONS_CONFIGNAME, ConfigurationSettings.FEAR_LEVEL_AUDIO_HALLUCINATIONS_DEFAULT).getInt(ConfigurationSettings.FEAR_LEVEL_AUDIO_HALLUCINATIONS_DEFAULT);
            ConfigurationSettings.FEAR_LEVEL_VISUAL_HALLUCINATIONS = configuration.get(CATEGORY_FEAR_EFFECTS, ConfigurationSettings.FEAR_LEVEL_VISUAL_HALLUCINATIONS_CONFIGNAME, ConfigurationSettings.FEAR_LEVEL_VISUAL_HALLUCINATIONS_DEFAULT).getInt(ConfigurationSettings.FEAR_LEVEL_VISUAL_HALLUCINATIONS_DEFAULT);
            ConfigurationSettings.FEAR_LEVEL_EFFICIENCY_REDUCTION = configuration.get(CATEGORY_FEAR_EFFECTS, ConfigurationSettings.FEAR_LEVEL_EFFICIENCY_REDUCTION_CONFIGNAME, ConfigurationSettings.FEAR_LEVEL_EFFICIENCY_REDUCTION_DEFAULT).getInt(ConfigurationSettings.FEAR_LEVEL_EFFICIENCY_REDUCTION_DEFAULT);
            ConfigurationSettings.FEAR_LEVEL_NAUSIA = configuration.get(CATEGORY_FEAR_EFFECTS, ConfigurationSettings.FEAR_LEVEL_NAUSIA_CONFIGNAME, ConfigurationSettings.FEAR_LEVEL_NAUSIA_DEFAULT).getInt(ConfigurationSettings.FEAR_LEVEL_NAUSIA_DEFAULT);
        }
        catch (Exception e) {
        	FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " has had a problem loading its configuration");
        }
        finally {
            configuration.save();
        }
    }
    /*// Live configuration changing
    public static void set(String categoryName, String propertyName, String newValue) {
        configuration.load();
        if (configuration.getCategoryNames().contains(categoryName)) {
            if (configuration.getCategory(categoryName).containsKey(propertyName)) {
                configuration.getCategory(categoryName).get(propertyName).set(newValue);
            }
        }
        configuration.save();
    }
    */
}
