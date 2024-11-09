package com.kenetic.zawatchudo.item.custom.thewatch;

import com.kenetic.zawatchudo.item.ModItems;
import net.minecraft.world.item.Item;
import net.neoforged.fml.common.Mod;

public class TheWatchSetSync {
    private static final Item[] theWatch = {ModItems.DaWatch.get(),ModItems.DaWatchT2.get(),ModItems.DaWatchT3.get(),
            ModItems.DaWatchT4.get(),ModItems.DaWatchT5.get(),ModItems.DaWatchT6.get(),ModItems.DaWatchT7.get(),
            ModItems.DaWatchT8.get()};

    public static Item[] getTheWatchItem(){
        return theWatch;
    }

    public static void setActiveWatch(boolean active){
        TheWatchTier1.setActive(active);
        TheWatchTier2.setActive(active);
        TheWatchTier3.setActive(active);
        TheWatchTier4.setActive(active);
        TheWatchTier5.setActive(active);
        TheWatchTier6.setActive(active);
        TheWatchTier7.setActive(active);
        TheWatchTier8.setActive(active);
        TheWatchOverHeaven.setActive(active);
    }
}
