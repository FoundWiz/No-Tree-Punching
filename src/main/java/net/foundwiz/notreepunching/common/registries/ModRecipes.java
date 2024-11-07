package net.foundwiz.notreepunching.common.registries;

import net.foundwiz.notreepunching.NoTreePunching;
import net.foundwiz.notreepunching.common.recipes.DamageItemRecipeSerializer;
import net.foundwiz.notreepunching.common.recipes.DamageItemRecipeType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipes {
    public final DeferredRegister<RecipeType<?>> RecipeTypeRegistry = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, NoTreePunching.MOD_ID);
    public final DeferredRegister<RecipeSerializer<?>> SerializerRegistry = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, NoTreePunching.MOD_ID);

    public ModRecipes() {
        RegisterRecipeStuff();
    }

    public void RegisterAll(FMLJavaModLoadingContext ctx) {
        RecipeTypeRegistry.register(ctx.getModEventBus());
        SerializerRegistry.register(ctx.getModEventBus());
    }

    public void RegisterRecipeStuff() {
        SerializerRegistry.register("damage_tools", DamageItemRecipeSerializer::new);
        RecipeTypeRegistry.register("damage_tools", DamageItemRecipeType::new);
    }
}