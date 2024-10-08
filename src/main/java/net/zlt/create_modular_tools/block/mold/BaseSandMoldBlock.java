package net.zlt.create_modular_tools.block.mold;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.zlt.create_modular_tools.block.entity.mold.SandMoldBlockEntity;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModule;
import net.zlt.create_modular_tools.tool.module.ToolModuleRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import org.jetbrains.annotations.Unmodifiable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class BaseSandMoldBlock extends SandMoldBlock implements EntityBlock {
    public BaseSandMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!(level.getBlockEntity(pos) instanceof SandMoldBlockEntity sandMoldBlockEntity)) {
            return InteractionResult.PASS;
        }

        ItemStack stack = player.getItemInHand(hand);
        if (!stack.isEmpty()) {
            CompoundTag toolModulesNbt = sandMoldBlockEntity.getToolModulesNbt();

            for (ToolModule toolModule : ToolModuleRegistry.getAll()) {
                if (stack.is(toolModule.getItem())) {
                    if (!sandMoldBlockEntity.isCompatible(toolModule.getType())) {
                        return InteractionResult.PASS;
                    }

                    if (!toolModulesNbt.contains(toolModule.getType().getTag(), Tag.TAG_STRING)) {
                        for (String toolModuleTypeTag : toolModulesNbt.getAllKeys()) {
                            if (ToolUtils.getMoldSlot(toolModulesNbt, toolModuleTypeTag).state() == ToolUtils.MoldSlotState.FLUID) {
                                return InteractionResult.PASS;
                            }
                        }
                    }

                    ToolUtils.MoldSlot moldSlot = ToolUtils.getMoldSlot(toolModulesNbt, toolModule.getType());
                    if (moldSlot.state() == ToolUtils.MoldSlotState.FLUID) {
                        return InteractionResult.PASS;
                    }

                    if (!level.isClientSide) {
                        if (!player.isCreative()) {
                            stack.shrink(1);
                            if (moldSlot.state() == ToolUtils.MoldSlotState.SOLID) {
                                player.getInventory().placeItemBackInInventory(((ToolModule) moldSlot.contents()).getItem().getDefaultInstance());
                            }
                        }
                        sandMoldBlockEntity.putToolModule(toolModule.getType(), toolModule);
                    }

                    SoundEvent toolModuleSound = toolModule.getSound();
                    if (toolModuleSound != null) {
                        level.playSound(player, pos, toolModuleSound, SoundSource.BLOCKS, 0.5f, 0.8f);
                    }

                    playMoldSlotSound(level, pos, player, moldSlot.state() == ToolUtils.MoldSlotState.SOLID);

                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            }

            for (String toolModuleTypeTag : toolModulesNbt.getAllKeys()) {
                if (ToolUtils.getMoldSlot(toolModulesNbt, toolModuleTypeTag).state() != ToolUtils.MoldSlotState.EMPTY) {
                    return InteractionResult.PASS;
                }
            }

            return super.use(state, level, pos, player, hand, hit);
        }

        HitCoords hitCoords = getHitCoords(pos, state.getValue(FACING), hit);
        if (hitCoords == null) {
            return InteractionResult.PASS;
        }

        CompoundTag toolModulesNbt = sandMoldBlockEntity.getToolModulesNbt();

        List<ToolModuleType> existingToolModuleTypes = new ArrayList<>();
        Iterator<ToolModuleType> it = getCompatible().descendingIterator();
        while (it.hasNext()) {
            ToolModuleType toolModuleType = it.next();

            ToolUtils.MoldSlot moldSlot = ToolUtils.getMoldSlot(toolModulesNbt, toolModuleType);
            if (moldSlot.state() == ToolUtils.MoldSlotState.ABSENT) {
                continue;
            }

            if (moldSlot.state() == ToolUtils.MoldSlotState.FLUID) {
                return InteractionResult.PASS;
            }

            existingToolModuleTypes.add(toolModuleType);
        }

        for (ToolModuleType toolModuleType : existingToolModuleTypes) {
            ToolModuleType.MoldTopTexture moldTopTexture = toolModuleType.getMoldTopTexture(this, toolModulesNbt);
            if (moldTopTexture == null) {
                continue;
            }

            ToolUtils.MoldSlot moldSlot = ToolUtils.getMoldSlot(toolModulesNbt, toolModuleType);

            if (moldSlot.state() == ToolUtils.MoldSlotState.EMPTY && isRequired(toolModuleType)) {
                continue;
            }

            if (!moldTopTexture.clicked(hitCoords.X, hitCoords.Y)) {
                continue;
            }

            if (!level.isClientSide) {
                if (moldSlot.state() == ToolUtils.MoldSlotState.EMPTY) {
                    sandMoldBlockEntity.removeToolModule(toolModuleType);
                } else {
                    sandMoldBlockEntity.putToolModule(toolModuleType, null);

                    if (!player.isCreative()) {
                        player.getInventory().placeItemBackInInventory(((ToolModule) moldSlot.contents()).getItem().getDefaultInstance());
                    }
                }
            }

            playMoldSlotSound(level, pos, player, moldSlot.state() == ToolUtils.MoldSlotState.SOLID);

            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;

    }

    protected void playMoldSlotSound(Level level, BlockPos pos, Player player, boolean replacing) {
        level.playSound(player, pos, SoundEvents.SAND_PLACE, SoundSource.BLOCKS, 0.25f, 0.8f);

        if (replacing) {
            level.playSound(player, pos, SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2f, 1.0f + level.random.nextFloat());
        }
    }

    public boolean isCompatible(ToolModuleType toolModuleType) {
        return getCompatible().contains(toolModuleType);
    }

    public boolean isRequired(ToolModuleType toolModuleType) {
        return getRequired().contains(toolModuleType);
    }

    @Unmodifiable
    public abstract TreeSet<ToolModuleType> getCompatible();

    @Unmodifiable
    public abstract List<ToolModuleType> getRequired();
}
