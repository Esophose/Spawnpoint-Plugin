package de.patrick260.spawpointPlugin.commands;

import de.patrick260.spawpointPlugin.main.Main;
import de.patrick260.spawpointPlugin.util.LanguageManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class ReloadConfigCommand implements CommandExecutor {

    LanguageManager languageManager = Main.getPlugin().getLanguageManager();

    FileConfiguration config;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        config = Main.getPlugin().getConfig();

        if (commandSender.hasPermission(config.getString("permissions.commands.admin.reloadConfig"))) {

            Main.getPlugin().reloadConfig();
            languageManager.reloadLanguage();

            commandSender.sendMessage(languageManager.getText("messages.commands.reloadConfigCommand.reloadSuccess"));

        }

        return true;

    }

}
