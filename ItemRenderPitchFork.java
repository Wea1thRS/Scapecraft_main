package net.minecraft.src;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.models.ModelPitchFork;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderPitchFork implements IItemRenderer {

	protected ModelPitchFork PitchforkModel;

	public ItemRenderPitchFork() {
		PitchforkModel = new ModelPitchFork();
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

			float scale = 1.75F;
			GL11.glScalef(scale, scale, scale);
			Minecraft.getMinecraft().renderEngine.bindTexture(Resources.TEXTURE_PITCHFORK);

			GL11.glRotatef(90F, 1.0f, 0.0f, 0.0f);
			GL11.glRotatef(0F, 0.0f, 1.0f, 0.0f);
			GL11.glRotatef(45F, 0.0f, 0.0f, 1.0f);

			GL11.glTranslatef(-0.2F, 0F, -0.3F);

			PitchforkModel.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			// FMLClientHandler.instance().getClient().renderEngine.resetBoundTexture();

			GL11.glPopMatrix();
		}
			break;
		case EQUIPPED_FIRST_PERSON: {
			GL11.glPushMatrix();

			Minecraft.getMinecraft().renderEngine.bindTexture(Resources.TEXTURE_PITCHFORK);

			float scale = 0.9F;

			GL11.glScalef(scale, scale, scale);

			GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(320.0F, 0.0F, 0.0F, 1.0F);

			GL11.glTranslatef(0.80F, -0.40F, 0.0F);

			PitchforkModel.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

			// ForgeHooksClient.unbindTexture();

			GL11.glPopMatrix();

		}
		case EQUIPPED: {
			GL11.glPushMatrix();

			Minecraft.getMinecraft().renderEngine.bindTexture(Resources.TEXTURE_PITCHFORK);

			float scale = 0.9F;

			GL11.glScalef(scale, scale, scale);

			GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(320.0F, 0.0F, 0.0F, 1.0F);

			GL11.glTranslatef(0.80F, -0.40F, 0.0F);

			PitchforkModel.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

			// ForgeHooksClient.unbindTexture();

			GL11.glPopMatrix();

		}
		default:
			break;
		}

	}

}
