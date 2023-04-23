package net.wood_studios.woodmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.wood_studios.woodmod.WoodMod;
import net.wood_studios.woodmod.item.ModItemGroup;

public class ModBlocks {

    public static final Block CITRINE_BLOCK = registerBlock("citrine_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(5.0f, 6.0f).requiresTool().sounds(BlockSoundGroup.METAL)),
            ModItemGroup.WoodmodItemGroup, ItemGroups.BUILDING_BLOCKS);

    public static final Block CITRINE_ORE = registerBlock("citrine_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0f, 3.0f).requiresTool(),
                    UniformIntProvider.create(3,7)),
            ModItemGroup.WoodmodItemGroup, ItemGroups.NATURAL);

    public static final Block DEEPSLATE_CITRINE_ORE = registerBlock("deepslate_citrine_ore",
            new ExperienceDroppingBlock(AbstractBlock.Settings.copy(CITRINE_ORE).strength(4.5f, 3.0f).mapColor(MapColor.DEEPSLATE_GRAY).sounds(BlockSoundGroup.DEEPSLATE).requiresTool(),
                UniformIntProvider.create(3,7)),
            ModItemGroup.WoodmodItemGroup, ItemGroups.NATURAL);
    private static Block registerBlock(String name, Block block, ItemGroup... groups) {
        registerBlockItem(name, block, groups);

        return Registry.register(Registries.BLOCK, new Identifier(WoodMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup ...groups) {
        Item item = Registry.register(Registries.ITEM, new Identifier(WoodMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        for(ItemGroup group : groups) {
            ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        }
        return item;
    }

    public static void registerModBlocks() {
        WoodMod.LOGGER.info("Registering Mod Blocks for " + WoodMod.MOD_ID);
    }
}
