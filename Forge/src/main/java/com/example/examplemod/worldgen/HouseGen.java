package com.example.examplemod.worldgen;

import java.util.HashMap;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class HouseGen extends StructureMap {
	static String[][][] map = new String[][][]{
		// Layer 1
		{
			{"w","w","w","w"},
			{"w","w","w","w"},
			{"w","w","w","w"},
			{"w","w","w","w"},
		},
		
		// Layer 2
		{
			{"w","p","p","w"},
			{"p","f","c","p"},
			{"p","a","a","p"},
			{"w","d","p","w"},
		},
		
		// Layer 3
		{
			{"w","p","p","w"},
			{"p","a","a","p"},
			{"p","a","a","p"},
			{"w","d2","p","w"},
		},
		
		// Layer 4
		{
			{"w","p","p","w"},
			{"p","a","a","p"},
			{"p","a","a","p"},
			{"w","p","p","w"},
		},
		
		//Layer 5
		{
			{"w","p","p","w"},
			{"p","w","w","p"},
			{"p","w","w","p"},
			{"w","p","p","w"},
		},
		
	};
	
	static HashMap<String,Block> key = new HashMap<String,Block>();
	public HouseGen() {

		super(map, key);
		key.put("a",Blocks.air);
		key.put("p", Blocks.planks);
		key.put("w", Blocks.cobblestone);
		key.put("c", Blocks.crafting_table);
		key.put("f", Blocks.furnace);
		key.put("d", Blocks.oak_door);
		key.put("d2", Blocks.oak_door);
		
		blockStateKey.put("d2", Blocks.oak_door.getDefaultState().withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER));
		
		// TODO Auto-generated constructor stub
	}
}
