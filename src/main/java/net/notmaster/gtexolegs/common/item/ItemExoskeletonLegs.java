package net.notmaster.gtexolegs.common.item;

import net.minecraft.world.item.Item;

public class ItemExoskeletonLegs extends Item {

    protected int tier;

    protected ItemExoskeletonLegs(Properties properties, int tier) {
        super(properties);
        this.tier = tier;
    }

    public static ItemExoskeletonLegs create(Item.Properties properties, int tier) {
        return new ItemExoskeletonLegs(properties.stacksTo(1), tier);
    }
}
