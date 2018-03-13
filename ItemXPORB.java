package net.minecraft.src;

import org.lwjgl.input.Keyboard;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;

public class ItemXPORB extends Item {

	public ItemXPORB(int i) {
		super(i);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

	public boolean hasEffect(ItemStack itemstack) {
		return false;
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			ExtendedPlayer.get(entityplayer).addXp(itemstack.stackSize);
			itemstack.stackSize = 0;
			return itemstack;
		} else {
			ExtendedPlayer.get(entityplayer).addXp(1);
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