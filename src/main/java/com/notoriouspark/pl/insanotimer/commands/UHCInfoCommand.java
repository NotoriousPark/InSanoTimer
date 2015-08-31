package com.notoriouspark.pl.insanotimer.commands;

import com.notoriouspark.pl.insanotimer.InSanoTimer;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class UHCInfoCommand implements CommandExecutor {

    private final InSanoTimer insanotimer;

    public UHCInfoCommand(InSanoTimer insanotimer) {
        this.insanotimer = insanotimer;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (insanotimer.getRunning()) {
            openUHCInfo((Player) sender);
        } else {
            sender.sendMessage(insanotimer.getPrefix() + "No timer is running!");
        }
        return false;
    }

    public void openUHCInfo(Player player) {
        Inventory uhcinfo = Bukkit.createInventory(null, 9, "UHC Info");

        ItemStack pvp = new ItemStack(Material.DIAMOND_SWORD, 1);
        pvp.getItemMeta().setDisplayName("PvP: " + insanotimer.getPvP());

        ItemStack meetup = new ItemStack(Material.COMPASS, 1);
        meetup.getItemMeta().setDisplayName("MeetUp: " + insanotimer.getMeetUp());

        uhcinfo.setItem(0, pvp);
        uhcinfo.setItem(1, meetup);

        player.openInventory(uhcinfo);
    }
}
