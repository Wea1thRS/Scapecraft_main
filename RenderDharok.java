package net.minecraft.src;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderDharok extends RenderLiving {

	protected void preRenderScale(EntityDharok par1EntityNameHere, float par2) {
		// These values are x,y,z scale. Where 1.0F = 100% (original size)
		GL11.glScalef(1.0F, 1.0F, 1.0F);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
		this.preRenderScale((EntityDharok) par1EntityLivingBase, par2);
	}

	public RenderDharok(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}

	public void renderDharok(EntityDharok par1EntityDharok, double par2, double par4, double par6, float par8,
			float par9) {
		super.doRenderLiving(par1EntityDharok, par2, par4, par6, par8, par9);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8,
			float par9) {
		renderDharok((EntityDharok) par1EntityLiving, par2, par4, par6, par8, par9);
	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		renderDharok((EntityDharok) par1Entity, par2, par4, par6, par8, par9);
	}

	private static final ResourceLocation textureLocation = new ResourceLocation("textures/entity/Dharok.png");

	protected ResourceLocation func_110779_a(EntityDharok par1EntityDharok) {
		return textureLocation;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return textureLocation;
	}
}