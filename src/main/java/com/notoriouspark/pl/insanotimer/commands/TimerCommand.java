package com.notoriouspark.pl.insanotimer.commands;

import com.notoriouspark.pl.insanotimer.InSanoTimer;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TimerCommand implements CommandExecutor {

    private final InSanoTimer insanotimer;

    public TimerCommand(InSanoTimer insanotimer) {
        this.insanotimer = insanotimer;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Bukkit.broadcastMessage("Running");

        if (!insanotimer.getRunning()) {
            if (args.length == 0) {
                insanotimer.setRunning(true);

                insanotimer.setPvP(insanotimer.getConfig().getInt("Default PvP"));
                insanotimer.setMeetUp(insanotimer.getConfig().getInt("Default MeetUp"));

                runGame();
                return true;
            } else if (args.length == 1) {
                if (args[0].matches("\\d+")) {
                    insanotimer.setRunning(true);

                    insanotimer.setPvP(Integer.parseInt(args[0]));
                    insanotimer.setMeetUp(insanotimer.getConfig().getInt("Default MeetUp"));

                    runGame();
                    return true;
                } else {
                    sender.sendMessage(insanotimer.getPrefix() + "Invalid Syntax.");
                    return true;
                }
            } else if (args.length == 2) {
                if (args[0].matches("\\d+") && args[1].matches("\\d+")) {
                    insanotimer.setRunning(true);

                    insanotimer.setPvP(Integer.parseInt(args[0]));
                    insanotimer.setMeetUp(Integer.parseInt(args[1]));

                    runGame();
                    return true;
                } else {
                    sender.sendMessage(insanotimer.getPrefix() + "Invalid Syntax.");
                    return true;
                }
            } else {
                sender.sendMessage(insanotimer.getPrefix() + "Invalid Syntax.");
                return true;
            }
        } else {
            sender.sendMessage(insanotimer.getPrefix() + "Timer is already running!");
            return true;
        }
    }

    public void runGame() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(insanotimer, new Runnable() {
            @Override
            public void run() {
                insanotimer.setPvP(insanotimer.getPvP() - 1);
                insanotimer.setMeetUp(insanotimer.getMeetUp() - 1);
            }
        }, 1200L, 1200L);
    }
}
