package net.foundwiz.notreepunching.common.event;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.foundwiz.notreepunching.NoTreePunching;

@Mod.EventBusSubscriber(modid = NoTreePunching.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class StonesBreakingEvent {
    @SubscribeEvent
    public static void onBlockHit(final PlayerInteractEvent.LeftClickBlock event) {
        if (!event.getPlayer().isCreative() && !event.getItemStack().isCorrectToolForDrops(
                Blocks.STONE.defaultBlockState()) && event.getWorld().getBlockState(event.getPos())
                .is(BlockTags.MINEABLE_WITH_PICKAXE)) event.setCanceled(true);
    }
}