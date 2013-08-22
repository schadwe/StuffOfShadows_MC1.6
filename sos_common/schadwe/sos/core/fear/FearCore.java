package schadwe.sos.core.fear;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.ModLoader;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import schadwe.sos.configuration.ConfigurationSettings;

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
	public static final int VISUAL_HALLUCINATION_DIST = 5;
	public static final int VISUAL_HALLUCINATION_DELAY_MS = 2000;
	
	public static FearCore forPlayer(Entity player){
		return (FearCore) player.getExtendedProperties(IDENTIFIER);
	}
	
	public static boolean dirty = true;
	
	private static int fearLevel;
	
	private static EntityPlayer player;
	
	public FearCore(EntityPlayer p){
		player = p;
	}
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound nbt = new NBTTagCompound();	
		nbt.setInteger("fear", fearLevel);
		compound.setCompoundTag(IDENTIFIER, nbt);		
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound nbt = compound.getCompoundTag(IDENTIFIER);
		
		fearLevel = nbt.getInteger("fear");
	}

	@Override
	public void init(Entity entity, World world) {
	}
	
	// Fear Access Methods
	
	public static int getFearLevel(){
		return fearLevel;
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
	
	// Fear events
	
	public static void processLightLevel(int lightLevel){
	     setFear(fearLevel + (7 - lightLevel)/2);
	}
	
	// Only activate sound 10% of the time for now
	public static void processAudioHallucination(){
        if (fearLevel >= ConfigurationSettings.FEAR_LEVEL_AUDIO_HALLUCINATIONS  && (int)(Math.random() * 100 + 1) <= 10){
            Minecraft mc = ModLoader.getMinecraftInstance();
            String mobSound;
            switch ((int)(Math.random() * 5 + 1)){
                case 1: 
                    mobSound = "mob.creeper.say";
                    break;
                case 2:
                    mobSound = "mob.zombie.say";
                    break;
                case 3:
                    mobSound = "mob.endermen.scream";
                    break;
                case 4:
                    mobSound = "mob.spider.say";
                    break;
                case 5:
                    mobSound = "mob.skeleton.say";
                    break;
                default:
                    mobSound = "mob.creeper.death";
                    break;
            }
            mc.theWorld.playSound(player.posX, player.posY, player.posZ, mobSound, 1.0F, 1.0F, true); 
        }
	}
	
	public static void processVisualHallucination(){
        if (fearLevel >= ConfigurationSettings.FEAR_LEVEL_VISUAL_HALLUCINATIONS  && (int)(Math.random() * 100 + 1) <= 5){
            // Add fake mob spawn and despawn here (Client side only)
            Minecraft mc = ModLoader.getMinecraftInstance();
            if (mc.theWorld.isRemote){
                // Get random mob
                //EntitySkeleton ent = new EntitySkeleton(mc.theWorld);
                Entity ent;
                switch ((int)(Math.random() * 5 + 1)){
                    case 1: 
                        ent = new EntityCreeper(mc.theWorld);
                        break;
                    case 2:
                        ent = new EntityZombie(mc.theWorld);
                        break;
                    case 3:
                        ent = new EntityEnderman(mc.theWorld);
                        break;
                    case 4:
                        ent = new EntitySpider(mc.theWorld);
                        break;
                    case 5:
                        ent = new EntitySkeleton(mc.theWorld);
                        break;
                    default:
                        ent = new EntitySnowman(mc.theWorld);
                        break;
                }
                
                // facing 0=S, 1=W, 2=N, 3=E (X=East, Z=South)
                switch (MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3){
                    case 0:
                        ent.setPosition(player.posX, player.posY, player.posZ + VISUAL_HALLUCINATION_DIST);
                        break;
                    case 1:
                        ent.setPosition(player.posX - VISUAL_HALLUCINATION_DIST, player.posY, player.posZ);
                        break;
                    case 2:
                        ent.setPosition(player.posX, player.posY, player.posZ - VISUAL_HALLUCINATION_DIST);
                        break;
                    case 3:
                        ent.setPosition(player.posX + VISUAL_HALLUCINATION_DIST, player.posY, player.posZ);
                        break;
                    default:
                        break;                            
                }

                //ent.spawnExplosionParticle();
                mc.theWorld.spawnEntityInWorld(ent);
                try {
                    Thread.sleep(VISUAL_HALLUCINATION_DELAY_MS);// delay in ms
                } catch(InterruptedException ex) {
                    //Thread.currentThread().interrupt();
                }
                mc.theWorld.removeEntity(ent);
                
                /*
                int yaw = (int)player.rotationYaw;
    
                if (yaw<0)              //due to the yaw running a -360 to positive 360
                  yaw+=360;    //not sure why it's that way
    
                yaw+=22;     //centers coordinates you may want to drop this line
                yaw%=360;  //and this one if you want a strict interpretation of the zones
    
                int facing = yaw/45;   //  360degrees divided by 45 == 8 zones
                System.out.println("Yaw is " + yaw + "facing is " + facing);
                */
            }
        }
	}
	
	public static void processEfficiencyReduction(){
	    if (fearLevel >= ConfigurationSettings.FEAR_LEVEL_EFFICIENCY_REDUCTION){
	        // Add Mining Fatigue and Damage Reduction
	        player.addPotionEffect((new PotionEffect(Potion.digSlowdown.getId(), 100, 0)));
	        player.addPotionEffect((new PotionEffect(Potion.weakness.getId(), 100, 0)));
	    }
	}
	
   public static void processNausia(){
        if (fearLevel >= ConfigurationSettings.FEAR_LEVEL_NAUSIA){
            // Add Nausia
            player.addPotionEffect((new PotionEffect(Potion.confusion.getId(), 100, 0)));
        }
    }
	   
    public static void processConfusion(){
        if (fearLevel >= ConfigurationSettings.FEAR_LEVEL_CONFUSION){
            // Add movement keymap change
        }
    }
}
