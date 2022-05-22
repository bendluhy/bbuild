package net.benji.bbuild.module.modules.combat;

import net.benji.bbuild.module.Category;
import net.benji.bbuild.module.Module;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.input.Keyboard;

import java.util.Iterator;

import static net.benji.bbuild.BBuild.mc;

public class KillAura extends Module {
    public KillAura()
    {
        super("KillAura", Keyboard.KEY_R, Category.COMBAT);
    }
    public void update()
    {
        if(!this.isToggled()) {
            return;
        }
        for(Iterator<Entity> entities = mc.world.loadedEntityList.iterator(); entities.hasNext(); ){
            Object theObject = entities.hasNext();
            if(theObject instanceof EntityLivingBase) {
                EntityLivingBase entity = (EntityLivingBase) theObject;

                if(entity instanceof EntityPlayerSP) continue;

                if(mc.player.getDistanceSq(entity) <= 6.2173613F) {
                    if(entity.isEntityAlive()){
                        mc.playerController.attackEntity(mc.player, entity);
                        mc.player.swingArm(mc.player.swingingHand);
                        continue;
                    }
                }

            }
        }
        super.update();
    }
}
