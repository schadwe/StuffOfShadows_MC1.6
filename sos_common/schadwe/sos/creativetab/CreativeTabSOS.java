package schadwe.sos.creativetab;

import schadwe.sos.lib.ItemIds;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Stuff Of Shadows
 * 
 * CreativeTabSOS
 * 
 * @author schadwe
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class CreativeTabSOS extends CreativeTabs{
    public CreativeTabSOS(int par1, String par2Str) {

        super(par1, par2Str);
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * This item will be displayed on the creative tab
     */
    public int getTabIconItemIndex() {

        return ItemIds.SHADOW_DUST;
    }
}
