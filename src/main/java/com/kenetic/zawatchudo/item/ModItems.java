package com.kenetic.zawatchudo.item;

import com.kenetic.zawatchudo.ZaWatchudo;
import com.kenetic.zawatchudo.item.custom.thewatch.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ZaWatchudo.MODID);

    public static  final DeferredItem<Item> FWatch = ITEMS.register("frozen_watch",
            () -> new Item(new Item.Properties()));

    public static  final DeferredItem<Item> DaWatch = ITEMS.register("the_watch_1",
            () -> new TheWatchTier1(new Item.Properties().stacksTo(1)));

    public static  final DeferredItem<Item> DaWatchT2 = ITEMS.register("the_watch_2",
            () -> new TheWatchTier2(new Item.Properties().stacksTo(1)));

    public static  final DeferredItem<Item> DaWatchT3 = ITEMS.register("the_watch_3",
            () -> new TheWatchTier3(new Item.Properties().stacksTo(1)));

    public static  final DeferredItem<Item> DaWatchT4 = ITEMS.register("the_watch_4",
            () -> new TheWatchTier4(new Item.Properties().stacksTo(1)));

    public static  final DeferredItem<Item> DaWatchT5 = ITEMS.register("the_watch_5",
            () -> new TheWatchTier5(new Item.Properties().stacksTo(1)));

    public static  final DeferredItem<Item> DaWatchT6 = ITEMS.register("the_watch_6",
            () -> new TheWatchTier6(new Item.Properties().stacksTo(1)));

    public static  final DeferredItem<Item> DaWatchT7 = ITEMS.register("the_watch_7",
            () -> new TheWatchTier7(new Item.Properties().stacksTo(1)));

    public static  final DeferredItem<Item> DaWatchT8 = ITEMS.register("the_watch_8",
            () -> new TheWatchTier8(new Item.Properties().stacksTo(1)));

    public static  final DeferredItem<Item> DaWatchOverHeaven = ITEMS.register("the_watch_oh",
            () -> new TheWatchOverHeaven(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
