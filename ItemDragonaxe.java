package net.minecraft.src;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemDragonaxe extends ItemTool {
	private static Block blocksEffectiveAgainst[];

	protected ItemDragonaxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, 3, par2EnumToolMaterial, blocksEffectiveAgainst);
	}

	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
		if (par2Block != null && par2Block.blockMaterial == Material.wood) {
			return efficiencyOnProperMaterial;
		} else {
			return super.getStrVsBlock(par1ItemStack, par2Block);
		}
	}

	static {
		blocksEffectiveAgainst = (new Block[] { Block.planks, Block.bookShelf, Block.wood, Block.chest,
				Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern,
				mod_MagicTree.Magiclog });
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		{
			this.itemIcon = ir.registerIcon("Dragonaxe");
		}
	}
}