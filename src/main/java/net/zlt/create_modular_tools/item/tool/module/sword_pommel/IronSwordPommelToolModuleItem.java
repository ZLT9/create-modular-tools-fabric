package net.zlt.create_modular_tools.item.tool.module.sword_pommel;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class IronSwordPommelToolModuleItem extends SwordPommelToolModuleItem {
    public IronSwordPommelToolModuleItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getTierLevel() {
        return ToolModuleConstants.IRON_TIER_LEVEL;
    }

    @Override
    public float getAttackSpeedWhenAttached() {
        return 0.3f;
    }

    @Override
    public int getDurabilityWhenAttached() {
        return ToolModuleConstants.IRON_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 3;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.IRON_SOUND;
    }
}
