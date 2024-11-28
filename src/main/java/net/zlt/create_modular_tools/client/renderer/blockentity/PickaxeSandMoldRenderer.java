package net.zlt.create_modular_tools.client.renderer.blockentity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.PickaxeSandMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.BaseSandMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PickaxeSandMoldRenderer extends BaseSandMoldRenderer<PickaxeSandMoldBlockEntity> {
    public PickaxeSandMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected BaseSandMoldBlock getMoldBlock() {
        return AllMoldBlocks.PICKAXE_SAND_MOLD;
    }
}
