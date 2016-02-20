package com.packsgaminghd.freedomcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.packsgaminghd.freedomcore.config.ConfigManager;
import com.packsgaminghd.freedomcore.FreedomCore;
import static com.packsgaminghd.freedomcore.config.RankManager.isSeniorAdmin;
import static com.packsgaminghd.freedomcore.config.RankManager.isTelnetAdmin;

public class Command_admin implements CommandExecutor {
    
    private final FreedomCore plugin;
    
    public Command_admin(FreedomCore plugin) {
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = Bukkit.getPlayer(args[1]);
        if (isTelnetAdmin(player) || isSeniorAdmin(player))
        {
        if (args.length == 1) {
            if (!args[0].equalsIgnoreCase("list")) {
                return false;
            }
            sender.sendMessage(ChatColor.RED + "Admin list is currently under development");
            return true;
        }
        
        if (args.length == 2) {

            if (player == null) {
                sender.sendMessage(ChatColor.RED + "Player: " + args[1] + " is invalid");
                return true;
            }
            if (args[0].equalsIgnoreCase("add")) {
                Bukkit.broadcastMessage(ChatColor.GREEN + sender.getName() + " - Adding " + player.getName() + " to superadmin list");
                ConfigManager.getAdmin().getConfig().set(player.getUniqueId().toString() + ".name", player.getName());
                ConfigManager.getAdmin().getConfig().set(player.getUniqueId().toString() + ".ip", player.getAddress().getHostString());
                ConfigManager.getAdmin().getConfig().set(player.getUniqueId().toString() + ".admin", "super");
                ConfigManager.getAdmin().getConfig().set(player.getUniqueId().toString() + ".tag", "");
                ConfigManager.getAdmin().saveConfig();
                return true;
            }
            
            if (args[0].equalsIgnoreCase("delete")) {
                Bukkit.broadcastMessage(ChatColor.RED + sender.getName() + " - Removing " + player.getName() + " from superadmin list");
                ConfigManager.getAdmin().getConfig().set(player.getUniqueId().toString(), null);
                ConfigManager.getAdmin().saveConfig();
                return true;
            }
            return false;
        }
        return false;
        } else {
            sender.sendMessage(ChatColor.RED + "You do not have permission to use /admin");
        }
        return true;
    }
}
