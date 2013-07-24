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
	public static int getFearLevel(){
		return fearLevel;
	}
	
	public static void processLightLevel(int lightLevel){
		setFear(fearLevel + (7 - lightLevel)/2);
	}
	
	public static void setFearLevel(int fear){
		setFear(fear);
	}
	
	public static void addFearLevel(int fear){
		setFear(fearLevel + fear);
	}
	
	private static void setFear(int fear){
		if (fear > MAX_FEAR) {
			fearLevel = 100;
		} else if (fear < MIN_FEAR) {
			fearLevel = 0;
		} else {
			fearLevel = fear;
		}
		
		setDirty();
	}
	
	public static void setDirty() {
		dirty = true;
	}
}
