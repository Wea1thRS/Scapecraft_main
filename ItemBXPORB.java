package net.minecraft.src;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBXPORB extends Item {

	public ItemBXPORB(int i) {
		super(i);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

	public boolean hasEffect(ItemStack itemstack) {
		return false;
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		if (entityplayer.isSneaking()) {
			ExtendedPlayer.get(entityplayer).addXp(itemstack.stackSize * 6);
			itemstack.stackSize = 0;
			return itemstack;
		} else {
			ExtendedPlayer.get(entityplayer).addXp(6);
			--itemstack.stackSize;
			return itemstack;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		{
			this.itemIcon = ir.registerIcon("xporb");
		}
	}
}
