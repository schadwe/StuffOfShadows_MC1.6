package schadwe.sos.core.handlers;

import java.util.EnumSet;

import schadwe.sos.gui.GuiFearMeter;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
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
		if(tickCounter > 20) {
			Minecraft mc = ModLoader.getMinecraftInstance();
			int xpos = (int) Math.floor(mc.thePlayer.posX);
			int ypos = (int) Math.floor(mc.thePlayer.posY);
			int zpos = (int) Math.floor(mc.thePlayer.posZ);
			int lightLevel = mc.theWorld.getBlockLightValue(xpos, ypos, zpos);
			System.out.println("*** Current Light Level: " + lightLevel);
			GuiFearMeter.fearLevel = lightLevel;
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
