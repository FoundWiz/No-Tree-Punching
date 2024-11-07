package net.foundwiz.notreepunching.common.recipes;

import net.foundwiz.notreepunching.NoTreePunching;
import net.minecraft.world.item.crafting.RecipeType;

public class DamageItemRecipeType implements RecipeType<DamageItemRecipe> {
    @Override
    public String toString() {
        return NoTreePunching.MOD_ID + ":damage_tools";
    }
}