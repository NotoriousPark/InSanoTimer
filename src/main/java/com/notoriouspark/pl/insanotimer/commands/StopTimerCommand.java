package com.notoriouspark.pl.insanotimer.commands;

import com.notoriouspark.pl.insanotimer.InSanoTimer;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StopTimerCommand implements CommandExecutor {

    private final InSanoTimer insanotimer;

    public StopTimerCommand(InSanoTimer insanotimer) {
        this.insanotimer = insanotimer;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (insanotimer.getRunning()) {
            insanotimer.setRunning(false);

            Bukkit.broadcastMessage(insanotimer.getPrefix() + "Timer stopped!");

            for (Player player : Bukkit.getOnlinePlayers()) {
                player.playSound(player.getLocation(), Sound.NOTE_BASS, 10, 1);
            }
            return true;
        } else {
            sender.sendMessage(insanotimer.getPrefix() + "No timer running!");
            return false;
        }
    }
}
