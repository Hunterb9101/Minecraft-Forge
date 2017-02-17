package com.example.examplemod;

import com.example.examplemod.items.ItemRenderRegister;
import com.example.examplemod.items.RegisterItems;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	 public void preInit(FMLPreInitializationEvent e) {
		 	super.preInit(e);
	    	//RegisterItems.createItems();
	    }

	    public void init(FMLInitializationEvent e) {
	    	super.init(e);
	    	ItemRenderRegister.registerItemRenderer();
	    }

	    public void postInit(FMLPostInitializationEvent e) {
	    	super.postInit(e);
	    }

}
