package net.foundwiz.notreepunching.common.events;

import com.google.common.collect.Lists;
import net.foundwiz.notreepunching.common.registries.ModTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class LogsBreakingEvent {
    @SubscribeEvent
    public void registerEvent(PlayerEvent.BreakSpeed event) {
        final List<SoundType> hardMaterials = Lists.newArrayList(SoundType.WOOD, SoundType.NETHER_WOOD);
        if (event.getState() == null || event.getEntity() == null) {
            return;
        }
        ItemStack heldItem = event.getEntity().getMainHandItem();
        if (!hardMaterials.contains(event.getState().getSoundType())) {
            return;
        }
        if (event.getState().is(ModTags.Blocks.ALWAYS_BREAKABLE_WOOD_BLOCKS)) {
            return;
        }
        if (heldItem.is(ModTags.Items.SPECIAL_AXES)) {
            return;
        }
        if (!heldItem.canPerformAction(ToolActions.AXE_DIG)) {
            event.setCanceled(true);
        }
    }
}