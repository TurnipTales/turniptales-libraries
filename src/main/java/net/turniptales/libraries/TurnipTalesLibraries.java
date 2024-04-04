package net.turniptales.libraries;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.NamedTextColor.RED;
import static org.bukkit.Bukkit.getPluginManager;
import static org.bukkit.event.player.PlayerLoginEvent.Result.KICK_OTHER;

public class TurnipTalesLibraries extends JavaPlugin implements Listener {

    /**
     * In Gedenken an Toms Versuche uns doch irgendwie Skript unterzujubeln...
     *
     * <blockquote><pre>
     *  #
     *  # TurnipTales Plugin Check
     *  #
     *  on connect:
     *      if plugin "TurnipTales" is not enabled:
     *          if player is not an operator:
     *              kick player due to "Fehler: Das Plugin wurde nicht korrekt geladen."
     * </pre></blockquote>
     */
    @Override
    public void onEnable() {
        getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        if (getPluginManager().isPluginEnabled("TurnipTales") || event.getPlayer().isOp()) {
            return;
        }

        event.disallow(KICK_OTHER, text("Fehler: Das Plugin wurde nicht korrekt geladen.", RED));
    }
}
