package com.example.examplemod.biome;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenAlpineForest extends BiomeGenBase {

	public BiomeGenAlpineForest(int id) {
		super(id);
		topBlock = (IBlockState)Blocks.grass.getDefaultState();
		fillerBlock = (IBlockState)Blocks.dirt.getDefaultState();
		this.setHeight(height_MidHills);
		this.setColor(8947712);
		// TODO Auto-generated constructor stub
	}
	
	public int getGrassColorAtPos(BlockPos p_180627_1_){
	return 16746496;
}

    public int getFoliageColorAtPos(int x, int y, int z)
{
	return 8947712;
}

}
