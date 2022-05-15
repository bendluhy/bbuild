package net.benji.bbuild.module.modules.movement;

import net.benji.bbuild.module.Category;
import net.benji.bbuild.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class Fly extends Module {
    public Fly()
    {
        super("Fly", Keyboard.KEY_F, Category.MOVEMENT);
    }
    public void onEnable()
    {
        Minecraft.getMinecraft().player.capabilities.isFlying = true;
        Minecraft.getMinecraft().player.capabilities.allowFlying = true;
    }
    public void onDisable()
    {
        Minecraft.getMinecraft().player.capabilities.isFlying = false;
        Minecraft.getMinecraft().player.capabilities.allowFlying = false;
    }
}
