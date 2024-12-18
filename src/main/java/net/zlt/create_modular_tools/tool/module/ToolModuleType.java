package net.zlt.create_modular_tools.tool.module;

import com.tterrag.registrate.fabric.TriFunction;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ToolModuleType {
    private final Component NAME;
    private final String TAG;
    private final int LAYER;
    private final long REQUIRED_MOLTEN_METAL_AMOUNT;
    private final List<TriFunction<@Nullable MoldTopTexture, MaterialMoldBlock, CompoundTag, @Nullable MoldTopTexture>> MOLD_TOP_TEXTURE_GETTERS = new ArrayList<>();

    public ToolModuleType(Component name, String tag, int layer, long requiredMoltenMetalAmount) {
        NAME = name;
        TAG = tag;
        LAYER = layer;
        REQUIRED_MOLTEN_METAL_AMOUNT = requiredMoltenMetalAmount;
    }

    public Component getName() {
        return NAME;
    }

    public String getTag() {
        return TAG;
    }

    public int getLayer() {
        return LAYER;
    }

    public void registerMoldTopTextureGetter(TriFunction<@Nullable MoldTopTexture, MaterialMoldBlock, CompoundTag, MoldTopTexture> moldTopTextureGetter) {
        MOLD_TOP_TEXTURE_GETTERS.add(moldTopTextureGetter);
    }

    @Nullable
    public MoldTopTexture getMoldTopTexture(MaterialMoldBlock materialMoldBlock, CompoundTag moldNbt) {
        MoldTopTexture moldTopTexture = null;
        for (TriFunction<@Nullable MoldTopTexture, MaterialMoldBlock, CompoundTag, @Nullable MoldTopTexture> moldTopTextureGetter : MOLD_TOP_TEXTURE_GETTERS) {
            moldTopTexture = moldTopTextureGetter.apply(moldTopTexture, materialMoldBlock, moldNbt);
        }
        return moldTopTexture;
    }

    public long getRequiredMoltenMetalAmount() {
        return REQUIRED_MOLTEN_METAL_AMOUNT;
    }

    public static class MoldTopTexture {
        private final List<TriFunction<@Nullable ResourceLocation, ToolMaterialMoldBlock, CompoundTag, @Nullable ResourceLocation>> TEXTURE_ID_GETTERS = new ArrayList<>();

        public boolean clicked(int x, int y) {
            return false;
        }

        @Environment(EnvType.CLIENT)
        public void registerTextureIdGetter(TriFunction<@Nullable ResourceLocation, ToolMaterialMoldBlock, CompoundTag, @Nullable ResourceLocation> textureIdGetter) {
            TEXTURE_ID_GETTERS.add(textureIdGetter);
        }

        @Environment(EnvType.CLIENT)
        @Nullable
        public ResourceLocation getTextureId(ToolMaterialMoldBlock toolMaterialMoldBlock, CompoundTag moldNbt) {
            ResourceLocation id = null;
            for (TriFunction<@Nullable ResourceLocation, ToolMaterialMoldBlock, CompoundTag, @Nullable ResourceLocation> textureIdGetter : TEXTURE_ID_GETTERS) {
                id = textureIdGetter.apply(id, toolMaterialMoldBlock, moldNbt);
            }
            return id;
        }
    }
}
