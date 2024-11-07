package net.foundwiz.notreepunching.common.registries;

import net.foundwiz.notreepunching.NoTreePunching;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Items {
        //Items that are supposed to be registered as an axe.
        public static final TagKey<Item> SPECIAL_AXES = tag("special_axes");
        //Items that are supposed to be registered as a pickaxe.
        public static final TagKey<Item> SPECIAL_PICKAXES = tag("special_pickaxes");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(NoTreePunching.MOD_ID, name));
        }
    }

    public static class Blocks {
        //Blocks that requires flint or better tool to drop.
        public static final TagKey<Block> NEEDS_FLINT_TOOL = tag("needs_flint_tool");

        //Wood blocks that are always breakable even if not holding an axe.
        public static final TagKey<Block> ALWAYS_BREAKABLE_WOOD_BLOCKS = tag("always_breakable_wood_blocks");
        //Stone blocks that are always breakable even if not holding a pickaxe.
        public static final TagKey<Block> ALWAYS_BREAKABLE_STONE_BLOCKS = tag("always_breakable_stone_blocks");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(NoTreePunching.MOD_ID, name));
        }
    }
}