package net.zlt.create_modular_tools;

import com.simibubi.create.Create;
import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluids;
import net.zlt.create_modular_tools.advancement.AllCriterionTriggers;
import net.zlt.create_modular_tools.block.AllBlocks;
import net.zlt.create_modular_tools.block.AllSoundTypes;
import net.zlt.create_modular_tools.block.entity.mold.AllMoldBlockEntityTypes;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.AllMoldTopTextures;
import net.zlt.create_modular_tools.block.mold.MoldBlock;
import net.zlt.create_modular_tools.damage.AllDamageTypes;
import net.zlt.create_modular_tools.entity.AllEntityTypes;
import net.zlt.create_modular_tools.fluid.AllFluids;
import net.zlt.create_modular_tools.item.AllCreativeModeTabs;
import net.zlt.create_modular_tools.item.AllItemTags;
import net.zlt.create_modular_tools.item.AllItems;
import net.zlt.create_modular_tools.item.mold.AllMoldItems;
import net.zlt.create_modular_tools.mold.MoldRegistry;
import net.zlt.create_modular_tools.recipe.AllRecipeTypes;
import net.zlt.create_modular_tools.sound.AllSoundEvents;
import net.zlt.create_modular_tools.tool.AllModularTools;
import net.zlt.create_modular_tools.tool.module.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class CreateModularTools implements ModInitializer {
    public static final String ID = "create_modular_tools";
    public static final String NAME = "Create: Modular Tools";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    @Override
    public void onInitialize() {
        LOGGER.info("Create addon mod [{}] is loading alongside Create [{}]!", NAME, Create.VERSION);
        LOGGER.info(EnvExecutor.unsafeRunForDist(
            () -> () -> "{} is accessing Porting Lib from the client!",
            () -> () -> "{} is accessing Porting Lib from the server!"
        ), NAME);

        AllItemTags.init();
        AllSoundEvents.init();
        AllSoundTypes.init();
        AllFluids.init();
        AllBlocks.init();
        AllToolModuleTypes.init();
        AllToolModuleFeatures.init();
        AllToolModules.init();
        AllItems.init();
        AllModularTools.init();
        AllMoldBlocks.init();
        AllMoldBlockEntityTypes.init();
        AllMoldItems.init();
        AllCreativeModeTabs.init();
        AllRecipeTypes.init();
        AllMoldTopTextures.init();
        AllDamageTypes.init();
        AllEntityTypes.init();
        AllCriterionTriggers.init();

        MoldRegistry.addRequired(AllModularTools.SWORD, AllToolModuleTypes.TOOL_HANDLE, AllToolModuleTypes.SWORD_BLADE);
        MoldRegistry.addCompatible(AllModularTools.SWORD, AllToolModuleTypes.SWORD_POMMEL, AllToolModuleTypes.SWORD_GUARD);

        MoldRegistry.addRequired(AllModularTools.SHOVEL, AllToolModuleTypes.TOOL_HANDLE, AllToolModuleTypes.SHOVEL_HEAD);
        MoldRegistry.addCompatible(AllModularTools.SHOVEL, AllToolModuleTypes.TOOL_GRIP);

        MoldRegistry.addRequired(AllModularTools.PICKAXE, AllToolModuleTypes.TOOL_HANDLE, AllToolModuleTypes.PICKAXE_HEAD);
        MoldRegistry.addCompatible(AllModularTools.PICKAXE, AllToolModuleTypes.TOOL_GRIP);

        MoldRegistry.addRequired(AllModularTools.AXE, AllToolModuleTypes.TOOL_HANDLE, AllToolModuleTypes.AXE_HEAD);
        MoldRegistry.addCompatible(AllModularTools.AXE, AllToolModuleTypes.TOOL_GRIP);

        MoldRegistry.addRequired(AllModularTools.HOE, AllToolModuleTypes.TOOL_HANDLE, AllToolModuleTypes.HOE_HEAD);
        MoldRegistry.addCompatible(AllModularTools.HOE, AllToolModuleTypes.TOOL_GRIP);

        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_BLADE, Fluids.LAVA, AllToolModules.STONE_SWORD_BLADE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_BLADE, AllFluids.MOLTEN_IRON, AllToolModules.IRON_SWORD_BLADE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_BLADE, AllFluids.MOLTEN_COPPER, AllToolModules.COPPER_SWORD_BLADE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_BLADE, AllFluids.MOLTEN_GOLD, AllToolModules.GOLDEN_SWORD_BLADE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_BLADE, AllFluids.MOLTEN_NETHERITE, AllToolModules.NETHERITE_SWORD_BLADE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_BLADE, AllFluids.MOLTEN_ZINC, AllToolModules.ZINC_SWORD_BLADE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_BLADE, AllFluids.MOLTEN_BRASS, AllToolModules.BRASS_SWORD_BLADE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_BLADE, AllFluids.MOLTEN_DIAMOND, AllToolModules.DIAMOND_SWORD_BLADE);

        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SHOVEL_HEAD, Fluids.LAVA, AllToolModules.STONE_SHOVEL_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SHOVEL_HEAD, AllFluids.MOLTEN_IRON, AllToolModules.IRON_SHOVEL_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SHOVEL_HEAD, AllFluids.MOLTEN_COPPER, AllToolModules.COPPER_SHOVEL_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SHOVEL_HEAD, AllFluids.MOLTEN_GOLD, AllToolModules.GOLDEN_SHOVEL_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SHOVEL_HEAD, AllFluids.MOLTEN_NETHERITE, AllToolModules.NETHERITE_SHOVEL_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SHOVEL_HEAD, AllFluids.MOLTEN_ZINC, AllToolModules.ZINC_SHOVEL_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SHOVEL_HEAD, AllFluids.MOLTEN_BRASS, AllToolModules.BRASS_SHOVEL_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SHOVEL_HEAD, AllFluids.MOLTEN_DIAMOND, AllToolModules.DIAMOND_SHOVEL_HEAD);

        ToolModuleRecipeRegistry.register(AllToolModuleTypes.PICKAXE_HEAD, Fluids.LAVA, AllToolModules.STONE_PICKAXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.PICKAXE_HEAD, AllFluids.MOLTEN_IRON, AllToolModules.IRON_PICKAXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.PICKAXE_HEAD, AllFluids.MOLTEN_COPPER, AllToolModules.COPPER_PICKAXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.PICKAXE_HEAD, AllFluids.MOLTEN_GOLD, AllToolModules.GOLDEN_PICKAXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.PICKAXE_HEAD, AllFluids.MOLTEN_NETHERITE, AllToolModules.NETHERITE_PICKAXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.PICKAXE_HEAD, AllFluids.MOLTEN_ZINC, AllToolModules.ZINC_PICKAXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.PICKAXE_HEAD, AllFluids.MOLTEN_BRASS, AllToolModules.BRASS_PICKAXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.PICKAXE_HEAD, AllFluids.MOLTEN_DIAMOND, AllToolModules.DIAMOND_PICKAXE_HEAD);

        ToolModuleRecipeRegistry.register(AllToolModuleTypes.AXE_HEAD, Fluids.LAVA, AllToolModules.STONE_AXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.AXE_HEAD, AllFluids.MOLTEN_IRON, AllToolModules.IRON_AXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.AXE_HEAD, AllFluids.MOLTEN_COPPER, AllToolModules.COPPER_AXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.AXE_HEAD, AllFluids.MOLTEN_GOLD, AllToolModules.GOLDEN_AXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.AXE_HEAD, AllFluids.MOLTEN_NETHERITE, AllToolModules.NETHERITE_AXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.AXE_HEAD, AllFluids.MOLTEN_ZINC, AllToolModules.ZINC_AXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.AXE_HEAD, AllFluids.MOLTEN_BRASS, AllToolModules.BRASS_AXE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.AXE_HEAD, AllFluids.MOLTEN_DIAMOND, AllToolModules.DIAMOND_AXE_HEAD);

        ToolModuleRecipeRegistry.register(AllToolModuleTypes.HOE_HEAD, Fluids.LAVA, AllToolModules.STONE_HOE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.HOE_HEAD, AllFluids.MOLTEN_IRON, AllToolModules.IRON_HOE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.HOE_HEAD, AllFluids.MOLTEN_COPPER, AllToolModules.COPPER_HOE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.HOE_HEAD, AllFluids.MOLTEN_GOLD, AllToolModules.GOLDEN_HOE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.HOE_HEAD, AllFluids.MOLTEN_NETHERITE, AllToolModules.NETHERITE_HOE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.HOE_HEAD, AllFluids.MOLTEN_ZINC, AllToolModules.ZINC_HOE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.HOE_HEAD, AllFluids.MOLTEN_BRASS, AllToolModules.BRASS_HOE_HEAD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.HOE_HEAD, AllFluids.MOLTEN_DIAMOND, AllToolModules.DIAMOND_HOE_HEAD);

        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_HANDLE, Fluids.LAVA, AllToolModules.STONE_TOOL_HANDLE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_IRON, AllToolModules.IRON_TOOL_HANDLE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_COPPER, AllToolModules.COPPER_TOOL_HANDLE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_GOLD, AllToolModules.GOLDEN_TOOL_HANDLE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_NETHERITE, AllToolModules.NETHERITE_TOOL_HANDLE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_ZINC, AllToolModules.ZINC_TOOL_HANDLE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_BRASS, AllToolModules.BRASS_TOOL_HANDLE);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_HANDLE, AllFluids.MOLTEN_DIAMOND, AllToolModules.DIAMOND_TOOL_HANDLE);

        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_GRIP, Fluids.LAVA, AllToolModules.STONE_TOOL_GRIP);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_GRIP, AllFluids.MOLTEN_IRON, AllToolModules.IRON_TOOL_GRIP);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_GRIP, AllFluids.MOLTEN_COPPER, AllToolModules.COPPER_TOOL_GRIP);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_GRIP, AllFluids.MOLTEN_GOLD, AllToolModules.GOLDEN_TOOL_GRIP);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_GRIP, AllFluids.MOLTEN_NETHERITE, AllToolModules.NETHERITE_TOOL_GRIP);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_GRIP, AllFluids.MOLTEN_ZINC, AllToolModules.ZINC_TOOL_GRIP);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_GRIP, AllFluids.MOLTEN_BRASS, AllToolModules.BRASS_TOOL_GRIP);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.TOOL_GRIP, AllFluids.MOLTEN_DIAMOND, AllToolModules.DIAMOND_TOOL_GRIP);

        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_GUARD, Fluids.LAVA, AllToolModules.STONE_SWORD_GUARD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_GUARD, AllFluids.MOLTEN_IRON, AllToolModules.IRON_SWORD_GUARD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_GUARD, AllFluids.MOLTEN_COPPER, AllToolModules.COPPER_SWORD_GUARD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_GUARD, AllFluids.MOLTEN_GOLD, AllToolModules.GOLDEN_SWORD_GUARD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_GUARD, AllFluids.MOLTEN_NETHERITE, AllToolModules.NETHERITE_SWORD_GUARD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_GUARD, AllFluids.MOLTEN_ZINC, AllToolModules.ZINC_SWORD_GUARD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_GUARD, AllFluids.MOLTEN_BRASS, AllToolModules.BRASS_SWORD_GUARD);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_GUARD, AllFluids.MOLTEN_DIAMOND, AllToolModules.DIAMOND_SWORD_GUARD);

        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_POMMEL, Fluids.LAVA, AllToolModules.STONE_SWORD_POMMEL);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_POMMEL, AllFluids.MOLTEN_IRON, AllToolModules.IRON_SWORD_POMMEL);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_POMMEL, AllFluids.MOLTEN_COPPER, AllToolModules.COPPER_SWORD_POMMEL);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_POMMEL, AllFluids.MOLTEN_GOLD, AllToolModules.GOLDEN_SWORD_POMMEL);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_POMMEL, AllFluids.MOLTEN_NETHERITE, AllToolModules.NETHERITE_SWORD_POMMEL);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_POMMEL, AllFluids.MOLTEN_ZINC, AllToolModules.ZINC_SWORD_POMMEL);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_POMMEL, AllFluids.MOLTEN_BRASS, AllToolModules.BRASS_SWORD_POMMEL);
        ToolModuleRecipeRegistry.register(AllToolModuleTypes.SWORD_POMMEL, AllFluids.MOLTEN_DIAMOND, AllToolModules.DIAMOND_SWORD_POMMEL);

        registerMoldTopTextureGetter(AllToolModuleTypes.SWORD_BLADE, AllMoldTopTextures.SWORD_BLADE);

        registerMoldTopTextureGetter(AllToolModuleTypes.SHOVEL_HEAD, AllMoldTopTextures.SHOVEL_HEAD);

        registerMoldTopTextureGetter(AllToolModuleTypes.PICKAXE_HEAD, AllMoldTopTextures.PICKAXE_HEAD);

        registerMoldTopTextureGetter(AllToolModuleTypes.AXE_HEAD, AllMoldTopTextures.AXE_HEAD);

        registerMoldTopTextureGetter(AllToolModuleTypes.HOE_HEAD, AllMoldTopTextures.HOE_HEAD);

        Set<MoldBlock> swordMolds = Set.of(AllMoldBlocks.SWORD_SAND_MOLD, AllMoldBlocks.SWORD_RED_SAND_MOLD, AllMoldBlocks.SWORD_WHITE_CONCRETE_POWDER_MOLD, AllMoldBlocks.SWORD_LIGHT_GRAY_CONCRETE_POWDER_MOLD, AllMoldBlocks.SWORD_GRAY_CONCRETE_POWDER_MOLD, AllMoldBlocks.SWORD_BLACK_CONCRETE_POWDER_MOLD, AllMoldBlocks.SWORD_BROWN_CONCRETE_POWDER_MOLD, AllMoldBlocks.SWORD_RED_CONCRETE_POWDER_MOLD, AllMoldBlocks.SWORD_ORANGE_CONCRETE_POWDER_MOLD, AllMoldBlocks.SWORD_YELLOW_CONCRETE_POWDER_MOLD, AllMoldBlocks.SWORD_LIME_CONCRETE_POWDER_MOLD, AllMoldBlocks.SWORD_GREEN_CONCRETE_POWDER_MOLD, AllMoldBlocks.SWORD_CYAN_CONCRETE_POWDER_MOLD, AllMoldBlocks.SWORD_LIGHT_BLUE_CONCRETE_POWDER_MOLD, AllMoldBlocks.SWORD_BLUE_CONCRETE_POWDER_MOLD, AllMoldBlocks.SWORD_PURPLE_CONCRETE_POWDER_MOLD, AllMoldBlocks.SWORD_MAGENTA_CONCRETE_POWDER_MOLD, AllMoldBlocks.SWORD_PINK_CONCRETE_POWDER_MOLD);
        registerMoldTopTextureGetterForMoldsWithoutModule(AllToolModuleTypes.TOOL_HANDLE, swordMolds, AllToolModuleTypes.SWORD_POMMEL, AllMoldTopTextures.SWORD_HANDLE);
        registerMoldTopTextureGetterForMoldsWithModule(AllToolModuleTypes.TOOL_HANDLE, swordMolds, AllToolModuleTypes.SWORD_POMMEL, AllMoldTopTextures.POMMEL_SWORD_HANDLE);

        Set<MoldBlock> shovelMolds = Set.of(AllMoldBlocks.SHOVEL_SAND_MOLD, AllMoldBlocks.SHOVEL_RED_SAND_MOLD, AllMoldBlocks.SHOVEL_WHITE_CONCRETE_POWDER_MOLD, AllMoldBlocks.SHOVEL_LIGHT_GRAY_CONCRETE_POWDER_MOLD, AllMoldBlocks.SHOVEL_GRAY_CONCRETE_POWDER_MOLD, AllMoldBlocks.SHOVEL_BLACK_CONCRETE_POWDER_MOLD, AllMoldBlocks.SHOVEL_BROWN_CONCRETE_POWDER_MOLD, AllMoldBlocks.SHOVEL_RED_CONCRETE_POWDER_MOLD, AllMoldBlocks.SHOVEL_ORANGE_CONCRETE_POWDER_MOLD, AllMoldBlocks.SHOVEL_YELLOW_CONCRETE_POWDER_MOLD, AllMoldBlocks.SHOVEL_LIME_CONCRETE_POWDER_MOLD, AllMoldBlocks.SHOVEL_GREEN_CONCRETE_POWDER_MOLD, AllMoldBlocks.SHOVEL_CYAN_CONCRETE_POWDER_MOLD, AllMoldBlocks.SHOVEL_LIGHT_BLUE_CONCRETE_POWDER_MOLD, AllMoldBlocks.SHOVEL_BLUE_CONCRETE_POWDER_MOLD, AllMoldBlocks.SHOVEL_PURPLE_CONCRETE_POWDER_MOLD, AllMoldBlocks.SHOVEL_MAGENTA_CONCRETE_POWDER_MOLD, AllMoldBlocks.SHOVEL_PINK_CONCRETE_POWDER_MOLD);
        registerMoldTopTextureGetterForMoldsWithoutModule(AllToolModuleTypes.TOOL_HANDLE, shovelMolds, AllToolModuleTypes.TOOL_GRIP, AllMoldTopTextures.SHOVEL_HANDLE);
        registerMoldTopTextureGetterForMoldsWithModule(AllToolModuleTypes.TOOL_HANDLE, shovelMolds, AllToolModuleTypes.TOOL_GRIP, AllMoldTopTextures.GRIP_SHOVEL_HANDLE);

        Set<MoldBlock> pickaxeMolds = Set.of(AllMoldBlocks.PICKAXE_SAND_MOLD, AllMoldBlocks.PICKAXE_RED_SAND_MOLD, AllMoldBlocks.PICKAXE_WHITE_CONCRETE_POWDER_MOLD, AllMoldBlocks.PICKAXE_LIGHT_GRAY_CONCRETE_POWDER_MOLD, AllMoldBlocks.PICKAXE_GRAY_CONCRETE_POWDER_MOLD, AllMoldBlocks.PICKAXE_BLACK_CONCRETE_POWDER_MOLD, AllMoldBlocks.PICKAXE_BROWN_CONCRETE_POWDER_MOLD, AllMoldBlocks.PICKAXE_RED_CONCRETE_POWDER_MOLD, AllMoldBlocks.PICKAXE_ORANGE_CONCRETE_POWDER_MOLD, AllMoldBlocks.PICKAXE_YELLOW_CONCRETE_POWDER_MOLD, AllMoldBlocks.PICKAXE_LIME_CONCRETE_POWDER_MOLD, AllMoldBlocks.PICKAXE_GREEN_CONCRETE_POWDER_MOLD, AllMoldBlocks.PICKAXE_CYAN_CONCRETE_POWDER_MOLD, AllMoldBlocks.PICKAXE_LIGHT_BLUE_CONCRETE_POWDER_MOLD, AllMoldBlocks.PICKAXE_BLUE_CONCRETE_POWDER_MOLD, AllMoldBlocks.PICKAXE_PURPLE_CONCRETE_POWDER_MOLD, AllMoldBlocks.PICKAXE_MAGENTA_CONCRETE_POWDER_MOLD, AllMoldBlocks.PICKAXE_PINK_CONCRETE_POWDER_MOLD);
        registerMoldTopTextureGetterForMoldsWithoutModule(AllToolModuleTypes.TOOL_HANDLE, pickaxeMolds, AllToolModuleTypes.TOOL_GRIP, AllMoldTopTextures.PICKAXE_HANDLE);
        registerMoldTopTextureGetterForMoldsWithModule(AllToolModuleTypes.TOOL_HANDLE, pickaxeMolds, AllToolModuleTypes.TOOL_GRIP, AllMoldTopTextures.GRIP_PICKAXE_HANDLE);

        Set<MoldBlock> axeMolds = Set.of(AllMoldBlocks.AXE_SAND_MOLD, AllMoldBlocks.AXE_RED_SAND_MOLD, AllMoldBlocks.AXE_WHITE_CONCRETE_POWDER_MOLD, AllMoldBlocks.AXE_LIGHT_GRAY_CONCRETE_POWDER_MOLD, AllMoldBlocks.AXE_GRAY_CONCRETE_POWDER_MOLD, AllMoldBlocks.AXE_BLACK_CONCRETE_POWDER_MOLD, AllMoldBlocks.AXE_BROWN_CONCRETE_POWDER_MOLD, AllMoldBlocks.AXE_RED_CONCRETE_POWDER_MOLD, AllMoldBlocks.AXE_ORANGE_CONCRETE_POWDER_MOLD, AllMoldBlocks.AXE_YELLOW_CONCRETE_POWDER_MOLD, AllMoldBlocks.AXE_LIME_CONCRETE_POWDER_MOLD, AllMoldBlocks.AXE_GREEN_CONCRETE_POWDER_MOLD, AllMoldBlocks.AXE_CYAN_CONCRETE_POWDER_MOLD, AllMoldBlocks.AXE_LIGHT_BLUE_CONCRETE_POWDER_MOLD, AllMoldBlocks.AXE_BLUE_CONCRETE_POWDER_MOLD, AllMoldBlocks.AXE_PURPLE_CONCRETE_POWDER_MOLD, AllMoldBlocks.AXE_MAGENTA_CONCRETE_POWDER_MOLD, AllMoldBlocks.AXE_PINK_CONCRETE_POWDER_MOLD);
        registerMoldTopTextureGetterForMoldsWithoutModule(AllToolModuleTypes.TOOL_HANDLE, axeMolds, AllToolModuleTypes.TOOL_GRIP, AllMoldTopTextures.AXE_HANDLE);
        registerMoldTopTextureGetterForMoldsWithModule(AllToolModuleTypes.TOOL_HANDLE, axeMolds, AllToolModuleTypes.TOOL_GRIP, AllMoldTopTextures.GRIP_AXE_HANDLE);

        Set<MoldBlock> hoeMolds = Set.of(AllMoldBlocks.HOE_SAND_MOLD, AllMoldBlocks.HOE_RED_SAND_MOLD, AllMoldBlocks.HOE_WHITE_CONCRETE_POWDER_MOLD, AllMoldBlocks.HOE_LIGHT_GRAY_CONCRETE_POWDER_MOLD, AllMoldBlocks.HOE_GRAY_CONCRETE_POWDER_MOLD, AllMoldBlocks.HOE_BLACK_CONCRETE_POWDER_MOLD, AllMoldBlocks.HOE_BROWN_CONCRETE_POWDER_MOLD, AllMoldBlocks.HOE_RED_CONCRETE_POWDER_MOLD, AllMoldBlocks.HOE_ORANGE_CONCRETE_POWDER_MOLD, AllMoldBlocks.HOE_YELLOW_CONCRETE_POWDER_MOLD, AllMoldBlocks.HOE_LIME_CONCRETE_POWDER_MOLD, AllMoldBlocks.HOE_GREEN_CONCRETE_POWDER_MOLD, AllMoldBlocks.HOE_CYAN_CONCRETE_POWDER_MOLD, AllMoldBlocks.HOE_LIGHT_BLUE_CONCRETE_POWDER_MOLD, AllMoldBlocks.HOE_BLUE_CONCRETE_POWDER_MOLD, AllMoldBlocks.HOE_PURPLE_CONCRETE_POWDER_MOLD, AllMoldBlocks.HOE_MAGENTA_CONCRETE_POWDER_MOLD, AllMoldBlocks.HOE_PINK_CONCRETE_POWDER_MOLD);
        registerMoldTopTextureGetterForMoldsWithoutModule(AllToolModuleTypes.TOOL_HANDLE, hoeMolds, AllToolModuleTypes.TOOL_GRIP, AllMoldTopTextures.HOE_HANDLE);
        registerMoldTopTextureGetterForMoldsWithModule(AllToolModuleTypes.TOOL_HANDLE, hoeMolds, AllToolModuleTypes.TOOL_GRIP, AllMoldTopTextures.GRIP_HOE_HANDLE);

        registerMoldTopTextureGetter(AllToolModuleTypes.TOOL_GRIP, AllMoldTopTextures.GRIP);

        registerMoldTopTextureGetter(AllToolModuleTypes.SWORD_GUARD, AllMoldTopTextures.GUARD);

        registerMoldTopTextureGetter(AllToolModuleTypes.SWORD_POMMEL, AllMoldTopTextures.POMMEL);
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(ID, path);
    }

    private static void registerMoldTopTextureGetter(ToolModuleType toolModuleType, ToolModuleType.MoldTopTexture moldTopTexture) {
        toolModuleType.registerMoldTopTextureGetter((original, sandMoldBlock, nbt) -> original == null ? moldTopTexture : original);
    }

    private static void registerMoldTopTextureGetterForMold(ToolModuleType toolModuleType, MoldBlock moldBlock, ToolModuleType.MoldTopTexture moldTopTexture) {
        toolModuleType.registerMoldTopTextureGetter((original, sandMoldBlock, nbt) -> original == null && sandMoldBlock == moldBlock ? moldTopTexture : original);
    }

    private static void registerMoldTopTextureGetterForMoldsWithModule(ToolModuleType toolModuleType, Set<MoldBlock> moldBlocks, ToolModuleType otherToolModuleType, ToolModuleType.MoldTopTexture moldTopTexture) {
        toolModuleType.registerMoldTopTextureGetter((original, sandMoldBlock, nbt) -> original == null && moldBlocks.contains(sandMoldBlock) && nbt.contains(otherToolModuleType.getTag(), Tag.TAG_COMPOUND) ? moldTopTexture : original);
    }

    private static void registerMoldTopTextureGetterForMoldsWithoutModule(ToolModuleType toolModuleType, Set<MoldBlock> moldBlocks, ToolModuleType otherToolModuleType, ToolModuleType.MoldTopTexture moldTopTexture) {
        toolModuleType.registerMoldTopTextureGetter((original, sandMoldBlock, nbt) -> original == null && moldBlocks.contains(sandMoldBlock) && !nbt.contains(otherToolModuleType.getTag(), Tag.TAG_COMPOUND) ? moldTopTexture : original);
    }
}
