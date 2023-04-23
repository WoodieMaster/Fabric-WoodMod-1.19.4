package net.wood_studios.woodmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.wood_studios.woodmod.WoodMod;

public class ModItemGroup {
    public static ItemGroup WoodmodItemGroup;

    public static void registerItemGroups() {
        WoodMod.LOGGER.info("Registering Mod Item Groups for " + WoodMod.MOD_ID);
        WoodmodItemGroup = FabricItemGroup.builder(new Identifier(WoodMod.MOD_ID, "citrine"))
                .displayName(Text.translatable("item_group.woodmod_item_group"))
                .icon(() -> new ItemStack(ModItems.CITRINE)).build();
    }
}
