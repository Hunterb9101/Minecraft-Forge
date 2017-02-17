package com.example.examplemod.worldgen;

import java.util.HashMap;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class StructureMap extends WorldGenerator {
	String[][][] map;
	static HashMap<String,IBlockState> blockStateKey = new HashMap<String,IBlockState>();
	
	HashMap<String,Block> key;
	
	public StructureMap(String[][][] map, HashMap<String,Block> key){
		this.map = map;
		this.key = key;
	}
	
	public void generate(World worldIn, int x, int y, int z){
		Block block;
		IBlockState blockState;
		/*
		for(int iZ=0; iZ < map.length; iZ++){

		}
		*/
		
		for(int iY = 0; iY < map.length; iY++ ){
			for(int iX=0; iX < map[iY].length; iX++){
				for(int iZ=0; iZ < map[iY][iX].length; iZ++){
					block = key.get(map[iY][iX][iZ]);
					
					blockState = blockStateKey.get(map[iY][iX][iZ]);
					if(blockState == null){
						blockState = block.getDefaultState();
					}
					
					worldIn.setBlockState(new BlockPos(x + iX, y + iY, z + iZ), blockState, 2);
				}
			}
		}
		
		System.out.println("Generated Structure at:" + x + ", " + y + ", " + z);
		
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		generate(worldIn, position.getX(), getGroundFromAbove(worldIn,position.getX(),position.getZ()), position.getZ());
		return false;
	}
	
	
	public static int getGroundFromAbove(World world, int x, int z)
	{
		int y = 255;
		boolean foundGround = false;
		while(!foundGround && y-- >= 0)
		{
			Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			// "ground" for our bush is grass or dirt
			foundGround = blockAt == Blocks.dirt || blockAt == Blocks.grass;
		}
		return y;
	}
}
