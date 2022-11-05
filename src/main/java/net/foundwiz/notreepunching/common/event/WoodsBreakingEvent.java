package net.foundwiz.notreepunching.common.event;

import net.minecraft.world.level.block.Blocks;
import net.foundwiz.notreepunching.common.registry.ModTags;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.foundwiz.notreepunching.NoTreePunching;

@Mod.EventBusSubscriber(modid = NoTreePunching.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WoodsBreakingEvent {
    @SubscribeEvent
    public static void onBlockHit(final PlayerInteractEvent.LeftClickBlock event) {
        if (!event.getPlayer().isCreative() && !event.getItemStack().isCorrectToolForDrops(
                Blocks.OAK_LOG.defaultBlockState()) && event.getWorld().getBlockState(event.getPos())
                .is(ModTags.WOODS)) event.setCanceled(true);
    }
}