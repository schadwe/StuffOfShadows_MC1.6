package schadwe.sos.block;

import schadwe.sos.StuffOfShadows;
import schadwe.sos.lib.Strings;
import schadwe.sos.block.BlockSOS;

import net.minecraft.block.material.Material;

/**
 * Stuff Of Shadows
 * 
 * BlockShadowStone
 * 
 * @author schadwe
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class BlockShadowStone extends BlockSOS {
    public BlockShadowStone(int id) {

        super(id, Material.rock);
        this.setUnlocalizedName(Strings.SHADOW_STONE_NAME);
        this.setCreativeTab(StuffOfShadows.tabSOS);
        this.setHardness(5F);
        this.setResistance(500f);
    }

}
