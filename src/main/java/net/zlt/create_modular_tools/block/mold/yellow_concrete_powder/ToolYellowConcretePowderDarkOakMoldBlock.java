package net.zlt.create_modular_tools.block.mold.yellow_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.zlt.create_modular_tools.block.AllBlocks;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolYellowConcretePowderDarkOakMoldBlock extends ToolYellowConcretePowderMoldBlock {
    public ToolYellowConcretePowderDarkOakMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected Block getMoldBlock() {
        return AllBlocks.DARK_OAK_MOLD;
    }

    @Override
    protected MaterialMoldBlock getMaterialMoldBlock() {
        return AllMoldBlocks.YELLOW_CONCRETE_POWDER_DARK_OAK_MOLD;
    }
}
