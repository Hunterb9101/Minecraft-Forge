package com.example.examplemod.items;

import com.example.examplemod.Main;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class ItemRenderRegister {
	public static String modid = Main.MODID;
	
    public static void registerItemRenderer() {
    	reg(RegisterItems.exampleItem);
    	reg(RegisterItems.tutorialChocolate);
    }
    
    public static void reg(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
        .register(item, 0, new ModelResourceLocation(modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
