package jumppads.untitled;

import jumppads.untitled.listeners.FallDamage;
import jumppads.untitled.listeners.Moving;
import jumppads.untitled.listeners.PlayerTridentListener;
import jumppads.untitled.listeners.Riptide;
import org.bukkit.plugin.java.JavaPlugin;


public final class Untitled extends JavaPlugin {
    public static Untitled instance;
    public static Untitled getInstance() {
        return instance;
    }
    @Override
    public void onEnable() {
        // Plugin startup

        //Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();


        //Listeners
        getServer().getPluginManager().registerEvents(new FallDamage(this), this);
        getServer().getPluginManager().registerEvents(new Riptide(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown
    }
}
