package net.zlt.create_modular_tools.block.mold.red_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RedConcretePowderBambooMoldBlock extends MaterialMoldBlock {
    public RedConcretePowderBambooMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MaterialMoldBlock getSwordMoldBlock() {
        return AllMoldBlocks.SWORD_RED_CONCRETE_POWDER_BAMBOO_MOLD;
    }

    @Override
    protected MaterialMoldBlock getShovelMoldBlock() {
        return AllMoldBlocks.SHOVEL_RED_CONCRETE_POWDER_BAMBOO_MOLD;
    }

    @Override
    protected MaterialMoldBlock getPickaxeMoldBlock() {
        return AllMoldBlocks.PICKAXE_RED_CONCRETE_POWDER_BAMBOO_MOLD;
    }

    @Override
    protected MaterialMoldBlock getAxeMoldBlock() {
        return AllMoldBlocks.AXE_RED_CONCRETE_POWDER_BAMBOO_MOLD;
    }

    @Override
    protected MaterialMoldBlock getHoeMoldBlock() {
        return AllMoldBlocks.HOE_RED_CONCRETE_POWDER_BAMBOO_MOLD;
    }
}
