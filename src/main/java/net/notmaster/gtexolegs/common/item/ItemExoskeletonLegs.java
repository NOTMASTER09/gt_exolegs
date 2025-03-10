package net.notmaster.gtexolegs.common.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;
import net.notmaster.gtexolegs.config.GTExoLegsConfig;

import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.UUID;

public class ItemExoskeletonLegs extends Item implements ICurioItem {

    private static final UUID STEP_HEIGHT_MODIFIER_UUID = UUID.fromString("b8a6abba-b241-4795-9ff9-00d98b52ec04");
    private static final UUID MOVEMENT_SPEED_MULTIPLIER_UUID = UUID.fromString("0687d81a-0ef8-4c45-9a5a-a1e6a13719a9");
    private static final Attribute STEP_HEIGHT_ADDITION = ForgeMod.STEP_HEIGHT_ADDITION.get();

    private final int tier;

    protected ItemExoskeletonLegs(Properties properties, int tier) {
        super(properties);
        this.tier = tier;
    }

    private void setAttributeModifier(LivingEntity entity, Attribute attribute, AttributeModifier modifier) {
        AttributeInstance instance = entity.getAttribute(attribute);
        if (instance != null) {
            if (instance.getModifier(modifier.getId()) != null) {
                instance.removeModifier(modifier.getId());
            }
            instance.addTransientModifier(modifier);
        }
    }

    private void removeAttributeModifier(LivingEntity entity, Attribute attribute, UUID id) {
        AttributeInstance instance = entity.getAttribute(attribute);
        if (instance != null) {
            if (instance.getModifier(id) != null) {
                instance.removeModifier(id);
            }
        }
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
        setAttributeModifier(slotContext.entity(), Attributes.MOVEMENT_SPEED, new AttributeModifier(
                MOVEMENT_SPEED_MULTIPLIER_UUID,
                "Exoskeleton Legs Movement Speed Multiplier",
                GTExoLegsConfig.INSTANCE.movementSpeedMultipliers[tier - 1],
                AttributeModifier.Operation.MULTIPLY_TOTAL));
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (!(slotContext.entity() instanceof Player player)) return;
        if (player.isShiftKeyDown()) {
            removeAttributeModifier(player, STEP_HEIGHT_ADDITION, STEP_HEIGHT_MODIFIER_UUID);
        } else {
            setAttributeModifier(player, STEP_HEIGHT_ADDITION, new AttributeModifier(
                    STEP_HEIGHT_MODIFIER_UUID,
                    "Exoskeleton Legs Step Height Boost",
                    GTExoLegsConfig.INSTANCE.stepHeightModifiers[tier - 1],
                    AttributeModifier.Operation.ADDITION));
        }
    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        removeAttributeModifier(slotContext.entity(), STEP_HEIGHT_ADDITION, STEP_HEIGHT_MODIFIER_UUID);
        removeAttributeModifier(slotContext.entity(), Attributes.MOVEMENT_SPEED, MOVEMENT_SPEED_MULTIPLIER_UUID);
    }

    public static ItemExoskeletonLegs create(Item.Properties properties, int tier) {
        return new ItemExoskeletonLegs(properties.stacksTo(1), tier);
    }
}
