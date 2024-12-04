package net.zlt.create_modular_tools.block.mold.white_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.zlt.create_modular_tools.block.AllBlocks;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class WhiteConcretePowderDarkOakMoldBlock extends WhiteConcretePowderMoldBlock {
    public WhiteConcretePowderDarkOakMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected Block getMoldBlock() {
        return AllBlocks.DARK_OAK_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getSwordMoldBlock() {
        return AllMoldBlocks.SWORD_WHITE_CONCRETE_POWDER_DARK_OAK_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getShovelMoldBlock() {
        return AllMoldBlocks.SHOVEL_WHITE_CONCRETE_POWDER_DARK_OAK_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getPickaxeMoldBlock() {
        return AllMoldBlocks.PICKAXE_WHITE_CONCRETE_POWDER_DARK_OAK_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getAxeMoldBlock() {
        return AllMoldBlocks.AXE_WHITE_CONCRETE_POWDER_DARK_OAK_MOLD;
    }

    @Override
    protected ToolMaterialMoldBlock getHoeMoldBlock() {
        return AllMoldBlocks.HOE_WHITE_CONCRETE_POWDER_DARK_OAK_MOLD;
    }
}
