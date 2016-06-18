package com.lwer0.modtools;

import com.lwer0.modtools.commands.mtopen;
import com.lwer0.modtools.inventories.MainInventory;
import com.lwer0.modtools.listeners.InventoryMove;
import com.lwer0.modtools.utils.ColorUtil;
import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;

public class ModTools extends JavaPlugin {
    
    //Enable
    @Override
    public void onEnable() {
        this.getLogger().info("ModTools enabled correctly");
        registerCommands();
        implement();
        createConfig();
    }
    
    @Override
    public void onDisable() {
        this.getLogger().info("ModTools disabled correctly");
    }
    
    public void registerCommands() {
        this.getCommand("mt").setExecutor(new mtopen());
    }
    
    public void implement() {
        this.getServer().getPluginManager().registerEvents(new ColorUtil(this), this);
        this.getServer().getPluginManager().registerEvents(new MainInventory(this), this);
        this.getServer().getPluginManager().registerEvents(new InventoryMove(this), this);
    }
    
    public void createConfig() {
        File config = new File(getDataFolder(), "config.yml");
        if (!getDataFolder().exists()) {
            saveDefaultConfig();
        } else {
            if (!config.exists()) {
                saveDefaultConfig();
            }
        }
    }
    
}