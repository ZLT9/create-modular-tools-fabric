package net.zlt.create_modular_tools.client.renderer.blockentity.magenta_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.magenta_concrete_powder.ShovelMagentaConcretePowderCrimsonMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ShovelMagentaConcretePowderCrimsonMoldRenderer extends ToolMagentaConcretePowderMoldRenderer<ShovelMagentaConcretePowderCrimsonMoldBlockEntity> {
    public ShovelMagentaConcretePowderCrimsonMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.SHOVEL_MAGENTA_CONCRETE_POWDER_CRIMSON_MOLD;
    }
}
