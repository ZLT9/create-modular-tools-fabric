package net.zlt.create_modular_tools.client.renderer.blockentity.cyan_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.cyan_concrete_powder.AxeCyanConcretePowderCherryMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AxeCyanConcretePowderCherryMoldRenderer extends ToolCyanConcretePowderMoldRenderer<AxeCyanConcretePowderCherryMoldBlockEntity> {
    public AxeCyanConcretePowderCherryMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.AXE_CYAN_CONCRETE_POWDER_CHERRY_MOLD;
    }
}
