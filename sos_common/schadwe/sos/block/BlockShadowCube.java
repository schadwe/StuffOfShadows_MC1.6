package schadwe.sos.block;

import schadwe.sos.StuffOfShadows;
import schadwe.sos.lib.Reference;
import schadwe.sos.lib.Strings;
import schadwe.sos.block.BlockSOS;

import net.minecraft.block.material.Material;

/**
 * Stuff Of Shadows
 * 
 * BlockShadowCube
 * 
 * @author schadwe
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class BlockShadowCube extends BlockSOS {
    public BlockShadowCube(int id) {
        super(id, Material.glass);
        this.setUnlocalizedName(Strings.SHADOW_CUBE_NAME);
        //this.func_111022_d(Reference.MOD_ID.toLowerCase() + ":" + Strings.SHADOW_CUBE_NAME);
        this.setCreativeTab(StuffOfShadows.tabSOS);
        this.setHardness(2F);
        this.setResistance(10f);
    }
}
