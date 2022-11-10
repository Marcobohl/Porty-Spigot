package de.marcobohl.portyspigot;


import de.marcobohl.portyspigot.internal.PlayerListener;
import de.marcobohl.portyspigot.internal.TeleportScheduler;
import de.marcobohl.portyspigot.internal.TeleportTimer;
import de.marcobohl.portyspigot.internal.io.IOStatics;
import de.marcobohl.portyspigot.internal.io.InputHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class Porty extends JavaPlugin {

    private static Porty instance;

    public static Porty getInstance() {
        return instance;
    }

    private TeleportScheduler teleportScheduler;
    private TeleportTimer teleportTimer;

    @Override
    public void onEnable() {
        instance = this;

        getServer().getMessenger().registerIncomingPluginChannel(this, IOStatics.CHANNEL, new InputHandler());
        getServer().getMessenger().registerOutgoingPluginChannel(this, IOStatics.CHANNEL);

        teleportScheduler = new TeleportScheduler();
        teleportTimer = new TeleportTimer();

        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }

    public TeleportScheduler getTeleportScheduler() {
        return teleportScheduler;
    }

    public TeleportTimer getTeleportTimer() {
        return teleportTimer;
    }
}
