package com.example.examplemod;
import com.example.examplemod.items.RegisterItems;
import com.example.examplemod.worldgen.RoadGen;
import com.example.examplemod.worldgen.WorldGenerator;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
    	RegisterItems.createItems();
    }

    public void init(FMLInitializationEvent e) {
    	 GameRegistry.registerWorldGenerator(new WorldGenerator(), 0); // Mod World Generator
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}

