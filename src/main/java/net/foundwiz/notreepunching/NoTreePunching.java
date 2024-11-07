package net.foundwiz.notreepunching;

import com.mojang.logging.LogUtils;
import net.foundwiz.notreepunching.common.events.LogsBreakingEvent;
import net.foundwiz.notreepunching.common.events.StonesBreakingEvent;
import net.foundwiz.notreepunching.common.events.WoodenPlanksBreakingEvent;
import net.foundwiz.notreepunching.common.registries.ModItems;
import net.foundwiz.notreepunching.common.registries.ModRecipes;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(NoTreePunching.MOD_ID)
public class NoTreePunching {
    public static final String MOD_ID = "notreepunching";
    private static final Logger LOGGER = LogUtils.getLogger();
    public final ModRecipes REGISTRY;

    public NoTreePunching() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(new LogsBreakingEvent());
        MinecraftForge.EVENT_BUS.register(new StonesBreakingEvent());
        MinecraftForge.EVENT_BUS.register(new WoodenPlanksBreakingEvent());

        REGISTRY = new ModRecipes();
        REGISTRY.RegisterAll(FMLJavaModLoadingContext.get());

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.FLINT_HATCHET);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}