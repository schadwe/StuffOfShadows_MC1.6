package schadwe.sos.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import schadwe.sos.block.BlockShadowStone;
import schadwe.sos.item.Items;
import schadwe.sos.lib.BlockIds;
import schadwe.sos.lib.Strings;

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

    public static void init() {

        // Initialize Shadow Stone
        shadowStone = new BlockShadowStone(BlockIds.SHADOW_STONE);
        GameRegistry.registerBlock(shadowStone, Strings.SHADOW_STONE_NAME);
        LanguageRegistry.addName(shadowStone, "Shadow Stone");
        
        // Initialize Shadow Cube
        shadowCube = new BlockShadowCube(BlockIds.SHADOW_CUBE);
        GameRegistry.registerBlock(shadowCube, Strings.SHADOW_CUBE_NAME);
        LanguageRegistry.addName(shadowCube, "Shadow");

        // Initialize Block Recipes
        initBlockRecipes();

    }

    private static void initBlockRecipes() {

        GameRegistry.addRecipe(new ItemStack(shadowStone), new Object[] {"iii", "isi", "iii", Character.valueOf('i'), Items.shadowDust, Character.valueOf('s'), Block.stone });
    }    
    
}
