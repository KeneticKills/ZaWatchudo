package com.kenetic.zawatchudo.item.custom.thewatch;

import com.kenetic.zawatchudo.sound.ModSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TheWatchTier1 extends Item {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> endTask; // Store the scheduled end task
    private static boolean isActive = false;

    public TheWatchTier1(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, @NotNull InteractionHand usedHand) {
        ItemStack itemStack = player.getItemInHand(usedHand);
        if(level.isClientSide()){
            return InteractionResultHolder.success(itemStack);
        }

        if(level.tickRateManager().isFrozen()){
            isActive = setTimeStop(level,player,60,false);

            if (endTask != null && !endTask.isDone()) {
                endTask.cancel(true); // Cancel the task if it's still pending
            }
        }
        else {
            isActive = setTimeStop(level,player,2f,true);

            endTask = scheduler.schedule(() -> {
                isActive = setTimeStop(level,player,60,false);
            }, 2, TimeUnit.SECONDS);
        }

        return InteractionResultHolder.success(itemStack);
    }

    public static boolean getActive(){
        return isActive;
    }

    private boolean setTimeStop(Level level, Player player,float Cooldown,boolean timeStop){
        player.getCooldowns().addCooldown(this,(int) (Cooldown * 20));
        level.tickRateManager().setFrozen(timeStop);
        if (timeStop) {
            level.playSound(null, player.getOnPos(), ModSounds.timeStop.get(), SoundSource.PLAYERS);
        } else {
            level.playSound(null, player.getOnPos(), ModSounds.timeResume.get(), SoundSource.PLAYERS);
        }

        return timeStop;
    }
}
