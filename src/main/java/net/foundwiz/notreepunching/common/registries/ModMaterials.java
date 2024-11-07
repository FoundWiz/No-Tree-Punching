package net.foundwiz.notreepunching.common.registries;

import net.foundwiz.notreepunching.NoTreePunching;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModMaterials {
    public static final Tier FLINT = TierSortingRegistry.registerTier(
            new ForgeTier(0, 30, 1f, 0f, 8,
                    ModTags.Blocks.NEEDS_FLINT_TOOL, () -> Ingredient.of(Items.FLINT)),
            new ResourceLocation(NoTreePunching.MOD_ID, "flint"), List.of(Tiers.WOOD), List.of());
}