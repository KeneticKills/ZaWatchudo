package com.kenetic.zawatchudo.event;

import com.kenetic.zawatchudo.ZaWatchudo;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@EventBusSubscriber(modid = ZaWatchudo.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private static ScheduledFuture<?> endTask; // Store the scheduled end task

    @SubscribeEvent
    public static void livingDamage(LivingDamageEvent.Post event){
        if (endTask != null && !endTask.isDone()) {
            endTask.cancel(true); // Cancel the task if it's still pending
        }
        Entity entity = event.getEntity();
        Entity damageSourceEntity = event.getSource().getDirectEntity();
        if (damageSourceEntity instanceof Projectile){
            entity.invulnerableTime = 0;
            entity.setInvulnerable(false);
            return;
        }
        if(damageSourceEntity instanceof Player && event.getEntity().level().tickRateManager().isFrozen()){
            endTask = scheduler.schedule(() -> {
                entity.invulnerableTime = 0;
                entity.setInvulnerable(false);
            }, 500, TimeUnit.MILLISECONDS);
        }
    }
}
