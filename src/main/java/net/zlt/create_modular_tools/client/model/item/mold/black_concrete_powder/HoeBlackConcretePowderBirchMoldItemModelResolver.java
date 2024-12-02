package net.zlt.create_modular_tools.client.model.item.mold.black_concrete_powder;

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
public class HoeBlackConcretePowderBirchMoldItemModelResolver extends SingleModelResolver {
    public static final ResourceLocation HOE_BLACK_CONCRETE_POWDER_BIRCH_MOLD_MODEL_ID = CreateModularTools.asResource("item/hoe_black_concrete_powder_birch_mold");

    @Override
    public ResourceLocation getModelId() {
        return HOE_BLACK_CONCRETE_POWDER_BIRCH_MOLD_MODEL_ID;
    }

    @Override
    public UnbakedModel createUnbaked() {
        return new HoeBlackConcretePowderBirchMoldItemUnbakedModel();
    }
}
