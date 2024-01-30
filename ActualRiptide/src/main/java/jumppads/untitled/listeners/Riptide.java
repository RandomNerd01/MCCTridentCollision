package jumppads.untitled.listeners;

import jumppads.untitled.Untitled;

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



import java.util.Objects;
import java.util.TooManyListenersException;
public class Riptide implements Listener{
    Untitled plugin;
    Untitled plugin1= Untitled.getInstance();
    public Riptide(Untitled plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerWalking(PlayerMoveEvent move) {

        if (plugin.getConfig().getBoolean("Working")) {
            Player player1 = move.getPlayer();
            BoundingBox box1 = getPlayerBoundingBox(player1);
            Location block = player1.getLocation();
            Location block1 = player1.getLocation();
            for (Player player5 : Bukkit.getServer().getOnlinePlayers()) {

                    BoundingBox box2 = getPlayerBoundingBox(player5);


                    if (box1.overlaps(box2)&&player5!=player1) {
                        player5.sendMessage("lol");
                        player5.hidePlayer( Untitled.getPlugin(Untitled.class), player1);
                        player1.hidePlayer( Untitled.getPlugin(Untitled.class), player5);
                        player5.hidePlayer( Untitled.getPlugin(Untitled.class), player5);
                        player1.hidePlayer( Untitled.getPlugin(Untitled.class), player1);
                        // Do something when players collide
                    }
                    if (!box1.overlaps(box2)&&player5!=player1){
                        player5.showPlayer(Untitled.getPlugin(Untitled.class), player1);
                    }
                if (!box1.overlaps(box2)&&player5!=player1){
                    player1.showPlayer(Untitled.getPlugin(Untitled.class),player5);
                }


            }





        }
    }
    public BoundingBox getPlayerBoundingBox(Player player) {
        // Get player's location
        Vector playerLocation = player.getLocation().toVector();


        // Calculate bounding box based on player's location and size
        double minX = playerLocation.getX() - 5.0; // Adjust based on player's size
        double minY = playerLocation.getY();
        double minZ = playerLocation.getZ() - 5.0; // Adjust based on player's size


        double maxX = playerLocation.getX() + 5.0; // Adjust based on player's size
        double maxY = playerLocation.getY() + 4.0; // Assuming the player's height is 1.8 blocks
        double maxZ = playerLocation.getZ() + 5.0; // Adjust based on player's size


        return new BoundingBox(minX, minY, minZ, maxX, maxY, maxZ);
    }



}
