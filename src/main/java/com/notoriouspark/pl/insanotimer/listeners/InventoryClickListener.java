package com.notoriouspark.pl.insanotimer.listeners;

import com.notoriouspark.pl.insanotimer.InSanoTimer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    private final InSanoTimer insanotimer;

    public InventoryClickListener(InSanoTimer insanotimer) {
        this.insanotimer = insanotimer;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getName().equals("UHC Info")) {
            event.setCancelled(true);
        }
    }

}
