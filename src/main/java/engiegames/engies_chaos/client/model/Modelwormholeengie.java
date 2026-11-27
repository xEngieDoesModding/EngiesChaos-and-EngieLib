package engiegames.engies_chaos.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 5.2.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelwormholeengie<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("engies_chaos", "modelwormholeengie"), "main");
	public final ModelPart Root;
	public final ModelPart Head;
	public final ModelPart Goggles;
	public final ModelPart R2;
	public final ModelPart RSign2;
	public final ModelPart L2;
	public final ModelPart LSign2;
	public final ModelPart AngelHat;
	public final ModelPart Crown;
	public final ModelPart Body;
	public final ModelPart Scarf;
	public final ModelPart RightScarf;
	public final ModelPart RightScarf2;
	public final ModelPart RightScarf3;
	public final ModelPart RightScarf4;
	public final ModelPart RightScarf5;
	public final ModelPart RightScarf6;
	public final ModelPart RightScarf7;
	public final ModelPart RightScarf8;
	public final ModelPart RightScarf9;
	public final ModelPart LeftScarf;
	public final ModelPart LeftScarf2;
	public final ModelPart LeftScarf3;
	public final ModelPart LeftScarf4;
	public final ModelPart LeftScarf5;
	public final ModelPart LeftScarf6;
	public final ModelPart LeftScarf7;
	public final ModelPart LeftScarf8;
	public final ModelPart LeftScarf9;
	public final ModelPart LeftArm;
	public final ModelPart RightArm;
	public final ModelPart LeftLeg;
	public final ModelPart RightLeg;

	public Modelwormholeengie(ModelPart root) {
		this.Root = root.getChild("Root");
		this.Head = this.Root.getChild("Head");
		this.Goggles = this.Head.getChild("Goggles");
		this.R2 = this.Goggles.getChild("R2");
		this.RSign2 = this.R2.getChild("RSign2");
		this.L2 = this.Goggles.getChild("L2");
		this.LSign2 = this.L2.getChild("LSign2");
		this.AngelHat = this.Head.getChild("AngelHat");
		this.Crown = this.AngelHat.getChild("Crown");
		this.Body = this.Root.getChild("Body");
		this.Scarf = this.Body.getChild("Scarf");
		this.RightScarf = this.Scarf.getChild("RightScarf");
		this.RightScarf2 = this.RightScarf.getChild("RightScarf2");
		this.RightScarf3 = this.RightScarf2.getChild("RightScarf3");
		this.RightScarf4 = this.RightScarf3.getChild("RightScarf4");
		this.RightScarf5 = this.RightScarf4.getChild("RightScarf5");
		this.RightScarf6 = this.RightScarf5.getChild("RightScarf6");
		this.RightScarf7 = this.RightScarf6.getChild("RightScarf7");
		this.RightScarf8 = this.RightScarf7.getChild("RightScarf8");
		this.RightScarf9 = this.RightScarf8.getChild("RightScarf9");
		this.LeftScarf = this.Scarf.getChild("LeftScarf");
		this.LeftScarf2 = this.LeftScarf.getChild("LeftScarf2");
		this.LeftScarf3 = this.LeftScarf2.getChild("LeftScarf3");
		this.LeftScarf4 = this.LeftScarf3.getChild("LeftScarf4");
		this.LeftScarf5 = this.LeftScarf4.getChild("LeftScarf5");
		this.LeftScarf6 = this.LeftScarf5.getChild("LeftScarf6");
		this.LeftScarf7 = this.LeftScarf6.getChild("LeftScarf7");
		this.LeftScarf8 = this.LeftScarf7.getChild("LeftScarf8");
		this.LeftScarf9 = this.LeftScarf8.getChild("LeftScarf9");
		this.LeftArm = this.Root.getChild("LeftArm");
		this.RightArm = this.Root.getChild("RightArm");
		this.LeftLeg = this.Root.getChild("LeftLeg");
		this.RightLeg = this.Root.getChild("RightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Root = partdefinition.addOrReplaceChild("Root",
				CubeListBuilder.create().texOffs(16, 100).addBox(0.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.025F)).texOffs(0, 100).addBox(0.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.525F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition Head = Root.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(64, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(96, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)),
				PartPose.offset(0.0F, -24.0F, 0.0F));
		PartDefinition Goggles = Head.addOrReplaceChild("Goggles",
				CubeListBuilder.create().texOffs(73, 68).addBox(-4.0F, 0.6419F, -3.0662F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.025F)).texOffs(0, 118).addBox(-4.025F, 0.6419F, -2.0912F, 0.025F, 2.0F, 8.05F, new CubeDeformation(0.0F))
						.texOffs(0, 118).addBox(4.0F, 0.6419F, -2.0912F, 0.025F, 2.0F, 8.05F, new CubeDeformation(0.0F)).texOffs(0, 126).addBox(-4.025F, 0.6419F, 5.9088F, 8.05F, 2.0F, 0.05F, new CubeDeformation(0.0F)).texOffs(0, 119)
						.addBox(-2.025F, -2.4081F, -2.0912F, 4.05F, 0.05F, 8.05F, new CubeDeformation(0.0F)).texOffs(56, 64).addBox(2.025F, 0.45F, -2.7F, 0.2F, 0.2F, 0.2F, new CubeDeformation(0.0F)).texOffs(56, 64)
						.addBox(-2.225F, 0.45F, -2.7F, 0.2F, 0.2F, 0.2F, new CubeDeformation(0.0F)).texOffs(8, 124).addBox(-2.025F, -2.4081F, 5.9088F, 4.05F, 3.05F, 0.05F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -5.6419F, -1.9338F));
		PartDefinition cube_r1 = Goggles.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(8, 124).addBox(-2.025F, -0.025F, -0.025F, 4.05F, 3.15F, 0.05F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.3831F, -2.0662F, -0.1745F, 0.0F, 0.0F));
		PartDefinition R2 = Goggles.addOrReplaceChild("R2",
				CubeListBuilder.create().texOffs(77, 71).addBox(-0.9888F, -0.025F, -0.2882F, 2.0F, 0.025F, 0.65F, new CubeDeformation(0.0F)).texOffs(77, 71).addBox(-0.9888F, 2.0F, -0.2882F, 2.0F, 0.025F, 0.65F, new CubeDeformation(0.0F))
						.texOffs(77, 71).addBox(-1.0138F, 0.0F, -0.2882F, 0.025F, 2.0F, 0.65F, new CubeDeformation(0.0F)).texOffs(77, 71).addBox(-0.9888F, 0.0F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71)
						.addBox(-0.9888F, 0.25F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71).addBox(-0.7388F, 0.0F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71)
						.addBox(-0.9888F, 1.75F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71).addBox(-0.7388F, 1.75F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71)
						.addBox(-0.9888F, 1.5F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71).addBox(0.7362F, 1.75F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71)
						.addBox(0.7362F, 1.5F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71).addBox(0.4862F, 1.75F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71)
						.addBox(0.7362F, 0.25F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71).addBox(0.4862F, 0.0F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71)
						.addBox(0.7362F, 0.0F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71).addBox(0.9862F, 0.0F, -0.2882F, 0.025F, 2.0F, 0.65F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0112F, 0.6419F, -3.378F));
		PartDefinition cube_r2 = R2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(60, 90).mirror().addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(-4.95F)).mirror(false),
				PartPose.offsetAndRotation(0.0112F, 1.025F, 4.7118F, -3.1416F, 0.0F, 0.0F));
		PartDefinition cube_r3 = R2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(58, 78).addBox(-3.999F, -4.0F, -1.0F, 8.0F, 8.0F, 2.0F, new CubeDeformation(-3.0F)),
				PartPose.offsetAndRotation(0.0112F, 1.0F, 2.1118F, 0.0F, 3.1416F, 0.0F));
		PartDefinition RSign2 = R2.addOrReplaceChild("RSign2", CubeListBuilder.create(), PartPose.offset(-0.0013F, 0.0F, -0.2882F));
		PartDefinition cube_r4 = RSign2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(67, 113).mirror().addBox(-7.5F, -7.5F, 0.0F, 15.0F, 15.0F, 0.0F, new CubeDeformation(-6.625F)).mirror(false),
				PartPose.offsetAndRotation(0.0125F, 1.0F, 7.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition L2 = Goggles.addOrReplaceChild("L2",
				CubeListBuilder.create().texOffs(77, 71).addBox(-0.9888F, -0.025F, -0.2882F, 2.0F, 0.025F, 0.65F, new CubeDeformation(0.0F)).texOffs(77, 71).addBox(-0.9888F, 2.0F, -0.2882F, 2.0F, 0.025F, 0.65F, new CubeDeformation(0.0F))
						.texOffs(77, 71).addBox(-1.0138F, 0.0F, -0.2882F, 0.025F, 2.0F, 0.65F, new CubeDeformation(0.0F)).texOffs(77, 71).addBox(-0.9888F, 0.0F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71)
						.addBox(-0.9888F, 0.25F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71).addBox(-0.7388F, 0.0F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71)
						.addBox(-0.9888F, 1.75F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71).addBox(-0.7388F, 1.75F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71)
						.addBox(-0.9888F, 1.5F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71).addBox(0.7362F, 1.75F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71)
						.addBox(0.7362F, 1.5F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71).addBox(0.4862F, 1.75F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71)
						.addBox(0.7362F, 0.25F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71).addBox(0.4862F, 0.0F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71)
						.addBox(0.7362F, 0.0F, -0.2882F, 0.25F, 0.25F, 0.6F, new CubeDeformation(0.0F)).texOffs(77, 71).addBox(0.9862F, 0.0F, -0.2882F, 0.025F, 2.0F, 0.65F, new CubeDeformation(0.0F)).texOffs(110, 77)
						.addBox(-0.9888F, 0.0F, 1.2868F, 1.975F, 2.0F, 0.05F, new CubeDeformation(0.0F)).texOffs(110, 77).addBox(-4.9888F, 0.0F, 1.2868F, 1.975F, 2.0F, 0.05F, new CubeDeformation(0.0F)),
				PartPose.offset(1.9888F, 0.6419F, -3.378F));
		PartDefinition cube_r5 = L2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(60, 90).mirror().addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(-4.95F)).mirror(false),
				PartPose.offsetAndRotation(0.0112F, 1.025F, 4.7118F, -3.1416F, 0.0F, 0.0F));
		PartDefinition cube_r6 = L2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(58, 78).addBox(-3.999F, -4.0F, -1.0F, 8.0F, 8.0F, 2.0F, new CubeDeformation(-3.0F)),
				PartPose.offsetAndRotation(0.0112F, 1.0F, 2.1118F, 0.0F, 3.1416F, 0.0F));
		PartDefinition LSign2 = L2.addOrReplaceChild("LSign2", CubeListBuilder.create(), PartPose.offset(-0.0013F, 0.0F, -0.2882F));
		PartDefinition cube_r7 = LSign2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(81, 80).mirror().addBox(-7.5F, -7.5F, 0.0F, 15.0F, 15.0F, 0.0F, new CubeDeformation(-6.625F)).mirror(false),
				PartPose.offsetAndRotation(0.0125F, 1.0F, 7.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition AngelHat = Head.addOrReplaceChild("AngelHat",
				CubeListBuilder.create().texOffs(0, 11).addBox(-9.0F, 2.0F, -9.0F, 18.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 11).addBox(-8.0F, 1.5F, -8.0F, 16.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 14)
						.addBox(-7.0F, 1.0F, -7.0F, 14.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 17).addBox(-6.0F, 0.5F, -6.0F, 12.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 20)
						.addBox(-4.0F, -0.5F, -4.0F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 23).addBox(-2.0F, -1.5F, -2.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -7.75F, 0.0F));
		PartDefinition cube_r8 = AngelHat.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 30).addBox(-3.0F, 0.5F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-5.0F, 1.5F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 23).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 20)
						.addBox(-4.0F, 1.0F, -4.0F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 17).addBox(-6.0F, 2.0F, -6.0F, 12.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 14)
						.addBox(-7.0F, 2.5F, -7.0F, 14.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 11).addBox(-8.0F, 3.0F, -8.0F, 16.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 11)
						.addBox(-9.0F, 3.5F, -9.0F, 18.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.5F, 0.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition cube_r9 = AngelHat.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(0, 20).addBox(-2.0F, -0.5F, -4.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 17).addBox(-4.0F, 0.5F, -6.0F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(4, 14)
						.addBox(-5.0F, 1.0F, -7.0F, 10.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 11).addBox(-6.0F, 1.5F, -8.0F, 12.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 11)
						.addBox(-7.0F, 2.0F, -9.0F, 14.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
		PartDefinition cube_r10 = AngelHat.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(0, 20).addBox(-2.0F, -0.5F, -4.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 17).addBox(-4.0F, 0.5F, -6.0F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(4, 14)
						.addBox(-5.0F, 1.0F, -7.0F, 10.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 11).addBox(-6.0F, 1.5F, -8.0F, 12.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 11)
						.addBox(-7.0F, 2.0F, -9.0F, 14.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition Crown = AngelHat.addOrReplaceChild("Crown",
				CubeListBuilder.create().texOffs(46, 108).addBox(-5.0F, -0.4096F, -4.6F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.001F)).texOffs(46, 108).addBox(-5.0F, -0.4096F, 4.4F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.001F)).texOffs(69, 99)
						.addBox(4.0F, -0.4096F, -4.6F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.001F)).texOffs(68, 99).addBox(-5.0F, -0.4096F, -4.6F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.001F)).texOffs(68, 99)
						.addBox(4.0F, -1.4096F, -4.6F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.001F)).texOffs(68, 108).addBox(-5.0F, -1.4096F, 4.4F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.001F)).texOffs(68, 99)
						.addBox(-5.0F, -1.4096F, -4.6F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.001F)).texOffs(68, 108).addBox(-5.0F, -1.4096F, -4.6F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.001F)).texOffs(91, 108)
						.addBox(-1.0F, -2.4096F, -4.6F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.001F)).texOffs(97, 108).addBox(-1.0F, -1.4096F, -4.85F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.001F)).texOffs(97, 104)
						.addBox(-5.0F, -1.4096F, -4.85F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.001F)).texOffs(97, 106).addBox(3.0F, -1.4096F, -4.85F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.001F)).texOffs(97, 100)
						.addBox(-1.0F, -1.4096F, 4.65F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.001F)).texOffs(97, 98).addBox(-5.0F, -1.4096F, 4.65F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.001F)).texOffs(97, 102)
						.addBox(3.0F, -1.4096F, 4.65F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.001F)).texOffs(91, 108).addBox(-5.0F, -2.4096F, -4.6F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.001F)).texOffs(90, 107)
						.addBox(-5.0F, -2.4096F, -0.6F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)).texOffs(90, 107).addBox(4.0F, -2.4096F, -0.6F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)).texOffs(90, 107)
						.addBox(-5.0F, -2.4096F, 3.4F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)).texOffs(90, 107).addBox(4.0F, -2.4096F, 3.4F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)).texOffs(90, 107)
						.addBox(4.0F, -2.4096F, -4.6F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)).texOffs(97, 119).addBox(-5.25F, -1.4096F, -4.6F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)).texOffs(97, 125)
						.addBox(-5.25F, -1.4096F, 3.4F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)).texOffs(97, 122).addBox(-5.25F, -1.4096F, -0.6F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)).texOffs(97, 110)
						.addBox(4.25F, -1.4096F, -4.6F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)).texOffs(97, 113).addBox(4.225F, -1.4096F, -0.6F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)).texOffs(97, 116)
						.addBox(4.25F, -1.4096F, 3.4F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)).texOffs(90, 107).addBox(-5.0F, -2.4096F, -4.6F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.001F)).texOffs(91, 108)
						.addBox(3.0F, -2.4096F, -4.6F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.001F)).texOffs(91, 108).addBox(3.0F, -2.4096F, 4.4F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.001F)).texOffs(91, 108)
						.addBox(-5.0F, -2.4096F, 4.4F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.001F)).texOffs(91, 108).addBox(-1.0F, -2.4096F, 4.4F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.001F)),
				PartPose.offset(0.0F, 0.0F, -0.4F));
		PartDefinition Body = Root.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(80, 16).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(80, 32).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, -18.0F, 0.0F));
		PartDefinition Scarf = Body.addOrReplaceChild("Scarf",
				CubeListBuilder.create().texOffs(0, 71).addBox(-4.275F, -1.0F, -4.125F, 8.55F, 1.0F, 8.55F, new CubeDeformation(0.0F)).texOffs(0, 71).addBox(-4.25F, -0.5F, -3.475F, 8.5F, 2.0F, 6.925F, new CubeDeformation(0.05F)).texOffs(0, 71)
						.addBox(-4.25F, 1.325F, -1.575F, 8.5F, 2.0F, 3.0F, new CubeDeformation(0.05F)).texOffs(0, 71).addBox(-4.525F, -1.6F, -4.525F, 9.05F, 2.125F, 9.05F, new CubeDeformation(0.05F)).texOffs(0, 71)
						.addBox(-3.525F, -2.6F, -3.525F, 7.05F, 0.025F, 7.05F, new CubeDeformation(0.05F)),
				PartPose.offset(0.0F, -6.0F, 0.0F));
		PartDefinition cube_r11 = Scarf.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 71).addBox(-4.225F, -0.6625F, -2.0F, 8.45F, 1.325F, 4.0F, new CubeDeformation(0.05F)),
				PartPose.offsetAndRotation(0.0F, 1.4315F, 2.6042F, -2.3562F, 0.0F, 0.0F));
		PartDefinition cube_r12 = Scarf.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 71).addBox(-4.225F, -0.6625F, -2.0F, 8.45F, 1.325F, 4.0F, new CubeDeformation(0.05F)),
				PartPose.offsetAndRotation(0.0F, 1.4315F, -2.6208F, -0.7854F, 0.0F, 0.0F));
		PartDefinition cube_r13 = Scarf.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 71).addBox(-0.5F, -0.725F, -4.025F, 1.0F, 1.45F, 8.05F, new CubeDeformation(0.05F)),
				PartPose.offsetAndRotation(0.0091F, -1.7409F, 3.675F, 1.5708F, -0.7854F, -1.5708F));
		PartDefinition cube_r14 = Scarf.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 71).addBox(-0.5F, -0.725F, -4.025F, 1.0F, 1.45F, 8.05F, new CubeDeformation(0.05F)),
				PartPose.offsetAndRotation(0.0091F, -1.7409F, -3.675F, 1.5708F, 0.7854F, -1.5708F));
		PartDefinition cube_r15 = Scarf.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 71).addBox(-0.5F, -0.725F, -4.025F, 1.0F, 1.45F, 8.05F, new CubeDeformation(0.05F)),
				PartPose.offsetAndRotation(-3.6659F, -1.7409F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition cube_r16 = Scarf.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 71).addBox(-0.5F, -0.725F, -4.025F, 1.0F, 1.45F, 8.05F, new CubeDeformation(0.05F)),
				PartPose.offsetAndRotation(3.6591F, -1.7409F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition RightScarf = Scarf.addOrReplaceChild("RightScarf", CubeListBuilder.create().texOffs(0, 71).addBox(-1.275F, -0.1F, -0.1625F, 2.55F, 2.5F, 0.325F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, -1.4F, 4.5625F, 0.5236F, -0.0873F, 0.0873F));
		PartDefinition RightScarf2 = RightScarf.addOrReplaceChild("RightScarf2", CubeListBuilder.create().texOffs(0, 73).addBox(-1.375F, -0.1F, -0.1625F, 2.75F, 2.5F, 0.325F, new CubeDeformation(0.025F)),
				PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, -0.1309F, 0.0F, 0.0436F));
		PartDefinition RightScarf3 = RightScarf2.addOrReplaceChild("RightScarf3", CubeListBuilder.create().texOffs(0, 75).addBox(-1.475F, -0.1F, -0.1625F, 2.95F, 2.5F, 0.325F, new CubeDeformation(0.05F)),
				PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, -0.1309F, 0.0F, 0.0436F));
		PartDefinition RightScarf4 = RightScarf3.addOrReplaceChild("RightScarf4", CubeListBuilder.create().texOffs(0, 77).addBox(-1.575F, -0.1F, -0.1625F, 3.15F, 2.5F, 0.325F, new CubeDeformation(0.075F)),
				PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.0873F, 0.0F, 0.0436F));
		PartDefinition RightScarf5 = RightScarf4.addOrReplaceChild("RightScarf5", CubeListBuilder.create().texOffs(0, 79).addBox(-1.675F, -0.1F, -0.1625F, 3.35F, 2.5F, 0.325F, new CubeDeformation(0.1F)),
				PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, -0.1745F, 0.0F, 0.0436F));
		PartDefinition RightScarf6 = RightScarf5.addOrReplaceChild("RightScarf6", CubeListBuilder.create().texOffs(0, 81).addBox(-1.775F, -0.1F, -0.1625F, 3.55F, 2.5F, 0.325F, new CubeDeformation(0.125F)),
				PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, -0.1745F, 0.0F, 0.0436F));
		PartDefinition RightScarf7 = RightScarf6.addOrReplaceChild("RightScarf7", CubeListBuilder.create().texOffs(0, 83).addBox(-1.875F, -0.1F, -0.1625F, 3.75F, 2.5F, 0.325F, new CubeDeformation(0.15F)),
				PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, -0.1745F, 0.0F, 0.0436F));
		PartDefinition RightScarf8 = RightScarf7.addOrReplaceChild("RightScarf8", CubeListBuilder.create().texOffs(0, 84).addBox(-1.975F, -0.1F, -0.1625F, 3.95F, 2.5F, 0.325F, new CubeDeformation(0.175F)),
				PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, -0.1745F, 0.0F, 0.0436F));
		PartDefinition RightScarf9 = RightScarf8.addOrReplaceChild("RightScarf9",
				CubeListBuilder.create().texOffs(0, 85).addBox(-0.5747F, 0.9923F, -0.3124F, 1.0F, 1.0F, 0.325F, new CubeDeformation(0.0F)).texOffs(0, 85).addBox(-0.5747F, 1.8923F, -0.3124F, 1.0F, 1.0F, 0.325F, new CubeDeformation(-0.1F)),
				PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, -0.1745F, 0.0F, 0.0436F));
		PartDefinition cube_r17 = RightScarf9.addOrReplaceChild("cube_r17",
				CubeListBuilder.create().texOffs(0, 85).addBox(-1.9811F, 0.4047F, -0.1807F, 1.0F, 1.0F, 0.325F, new CubeDeformation(-0.1F)).texOffs(0, 85).addBox(-1.9784F, -0.4922F, -0.1807F, 1.0F, 1.0F, 0.325F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.1481F, 1.583F, -0.1317F, 0.0F, 0.0F, 0.1309F));
		PartDefinition cube_r18 = RightScarf9.addOrReplaceChild("cube_r18",
				CubeListBuilder.create().texOffs(0, 85).addBox(1.1265F, 0.4239F, -0.1807F, 1.0F, 1.0F, 0.325F, new CubeDeformation(-0.1F)).texOffs(0, 85).addBox(1.1239F, -0.473F, -0.1807F, 1.0F, 1.0F, 0.325F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.1481F, 1.583F, -0.1317F, 0.0F, 0.0F, -0.1309F));
		PartDefinition cube_r19 = RightScarf9.addOrReplaceChild("cube_r19",
				CubeListBuilder.create().texOffs(0, 85).addBox(-3.5292F, 0.774F, -0.1807F, 1.0F, 1.0F, 0.325F, new CubeDeformation(-0.1F)).texOffs(0, 85).addBox(-3.5043F, -0.1144F, -0.1807F, 1.0F, 1.0F, 0.325F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.1481F, 1.583F, -0.1317F, 0.0F, 0.0F, 0.3054F));
		PartDefinition cube_r20 = RightScarf9.addOrReplaceChild("cube_r20",
				CubeListBuilder.create().texOffs(0, 85).addBox(2.7168F, 0.8332F, -0.1807F, 1.0F, 1.0F, 0.325F, new CubeDeformation(-0.1F)).texOffs(0, 85).addBox(2.6919F, -0.0553F, -0.1807F, 1.0F, 1.0F, 0.325F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.1481F, 1.583F, -0.1317F, 0.0F, 0.0F, -0.3054F));
		PartDefinition LeftScarf = Scarf.addOrReplaceChild("LeftScarf", CubeListBuilder.create().texOffs(0, 71).addBox(-1.275F, -0.1F, -0.1625F, 2.55F, 2.5F, 0.325F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, -1.4F, 4.5625F, 0.5236F, 0.0873F, -0.0873F));
		PartDefinition LeftScarf2 = LeftScarf.addOrReplaceChild("LeftScarf2", CubeListBuilder.create().texOffs(0, 73).addBox(-1.375F, -0.1F, -0.1625F, 2.75F, 2.5F, 0.325F, new CubeDeformation(0.025F)),
				PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, -0.1309F, 0.0F, -0.0436F));
		PartDefinition LeftScarf3 = LeftScarf2.addOrReplaceChild("LeftScarf3", CubeListBuilder.create().texOffs(0, 75).addBox(-1.475F, -0.1F, -0.1625F, 2.95F, 2.5F, 0.325F, new CubeDeformation(0.05F)),
				PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, -0.1309F, 0.0F, -0.0436F));
		PartDefinition LeftScarf4 = LeftScarf3.addOrReplaceChild("LeftScarf4", CubeListBuilder.create().texOffs(0, 77).addBox(-1.575F, -0.1F, -0.1625F, 3.15F, 2.5F, 0.325F, new CubeDeformation(0.075F)),
				PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.0873F, 0.0F, -0.0436F));
		PartDefinition LeftScarf5 = LeftScarf4.addOrReplaceChild("LeftScarf5", CubeListBuilder.create().texOffs(0, 79).addBox(-1.675F, -0.1F, -0.1625F, 3.35F, 2.5F, 0.325F, new CubeDeformation(0.1F)),
				PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, -0.1745F, 0.0F, -0.0436F));
		PartDefinition LeftScarf6 = LeftScarf5.addOrReplaceChild("LeftScarf6", CubeListBuilder.create().texOffs(0, 81).addBox(-1.775F, -0.1F, -0.1625F, 3.55F, 2.5F, 0.325F, new CubeDeformation(0.125F)),
				PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, -0.1745F, 0.0F, -0.0436F));
		PartDefinition LeftScarf7 = LeftScarf6.addOrReplaceChild("LeftScarf7", CubeListBuilder.create().texOffs(0, 83).addBox(-1.875F, -0.1F, -0.1625F, 3.75F, 2.5F, 0.325F, new CubeDeformation(0.15F)),
				PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, -0.1745F, 0.0F, -0.0436F));
		PartDefinition LeftScarf8 = LeftScarf7.addOrReplaceChild("LeftScarf8", CubeListBuilder.create().texOffs(0, 84).addBox(-1.975F, -0.1F, -0.1625F, 3.95F, 2.5F, 0.325F, new CubeDeformation(0.175F)),
				PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, -0.1745F, 0.0F, -0.0436F));
		PartDefinition LeftScarf9 = LeftScarf8.addOrReplaceChild("LeftScarf9",
				CubeListBuilder.create().texOffs(0, 85).addBox(-0.5748F, 0.9923F, -0.3124F, 1.0F, 1.0F, 0.325F, new CubeDeformation(0.0F)).texOffs(0, 85).addBox(-0.5748F, 1.8923F, -0.3124F, 1.0F, 1.0F, 0.325F, new CubeDeformation(-0.1F)),
				PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, -0.1745F, 0.0F, -0.0436F));
		PartDefinition cube_r21 = LeftScarf9.addOrReplaceChild("cube_r21",
				CubeListBuilder.create().texOffs(0, 85).addBox(-1.9811F, 0.4047F, -0.1807F, 1.0F, 1.0F, 0.325F, new CubeDeformation(-0.1F)).texOffs(0, 85).addBox(-1.9784F, -0.4922F, -0.1807F, 1.0F, 1.0F, 0.325F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.1481F, 1.583F, -0.1317F, 0.0F, 0.0F, 0.1309F));
		PartDefinition cube_r22 = LeftScarf9.addOrReplaceChild("cube_r22",
				CubeListBuilder.create().texOffs(0, 85).addBox(1.1265F, 0.4239F, -0.1807F, 1.0F, 1.0F, 0.325F, new CubeDeformation(-0.1F)).texOffs(0, 85).addBox(1.1239F, -0.473F, -0.1807F, 1.0F, 1.0F, 0.325F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.1481F, 1.583F, -0.1317F, 0.0F, 0.0F, -0.1309F));
		PartDefinition cube_r23 = LeftScarf9.addOrReplaceChild("cube_r23",
				CubeListBuilder.create().texOffs(0, 85).addBox(-3.5292F, 0.774F, -0.1807F, 1.0F, 1.0F, 0.325F, new CubeDeformation(-0.1F)).texOffs(0, 85).addBox(-3.5043F, -0.1144F, -0.1807F, 1.0F, 1.0F, 0.325F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.1481F, 1.583F, -0.1317F, 0.0F, 0.0F, 0.3054F));
		PartDefinition cube_r24 = LeftScarf9.addOrReplaceChild("cube_r24",
				CubeListBuilder.create().texOffs(0, 85).addBox(2.7168F, 0.8332F, -0.1807F, 1.0F, 1.0F, 0.325F, new CubeDeformation(-0.1F)).texOffs(0, 85).addBox(2.6919F, -0.0553F, -0.1807F, 1.0F, 1.0F, 0.325F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.1481F, 1.583F, -0.1317F, 0.0F, 0.0F, -0.3054F));
		PartDefinition LeftArm = Root.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(96, 48).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(112, 48).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(4.0F, -22.0F, 0.0F));
		PartDefinition RightArm = Root.addOrReplaceChild("RightArm",
				CubeListBuilder.create().texOffs(104, 16).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(104, 32).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(-4.0F, -22.0F, 0.0F));
		PartDefinition LeftLeg = Root.addOrReplaceChild("LeftLeg",
				CubeListBuilder.create().texOffs(80, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(64, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(2.0F, -12.0F, 0.0F));
		PartDefinition RightLeg = Root
				.addOrReplaceChild(
						"RightLeg", CubeListBuilder.create().texOffs(64, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(64, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F))
								.texOffs(0, 109).addBox(-2.0F, 7.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.525F)).texOffs(16, 109).addBox(-2.0F, 7.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.025F)),
						PartPose.offset(-2.0F, -12.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.LeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}