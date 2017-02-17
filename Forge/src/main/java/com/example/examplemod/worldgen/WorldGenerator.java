package com.example.examplemod.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenerator implements IWorldGenerator{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		int blockX = chunkX * 16;
		int blockZ = chunkZ * 16;
		
		// generate differently based on dimension
		switch(world.provider.getDimensionId())
		{
		case -1: generateNether(world, random, blockX, blockZ);
			break;
		case 0: generateOverworld(world, random, blockX, blockZ);
			break;
		case 1: generateEnd(world, random, blockX, blockZ);
			break;
		}

	}

	private void generateNether(World world, Random rand, int blockX, int blockZ) 
	{
		// leaving blank for now		
	}

	private void generateOverworld(World world, Random rand, int blockX, int blockZ) 
	{
		/** COOKIE BUSH GEN **/
		// make a world generator to use
		RoadGen genCookieBushes = new RoadGen();
		// get the biome. I used 64 for Y, but you can use anything between 0 and 255
		BiomeGenBase biome = world.getBiomeGenForCoords(new BlockPos(blockX, 64, blockZ));
		// check that it's a Plains biome
		// we could also use: if(biome instanceof BiomeGenPlains)
		if(biome == BiomeGenBase.plains){
			int randX = blockX + rand.nextInt(16);
			int randZ = blockZ + rand.nextInt(16);
			// the y-value we pass here will be used as minimum spawn height (in our generator, anyway)
			if(rand.nextInt(200) > 150){
				genCookieBushes.generate(world, rand, new BlockPos(randX, 24, randZ));
			}
			
			if(rand.nextInt(200) > 175){
				new HouseGen().generate(world, rand, new BlockPos(randX, 255, randZ));
			}
		}
	}

	private void generateEnd(World world, Random rand, int blockX, int blockZ) 
	{
		// leaving blank for now
	}

	/** HELPER METHODS **/

	// find a grass or dirt block to place the bush on
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
