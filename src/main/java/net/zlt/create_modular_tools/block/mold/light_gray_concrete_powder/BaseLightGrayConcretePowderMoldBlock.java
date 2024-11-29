package net.zlt.create_modular_tools.block.mold.light_gray_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.BaseMoldBlock;
import net.zlt.create_modular_tools.block.mold.MoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class BaseLightGrayConcretePowderMoldBlock extends BaseMoldBlock {
    public BaseLightGrayConcretePowderMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MoldBlock getMoldBlock() {
        return AllMoldBlocks.LIGHT_GRAY_CONCRETE_POWDER_MOLD;
    }
}