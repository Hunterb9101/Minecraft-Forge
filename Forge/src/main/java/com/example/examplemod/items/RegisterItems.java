package com.example.examplemod.items;

import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegisterItems {
	public static Item exampleItem;
	public static Item tutorialChocolate;
	public static void createItems(){
		GameRegistry.registerItem(exampleItem = new ExampleItem("example"),"tutorial" );
		
		GameRegistry.registerItem(tutorialChocolate = new ExampleFoodItem("tutorial_chocolate", 2, 0.2f, false,
			    new PotionEffect(Potion.moveSpeed.id, 1200, 3),
			    new PotionEffect(Potion.jump.id, 600, 1),
			    new PotionEffect(Potion.regeneration.id, 200, 2))
			    .setAlwaysEdible(), "tutorial_chocolate");
	}
}
