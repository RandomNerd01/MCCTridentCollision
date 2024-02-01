package jumppads.tridentcollision1.Listeners;

import jumppads.tridentcollision1.TridentCollision1;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;

import org.bukkit.entity.Player;
import org.bukkit.entity.Player.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRiptideEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.GameMode;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TooManyListenersException;
public class TridentCollisionListener implements Listener {
    TridentCollision1 plugin;
    public final Set<Player> riptidingPlayers= new HashSet<>();
    public TridentCollisionListener(TridentCollision1 plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerWalking(PlayerMoveEvent move) {

        if (plugin.getConfig().getBoolean("Working")) {
            Player player1 = move.getPlayer();
            BoundingBox box1 = getPlayerBoundingBox(player1);
            for (Player player5 : Bukkit.getServer().getOnlinePlayers()) {
                if (player5!=player1) {
                    BoundingBox box2 = getPlayerBoundingBox(player5);


                    if (box1.overlaps(box2)&&(player5.isRiptiding()||player1.isRiptiding())) {
                            player5.hidePlayer(TridentCollision1.getPlugin(TridentCollision1.class), player1);
                            player1.hidePlayer(TridentCollision1.getPlugin(TridentCollision1.class), player5);

                        // Do something when players collide
                        }
                    if(!player5.isRiptiding()){
                        player5.showPlayer(TridentCollision1.getPlugin(TridentCollision1.class), player1);
                    }
                    if(!player1.isRiptiding()){
                        player1.showPlayer(TridentCollision1.getPlugin(TridentCollision1.class), player5);
                    }
                    }
                }




            }





        }

    public BoundingBox getPlayerBoundingBox(Player player) {
        // Get player's location
        Vector playerLocation = player.getLocation().toVector();


        // Calculate bounding box based on player's location and size
        double minX = playerLocation.getX() - 30.0; // Adjust based on player's size
        double minY = playerLocation.getY();
        double minZ = playerLocation.getZ() - 30.0; // Adjust based on player's size


        double maxX = playerLocation.getX() + 30.0; // Adjust based on player's size
        double maxY = playerLocation.getY() + 30.0; // Assuming the player's height is 1.8 blocks
        double maxZ = playerLocation.getZ() + 30.0; // Adjust based on player's size


        return new BoundingBox(minX, minY, minZ, maxX, maxY, maxZ);
    }



}





