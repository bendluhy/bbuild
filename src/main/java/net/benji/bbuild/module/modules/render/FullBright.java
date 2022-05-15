package net.benji.bbuild.module.modules.render;

import net.benji.bbuild.module.Category;
import net.benji.bbuild.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class FullBright extends Module {
    public FullBright()
    {
        super("Fullbright", Keyboard.KEY_O, Category.RENDER);
    }
    public void update()
    {
        Minecraft.getMinecraft().gameSettings.gammaSetting = 100;
    }
    public void onDisable()
    {
        Minecraft.getMinecraft().gameSettings.gammaSetting = 0;
    }

}
