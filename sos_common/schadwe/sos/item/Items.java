package schadwe.sos.item;

import cpw.mods.fml.common.registry.LanguageRegistry;
import schadwe.sos.lib.ItemIds;

import net.minecraft.item.Item;

/**
 * Stuff Of Shadows
 * 
 * Items
 * 
 * @author schadwe
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class Items {
    // Item Instances
    public static Item shadowDust;
    
    public static void init() {

        // Initialize Shadow Dust
        shadowDust = new ItemShadowDust(ItemIds.SHADOW_DUST);
        LanguageRegistry.addName(shadowDust, "Shadow Dust");

        // Initialize Item Recipes
        initItemRecipes();
    }
    
    private static void initItemRecipes() {

        /*GameRegistry.addRecipe(new ItemStack(shadowStone), 
    		new Object[] {"iii", 
    					  "isi", 
    					  "iii", 
    					  Character.valueOf('i'), Item.redstone, Character.valueOf('s'), 
    					  Item.lightStoneDust });
    	*/
    }
}
