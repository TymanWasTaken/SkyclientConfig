package com.tyman.skyclientconfig;

import com.tyman.skyclientconfig.commands.DebugCommand;
import com.tyman.skyclientconfig.confighandlers.DSMHandler;
import com.tyman.skyclientconfig.confighandlers.ModHandler;
import com.tyman.skyclientconfig.confighandlers.PatcherHandler;
import com.tyman.skyclientconfig.utils.Utils;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

import java.util.HashMap;
import java.util.Map;

@Mod(modid = com.tyman.skyclientconfig.SkyclientConfig.MODID, version = com.tyman.skyclientconfig.SkyclientConfig.VERSION)
public class SkyclientConfig
{
    public static final String MODID = "skyclientconfig";
    public static final String VERSION = "0.0.1";
    public final HashMap<String, ModHandler> configHandlers = new HashMap<>();
    private static final Map<Class<? extends ModHandler>, String> modHandlers = Utils.createHandlerMap(
            new Object[]{PatcherHandler.class, "patcher"},
            new Object[]{DSMHandler.class, "Danker's Skyblock Mod"}
    );

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
    public void postInit(FMLPostInitializationEvent event) {
        for (Map.Entry<Class<? extends ModHandler>, String> modHandler : modHandlers.entrySet()) {
            ModHandler handlerClass;
            try {
                handlerClass = ModHandler.class.cast(Class.forName("com.tyman.skyclientconfig.confighandlers." + modHandler.getKey()));
            } catch (ClassNotFoundException e) {
                System.out.println("Handler class " + modHandler.getKey() + " was not found.");
                continue;
            } catch (ClassCastException e) {
                System.out.println("Unable to cast " + modHandler.getKey() + " to ModHandler");
                continue;
            }
            try {
                handlerClass = handlerClass.getClass().newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            if (Loader.isModLoaded(handlerClass.getModid())) {
                try {
                    handlerClass.init();
                } catch (Exception e) {
                    System.out.println("Unable to initialize handler " + modHandler.getKey());
                    e.printStackTrace();
                    continue;
                }
                configHandlers.put(handlerClass.getConfigPrefix(), handlerClass);
                System.out.println("Loaded config handler for mod " + handlerClass.getModid());
            }
        }
    }
}
