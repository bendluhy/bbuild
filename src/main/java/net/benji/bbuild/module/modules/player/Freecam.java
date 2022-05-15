package net.benji.bbuild.module.modules.player;

import net.benji.bbuild.module.Category;
import net.benji.bbuild.module.Module;
import org.lwjgl.input.Keyboard;

public class Freecam extends Module {
    public Freecam()
    {
        super("Freecam", Keyboard.KEY_H, Category.PLAYER);
    }
}
