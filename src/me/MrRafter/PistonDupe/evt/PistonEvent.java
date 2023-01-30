package me.MrRafter.PistonDupe.evt;

import me.MrRafter.PistonDupe.Main;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingBreakEvent;

public class PistonEvent implements Listener {
    private Main plugin;

    public PistonEvent(Main instance) {
        this.plugin = instance;
    }
    @EventHandler
    public void onItemPickup(HangingBreakEvent e){
        if(plugin.getConfig().getBoolean("piston-dupe.enabled")){
            if (e.getEntity().getType() == EntityType.ITEM_FRAME) {
                if (e.getCause() == HangingBreakEvent.RemoveCause.PHYSICS) {
                    ItemFrame itemFrame = (ItemFrame) e.getEntity();
                    if (itemFrame.getItem() != null) {
                        if (!(itemFrame.getItem().getType() == Material.AIR)) {
                            if (itemFrame.getWorld().getBlockAt(itemFrame.getLocation()).getRelative(itemFrame.getAttachedFace()).getType() != Material.AIR){
                                int amount = plugin.getConfig().getInt("piston-dupe.amount");
                                for (int i = 0; i < amount; i++) {
                                    itemFrame.getWorld().dropItem(itemFrame.getLocation(), itemFrame.getItem());
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
