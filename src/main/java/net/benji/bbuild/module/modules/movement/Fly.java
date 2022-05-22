package net.benji.bbuild.module.modules.movement;

import net.benji.bbuild.module.Category;
import net.benji.bbuild.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class Fly extends Module {
    public static float flyHackSpeed = 0.1f;
    public Fly()
    {
        super("Fly", Keyboard.KEY_F, Category.MOVEMENT);
    }
    Minecraft mc = Minecraft.getMinecraft();
    public void update()
    {
        if(this.isToggled()){
            mc.player.capabilities.isFlying = true;
            if(mc.gameSettings.keyBindJump.isPressed()){
                mc.player.motionY += 0.2f;
            }
            if(mc.gameSettings.keyBindSneak.isPressed()){
                mc.player.motionY -= 0.2f;
            }
            if(mc.gameSettings.keyBindForward.isPressed()) {
                mc.player.capabilities.setFlySpeed(flyHackSpeed);
            }
            super.onDisable();
        }

    }
    public void onDisable()
    {
        Minecraft.getMinecraft().player.capabilities.isFlying = false;
        super.onDisable();
    }
}
