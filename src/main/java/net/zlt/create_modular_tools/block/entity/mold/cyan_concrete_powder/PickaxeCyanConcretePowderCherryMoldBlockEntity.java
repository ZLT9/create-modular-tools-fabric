package net.zlt.create_modular_tools.block.entity.mold.cyan_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.PickaxeMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PickaxeCyanConcretePowderCherryMoldBlockEntity extends PickaxeMaterialMoldBlockEntity {
    public PickaxeCyanConcretePowderCherryMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.PICKAXE_CYAN_CONCRETE_POWDER_CHERRY_MOLD, pos, blockState);
    }
}
