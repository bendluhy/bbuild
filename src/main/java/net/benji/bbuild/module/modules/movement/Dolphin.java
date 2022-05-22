package net.benji.bbuild.module.modules.movement;

import net.benji.bbuild.module.Category;
import net.benji.bbuild.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class Dolphin extends Module {
    public Dolphin() {
        super("Dolphin", Keyboard.KEY_M, Category.MOVEMENT);
    }

    public void update() {
        if(Minecraft.getMinecraft().player.isInWater()) {
            Minecraft.getMinecraft().player.motionY += 0.04;
        }
    }
}
