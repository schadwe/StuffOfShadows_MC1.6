package schadwe.sos.core.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import schadwe.sos.configuration.ConfigurationSettings;
import schadwe.sos.core.fear.FearCore;
import cpw.mods.fml.common.IPlayerTracker;

public class GenericEventHandler implements IPlayerTracker {

    @ForgeSubscribe
    public void onEntityConstruct(EntityEvent.EntityConstructing event) {
        if (event.entity instanceof EntityPlayer) {
            event.entity.registerExtendedProperties(FearCore.IDENTIFIER, new FearCore((EntityPlayer) event.entity));
        }
    }
    
    @ForgeSubscribe
    public void damageEventHandler(LivingAttackEvent event) {
    	if (ConfigurationSettings.FEAR_FROM_DAMAGE && (event.entity instanceof EntityPlayer)){
    		double damage = event.ammount;
    		FearCore.addFearLevel((int)damage);
    	}
    }

    @Override
    public void onPlayerChangedDimension(EntityPlayer player) {
        FearCore.forPlayer(player);
        FearCore.setDirty();
    }

    @Override
    public void onPlayerLogin(EntityPlayer player) {
    }

    @Override
    public void onPlayerLogout(EntityPlayer player) {
    }

    @Override
    public void onPlayerRespawn(EntityPlayer player) {
    	FearCore.setFearLevel(0);
        FearCore.forPlayer(player);
        FearCore.setDirty();
    }
}
