package com.tyman.skyclientconfig;

import com.tyman.skyclientconfig.commands.DebugCommand;
import com.tyman.skyclientconfig.confighandlers.ModHandler;
import com.tyman.skyclientconfig.confighandlers.PatcherHandler;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

import java.util.HashMap;

@Mod(modid = com.tyman.skyclientconfig.SkyclientConfig.MODID, version = com.tyman.skyclientconfig.SkyclientConfig.VERSION)
public class SkyclientConfig
{
    public static final String MODID = "skyclientconfig";
    public static final String VERSION = "0.0.1";
    public static final HashMap<String, ModHandler> configHandlers = new HashMap<>();

    @Mod.Instance(MODID)
    public static com.tyman.skyclientconfig.SkyclientConfig INSTANCE;

    @SuppressWarnings("unused")
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ClientCommandHandler.instance.registerCommand(new DebugCommand());
    }

    @SuppressWarnings("unused")
    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        if (Loader.isModLoaded("patcher")) {
            configHandlers.put("patcher", new PatcherHandler());
        }
    }
}
