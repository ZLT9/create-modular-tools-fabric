package net.zlt.create_modular_tools.client.renderer.blockentity.pink_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.pink_concrete_powder.HoePinkConcretePowderCherryMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class HoePinkConcretePowderCherryMoldRenderer extends ToolPinkConcretePowderMoldRenderer<HoePinkConcretePowderCherryMoldBlockEntity> {
    public HoePinkConcretePowderCherryMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.HOE_PINK_CONCRETE_POWDER_CHERRY_MOLD;
    }
}
