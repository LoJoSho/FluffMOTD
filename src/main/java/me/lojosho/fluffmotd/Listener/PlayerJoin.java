package me.lojosho.fluffmotd.Listener;

import me.lojosho.fluffmotd.FluffMOTD;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PlayerJoin implements Listener {

    private final FluffMOTD plugin;

    public PlayerJoin(FluffMOTD plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        for (String line : plugin.getConfig().getStringList("MOTD")) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
        }
        List<String> list = new LinkedList<>();
        list.addAll(plugin.getConfig().getStringList("Tips"));
        Random random = new Random(); //Create random class object
        int randomNumber = random.nextInt(list.size()); //Generate a random number (index) with the size of the list being the maximum
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&o" + list.get(randomNumber)));


        /*if (event.getPlayer().hasPermission("group.rank1")) {
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&a" + player.getName() + "&7has come to trade goods!"));
            event.setJoinMessage(null);
        } else {
            if (event.getPlayer().hasPermission("group.rank2")) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&a" + player.getName() + "&7has landed a CEO position!"));
                event.setJoinMessage(null);
            } else {
                if (event.getPlayer().hasPermission("group.rank3")) {
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&a" + player.getName() + "&7has flown here in a private jet!"));
                    Bukkit.broadcastMessage(player.getName() + "");
                    event.setJoinMessage(null);
                }
            }
        }*/
    }
}
