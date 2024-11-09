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

import static com.kenetic.zawatchudo.item.ModItems.DaWatchOverHeaven;

public class TheWatchTier8 extends Item {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private static ScheduledFuture<?> endTask; // Store the scheduled end task
    private static boolean isActive = false;

    public TheWatchTier8(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, @NotNull InteractionHand usedHand) {
        ItemStack itemStack = player.getItemInHand(usedHand);
        if(level.isClientSide()){
            return InteractionResultHolder.success(itemStack);
        }

        if(level.tickRateManager().isFrozen()){
            isActive = setTimeStop(level,player,20,false);

            if (endTask != null && !endTask.isDone()) {
                endTask.cancel(true); // Cancel the task if it's still pending
            }
        }
        else {
            isActive = setTimeStop(level,player,2f,true);

            endTask = scheduler.schedule(() -> {
                isActive = setTimeStop(level,player,20,false);
            }, 20, TimeUnit.SECONDS);
        }

        return InteractionResultHolder.success(itemStack);
    }

    public static boolean getActive(){
        return isActive;
    }

    public static void setActive(boolean active){
        isActive = active;
        if (endTask != null && !endTask.isDone() && !active) {
            endTask.cancel(true); // Cancel the task if it's still pending
        }
    }

    private boolean setTimeStop(Level level, Player player,float Cooldown,boolean timeStop){
        Item[] theWatch = TheWatchSetSync.getTheWatchItem();
        for (Item item:theWatch){
            player.getCooldowns().addCooldown(item,(int) (Cooldown * 20));
        }
        TheWatchSetSync.setActiveWatch(timeStop);
        level.tickRateManager().setFrozen(timeStop);
        if (timeStop) {
            player.getCooldowns().addCooldown(DaWatchOverHeaven.get(),40);
            level.playSound(null, player.getOnPos(), ModSounds.timeStop.get(), SoundSource.PLAYERS);
        } else {
            player.getCooldowns().addCooldown(DaWatchOverHeaven.get(),40);
            level.playSound(null, player.getOnPos(), ModSounds.timeResume.get(), SoundSource.PLAYERS);
        }

        return timeStop;
    }
}
