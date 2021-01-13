package com.tyman.skyclientconfig.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class DebugCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "sccdebug";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "sccdebug";
    }

    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        // pass
    }
}
