package net.foundwiz.notreepunching.common.events;

import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class WoodenPlanksBreakingEvent {
    @SubscribeEvent
    public void registerEvent(PlayerEvent.BreakSpeed event) {
        if (event.getState().getSoundType() == SoundType.WOOD
                || event.getState().getSoundType() == SoundType.NETHER_WOOD) {
            //If not holding an axe
            if (!event.getEntity().getMainHandItem().isCorrectToolForDrops(event.getState())) {
                //Reduce the planks breaking speed to half.
                event.setNewSpeed(event.getOriginalSpeed() / 2);
            }
        }
    }
}