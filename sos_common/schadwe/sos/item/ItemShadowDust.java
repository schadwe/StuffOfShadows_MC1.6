package schadwe.sos.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import schadwe.sos.StuffOfShadows;
import schadwe.sos.lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


/**
 * Stuff Of Shadows
 * 
 * ItemShadowDust
 * 
 * @author schadwe
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ItemShadowDust extends ItemSOS {

    public ItemShadowDust(int id) {
        super(id);
        this.setUnlocalizedName(Strings.SHADOW_DUST_NAME);
        this.setCreativeTab(StuffOfShadows.tabSOS);
        maxStackSize = 64;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation) {
    	info.add("TEST");
    }

}
