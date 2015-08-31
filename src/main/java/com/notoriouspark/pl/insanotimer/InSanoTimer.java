package com.notoriouspark.pl.insanotimer;

import com.notoriouspark.pl.insanotimer.commands.StopTimerCommand;
import com.notoriouspark.pl.insanotimer.commands.TimerCommand;
import com.notoriouspark.pl.insanotimer.commands.UHCInfoCommand;
import com.notoriouspark.pl.insanotimer.listeners.InventoryClickListener;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class InSanoTimer extends JavaPlugin {
    FileConfiguration config = this.getConfig();
    private String prefix;
    private boolean running = false;
    private int pvp;
    private int meetup;

    public void onEnable() {

        this.prefix = ChatColor.getByChar(config.getString("Bracket ID")) + "[ " + ChatColor.getByChar(config.getString("Server ID")) + "InSano" + ChatColor.getByChar(config.getString("Bracket ID")) + "] ";

        this.getServer().getPluginManager().registerEvents(new InventoryClickListener(this), this);

        this.getCommand("starttimer").setExecutor(new TimerCommand(this));
        this.getCommand("stoptimer").setExecutor(new StopTimerCommand(this));
        this.getCommand("uhcinfo").setExecutor(new UHCInfoCommand(this));

    }

    public FileConfiguration getConfig() {
        return this.config;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public boolean getRunning() {
        return this.running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getPvP() {
        return this.pvp;
    }

    public void setPvP(int pvp) {
        this.pvp = pvp;
    }

    public int getMeetUp() {
        return this.meetup;
    }

    public void setMeetUp(int meetup) {
        this.meetup = meetup;
    }
}
