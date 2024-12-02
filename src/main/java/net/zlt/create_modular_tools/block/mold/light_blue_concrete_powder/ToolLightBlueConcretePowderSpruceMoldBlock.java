package net.zlt.create_modular_tools.block.mold.light_blue_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolLightBlueConcretePowderSpruceMoldBlock extends ToolMaterialMoldBlock {
    public ToolLightBlueConcretePowderSpruceMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.LIGHT_BLUE_CONCRETE_POWDER_SPRUCE_MOLD;
    }
}
