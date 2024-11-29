package net.zlt.create_modular_tools.client.renderer.blockentity.blue_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.zlt.create_modular_tools.block.entity.mold.MoldBlockEntity;
import net.zlt.create_modular_tools.client.renderer.blockentity.BaseMoldRenderer;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class BaseBlueConcretePowderMoldRenderer<T extends MoldBlockEntity> extends BaseMoldRenderer<T> {
    protected final Material BASE_MATERIAL = new Material(InventoryMenu.BLOCK_ATLAS, new ResourceLocation("minecraft", "block/blue_concrete_powder"));

    @Override
    protected Material getBaseMaterial() {
        return BASE_MATERIAL;
    }
}
