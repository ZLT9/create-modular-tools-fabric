package net.zlt.create_modular_tools.block.entity.mold.gray_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.entity.mold.SwordMaterialMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SwordGrayConcretePowderCherryMoldBlockEntity extends SwordMaterialMoldBlockEntity {
    public SwordGrayConcretePowderCherryMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.SWORD_GRAY_CONCRETE_POWDER_CHERRY_MOLD, pos, blockState);
    }
}
