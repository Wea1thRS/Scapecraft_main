package net.minecraft.src;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.models.ModelWhip;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderWhip implements IItemRenderer {

	protected ModelWhip WHIPModel;

	public ItemRenderWhip() {
		WHIPModel = new ModelWhip();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {

		switch (type) {
		case EQUIPPED:
			return true;
		case ENTITY:
			return true;
		case EQUIPPED_FIRST_PERSON:
			return true;
		default:
			return false;
		}

	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {

		case ENTITY: {
			GL11.glPushMatrix();

			float scale = 2.0F;
			GL11.glScalef(scale, scale, scale);
			// FMLClientHandler.instance().getClient().renderEngine.bindTexture("/mods/whip.png");
			Minecraft.getMinecraft().renderEngine.bindTexture(Resources.TEXTURE_Whip);

			GL11.glRotatef(90F, 1.0f, 0.0f, 0.0f);
			// GL11.glRotatef(0F, 0.0f, 1.0f, 0.0f);
			GL11.glRotatef(45F, 0.0f, 0.0f, 1.0f);

			GL11.glTranslatef(-0.2F, 0F, -0.5F);

			WHIPModel.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			// FMLClientHandler.instance().getClient().renderEngine.resetBoundTexture();

			GL11.glPopMatrix();

		}
			break;
		case EQUIPPED_FIRST_PERSON: {
			GL11.glPushMatrix();

			Minecraft.getMinecraft().renderEngine.bindTexture(Resources.TEXTURE_Whip);

			float scale = 1.15F;

			GL11.glScalef(scale, scale, scale);

			GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
			// GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(270.0F, 0.0F, 0.0F, 1.0F);

			GL11.glTranslatef(0.4F, 0.5F, 0.0F);

			WHIPModel.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

			// ForgeHooksClient.unbindTexture();

			GL11.glPopMatrix();

		}
		case EQUIPPED: {
			GL11.glPushMatrix();

			Minecraft.getMinecraft().renderEngine.bindTexture(Resources.TEXTURE_Whip);

			float scale = 1.15F;

			GL11.glScalef(scale, scale, scale);

			GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
			// GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(270.0F, 0.0F, 0.0F, 1.0F);

			GL11.glTranslatef(0.4F, 0.5F, 0.0F);

			WHIPModel.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

			// ForgeHooksClient.unbindTexture();

			GL11.glPopMatrix();

		}
		default:
			break;
		}
	}

}
