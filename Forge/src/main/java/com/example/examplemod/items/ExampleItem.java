package com.example.examplemod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ExampleItem extends Item {
	public ExampleItem(String unlocalizedName){
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
