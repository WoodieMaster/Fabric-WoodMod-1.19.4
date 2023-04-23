package net.wood_studios.woodmod;

import net.fabricmc.api.ModInitializer;

import net.wood_studios.woodmod.block.ModBlocks;
import net.wood_studios.woodmod.item.ModItemGroup;
import net.wood_studios.woodmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WoodMod implements ModInitializer {
    public static final String MOD_ID = "woodmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        ModItemGroup.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
    }
}