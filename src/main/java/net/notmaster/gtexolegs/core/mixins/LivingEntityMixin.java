package net.notmaster.gtexolegs.core.mixins;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.notmaster.gtexolegs.common.entity.attribute.GTExoLegsAttributes;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import javax.annotation.Nullable;

@SuppressWarnings("unused")
@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Shadow
    @Nullable
    public abstract AttributeInstance getAttribute(Attribute pAttribute);

    @ModifyReturnValue(method = "getJumpBoostPower", at = @At("RETURN"))
    private float gtexolegs$getJumpBoostPower(float original) {
        float modifier = 0;
        AttributeInstance attribute = this.getAttribute(GTExoLegsAttributes.JUMP_BOOST_ADDITION.get());
        if (attribute != null) {
            modifier = (float) attribute.getValue();
        }
        return original + modifier;
    }
}
