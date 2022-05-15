package net.benji.bbuild.module.modules.client;

import net.benji.bbuild.BBuild;
import net.benji.bbuild.module.Category;
import net.benji.bbuild.module.Module;
import org.lwjgl.input.Keyboard;


import net.minecraft.client.Minecraft;

public class ClickGuiModule extends Module {
	public ClickGuiModule()
	{
		super("ClickGui", Keyboard.KEY_RSHIFT, Category.CLIENT);
	}
	
	public void onEnable()
	{
		Minecraft.getMinecraft().displayGuiScreen(BBuild.clickGui);
		toggle();
	}
}
