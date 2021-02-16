package Boss90.RegionSheller;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.md_5.bungee.api.ChatColor;

public class Join implements Listener{
	private GLClass plugin;

	public Join(GLClass plugin) {
	this.plugin = plugin;
	}
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		  Player player = (Player) event.getPlayer();
	 		if(this.plugin.getConfig().getString("Info.owner").contains(player.getName()) || this.plugin.getConfig().getStringList("Staff").contains(player.getName())) {
	   			String JoinMessage = plugin.getConfig().getString("JoinAndQuit.MessageJoin");
	   			JoinMessage = JoinMessage.replace("%player%", event.getPlayer().getName());
	   			if(plugin.chat == null) {
	   				return;
	   		 }  JoinMessage = JoinMessage.replace("%suffix%", this.plugin.chat.getPlayerPrefix(player));
	   			JoinMessage = JoinMessage.replace("%prefix%", this.plugin.chat.getPlayerPrefix(player));
	   			if (!plugin.getConfig().getBoolean("JoinAndQuit.Join"))
	   				return;
      Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',JoinMessage));
      return;
	   		}
	}	 @EventHandler
    		public void onPlayerQuitEvent(PlayerQuitEvent event) {
    			  Player player = (Player) event.getPlayer();
    		 		if(this.plugin.getConfig().getString("Info.owner").contains(player.getName()) || this.plugin.getConfig().getStringList("Staff").contains(player.getName())) {
    		   			String QuitMessage = plugin.getConfig().getString("JoinAndQuit.MessageQuit");
    		   			if(plugin.chat == null) {
    		   				return;
    		   			}
    		   			QuitMessage = QuitMessage.replace("%player%", event.getPlayer().getName());
    		   			QuitMessage = QuitMessage.replace("%suffix%", this.plugin.chat.getPlayerPrefix(player));
    		   			QuitMessage = QuitMessage.replace("%prefix%", this.plugin.chat.getPlayerPrefix(player));
    		   			if (!plugin.getConfig().getBoolean("JoinAndQuit.Quit"))
    		   				return;
    	      Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',QuitMessage));
    	      return;
    			  }
    	  } @SuppressWarnings("unused")
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