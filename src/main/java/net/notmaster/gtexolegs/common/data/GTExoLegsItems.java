package net.notmaster.gtexolegs.common.data;

import com.gregtechceu.gtceu.api.GTValues;

import net.notmaster.gtexolegs.GTExoLegs;
import net.notmaster.gtexolegs.common.item.ItemExoskeletonLegs;

import com.tterrag.registrate.util.entry.ItemEntry;

import static net.notmaster.gtexolegs.GTExoLegs.REGISTRATE;

public class GTExoLegsItems {

    static {
        REGISTRATE.creativeModeTab(() -> GTExoLegsCreativeTabs.EXOLEGS_CREATIVE_TAB);
    }

    @SuppressWarnings("unused")
    public static final ItemEntry<ItemExoskeletonLegs> LV_EXOSKELETON_LEGS = REGISTRATE
            .item("lv_exoskeleton_legs", p -> ItemExoskeletonLegs.create(p, GTValues.LV))
            .lang("LV Exoskeleton Legs")
            .tag(GTExoLegs.EXOLEGS_TAG)
            .register();

    @SuppressWarnings("unused")
    public static final ItemEntry<ItemExoskeletonLegs> MV_EXOSKELETON_LEGS = REGISTRATE
            .item("mv_exoskeleton_legs", p -> ItemExoskeletonLegs.create(p, GTValues.MV))
            .lang("MV Exoskeleton Legs")
            .tag(GTExoLegs.EXOLEGS_TAG)
            .register();

    @SuppressWarnings("unused")
    public static final ItemEntry<ItemExoskeletonLegs> HV_EXOSKELETON_LEGS = REGISTRATE
            .item("hv_exoskeleton_legs", p -> ItemExoskeletonLegs.create(p, GTValues.HV))
            .lang("HV Exoskeleton Legs")
            .tag(GTExoLegs.EXOLEGS_TAG)
            .register();

    @SuppressWarnings("unused")
    public static final ItemEntry<ItemExoskeletonLegs> EV_EXOSKELETON_LEGS = REGISTRATE
            .item("ev_exoskeleton_legs", p -> ItemExoskeletonLegs.create(p, GTValues.EV))
            .lang("EV Exoskeleton Legs")
            .tag(GTExoLegs.EXOLEGS_TAG)
            .register();

    @SuppressWarnings("unused")
    public static final ItemEntry<ItemExoskeletonLegs> IV_EXOSKELETON_LEGS = REGISTRATE
            .item("iv_exoskeleton_legs", p -> ItemExoskeletonLegs.create(p, GTValues.IV))
            .lang("IV Exoskeleton Legs")
            .tag(GTExoLegs.EXOLEGS_TAG)
            .register();

    public static void init() {
    }
}
