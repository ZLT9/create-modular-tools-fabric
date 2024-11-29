package net.zlt.create_modular_tools.client.renderer.blockentity.white_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.white_concrete_powder.AxeWhiteConcretePowderMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.BaseMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AxeWhiteConcretePowderMoldRenderer extends BaseWhiteConcretePowderMoldRenderer<AxeWhiteConcretePowderMoldBlockEntity> {
    public AxeWhiteConcretePowderMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected BaseMoldBlock getMoldBlock() {
        return AllMoldBlocks.AXE_WHITE_CONCRETE_POWDER_MOLD;
    }
}