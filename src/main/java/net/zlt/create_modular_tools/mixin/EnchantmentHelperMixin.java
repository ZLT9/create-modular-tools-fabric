package net.zlt.create_modular_tools.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.zlt.create_modular_tools.item.CustomEnchantableItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(EnchantmentHelper.class)
public abstract class EnchantmentHelperMixin {
    @Unique
    private static int getEnchantmentValue(int original, ItemStack stack, Item item) {
        return item instanceof CustomEnchantableItem customEnchantableItem ? customEnchantableItem.getEnchantmentValue(stack) : original;
    }

    @ModifyExpressionValue(method = "getEnchantmentCost", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item;getEnchantmentValue()I"))
    private static int createModularTools$getEnchantmentCost(int original, @Local(argsOnly = true) ItemStack stack, @Local Item item) {
        return getEnchantmentValue(original, stack, item);
    }

    @ModifyExpressionValue(method = "selectEnchantment", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item;getEnchantmentValue()I"))
    private static int createModularTools$selectEnchantment(int original, @Local(argsOnly = true) ItemStack stack, @Local Item item) {
        return getEnchantmentValue(original, stack, item);
    }
}
