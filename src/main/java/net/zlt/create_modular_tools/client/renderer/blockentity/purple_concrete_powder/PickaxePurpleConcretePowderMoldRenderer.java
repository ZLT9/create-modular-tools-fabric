package net.zlt.create_modular_tools.client.renderer.blockentity.purple_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.purple_concrete_powder.PickaxePurpleConcretePowderMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.BaseMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PickaxePurpleConcretePowderMoldRenderer extends BasePurpleConcretePowderMoldRenderer<PickaxePurpleConcretePowderMoldBlockEntity> {
    public PickaxePurpleConcretePowderMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected BaseMoldBlock getMoldBlock() {
        return AllMoldBlocks.PICKAXE_PURPLE_CONCRETE_POWDER_MOLD;
    }
}