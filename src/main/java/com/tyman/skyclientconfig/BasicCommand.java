package com.tyman.skyclientconfig;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.Arrays;
import java.util.function.Supplier;

public abstract class BasicCommand extends CommandBase {

    String cmdName;
    Object[] argCount;

    /**
     * Execute the command
     * @param sender The ICommandSender who ran the command
     * @param args The arguments to run the command with
     */
    public abstract void execute(ICommandSender sender, String[] args);

    /**
     * Create the command instance
     * @param name The name of the command
     * @param argCount An array specifying the argument parsing.
     *                 The first value should be one of "eq", "lt", or "gt".
     *                 This specifies if it should check for exact, less than, or more than
     *                 the amount of specified arguments
     *                 The second value should be an int specifying how many args.
     */
    public BasicCommand(String name, Object[] argCount) {
        this.cmdName = name;
        String[] argModifiers = {"eq", "lt", "gt"};
        if (Arrays.stream(argModifiers).noneMatch(argCount[0]::equals)) {
            throw new IllegalArgumentException("Invalid argument length modifier");
        }
        this.argCount = argCount;
    }

    /**
     * Gets the name of this command
     * @return The name of the command
     */
    @Override
    public String getCommandName() {
        return cmdName;
    }

    /**
     * Get how to use this command
     * @param iCommandSender The
     * @return The ICommandSender who tried to run the command
     */
    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return cmdName;
    }

    /**
     * Checks if an ICommandSender can use this command
     * @param sender The ICommandSender trying to run the command
     * @return A boolean showing if they can run the command or not
     */
    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender)
    {
        return true;
    }

    /**
     * The internal processing of the command, this is how argument checking is done
     * @param sender The ICommandSender who ran the command
     * @param args The arguments to run the command with
     */
    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        try {
            Supplier<Boolean> expr = () -> args.length == (int) argCount[1];
            if (argCount[0] == "eq") {
                expr = () -> args.length == (int) argCount[1];
            } else if (argCount[0] == "lt") {
                expr = () -> args.length < (int) argCount[1];
            } else if (argCount[0] == "gt") {
                expr = () -> args.length > (int) argCount[1];
            }
            if (expr.get()) {
                this.execute(sender, args);
            } else {
                String argModNice = "Exactly ";
                switch ((String) argCount[0]) {
                    case "eq":
                        argModNice = "Exactly ";
                        break;

                    case "gt":
                        argModNice = "More than ";
                        break;

                    case "lt":
                        argModNice = "Less than ";
                        break;
                }
                sender.addChatMessage(
                        new ChatComponentText(
                                EnumChatFormatting.RED +
                                        "Invalid amount of arguments given!\n" +
                                        "Correct: " + argModNice + argCount[1] + " " +
                                        "Given: " + args.length
                        )
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
            sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "An error occurred while executing the command:"));
            sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + e.getMessage()));
        }
    }
}
