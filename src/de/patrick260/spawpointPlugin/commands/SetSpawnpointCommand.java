package de.patrick260.spawpointPlugin.commands;

import de.patrick260.spawpointPlugin.main.Main;
import de.patrick260.spawpointPlugin.util.LanguageManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SetSpawnpointCommand implements CommandExecutor {

    private final FileConfiguration config = Main.getPlugin().getConfig();

    private final LanguageManager languageManager = Main.getPlugin().getLanguageManager();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        if (commandSender.hasPermission(config.getString("permissions.commands.admin.setSpawnpoint"))) {

            // PLAYER: /setspawnpoint
            if (args.length == 0) {

                if (commandSender instanceof Player) {

                    Player player = (Player) commandSender;

                    config.set("data.spawnpoint.world", Bukkit.getWorld(player.getWorld().getName()).getName());
                    config.set("data.spawnpoint.x", player.getLocation().getX());
                    config.set("data.spawnpoint.y", player.getLocation().getY());
                    config.set("data.spawnpoint.z", player.getLocation().getZ());
                    config.set("data.spawnpoint.yaw", player.getLocation().getYaw());
                    config.set("data.spawnpoint.pitch", player.getLocation().getPitch());

                    Main.getPlugin().saveConfig();
                    Main.getPlugin().reloadConfig();

                    player.sendMessage(languageManager.getText("messages.commands.setSpawnpointCommand.succesSetSpawnpointToPlayerPosition"));
                } else {

                    commandSender.sendMessage(languageManager.getText("messages.commands.setSpawnpointCommand.consoleSetSpawnpointWithWrongArgs"));

                }

            // PLAYER: /setspawnpoint <x, y, z>
            } else if (args.length == 3) {

                if (commandSender instanceof Player) {

                    try {

                        config.set("data.spawnpoint.world", Bukkit.getWorld(((Player) commandSender).getWorld().getName()).getName());
                        config.set("data.spawnpoint.x", Integer.parseInt(args[0]));
                        config.set("data.spawnpoint.y", Integer.parseInt(args[1]));
                        config.set("data.spawnpoint.z", Integer.parseInt(args[2]));

                        Main.getPlugin().saveConfig();
                        Main.getPlugin().reloadConfig();

                        commandSender.sendMessage(languageManager.getText("messages.commands.setSpawnpointCommand.succesSetSpawnpointToCoordinates"));


                    } catch (NumberFormatException exception) {

                        commandSender.sendMessage(languageManager.getText("messages.commands.setSpawnpointCommand.failToSetSpawnpointInvalidInput"));

                    }

                } else {

                    commandSender.sendMessage(languageManager.getText("messages.commands.setSpawnpointCommand.consoleSetSpawnpointWithWrongArgs"));

                }

            // PLAYER AND CONSOLE: /setspawnpoint <world, x, y, z>
            } else if (args.length == 4) {

                if (Bukkit.getWorld(args[0]) != null) {

                    try {

                        config.set("data.spawnpoint.world", Bukkit.getWorld(args[0]).getName());
                        config.set("data.spawnpoint.x", Integer.parseInt(args[1]));
                        config.set("data.spawnpoint.y", Integer.parseInt(args[2]));
                        config.set("data.spawnpoint.z", Integer.parseInt(args[3]));

                        Main.getPlugin().saveConfig();
                        Main.getPlugin().reloadConfig();

                        commandSender.sendMessage(languageManager.getText("messages.commands.setSpawnpointCommand.succesSetSpawnpointToCoordinates"));

                    } catch (NumberFormatException exception) {

                        commandSender.sendMessage(languageManager.getText("messages.commands.setSpawnpointCommand.consoleSetSpawnpointWithWrongArgs"));

                    }

                } else {

                    commandSender.sendMessage(languageManager.getText("messages.commands.setSpawnpointCommand.failToSetSpawnpointUnexistingWorld"));

                }

            // PLAYER: /setspawnpoint <x, y, z, yaw, pitch>
            } else if (args.length == 5) {

                if (commandSender instanceof Player) {

                    try {

                        config.set("data.spawnpoint.world", Bukkit.getWorld(((Player) commandSender).getWorld().getName()).getName());
                        config.set("data.spawnpoint.x", Integer.parseInt(args[0]));
                        config.set("data.spawnpoint.y", Integer.parseInt(args[1]));
                        config.set("data.spawnpoint.z", Integer.parseInt(args[2]));
                        config.set("data.spawnpoint.yaw", Integer.parseInt(args[3]));
                        config.set("data.spawnpoint.pitch", Integer.parseInt(args[4]));

                        Main.getPlugin().saveConfig();
                        Main.getPlugin().reloadConfig();

                        commandSender.sendMessage(languageManager.getText("messages.commands.setSpawnpointCommand.succesSetSpawnpointToCoordinates"));

                    } catch (NumberFormatException exception) {

                        commandSender.sendMessage(languageManager.getText("messages.commands.setSpawnpointCommand.failToSetSpawnpointInvalidInput"));

                    }

                } else {

                    commandSender.sendMessage(languageManager.getText("messages.commands.setSpawnpointCommand.consoleSetSpawnpointWithWrongArgs"));

                }

            // PLAYER AND CONSOLE: /setspawnpoint <world, x, y, z, yaw, pitch>
            } else if (args.length == 6) {

                if (Bukkit.getWorld(args[0]) != null) {

                    try {

                        config.set("data.spawnpoint.world", Bukkit.getWorld(args[0]).getName());
                        config.set("data.spawnpoint.x", Integer.parseInt(args[1]));
                        config.set("data.spawnpoint.y", Integer.parseInt(args[2]));
                        config.set("data.spawnpoint.z", Integer.parseInt(args[3]));
                        config.set("data.spawnpoint.yaw", Integer.parseInt(args[4]));
                        config.set("data.spawnpoint.pitch", Integer.parseInt(args[5]));

                        Main.getPlugin().saveConfig();
                        Main.getPlugin().reloadConfig();

                        commandSender.sendMessage(languageManager.getText("messages.commands.setSpawnpointCommand.succesSetSpawnpointToCoordinates"));

                    } catch (NumberFormatException exception) {

                        commandSender.sendMessage(languageManager.getText("messages.commands.setSpawnpointCommand.failToSetSpawnpointInvalidInput"));

                    }

                } else {

                    commandSender.sendMessage(languageManager.getText("messages.commands.setSpawnpointCommand.failToSetSpawnpointUnexistingWorld"));

                }

            } else {

                commandSender.sendMessage(languageManager.getText("messages.commands.setSpawnpointCommand.consoleSetSpawnpointWithWrongArgs"));

            }

        } else {

            commandSender.sendMessage(languageManager.getText("messages.commands.general.noPermissions"));

        }

        return true;

    }

}
