package net.zlt.create_modular_tools.block.mold.red_sand;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.zlt.create_modular_tools.block.AllBlocks;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolRedSandOakMoldBlock extends ToolRedSandMoldBlock {
    public ToolRedSandOakMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected Block getMoldBlock() {
        return AllBlocks.OAK_MOLD;
    }

    @Override
    protected MaterialMoldBlock getMaterialMoldBlock() {
        return AllMoldBlocks.RED_SAND_OAK_MOLD;
    }
}
