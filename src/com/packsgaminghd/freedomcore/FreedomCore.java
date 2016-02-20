package com.packsgaminghd.freedomcore;

import java.util.logging.Level;
import org.bukkit.plugin.java.JavaPlugin;
import com.packsgaminghd.freedomcore.commands.*;
import com.packsgaminghd.freedomcore.config.ConfigManager;
import com.packsgaminghd.freedomcore.listeners.PlayerListener;
import com.packsgaminghd.freedomcore.listeners.ServerListener;
import static org.bukkit.Bukkit.getServer;
import org.bukkit.plugin.PluginManager;

public class FreedomCore extends JavaPlugin {
    public static FreedomCore plugin;
    PluginManager pm = getServer().getPluginManager();
    
    @Override
    public void onLoad() {
        plugin = this;

    }
    
    @Override
    public void onEnable() {
        register();
        getLogger().log(Level.INFO, "FreedomCore enabled! Created by PacksGamingHD");
    }
    
    @Override
    public void onDisable() {
        getLogger().log(Level.INFO, "FreedomCore disabled!");
    }
    
    public void register() {
        /*ConfigManager.getAdmin().saveDefaultConfig();
        ConfigManager.getMConfig().saveDefaultConfig();
        pm.registerEvents(new ServerListener(), this);
        pm.registerEvents(new PlayerListener(), this);*/
        new ConfigManager();
        ConfigManager.getAdmin().saveDefaultConfig();
        ConfigManager.getMConfig().saveDefaultConfig();
        this.getCommand("list").setExecutor(new Command_list(this));
        this.getCommand("fc").setExecutor(new Command_fc(this));
        this.getCommand("admin").setExecutor(new Command_admin(this));
        this.getCommand("op").setExecutor(new Command_op(this));
    }
}
