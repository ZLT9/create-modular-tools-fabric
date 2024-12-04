package net.zlt.create_modular_tools.block.mold.yellow_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.zlt.create_modular_tools.block.AllBlocks;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class YellowConcretePowderCherryMoldBlock extends YellowConcretePowderMoldBlock {
    public YellowConcretePowderCherryMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected Block getMoldBlock() {
        return AllBlocks.CHERRY_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getSwordMoldBlock() {
        return AllMoldBlocks.SWORD_YELLOW_CONCRETE_POWDER_CHERRY_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getShovelMoldBlock() {
        return AllMoldBlocks.SHOVEL_YELLOW_CONCRETE_POWDER_CHERRY_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getPickaxeMoldBlock() {
        return AllMoldBlocks.PICKAXE_YELLOW_CONCRETE_POWDER_CHERRY_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getAxeMoldBlock() {
        return AllMoldBlocks.AXE_YELLOW_CONCRETE_POWDER_CHERRY_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getHoeMoldBlock() {
        return AllMoldBlocks.HOE_YELLOW_CONCRETE_POWDER_CHERRY_MOLD;
    }
}
