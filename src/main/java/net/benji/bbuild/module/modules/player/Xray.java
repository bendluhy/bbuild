package net.benji.bbuild.module.modules.player;

import net.benji.bbuild.module.Category;
import net.benji.bbuild.module.Module;
import net.minecraft.block.Block;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;

import static net.benji.bbuild.BBuild.mc;

public class Xray extends Module {
    public static boolean enabled;
    public float oldGamma;
    public ArrayList<Block> xrayBlocks = new ArrayList<Block>();
    public Xray()
    {
        super("Xray", Keyboard.KEY_X, Category.RENDER);
    }
    public void onEnable() {
        Xray.enabled = true;
        this.oldGamma = mc.gameSettings.gammaSetting;
        mc.gameSettings.gammaSetting = 10.0f;
        mc.gameSettings.ambientOcclusion = 0;
        mc.renderGlobal.loadRenderers();
    }
    public void onDisable() {
        Xray.enabled = false;
        mc.gameSettings.gammaSetting = this.oldGamma;
        mc.gameSettings.ambientOcclusion = 1;
        mc.renderGlobal.loadRenderers();
    }
    public boolean shouldXrayBlock(Block blockid) {
        if(this.xrayBlocks.contains(blockid)) {
            return true;
        }
        return false;
    }
}
