package schadwe.sos;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;

import schadwe.sos.block.Blocks;
import schadwe.sos.item.Items;
import schadwe.sos.lib.Reference;
import schadwe.sos.configuration.ConfigurationHandler;
import schadwe.sos.creativetab.CreativeTabSOS;

import cpw.mods.fml.common.Mod;
//import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

/**
 * Stuff Of Shadows
 * 
 * StuffOfShadows
 * 
 * @author schadwe
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class StuffOfShadows {

    @Instance(Reference.MOD_ID)
    public static StuffOfShadows instance;

    //@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    //public static CommonProxy proxy;

    public static CreativeTabs tabSOS = new CreativeTabSOS(CreativeTabs.getNextID(), Reference.MOD_ID);
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event){
        
        // Initialize the configuration
        ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.CHANNEL_NAME + File.separator + Reference.MOD_ID + ".cfg"));
    }
    
    @Init
    public void load(FMLInitializationEvent event){
        
        // Initialize Items
        Items.init();
        
        // Initialize Blocks
        Blocks.init();
    
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event){
        
    }
}
