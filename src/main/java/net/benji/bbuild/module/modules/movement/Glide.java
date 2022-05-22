package net.benji.bbuild.module.modules.movement;

import net.benji.bbuild.module.Category;
import net.benji.bbuild.module.Module;
import net.minecraft.block.material.Material;
import org.lwjgl.input.Keyboard;

import static net.benji.bbuild.BBuild.mc;

public class Glide extends Module {
    public Glide()
    {
        super("Glide", Keyboard.KEY_Y, Category.MOVEMENT);
    }
    public void update() {
        double oldY = mc.player.motionY;
        float oldJ = mc.player.jumpMovementFactor;
        if(this.isToggled()){
            if((mc.player.motionY < 0.0d) && (mc.player.isAirBorne) && (!mc.player.isInWater()) && (!mc.player.isOnLadder()))
            {
                if(!mc.player.isInsideOfMaterial(Material.LAVA))
                {
                    mc.player.motionY = -.125d;
                    mc.player.jumpMovementFactor *= 1.12337f;
                }
            }
        }else {
            mc.player.motionY = oldY;
            mc.player.jumpMovementFactor = oldJ;
        }
    }
}
