package jumppads.untitled.listeners;

import jumppads.untitled.Untitled;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

public class FallDamage implements Listener {

    Untitled plugin;

    public FallDamage(Untitled plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void noFallDamage(EntityDamageEvent player2){
        if (player2.getCause().equals(EntityDamageEvent.DamageCause.FALL) && plugin.getConfig().getBoolean("disable-fall-damage")){
                player2.setCancelled(true);
            }
        }
    }



