package schadwe.sos.configuration;

import java.io.File;
//import java.util.logging.Level;

import schadwe.sos.lib.BlockIds;
import schadwe.sos.lib.ItemIds;
import schadwe.sos.lib.Strings;

//import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.Configuration;

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
    public static final String CATEGORY_BLOCK_PROPERTIES = Configuration.CATEGORY_BLOCK + Configuration.CATEGORY_SPLITTER + "properties";
    public static final String CATEGORY_DURABILITY = Configuration.CATEGORY_ITEM + Configuration.CATEGORY_SPLITTER + "durability";
    
    public static void init(File configFile) {

        configuration = new Configuration(configFile);

        try {
            configuration.load();

            /* Block configs */
            BlockIds.SHADOW_STONE = configuration.getBlock(Strings.SHADOW_STONE_NAME, BlockIds.SHADOW_STONE_DEFAULT).getInt(BlockIds.SHADOW_STONE_DEFAULT);

            /* Block property configs */
            //configuration.addCustomCategoryComment(CATEGORY_BLOCK_PROPERTIES, "Custom block properties");

            /* Item configs */
            ItemIds.SHADOW_DUST = configuration.getItem(Strings.SHADOW_DUST_NAME, ItemIds.SHADOW_DUST_DEFAULT).getInt(ItemIds.SHADOW_DUST_DEFAULT);


            /* Item durability configs */
            //ConfigurationSettings.MINIUM_STONE_MAX_DURABILITY = configuration.get(CATEGORY_DURABILITY, ConfigurationSettings.MINIUM_STONE_MAX_DURABILITY_CONFIGNAME, ConfigurationSettings.MINIUM_STONE_MAX_DURABILITY_DEFAULT).getInt(ConfigurationSettings.MINIUM_STONE_MAX_DURABILITY_DEFAULT);

        }
        catch (Exception e) {
            //FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " has had a problem loading its configuration");
        }
        finally {
            configuration.save();
        }
    }
}
