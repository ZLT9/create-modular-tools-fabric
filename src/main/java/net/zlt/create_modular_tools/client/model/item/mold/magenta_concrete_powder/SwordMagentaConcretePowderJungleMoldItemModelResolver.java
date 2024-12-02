package net.zlt.create_modular_tools.client.model.item.mold.magenta_concrete_powder;

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
public class SwordMagentaConcretePowderJungleMoldItemModelResolver extends SingleModelResolver {
    public static final ResourceLocation SWORD_MAGENTA_CONCRETE_POWDER_JUNGLE_MOLD_MODEL_ID = CreateModularTools.asResource("item/sword_magenta_concrete_powder_jungle_mold");

    @Override
    public ResourceLocation getModelId() {
        return SWORD_MAGENTA_CONCRETE_POWDER_JUNGLE_MOLD_MODEL_ID;
    }

    @Override
    public UnbakedModel createUnbaked() {
        return new SwordMagentaConcretePowderJungleMoldItemUnbakedModel();
    }
}
