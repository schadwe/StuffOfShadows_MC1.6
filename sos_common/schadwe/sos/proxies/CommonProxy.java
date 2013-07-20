package schadwe.sos.proxies;

import schadwe.sos.core.handlers.PlayerTickHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;


/**
 * Stuff Of Shadows
 * 
 * CommonProxy
 * 
 * @author schadwe
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class CommonProxy {
	public void initRenderers() {

	}

	public void initSounds() {

	}
	
	public void registerHandlers(){
		TickRegistry.registerTickHandler(new PlayerTickHandler(), Side.SERVER);
	}
}
