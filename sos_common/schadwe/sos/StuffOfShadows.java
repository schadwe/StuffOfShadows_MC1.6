package schadwe.sos;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.MinecraftForge;
import schadwe.sos.block.Blocks;
import schadwe.sos.configuration.ConfigurationHandler;
import schadwe.sos.core.handlers.GenericEventHandler;
import schadwe.sos.core.helper.LogHelper;
import schadwe.sos.creativetab.CreativeTabSOS;
import schadwe.sos.gui.GuiFearMeter;
import schadwe.sos.item.Items;
import schadwe.sos.lib.Reference;
import schadwe.sos.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

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

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static CreativeTabs tabSOS = new CreativeTabSOS(CreativeTabs.getNextID(), Reference.MOD_ID);
        
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        // Initialize log helper
        LogHelper.init();
        
        // Initialize the configuration
        ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.CHANNEL_NAME + File.separator + Reference.MOD_ID + ".cfg"));
  
        // Register Renders (Client Only)
        proxy.initRenderers();
        
        // Register Sounds (Client Only)
        proxy.initSounds();
               
        // Initialize Items
        Items.init();
        
        // Initialize Blocks
        Blocks.init();
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event){
        // Register tick handlers
        proxy.registerHandlers();
        
        // Register Player Tracker
        GenericEventHandler handler = new GenericEventHandler();
        MinecraftForge.EVENT_BUS.register(handler);
        GameRegistry.registerPlayerTracker(handler);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	MinecraftForge.EVENT_BUS.register(new GuiFearMeter(Minecraft.getMinecraft()));
    }
}
