package net.benji.bbuild.module.modules.player;

import net.benji.bbuild.module.Category;
import net.benji.bbuild.module.Module;
import net.benji.bbuild.wrapper.Wrapper;
import net.minecraft.network.play.client.CPacketPlayer;
import org.lwjgl.input.Keyboard;

import static net.benji.bbuild.BBuild.mc;

public class NoFall extends Module {
    public NoFall() {
        super("NoFall", Keyboard.KEY_P, Category.PLAYER);
    }
    public void update() {
        if(this.isToggled()) {
            if(mc.player.fallDistance > 2f) {
                Wrapper.INSTANCE.sendPacket(new CPacketPlayer(true));
            }
            super.update();
        }
    }
}
