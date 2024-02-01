package jumppads.tridentcollision1;

import jumppads.tridentcollision1.Listeners.TridentCollisionListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class TridentCollision1 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        //Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new TridentCollisionListener(this), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
