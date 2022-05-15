package net.benji.bbuild.gui;

import java.io.IOException;
import java.util.ArrayList;

import net.benji.bbuild.BBuild;
import net.benji.bbuild.module.Category;
import net.benji.bbuild.module.Module;
import net.minecraft.client.gui.GuiScreen;

public class ClickGui extends GuiScreen{
	
	public ArrayList<Frame> frames;
	
	public ClickGui()
	{
		int offset = 0;
		frames = new ArrayList<>();
		for(Category c : Category.values()) {
			Frame frame = new Frame(c.name(), 100 + offset, 20, 100, 12);
			for (Module m : BBuild.moduleManager.getModsInCategory(c))
			{
				Button button = new Button(frame, m);
				frame.buttons.add(button);
			}
			frames.add(frame);
			offset += 150;
		}
	}
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX, mouseY, partialTicks);
		for (Frame f : frames)
		{
			f.update(mouseX,mouseY);
			f.drawScreen(mouseX, mouseY, partialTicks);
		}
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		super.keyTyped(typedChar, keyCode);
		for (Frame f : frames)
		{
			f.keyTyped(typedChar, keyCode);
		}
		
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		for (Frame f : frames)
		{
			f.mouseClicked(mouseX, mouseY, mouseButton);
		}
	}

	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		super.mouseReleased(mouseX, mouseY, state);
		for (Frame f : frames)
		{
			f.mouseReleased(mouseX, mouseY, state);
		}
	}

	@Override
	public boolean doesGuiPauseGame() {
		return super.doesGuiPauseGame();

	}

}
