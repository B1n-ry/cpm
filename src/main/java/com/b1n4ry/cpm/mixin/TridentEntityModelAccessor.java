package com.b1n4ry.cpm.mixin;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.TridentEntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(TridentEntityModel.class)
public interface TridentEntityModelAccessor {
    @Accessor("trident")
    public void setTrident(ModelPart trident);
}
