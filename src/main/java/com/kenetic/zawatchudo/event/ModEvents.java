package com.kenetic.zawatchudo.event;

import com.kenetic.zawatchudo.ZaWatchudo;
import net.minecraft.world.entity.Entity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber(modid = ZaWatchudo.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {
    @SubscribeEvent
    public static void livingDamage(LivingDamageEvent.Post event){
        Entity entity = event.getEntity();
        entity.invulnerableTime = 0;
        entity.setInvulnerable(false);
    }
}
