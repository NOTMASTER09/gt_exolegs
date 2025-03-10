package net.notmaster.gtexolegs.common.data.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class LangHandler {

    public static void init(RegistrateLangProvider provider) {
        ConfigurationLang.init(provider);

        provider.add("curios.identifier.exoskeleton_legs", "Exoskeleton Legs");
    }
}
