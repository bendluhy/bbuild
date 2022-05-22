package net.benji.bbuild.module.modules.movement;

import net.benji.bbuild.module.Category;
import net.benji.bbuild.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class Step extends Module {
    public Step()
    {
        super("Step", Keyboard.KEY_B, Category.MOVEMENT);
    }
    public void onEnable()
    {
        Minecraft.getMinecraft().player.stepHeight = 2f;
    }
    public void onDisable()
    {
        Minecraft.getMinecraft().player.stepHeight = 0.5f;
    }
}
