package net.notmaster.gtexolegs.common.data;

import net.notmaster.gtexolegs.GTExoLegs;
import net.notmaster.gtexolegs.common.data.lang.LangHandler;

import com.tterrag.registrate.providers.ProviderType;

public class ExoLegsDataGen {

    public static void init() {
        GTExoLegs.REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::init);
    }
}
