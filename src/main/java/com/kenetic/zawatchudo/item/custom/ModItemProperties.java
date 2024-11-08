package com.kenetic.zawatchudo.item.custom;

import com.kenetic.zawatchudo.ZaWatchudo;
import com.kenetic.zawatchudo.item.ModItems;
import com.kenetic.zawatchudo.item.custom.thewatch.TheWatchTier1;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {
    public static void addCustomItemProperties(){
        ItemProperties.register(ModItems.DaWatch.get(), ResourceLocation.fromNamespaceAndPath(ZaWatchudo.MODID,"active"),
                ((stack, level, entity, seed) -> TheWatchTier1.getActive() ? 1 : 0));
    }
}
