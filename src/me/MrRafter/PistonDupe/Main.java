package me.MrRafter.PistonDupe;

import me.MrRafter.PistonDupe.evt.PistonEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    FileConfiguration config;
    public void onEnable() {
        config = getConfig();

        saveDefaultConfig();

        int pluginId = 17584;
        Metrics metrics = new Metrics(this, pluginId);

        getServer().getPluginManager().registerEvents(new PistonEvent(this), this);
        Bukkit.getLogger().info("PistonDupe loaded succesfully");
    }

    public static Main getPlugin(){
        return getPlugin(Main.class);
    }
}
