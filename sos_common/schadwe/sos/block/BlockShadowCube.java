package schadwe.sos.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import schadwe.sos.StuffOfShadows;
import schadwe.sos.lib.BlockIds;
import schadwe.sos.lib.Reference;
import schadwe.sos.lib.Strings;
import schadwe.sos.tileentity.TileEntityShadowCube;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Stuff Of Shadows
 * 
 * BlockShadowCube
 * 
 * @author schadwe
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class BlockShadowCube extends BlockContainer {
	
    public BlockShadowCube(int id) {
        super(id, Material.glass);
        
        this.setUnlocalizedName(Strings.SHADOW_CUBE_NAME);
        this.setCreativeTab(StuffOfShadows.tabSOS);
        this.setHardness(2F);
        this.setResistance(10f);
    }
    
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Strings.SHADOW_CUBE_NAME);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityShadowCube();
	}
	
	@Override
	public int idDropped(int meta, Random random, int fortune) {
	    // -1 = Nothing is dropped
		return -1;
	}
	
	@Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6)
    {
        super.breakBlock(world, x, y, z, par5, par6);

        breakNeighbors(world, x, y, z);
    }
	
	private void breakNeighbors(World world, int x, int y, int z){
        breakNeighbor(world, x + 1, y, z);
        breakNeighbor(world, x - 1, y, z);
        breakNeighbor(world, x, y + 1, z);
        breakNeighbor(world, x, y - 1, z);
        breakNeighbor(world, x, y, z + 1);
        breakNeighbor(world, x, y, z - 1);
	}
	
	private void breakNeighbor(World world, int x, int y, int z){
		if (world.getBlockId(x, y, z) == BlockIds.DARKNESS) {
			world.destroyBlock(x, y, z, false);
		}
	}
}
