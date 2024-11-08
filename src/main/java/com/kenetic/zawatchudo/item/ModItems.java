package com.kenetic.zawatchudo.item;

import com.kenetic.zawatchudo.ZaWatchudo;
import com.kenetic.zawatchudo.item.custom.thewatch.TheWatchTier1;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ZaWatchudo.MODID);

    public static  final DeferredItem<Item> FWatch = ITEMS.register("frozen_watch",
            () -> new Item(new Item.Properties()));

    public static  final DeferredItem<Item> DaWatch = ITEMS.register("the_watch",
            () -> new TheWatchTier1(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
