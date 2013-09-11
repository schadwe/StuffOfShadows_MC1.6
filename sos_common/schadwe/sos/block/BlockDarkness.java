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
import schadwe.sos.tileentity.TileEntityDarkness;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Stuff Of Shadows
 * 
 * BlockDarkness
 * 
 * @author schadwe
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class BlockDarkness extends BlockContainer {

	public BlockDarkness(int id) {
		super(id, Material.air);

		this.setUnlocalizedName(Strings.DARKNESS_NAME);
        this.setCreativeTab(StuffOfShadows.tabSOS);
		setBlockBounds(0, 0, 0, 0, 0, 0);
		//setTickRandomly(true);
		setLightOpacity(215);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Strings.DARKNESS_NAME);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityDarkness();
	}
	
	@Override
	public int idDropped(int meta, Random random, int fortune) {
		return -1;
	}
	
    @Override
    public boolean isBlockNormalCube(World world, int x, int y, int z) {
        return false;
    }
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	@Override
	public boolean isCollidable(){
	    return false;
	}
	
	@Override
	public boolean isAirBlock(World world, int x, int y, int z){
	    return true;
	}
	
	@Override
	public boolean canBeReplacedByLeaves(World world, int x, int y, int z){
	    return true;
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
		if (world.getBlockId(x, y, z) == BlockIds.DARKNESS || world.getBlockId(x, y, z) == BlockIds.SHADOW_CUBE) {
			world.destroyBlock(x, y, z, false);
		}
	}
}
