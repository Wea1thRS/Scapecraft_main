package net.minecraft.src;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenVarrock extends WorldGenerator {
	public WorldGenVarrock() {
	}

	public boolean generate(World world, Random rand, int i, int j, int k) {
		world.setBlock(i + 0, j + 0, k + 0, Block.dirt.blockID);
		return true;
	}
}