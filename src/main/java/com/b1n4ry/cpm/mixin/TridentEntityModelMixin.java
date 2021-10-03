package com.b1n4ry.cpm.mixin;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.TridentEntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TridentEntityModel.class)
public class TridentEntityModelMixin {
    private final ModelPart model = new ModelPart(64, 64, 0, 0);
    private TridentEntityModel tridentEntityModel;

    @Inject(at = @At("TAIL"), method = "<init>")
    private void init(CallbackInfo info) {
        System.out.println("Loading custom trident model");

        this.model.addCuboid(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F);
        ModelPart leftArm = new ModelPart(64, 64, 32, 48);
        leftArm.addCuboid(4.0F, 4.0F, -2.0F, 4.0F, 12.0F, 4.0F);
        this.model.addChild(leftArm);
        ModelPart rightArm = new ModelPart(64, 64, 40, 16);
        rightArm.addCuboid(-8.0F, 4.0F, -2.0F, 4.0F, 12.0F, 4.0F);
        this.model.addChild(rightArm);
        ModelPart torso = new ModelPart(64, 64, 16, 16);
        torso.addCuboid(-4.0F, 4.0F, -2.0F, 8.0F, 12.0F, 4.0F);
        this.model.addChild(torso);
        ModelPart leftLeg = new ModelPart(64, 64, 16, 48);
        leftLeg.addCuboid(0.0F, 16.0F, -2.0F, 4.0F, 12.0F, 4.0F);
        this.model.addChild(leftLeg);
        ModelPart rightLeg = new ModelPart(64, 64, 0, 16);
        rightLeg.addCuboid(-4.0F, 16, -2.0F, 4.0F, 12.0F, 4.0F);
        this.model.addChild(rightLeg);

        tridentEntityModel = (TridentEntityModel)(Object)this;
        TridentEntityModelAccessor tridentAccessor = (TridentEntityModelAccessor)tridentEntityModel;

        tridentAccessor.setTrident(this.model);
    }
}
