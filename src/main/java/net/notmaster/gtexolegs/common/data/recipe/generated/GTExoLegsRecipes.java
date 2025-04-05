package net.notmaster.gtexolegs.common.data.recipe.generated;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.notmaster.gtexolegs.GTExoLegs;
import net.notmaster.gtexolegs.common.data.GTExoLegsItems;

import com.tterrag.registrate.util.entry.ItemEntry;

import java.util.HashMap;
import java.util.Objects;
import java.util.function.Consumer;

public class GTExoLegsRecipes {

    public static HashMap<Integer, ItemEntry<? extends Item>> exoskeletonItems = new HashMap<>();
    public static HashMap<Integer, ItemEntry<? extends Item>> motors = new HashMap<>();
    public static HashMap<Integer, ItemEntry<? extends Item>> pistonItems = new HashMap<>();
    public static HashMap<Integer, TagKey<? extends Item>> circuitItems = new HashMap<>();

    public static void init(Consumer<FinishedRecipe> provider) {
        initItems();
        registerRecipes(provider);
    }

    private static void initItems() {
        exoskeletonItems.put(GTValues.LV, GTExoLegsItems.LV_EXOSKELETON_LEGS);
        exoskeletonItems.put(GTValues.MV, GTExoLegsItems.MV_EXOSKELETON_LEGS);
        exoskeletonItems.put(GTValues.HV, GTExoLegsItems.HV_EXOSKELETON_LEGS);
        exoskeletonItems.put(GTValues.EV, GTExoLegsItems.EV_EXOSKELETON_LEGS);
        exoskeletonItems.put(GTValues.IV, GTExoLegsItems.IV_EXOSKELETON_LEGS);

        motors.put(GTValues.LV, GTItems.ELECTRIC_MOTOR_LV);
        motors.put(GTValues.MV, GTItems.ELECTRIC_MOTOR_MV);
        motors.put(GTValues.HV, GTItems.ELECTRIC_MOTOR_HV);
        motors.put(GTValues.EV, GTItems.ELECTRIC_MOTOR_EV);
        motors.put(GTValues.IV, GTItems.ELECTRIC_MOTOR_IV);

        pistonItems.put(GTValues.LV, GTItems.ELECTRIC_PISTON_LV);
        pistonItems.put(GTValues.MV, GTItems.ELECTRIC_PISTON_MV);
        pistonItems.put(GTValues.HV, GTItems.ELECTRIC_PISTON_HV);
        pistonItems.put(GTValues.EV, GTItems.ELECTRIC_PISTON_EV);
        pistonItems.put(GTValues.IV, GTItems.ELECTRIC_PISTON_IV);

        circuitItems.put(GTValues.LV, CustomTags.LV_CIRCUITS);
        circuitItems.put(GTValues.MV, CustomTags.MV_CIRCUITS);
        circuitItems.put(GTValues.HV, CustomTags.HV_CIRCUITS);
        circuitItems.put(GTValues.EV, CustomTags.EV_CIRCUITS);
        circuitItems.put(GTValues.IV, CustomTags.IV_CIRCUITS);
    }

    private static void registerRecipes(Consumer<FinishedRecipe> provider) {
        for (int tier : exoskeletonItems.keySet()) {
            ItemStack stack = exoskeletonItems.get(tier).asStack();
            ResourceLocation recipeName = GTExoLegs
                    .id(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(exoskeletonItems.get(tier).get()))
                            .getPath());
            VanillaRecipeHelper.addShapedRecipe(provider, recipeName, stack,
                    "MDM",
                    "PCP",
                    "L L",
                    'M', motors.get(tier),
                    'P', pistonItems.get(tier),
                    'C', circuitItems.get(tier),
                    'L', new MaterialEntry(TagPrefix.plate, GTMaterials.TinAlloy),
                    'D', new MaterialEntry(TagPrefix.plateDouble, GTMaterials.TinAlloy));
        }
    }
}
