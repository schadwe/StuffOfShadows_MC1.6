package schadwe.sos.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import schadwe.sos.configuration.ConfigurationSettings;
import schadwe.sos.lib.BlockIds;

/**
 * Stuff Of Shadows
 * 
 * TileEntityDarkness
 * 
 * @author schadwe
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class TileEntityDarkness extends TileEntity {
	
	private static final boolean PLACED = false;
	
	int level;
	private boolean spreadComplete;
	
	public TileEntityDarkness() {
		level = 0;	
		spreadComplete = PLACED;
	}
	
	@Override
	public void updateEntity() {
		if (!worldObj.isRemote) {
			if (!spreadComplete && level < ConfigurationSettings.DARKNESS_SPREAD_LEVELS) {
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
			darkness.level = level + 1;
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		compound.setBoolean("Spread", (boolean)spreadComplete);
		compound.setByte("Level", (byte)level);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		spreadComplete = compound.getBoolean("Spread");
		level = compound.getByte("Level");
	}
}
