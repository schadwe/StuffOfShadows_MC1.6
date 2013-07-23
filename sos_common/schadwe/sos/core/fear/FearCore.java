package schadwe.sos.core.fear;

import java.util.HashMap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

/**
 * Stuff Of Shadows
 * 
 * FearCore
 * 
 * @author schadwe
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public final class FearCore implements IExtendedEntityProperties{
	
	public static final String IDENTIFIER = "sos_playerinfo";
	
	public static final int MAX_FEAR = 100;
	public static final int MIN_FEAR = 0;
	
	public static FearCore forPlayer(Entity player){
		return (FearCore) player.getExtendedProperties(IDENTIFIER);
	}
	
	public static boolean dirty = true;
	
	private static int fearLevel;
	
	private final EntityPlayer player;
	
	public FearCore(EntityPlayer player){
		this.player = player;
	}
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound nbt = new NBTTagCompound();	
		nbt.setInteger("fear", this.fearLevel);
		compound.setCompoundTag(IDENTIFIER, nbt);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound nbt = compound.getCompoundTag(IDENTIFIER);
		
		this.fearLevel = nbt.getInteger("fear");
	}

	@Override
	public void init(Entity entity, World world) {
	}
	
	// Fear Access Methods
	public static void processLightLevel(int lightLevel){		
		fearLevel += (7 - lightLevel)/2;
		if (fearLevel > 100) fearLevel = 100;
		if (fearLevel < 0) fearLevel = 0;
		
		setDirty();
	}
	
	public static int getFearLevel(){
		return fearLevel;
	}
	public void setFearLevel(int fear){
		fearLevel = fear;
	}
	public void addFearLevel(int fear){
		fearLevel += fear;
	}
	
	public static void setDirty() {
		dirty = true;
	}
}
