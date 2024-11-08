package net.zlt.create_modular_tools.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.zlt.create_modular_tools.block.mold.SandMoldBlock;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.tool.module.ToolModule;
import net.zlt.create_modular_tools.tool.module.ToolModuleRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class MoldModelUtils {
    private MoldModelUtils() {
    }

    public static void forEachMoldTopQuad(Collection<ToolModuleType> compatibleToolModuleTypes, CompoundTag toolModulesNbt, SandMoldBlock sandMoldBlock, ModularToolItem modularTool, Consumer<ResourceLocation> action) {
        List<ResourceLocation> existingToolModuleIds = new ArrayList<>();

        for (ToolModuleType toolModuleType : compatibleToolModuleTypes) {
            if (!toolModulesNbt.contains(toolModuleType.getTag())) {
                continue;
            }

            String toolModuleId = toolModulesNbt.getString(toolModuleType.getTag());
            if (toolModuleId.isEmpty()) {
                ToolModuleType.MoldTopTexture moldTopTexture = toolModuleType.getMoldTopTexture(sandMoldBlock, toolModulesNbt);
                if (moldTopTexture == null) {
                    continue;
                }

                ResourceLocation moldTopTextureId = moldTopTexture.getTextureId(sandMoldBlock, toolModulesNbt);
                if (moldTopTextureId != null) {
                    action.accept(moldTopTextureId);
                }

                continue;
            }

            ToolModule toolModule = ToolModuleRegistry.get(toolModuleId);
            if (toolModule == null) {
                ToolModuleType.MoldTopTexture moldTopTexture = toolModuleType.getMoldTopTexture(sandMoldBlock, toolModulesNbt);
                if (moldTopTexture == null) {
                    continue;
                }

                ResourceLocation moldTopTextureId = moldTopTexture.getTextureId(sandMoldBlock, toolModulesNbt);
                if (moldTopTextureId != null) {
                    existingToolModuleIds.add(moldTopTextureId);
                }

                continue;
            }

            ResourceLocation toolModuleModelId = toolModule.getModelId(modularTool, toolModulesNbt);
            if (toolModuleModelId != null) {
                existingToolModuleIds.add(toolModuleModelId);
            }
        }

        for (ResourceLocation toolModuleId : existingToolModuleIds) {
            action.accept(toolModuleId);
        }
    }
}
