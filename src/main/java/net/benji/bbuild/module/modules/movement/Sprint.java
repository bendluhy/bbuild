package net.benji.bbuild.module.modules.movement;

import net.benji.bbuild.module.Category;
import net.benji.bbuild.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class Sprint extends Module {
    public Sprint()
    {
        super("Sprint", Keyboard.KEY_K, Category.MOVEMENT);
    }
    public void update()
    {
        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSprint.getKeyCode(), true);
    }
    public void onDisable()
    {
        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSprint.getKeyCode(), false);
    }
}
