package schadwe.sos.item;

import schadwe.sos.StuffOfShadows;
import schadwe.sos.lib.Strings;


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

}
