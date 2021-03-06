package net.minecraft.src;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.models.Modeld2h;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderD2H implements IItemRenderer {

	protected Modeld2h D2HModel;

	public ItemRenderD2H() {
		D2HModel = new Modeld2h();
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

			float scale = 0.65F;
			GL11.glScalef(scale, scale, scale);
			Minecraft.getMinecraft().renderEngine.bindTexture(Resources.TEXTURE_D2H);

			GL11.glRotatef(90F, 1.0f, 0.0f, 0.0f);
			GL11.glRotatef(0F, 0.0f, 1.0f, 0.0f);
			GL11.glRotatef(45F, 0.0f, 0.0f, 1.0f);

			GL11.glTranslatef(-0.2F, 0F, -3.0F);

			D2HModel.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			// FMLClientHandler.instance().getClient().renderEngine.resetBoundTexture();

			GL11.glPopMatrix();
		}
			break;
		case EQUIPPED_FIRST_PERSON: {
			GL11.glPushMatrix();

			Minecraft.getMinecraft().renderEngine.bindTexture(Resources.TEXTURE_D2H);
			float scale = 0.40F;

			GL11.glScalef(scale, scale, scale);

			GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(320.0F, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(1.70F, 0.00F, 0F);
			D2HModel.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();

		}
		case EQUIPPED: {
			GL11.glPushMatrix();

			Minecraft.getMinecraft().renderEngine.bindTexture(Resources.TEXTURE_D2H);

			float scale = 0.40F;

			GL11.glScalef(scale, scale, scale);

			GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(320.0F, 0.0F, 0.0F, 1.0F);

			GL11.glTranslatef(1.70F, 0.00F, 0F);

			D2HModel.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

			// ForgeHooksClient.unbindTexture();

			GL11.glPopMatrix();

		}
		default:
			break;
		}
	}

}
