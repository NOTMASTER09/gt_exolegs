package net.notmaster.gtexolegs.common.data;

import com.tterrag.registrate.providers.ProviderType;
import net.notmaster.gtexolegs.GTExoLegs;
import net.notmaster.gtexolegs.common.data.lang.LangHandler;

public class ExoLegsDataGen {
    public static void init(){
        GTExoLegs.REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::init);
    }
}
