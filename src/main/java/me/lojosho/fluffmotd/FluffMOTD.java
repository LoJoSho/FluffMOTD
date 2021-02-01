package me.lojosho.fluffmotd;

import me.lojosho.fluffmotd.Listener.PlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;

public final class FluffMOTD extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
