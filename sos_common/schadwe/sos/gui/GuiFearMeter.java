package schadwe.sos.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import schadwe.sos.core.fear.Fear;

/**
 * Stuff Of Shadows
 * 
 * GuiFearMeter
 * 
 * @author schadwe
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class GuiFearMeter {
	  private Minecraft mc;
	  public static int fearLevel;

	  public GuiFearMeter(Minecraft mc)
	  {
	    super();
	    this.mc = mc;
	  }
	  
	  @ForgeSubscribe(priority = EventPriority.NORMAL)
	  public void onRenderExperienceBar(RenderGameOverlayEvent event) {
		    if(event.isCancelable() || event.type != ElementType.EXPERIENCE)
		    {      
		      return;
		    }

		    // Text position temp location.  Pixels from top left.
		    int xPos = 2;
		    int yPos = 2;
		    
		    FontRenderer fontRender = this.mc.fontRenderer;
			ScaledResolution sclRes = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
			
			//fontRender.drawStringWithShadow("This is the test string!", xPos, yPos, 0xffffffff);
			fontRender.drawStringWithShadow(Integer.toString(fearLevel), xPos, yPos, 0xffffffff);
	  }
}
