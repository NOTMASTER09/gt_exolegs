package net.notmaster.gtexolegs.config;

import net.notmaster.gtexolegs.GTExoLegs;

import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.Configurable;
import dev.toma.configuration.config.format.ConfigFormats;

@Config(id = GTExoLegs.MOD_ID)
public class GTExoLegsConfig {

    public static GTExoLegsConfig INSTANCE;
    private static final Object LOCK = new Object();

    public static void init() {
        synchronized (LOCK) {
            if (INSTANCE == null) {
                INSTANCE = Configuration.registerConfig(GTExoLegsConfig.class, ConfigFormats.yaml())
                        .getConfigInstance();
            }
        }
    }

    @Configurable
    @Configurable.Comment({ "Step height modifier per tier", "Must be >= 0" })
    @Configurable.FixedSize
    @Configurable.DecimalRange(min = 0)
    public double[] stepHeightModifiers = { 0.4, 0.4, 0.4, 0.4, 0.4 };

    @Configurable
    @Configurable.Comment({ "Movement speed multiplier per tier", "Must be >= 0" })
    @Configurable.FixedSize
    @Configurable.DecimalRange(min = 0)
    public double[] movementSpeedMultipliers = { 0.2, 0.4, 0.6, 0.8, 1.0 };
}
