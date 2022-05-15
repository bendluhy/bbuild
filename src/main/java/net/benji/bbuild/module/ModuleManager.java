package net.benji.bbuild.module;

import net.benji.bbuild.module.modules.client.ClickGuiModule;
import net.benji.bbuild.module.modules.movement.Fly;
import net.benji.bbuild.module.modules.movement.Sprint;
import net.benji.bbuild.module.modules.player.Freecam;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;

public class ModuleManager {
    public ArrayList<Module> modules;

    public ModuleManager()
    {
        modules = new ArrayList<Module>();
        MinecraftForge.EVENT_BUS.register(this);
        init();
    }
    public void init()
    {
        //Where to add module
        modules.add(new Fly());
        modules.add(new Sprint());
        modules.add(new ClickGuiModule());
        modules.add(new Freecam());
    }
    public ArrayList<Module> getModules()
    {
        return modules;
    }
    public Module getModule(String name)
    {
        for(Module m : modules)
        {
            if(m.getName().equalsIgnoreCase(name))
            {
                return m;
            }
        }
        return null;
    }
    public ArrayList<Module> getModsInCategory(Category cat)
    {
        ArrayList<Module> mods = new ArrayList<Module>();
        for(Module m : modules)
        {
            if(m.getCategory() == cat)
            {
                mods.add(m);
            }
        }
        return mods;
    }
    @SubscribeEvent
    public void onkey(InputEvent.KeyInputEvent event)
    {
        if(Keyboard.getEventKeyState())
        {
            for(Module m : modules)
            {
                if(m.getKey() == Keyboard.getEventKey())
                {
                    m.toggle();
                }
            }
        }
    }
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event)
    {
        for(Module m : modules)
        {
            if(m.isToggled())
            {
                m.update();
            }
        }
    }
    public void onRender(RenderWorldLastEvent event)
    {
        for(Module m : modules)
        {
            if(m.isToggled())
            {
                m.render();
            }
        }
    }
}
