package com.example.examplemod.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class RoadGen extends WorldGenerator {
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		// we randomly pick between a bush with a cookie and a bush without a cookie
		Block road = Blocks.gravel;
		Block road2 = Blocks.cobblestone;
		
		//int y = getGroundFromAbove(worldIn, pos.getX(), pos.getZ()) + 1; // Get Y value of ground Add 1 to spawn above ground
		
		int nsLength = rand.nextInt(32);
		int ewLength = 3;
		
		int y;
		
		for(int ns = 0; ns < nsLength; ns++){
			for(int ew = 0; ew < ewLength; ew++){
				y = getGroundFromAbove(worldIn, pos.getX() + ew, pos.getZ() + ns); // Get Y value of ground Add 1 to spawn above ground
				BlockPos roadPos = new BlockPos(pos.getX() + ew, y, pos.getZ() + ns);
				
				if(rand.nextBoolean()){
					worldIn.setBlockState(roadPos, road.getDefaultState(), 2);
				}
				else{
					worldIn.setBlockState(roadPos, road2.getDefaultState(), 2);
				}
			}
		}
		
		return true;
	}

	// find a grass or dirt block to place the bush on
	public static int getGroundFromAbove(World world, int x, int z) {
		int y = 255;
		boolean surface = false;
		while(!surface && y-- >= 0){
			Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			surface = blockAt == Blocks.dirt || blockAt == Blocks.grass;
			//foundGround = blockAt != Blocks.air && blockAt.getMaterial() != Material.plants && blockAt.getMaterial() != Material.leaves && blockAt!= Blocks.water;
		}

		return y;
	}
}
