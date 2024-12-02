package net.zlt.create_modular_tools.client.renderer.blockentity.orange_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.orange_concrete_powder.AxeOrangeConcretePowderAcaciaMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AxeOrangeConcretePowderAcaciaMoldRenderer extends ToolOrangeConcretePowderMoldRenderer<AxeOrangeConcretePowderAcaciaMoldBlockEntity> {
    public AxeOrangeConcretePowderAcaciaMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.AXE_ORANGE_CONCRETE_POWDER_ACACIA_MOLD;
    }
}
