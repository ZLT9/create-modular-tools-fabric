package net.zlt.create_modular_tools.client.model.item.mold.red_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.Material;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.BaseMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Function;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PickaxeRedConcretePowderMoldItemUnbakedModel extends BaseRedConcretePowderMoldItemUnbakedModel {
    @Override
    protected BakedModel createDynamic(BakedModel baseSandMoldModel, BakedQuad interiorTopQuad, Function<Material, TextureAtlasSprite> spriteGetter) {
        return new PickaxeRedConcretePowderMoldItemDynamicBakedModel(baseSandMoldModel, interiorTopQuad, spriteGetter);
    }

    @Override
    protected BaseMoldBlock getMoldBlock() {
        return AllMoldBlocks.PICKAXE_RED_CONCRETE_POWDER_MOLD;
    }
}
