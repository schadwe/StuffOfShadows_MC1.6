package schadwe.sos.core.fear;

import net.minecraft.nbt.NBTTagCompound;

/**
 * Stuff Of Shadows
 * 
 * Fear
 * 
 * @author schadwe
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class Fear {
	
	static private int fearLevel;
	 
    public Fear()
    {
        //default values
    	fearLevel = 0;
    }

    public void readFromNBTTagCompound(NBTTagCompound compound) {
            //read the values you need
    }

    public void writeToNBTTagCompound(NBTTagCompound compound) {
            //write the values
    }
	
	public static int getFearLevel(){
		return fearLevel;
	}
	public static void setFearLevel(int fear){
		fearLevel = fear;
	}

}
