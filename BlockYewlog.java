package net.minecraft.src;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class BlockYewlog extends Block {

	protected BlockYewlog(int i, int j) {
		super(i, Material.wood);
		this.setCreativeTab(CreativeTabs.tabBlock);

		MinecraftForge.setBlockHarvestLevel(mod_YewTree.Yewlog, 0, "axe", 2);
		setTickRandomly(true);

	}

	public int quantityDropped(Random random) {
		return 1;
	}

	public int idDropped(int i, Random random, int j) {
		return mod_YewTree.Yewlog.blockID;
	}

	public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l) {
		super.harvestBlock(world, entityplayer, i, j, k, l);
	}

	public void onBlockRemoval(World world, int i, int j, int k) {
		byte byte0 = 4;
		int l = byte0 + 1;
		if (world.checkChunksExist(i - l, j - l, k - l, i + l, j + l, k + l)) {
			for (int i1 = -byte0; i1 <= byte0; i1++) {
				for (int j1 = -byte0; j1 <= byte0; j1++) {
					for (int k1 = -byte0; k1 <= byte0; k1++) {
						int l1 = world.getBlockId(i + i1, j + j1, k + k1);
						if (l1 != mod_YewTree.Yewleaf.blockID) {
							continue;
						}
						int i2 = world.getBlockMetadata(i + i1, j + j1, k + k1);
						if ((i2 & 8) == 0) {
							world.setBlock(i + i1, j + j1, k + k1, i2 | 8);
						}
					}

				}

			}

		}
	}

	public void updateTick(World world, int x, int y, int z, Random par5Random)

	{

		EntityBot entity = new EntityBot(world);
		entity.setLocationAndAngles(x + 5, y - 1, z + 2, world.rand.nextFloat() * 360.0F, 0.0F);
		world.spawnEntityInWorld(entity);

	}

	public int damageDropped(int i) {
		return i;
	}

	@SideOnly(Side.CLIENT)
	private Icon field_94393_a;
	@SideOnly(Side.CLIENT)
	private Icon field_94392_b;

	public Icon getIcon(int par1, int par2) {
		return par1 == 0 ? this.field_94392_b : (par1 == 1 ? this.field_94393_a : this.blockIcon);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		this.blockIcon = ir.registerIcon("yewlog0");// side
		this.field_94393_a = ir.registerIcon("yewlog1");// Top
		this.field_94392_b = ir.registerIcon("yewlog1");// Bottom
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < 2; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}
	}
}
