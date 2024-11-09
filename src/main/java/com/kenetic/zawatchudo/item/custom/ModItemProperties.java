package com.kenetic.zawatchudo.item.custom;

import com.kenetic.zawatchudo.ZaWatchudo;
import com.kenetic.zawatchudo.item.ModItems;
import com.kenetic.zawatchudo.item.custom.thewatch.*;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {
    public static void addCustomItemProperties(){
        ItemProperties.register(ModItems.DaWatch.get(), ResourceLocation.fromNamespaceAndPath(ZaWatchudo.MODID,"active"),
                ((stack, level, entity, seed) -> TheWatchTier1.getActive() ? 1 : 0));
        ItemProperties.register(ModItems.DaWatchT2.get(), ResourceLocation.fromNamespaceAndPath(ZaWatchudo.MODID,"active"),
                ((stack, level, entity, seed) -> TheWatchTier2.getActive() ? 1 : 0));
        ItemProperties.register(ModItems.DaWatchT3.get(), ResourceLocation.fromNamespaceAndPath(ZaWatchudo.MODID,"active"),
                ((stack, level, entity, seed) -> TheWatchTier3.getActive() ? 1 : 0));
        ItemProperties.register(ModItems.DaWatchT4.get(), ResourceLocation.fromNamespaceAndPath(ZaWatchudo.MODID,"active"),
                ((stack, level, entity, seed) -> TheWatchTier4.getActive() ? 1 : 0));
        ItemProperties.register(ModItems.DaWatchT5.get(), ResourceLocation.fromNamespaceAndPath(ZaWatchudo.MODID,"active"),
                ((stack, level, entity, seed) -> TheWatchTier5.getActive() ? 1 : 0));
        ItemProperties.register(ModItems.DaWatchT6.get(), ResourceLocation.fromNamespaceAndPath(ZaWatchudo.MODID,"active"),
                ((stack, level, entity, seed) -> TheWatchTier6.getActive() ? 1 : 0));
        ItemProperties.register(ModItems.DaWatchT7.get(), ResourceLocation.fromNamespaceAndPath(ZaWatchudo.MODID,"active"),
                ((stack, level, entity, seed) -> TheWatchTier7.getActive() ? 1 : 0));
        ItemProperties.register(ModItems.DaWatchT8.get(), ResourceLocation.fromNamespaceAndPath(ZaWatchudo.MODID,"active"),
                ((stack, level, entity, seed) -> TheWatchTier8.getActive() ? 1 : 0));
    }
}
