package net.zlt.create_modular_tools.client.renderer.blockentity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.zlt.create_modular_tools.block.entity.mold.SandMoldBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class BaseRedSandMoldRenderer<T extends SandMoldBlockEntity> extends BaseMoldRenderer<T> {
    protected final Material BASE_MATERIAL = new Material(InventoryMenu.BLOCK_ATLAS, new ResourceLocation("minecraft", "block/red_sand"));

    @Override
    protected Material getBaseMaterial() {
        return BASE_MATERIAL;
    }
}
