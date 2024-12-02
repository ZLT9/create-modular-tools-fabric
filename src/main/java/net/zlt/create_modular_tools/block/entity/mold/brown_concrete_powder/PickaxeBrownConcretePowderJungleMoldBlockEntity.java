package net.zlt.create_modular_tools.block.entity.mold.brown_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.PickaxeMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PickaxeBrownConcretePowderJungleMoldBlockEntity extends PickaxeMaterialMoldBlockEntity {
    public PickaxeBrownConcretePowderJungleMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.PICKAXE_BROWN_CONCRETE_POWDER_JUNGLE_MOLD, pos, blockState);
    }
}
