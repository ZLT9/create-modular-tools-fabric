package net.zlt.create_modular_tools.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.zlt.create_modular_tools.block.entity.mold.SandMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.SandMoldBlock;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.tool.module.ToolModule;
import net.zlt.create_modular_tools.tool.module.ToolModuleRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class BaseSandMoldRenderer<T extends SandMoldBlockEntity> implements BlockEntityRenderer<T> {
    private static final ModelPart TOP = createInteriorLayer().bakeRoot();
    private static final Material BASE_MATERIAL = new Material(InventoryMenu.BLOCK_ATLAS, new ResourceLocation("minecraft", "block/sand"));
    private static final Map<ResourceLocation, Material> MATERIALS = new HashMap<>();

    @Override
    public void render(T blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        CompoundTag toolModulesNbt = blockEntity.getToolModulesNbt();

        poseStack.pushPose();

        poseStack.translate(0.5, 0.0, 0.5);
        poseStack.mulPose(Axis.YP.rotationDegrees(-blockEntity.getBlockState().getValue(SandMoldBlock.FACING).toYRot()));
        poseStack.translate(-0.5, 0.1875f, -0.5);

        TOP.render(poseStack, BASE_MATERIAL.buffer(buffer, RenderType::entityCutout), packedLight, packedOverlay);

        List<ResourceLocation> existingToolModuleIds = new ArrayList<>();
        for (ToolModuleType toolModuleType : getCompatible()) {
            if (!toolModulesNbt.contains(toolModuleType.getTag())) {
                continue;
            }

            String toolModuleId = toolModulesNbt.getString(toolModuleType.getTag());
            if (toolModuleId.isEmpty()) {
                ToolModuleType.MoldTopTexture moldTopTexture = toolModuleType.getMoldTopTexture(getMoldBlock(), toolModulesNbt);
                if (moldTopTexture != null) {
                    ResourceLocation moldTopTextureId = moldTopTexture.getTextureId(getMoldBlock(), toolModulesNbt);
                    if (moldTopTextureId != null) {
                        TOP.render(poseStack, getMaterial(moldTopTextureId).buffer(buffer, RenderType::entityCutout), packedLight, packedOverlay);
                    }
                }
            } else {
                ToolModule toolModule = ToolModuleRegistry.get(toolModuleId);
                if (toolModule == null) {
                    ToolModuleType.MoldTopTexture moldTopTexture = toolModuleType.getMoldTopTexture(getMoldBlock(), toolModulesNbt);
                    if (moldTopTexture != null) {
                        ResourceLocation moldTopTextureId = moldTopTexture.getTextureId(getMoldBlock(), toolModulesNbt);
                        if (moldTopTextureId != null) {
                            existingToolModuleIds.add(moldTopTextureId);
                        }
                    }
                } else {
                    ResourceLocation toolModuleModelId = toolModule.getModelId(getModularTool(), toolModulesNbt);
                    if (toolModuleModelId != null) {
                        existingToolModuleIds.add(toolModuleModelId);
                    }
                }
            }
        }
        for (ResourceLocation toolModuleId : existingToolModuleIds) {
            TOP.render(poseStack, getMaterial(toolModuleId).buffer(buffer, RenderType::entityCutout), packedLight, packedOverlay);
        }

        poseStack.popPose();
    }

    private static Material getMaterial(ResourceLocation id) {
        return MATERIALS.computeIfAbsent(id, s -> new Material(InventoryMenu.BLOCK_ATLAS, id));
    }

    private static LayerDefinition createInteriorLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeListBuilder cubeListBuilder = CubeListBuilder.create().texOffs(0, 0).addBox(0.0f, 0.0f, 0.0f, 16.0f, 16.0f, 0.0f, EnumSet.of(Direction.NORTH));
        partdefinition.addOrReplaceChild("top", cubeListBuilder, PartPose.rotation((float) (Math.PI / 2), 0.0f, 0.0f));
        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    protected abstract Collection<ToolModuleType> getCompatible();

    protected abstract SandMoldBlock getMoldBlock();

    protected abstract ModularToolItem getModularTool();
}
