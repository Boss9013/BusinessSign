package Boss90.RegionSheller;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.md_5.bungee.api.ChatColor;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Join implements Listener{
	private GLClass plugin;

	public Join(GLClass plugin) {
	this.plugin = plugin;
	}
	@SuppressWarnings("unused")
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		  Player player = (Player) event.getPlayer();
	   		for(Player player1 : Bukkit.getOnlinePlayers()) {
	   			if(!player.hasPermission("Business.Join")) continue;
	   			PermissionUser user = PermissionsEx.getUser(player);
	   			String JoinMessage = plugin.getConfig().getString("JoinAndQuit.MessageJoin");
	   			JoinMessage = JoinMessage.replace("&", "\u00a7");
	   			JoinMessage = JoinMessage.replace("%player%", event.getPlayer().getName());
	   			JoinMessage = JoinMessage.replace("%suffix%", user.getSuffix());
	   			JoinMessage = JoinMessage.replace("%prefix%", user.getPrefix());
	   			if (!plugin.getConfig().getBoolean("JoinAndQuit.Join"))
	   				return;
      Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',JoinMessage));
      return;
	   		}
	}
    		@SuppressWarnings("unused")
			@EventHandler
    		public void onPlayerQuitEvent(PlayerQuitEvent event) {
    			  Player player = (Player) event.getPlayer();
    		   		for(Player player1 : Bukkit.getOnlinePlayers()) {
    		   			if(!player.hasPermission("Business.Quit")) continue;
    		   			PermissionUser user = PermissionsEx.getUser(player);
    		   			String QuitMessage = plugin.getConfig().getString("JoinAndQuit.MessageQuit");
    		   			QuitMessage = QuitMessage.replace("&", "\u00a7");
    		   			QuitMessage = QuitMessage.replace("%player%", event.getPlayer().getName());
    		   			QuitMessage = QuitMessage.replace("%suffix%", user.getSuffix());
    		   			QuitMessage = QuitMessage.replace("%prefix%", user.getPrefix());
    		   			if (!plugin.getConfig().getBoolean("JoinAndQuit.Quit"))
    		   				return;
    	      Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',QuitMessage));
    	      return;
    			  }
    		}
    		@EventHandler
    		public void onPlayerJoinEvent1(PlayerJoinEvent event) {
  			    Player player = (Player) event.getPlayer();
		   		for(Player player1 : Bukkit.getOnlinePlayers()) {
		   			if(!player.hasPermission("Business.update")) continue;
    				player.sendMessage("Проверь новую обнову плагина, может быть она уже вышла.");
    				player.sendMessage("spigot: https://www.spigotmc.org/resources/businesssign-plugin-for-businesses-1-12-2.88056/");
    				player.sendMessage("Check out the new plugin update, maybe it's already out.");
		   		}
    		}
}