package net.zlt.create_modular_tools.client.renderer.blockentity.blue_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.blue_concrete_powder.SwordBlueConcretePowderAcaciaMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SwordBlueConcretePowderAcaciaMoldRenderer extends ToolBlueConcretePowderMoldRenderer<SwordBlueConcretePowderAcaciaMoldBlockEntity> {
    public SwordBlueConcretePowderAcaciaMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.SWORD_BLUE_CONCRETE_POWDER_ACACIA_MOLD;
    }
}