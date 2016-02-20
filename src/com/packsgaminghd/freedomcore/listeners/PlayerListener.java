package com.packsgaminghd.freedomcore.listeners;

import com.packsgaminghd.freedomcore.config.RankManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import com.packsgaminghd.freedomcore.FreedomCore;

public class PlayerListener implements Listener 
{

    public PlayerListener(FreedomCore plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public PlayerListener() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        
        if (RankManager.isSuperAdmin(player)) {
            if (RankManager.isSuperAdmin(player)) {
                event.setJoinMessage(ChatColor.AQUA + player.getName() + "is a " + ChatColor.GOLD + "Super Admin");
            }
            if (RankManager.isTelnetAdmin(player)) {
                event.setJoinMessage(ChatColor.AQUA + player.getName() + "is a " + ChatColor.GREEN + "Telnet Admin");
            }
            if (RankManager.isSeniorAdmin(player)) {
                event.setJoinMessage(ChatColor.AQUA + player.getName() + " is a " + ChatColor.LIGHT_PURPLE + "Senior Admin");
            }
            if (RankManager.isOwner(player)) {
                event.setJoinMessage(ChatColor.AQUA + player.getName() + "is the " + ChatColor.BLUE + "Owner");
            }
        }
    }
    
}