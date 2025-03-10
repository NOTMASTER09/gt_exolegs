package net.notmaster.gtexolegs.common.data.lang;

import net.notmaster.gtexolegs.GTExoLegs;
import net.notmaster.gtexolegs.config.GTExoLegsConfig;

import com.tterrag.registrate.providers.RegistrateLangProvider;
import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.format.ConfigFormats;
import dev.toma.configuration.config.value.ConfigValue;
import dev.toma.configuration.config.value.ObjectValue;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Code stolen and adapted from https://github.com/GregTechCEu/GregTech-Modern

public class ConfigurationLang {

    public static void init(RegistrateLangProvider provider) {
        dfs(provider, new HashSet<>(),
                Configuration.registerConfig(GTExoLegsConfig.class, ConfigFormats.yaml()).getValueMap());
    }

    private static void dfs(RegistrateLangProvider provider, Set<String> added, Map<String, ConfigValue<?>> map) {
        for (var entry : map.entrySet()) {
            var id = entry.getValue().getId();
            if (added.add(id)) {
                provider.add(String.format("config.%s.option.%s", GTExoLegs.MOD_ID, id), id);
            }
            if (entry.getValue() instanceof ObjectValue objectValue) {
                dfs(provider, added, objectValue.get());
            }
        }
    }
}
