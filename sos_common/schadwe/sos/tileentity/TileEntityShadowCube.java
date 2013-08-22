package schadwe.sos.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import schadwe.sos.lib.BlockIds;

/**
 * Stuff Of Shadows
 * 
 * TileEntityShadowCube
 * 
 * @author schadwe
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class TileEntityShadowCube extends TileEntity{
	
	private boolean spreadComplete;
	
	public TileEntityShadowCube() {
		spreadComplete = false;
	}
	
	@Override
	public void updateEntity() {
		if (!worldObj.isRemote) {
			if (!spreadComplete) {
				spread(xCoord + 1, yCoord, zCoord);
				spread(xCoord - 1, yCoord, zCoord);
				spread(xCoord, yCoord, zCoord + 1);
				spread(xCoord, yCoord, zCoord - 1);
				spread(xCoord, yCoord + 1, zCoord);
				spread(xCoord, yCoord - 1, zCoord);
				worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 1, 3);
				
				spreadComplete = true;
			}
		}
	}
	
	private void spread(int x, int y, int z) {
		if ((worldObj.isAirBlock(x, y, z)) && (worldObj.getBlockId(x, y, z) != BlockIds.DARKNESS)) {
			worldObj.setBlock(x, y, z, BlockIds.DARKNESS);
			
			TileEntityDarkness darkness = (TileEntityDarkness)worldObj.getBlockTileEntity(x, y, z);
			darkness.level = 0;
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		compound.setBoolean("Spread", (boolean)spreadComplete);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		spreadComplete = compound.getBoolean("Spread");
	}

}
