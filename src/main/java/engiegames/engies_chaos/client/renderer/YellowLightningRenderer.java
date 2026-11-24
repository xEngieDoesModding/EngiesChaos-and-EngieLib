package engiegames.engies_chaos.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import engiegames.engies_chaos.procedures.YellowLightningScaleProcedure;
import engiegames.engies_chaos.entity.YellowLightningEntity;
import engiegames.engies_chaos.client.model.Modelmissilebeam;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class YellowLightningRenderer extends MobRenderer<YellowLightningEntity, Modelmissilebeam<YellowLightningEntity>> {
	public YellowLightningRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmissilebeam<YellowLightningEntity>(context.bakeLayer(Modelmissilebeam.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<YellowLightningEntity, Modelmissilebeam<YellowLightningEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("engies_chaos:textures/entities/yellowlightningbeam.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, YellowLightningEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				EntityModel model = new Modelmissilebeam(Minecraft.getInstance().getEntityModels().bakeLayer(Modelmissilebeam.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	protected void scale(YellowLightningEntity entity, PoseStack poseStack, float f) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		float scale = (float) YellowLightningScaleProcedure.execute(entity);
		poseStack.scale(scale, scale, scale);
	}

	@Override
	public ResourceLocation getTextureLocation(YellowLightningEntity entity) {
		return new ResourceLocation("engies_chaos:textures/entities/nothingness2.png");
	}

	@Override
	protected boolean isBodyVisible(YellowLightningEntity entity) {
		return false;
	}
}