package net.notmaster.gtexolegs.common.data;

import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.CreativeModeTab;
import net.notmaster.gtexolegs.GTExoLegs;

public class GTExoLegsCreativeTabs {
    public static RegistryEntry<CreativeModeTab> EXOLEGS_CREATIVE_TAB = GTExoLegs.REGISTRATE.defaultCreativeTab(GTExoLegs.MOD_ID,
                    builder -> builder
                            .displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator(GTExoLegs.MOD_ID, GTExoLegs.REGISTRATE))
                            .title(GTExoLegs.REGISTRATE.addLang("itemGroup", GTExoLegs.id("creative_tab"), "GT Exoskeleton Legs"))
                            .build())
            .register();

    public static void init() {}
}
