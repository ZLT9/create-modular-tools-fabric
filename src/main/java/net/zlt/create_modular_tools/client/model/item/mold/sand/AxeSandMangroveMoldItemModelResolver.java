package net.zlt.create_modular_tools.client.model.item.mold.sand;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.client.model.SingleModelResolver;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AxeSandMangroveMoldItemModelResolver extends SingleModelResolver {
    public static final ResourceLocation AXE_SAND_MANGROVE_MOLD_MODEL_ID = CreateModularTools.asResource("item/axe_sand_mangrove_mold");

    @Override
    public ResourceLocation getModelId() {
        return AXE_SAND_MANGROVE_MOLD_MODEL_ID;
    }

    @Override
    public UnbakedModel createUnbaked() {
        return new AxeSandMangroveMoldItemUnbakedModel();
    }
}