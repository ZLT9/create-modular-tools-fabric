package net.zlt.create_modular_tools.block.mold.blue_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BlueConcretePowderMangroveMoldBlock extends MaterialMoldBlock {
    public BlueConcretePowderMangroveMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MaterialMoldBlock getSwordMoldBlock() {
        return AllMoldBlocks.SWORD_BLUE_CONCRETE_POWDER_MANGROVE_MOLD;
    }

    @Override
    protected MaterialMoldBlock getShovelMoldBlock() {
        return AllMoldBlocks.SHOVEL_BLUE_CONCRETE_POWDER_MANGROVE_MOLD;
    }

    @Override
    protected MaterialMoldBlock getPickaxeMoldBlock() {
        return AllMoldBlocks.PICKAXE_BLUE_CONCRETE_POWDER_MANGROVE_MOLD;
    }

    @Override
    protected MaterialMoldBlock getAxeMoldBlock() {
        return AllMoldBlocks.AXE_BLUE_CONCRETE_POWDER_MANGROVE_MOLD;
    }

    @Override
    protected MaterialMoldBlock getHoeMoldBlock() {
        return AllMoldBlocks.HOE_BLUE_CONCRETE_POWDER_MANGROVE_MOLD;
    }
}