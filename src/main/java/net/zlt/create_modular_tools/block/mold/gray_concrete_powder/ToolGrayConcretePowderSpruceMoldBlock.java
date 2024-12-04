package net.zlt.create_modular_tools.block.mold.gray_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.zlt.create_modular_tools.block.AllBlocks;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolGrayConcretePowderSpruceMoldBlock extends ToolGrayConcretePowderMoldBlock {
    public ToolGrayConcretePowderSpruceMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected Block getMoldBlock() {
        return AllBlocks.SPRUCE_MOLD;
    }

    @Override
    protected MaterialMoldBlock getMaterialMoldBlock() {
        return AllMoldBlocks.GRAY_CONCRETE_POWDER_SPRUCE_MOLD;
    }
}
