package net.zlt.create_modular_tools.client.model.item.mold.blue_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.Material;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Function;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AxeBlueConcretePowderSpruceMoldItemUnbakedModel extends ToolBlueConcretePowderSpruceMoldItemUnbakedModel {
    @Override
    protected BakedModel createDynamic(BakedModel baseSandMoldModel, BakedQuad interiorTopQuad, Function<Material, TextureAtlasSprite> spriteGetter) {
        return new AxeBlueConcretePowderSpruceMoldItemDynamicBakedModel(baseSandMoldModel, interiorTopQuad, spriteGetter);
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.AXE_BLUE_CONCRETE_POWDER_SPRUCE_MOLD;
    }
}