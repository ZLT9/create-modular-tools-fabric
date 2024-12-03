package net.zlt.create_modular_tools.client.renderer.blockentity.white_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.white_concrete_powder.SwordWhiteConcretePowderMangroveMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SwordWhiteConcretePowderMangroveMoldRenderer extends ToolWhiteConcretePowderMoldRenderer<SwordWhiteConcretePowderMangroveMoldBlockEntity> {
    public SwordWhiteConcretePowderMangroveMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.SWORD_WHITE_CONCRETE_POWDER_MANGROVE_MOLD;
    }
}