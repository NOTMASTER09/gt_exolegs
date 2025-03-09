package net.notmaster.gtexolegs;

import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.notmaster.gtexolegs.common.data.ExoLegsDataGen;
import net.notmaster.gtexolegs.common.data.GTExoLegsCreativeTabs;
import net.notmaster.gtexolegs.common.data.GTExoLegsItems;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(GTExoLegs.MOD_ID)
public class GTExoLegs {

    public static final String MOD_ID = "gtexolegs";
    public static final Logger LOGGER = LogManager.getLogger();
    public static GTRegistrate REGISTRATE = GTRegistrate.create(GTExoLegs.MOD_ID);


    public static final TagKey<Item> EXOLEGS_TAG = TagKey.create(BuiltInRegistries.ITEM.key(), new ResourceLocation("curios", "exoskeleton_legs"));

    public GTExoLegs() {
        GTExoLegsCreativeTabs.init();
        GTExoLegs.init();
        REGISTRATE.registerRegistrate();
        ExoLegsDataGen.init();
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static void init() {
        GTExoLegsItems.init();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
