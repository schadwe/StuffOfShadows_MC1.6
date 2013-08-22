package schadwe.sos.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import schadwe.sos.item.Items;
import schadwe.sos.lib.BlockIds;
import schadwe.sos.lib.Strings;
import schadwe.sos.tileentity.TileEntityDarkness;
import schadwe.sos.tileentity.TileEntityShadowCube;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Stuff Of Shadows
 * 
 * Blocks
 * 
 * @author schadwe
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class Blocks {

    // Block instances
    public static Block shadowStone;
    public static Block shadowCube;
    public static Block darkness;

    public static void init() {

        // Initialize Shadow Stone
        shadowStone = new BlockShadowStone(BlockIds.SHADOW_STONE);
        GameRegistry.registerBlock(shadowStone, Strings.SHADOW_STONE_NAME);
        LanguageRegistry.addName(shadowStone, "Shadow Stone");
        
        // Initialize Shadow Cube
        shadowCube = new BlockShadowCube(BlockIds.SHADOW_CUBE);
        GameRegistry.registerBlock(shadowCube, Strings.SHADOW_CUBE_NAME);
        LanguageRegistry.addName(shadowCube, "Shadow");
        
        // Initialize darkness
        darkness = new BlockDarkness(BlockIds.DARKNESS);
        GameRegistry.registerBlock(darkness, Strings.DARKNESS_NAME);
        LanguageRegistry.addName(darkness, "Darkness");

        // Initialize Block Recipes
        initBlockRecipes();

    }

    private static void initBlockRecipes() {
    	
    	/* Shadow Stone */
        GameRegistry.addRecipe(new ItemStack(shadowStone), new Object[] {"ddd", 
        																 "dsd", 
        																 "ddd", 
        																 Character.valueOf('d'), Items.shadowDust, 
        																 Character.valueOf('s'), Block.stone });
    }   
    
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityDarkness.class, Strings.DARKNESS_NAME);
		GameRegistry.registerTileEntity(TileEntityShadowCube.class, Strings.SHADOW_CUBE_NAME);
	}
    
}
