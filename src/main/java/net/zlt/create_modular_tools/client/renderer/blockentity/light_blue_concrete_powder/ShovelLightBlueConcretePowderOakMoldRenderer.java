package net.zlt.create_modular_tools.client.renderer.blockentity.light_blue_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.light_blue_concrete_powder.ShovelLightBlueConcretePowderOakMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ShovelLightBlueConcretePowderOakMoldRenderer extends ToolLightBlueConcretePowderMoldRenderer<ShovelLightBlueConcretePowderOakMoldBlockEntity> {
    public ShovelLightBlueConcretePowderOakMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_OAK_MOLD;
    }
}