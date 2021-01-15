package com.tyman.skyclientconfig.commands;

import com.tyman.skyclientconfig.BaseHandler;
import com.tyman.skyclientconfig.BasicCommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class DebugCommand extends BasicCommand {
    public DebugCommand() {
        super("scctest", new Object[]{"gt", 0});
    }

    @Override
    public void execute(ICommandSender sender, String[] args) {
        try {
            boolean switchTo;
            switch (args[1]) {
                case "true": {
                    switchTo = true;
                    break;
                }
                case "false": {
                    switchTo = false;
                    break;
                }
                default: {
                    switchTo = true;
                }
            }
            BaseHandler.setConfigProp(args[0], switchTo);
            sender.addChatMessage(new ChatComponentText("It worked probably"));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            sender.addChatMessage(new ChatComponentText("Illegal argument: " + e.getMessage()));
        } catch (Exception e) {
            e.printStackTrace();
            sender.addChatMessage(new ChatComponentText("Unhandled error" + e.getMessage()));
        }
    }
}
