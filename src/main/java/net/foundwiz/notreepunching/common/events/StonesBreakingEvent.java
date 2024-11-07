package net.foundwiz.notreepunching.common.events;

import com.google.common.collect.Lists;
import net.foundwiz.notreepunching.common.registries.ModTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class StonesBreakingEvent {
    @SubscribeEvent
    public void registerEvent(PlayerEvent.BreakSpeed event) {
        final List<SoundType> hardMaterials = Lists.newArrayList(SoundType.STONE, SoundType.METAL);
        if (event.getState() == null || event.getEntity() == null) {
            return;
        }
        ItemStack heldItem = event.getEntity().getMainHandItem();
        if (!hardMaterials.contains(event.getState().getSoundType())) {
            return;
        }
        if (event.getState().is(ModTags.Blocks.ALWAYS_BREAKABLE_STONE_BLOCKS)) {
            return;
        }
        if (heldItem.is(ModTags.Items.SPECIAL_PICKAXES)) {
            return;
        }
        if (!heldItem.canPerformAction(ToolActions.PICKAXE_DIG)) {
            event.setCanceled(true);
        }
    }
}