package schadwe.sos.core.handlers;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;
import schadwe.sos.configuration.ConfigurationSettings;
import schadwe.sos.core.fear.FearCore;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

/**
 * Stuff Of Shadows
 * 
 * FearTickHandler
 * 
 * @author schadwe
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class PlayerTickHandler implements ITickHandler {
	int tickCounter = 0;

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {

	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		tickCounter++;
		if(tickCounter > ConfigurationSettings.FEAR_TICK_TIMING) {
			Minecraft mc = ModLoader.getMinecraftInstance();
			FearCore.processLightLevel(mc.theWorld.getBlockLightValue((int)Math.floor(mc.thePlayer.posX), (int)Math.floor(mc.thePlayer.posY), (int)Math.floor(mc.thePlayer.posZ)));
			tickCounter = 0;
			EntityPlayer entityplayer = mc.thePlayer;
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.PLAYER);
	}

	@Override
	public String getLabel() {
		return "Fear Tick Handler";
	}

}
