package net.benji.bbuild;

import net.benji.bbuild.gui.ClickGui;
import net.benji.bbuild.module.ModuleManager;
import net.benji.bbuild.proxy.CommonProxy;
import net.benji.bbuild.setting.SettingsManager;
import net.benji.bbuild.util.Reference;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.Mod.Instance;

import java.sql.Ref;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME)
public class BBuild
{
    @Instance
    public static BBuild instance = new BBuild();
    public static ModuleManager moduleManager;
    public SettingsManager settingsManager;


    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;
    public static ClickGui clickGui;
    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(instance);
        moduleManager = new ModuleManager();
        clickGui = new ClickGui();
    }
}
