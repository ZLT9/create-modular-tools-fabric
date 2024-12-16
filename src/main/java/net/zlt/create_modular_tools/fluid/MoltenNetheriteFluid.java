package net.zlt.create_modular_tools.fluid;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.zlt.create_modular_tools.block.AllBlocks;
import net.zlt.create_modular_tools.item.AllItems;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class MoltenNetheriteFluid extends MoltenMetalFluid {
    @Override
    protected Block getBlock() {
        return AllBlocks.MOLTEN_NETHERITE;
    }

    @Override
    public Fluid getSource() {
        return AllFluids.MOLTEN_NETHERITE;
    }

    @Override
    public Fluid getFlowing() {
        return AllFluids.FLOWING_MOLTEN_NETHERITE;
    }

    @Override
    public Item getBucket() {
        return AllItems.MOLTEN_NETHERITE_BUCKET;
    }

    @Override
    public int getTickDelay(LevelReader level) {
        return level.dimensionType().ultraWarm() ? 13 : 40;
    }

    @Override
    public Block solidifySourceByWater() {
        return Blocks.NETHERITE_BLOCK;
    }

    @Override
    public float[] getColor() {
        return new float[]{ 0.14f, 0.03f, 0.05f };
    }

    public static class Flowing extends MoltenNetheriteFluid {
        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        @Override
        public boolean isSource(FluidState state) {
            return false;
        }
    }

    public static class Source extends MoltenNetheriteFluid {
        @Override
        public int getAmount(FluidState state) {
            return 8;
        }

        @Override
        public boolean isSource(FluidState state) {
            return true;
        }
    }
}
