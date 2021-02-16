package Boss90.RegionSheller;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class BalanceBusinesss implements CommandExecutor, Listener {
private GLClass plugin;

public BalanceBusinesss(GLClass plugin) {
this.plugin = plugin;
}
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {		 
   		 Player player = (Player) sender;
  		if(this.plugin.getConfig().getString("Info.owner").contains(player.getName()) || this.plugin.getConfig().getStringList("Staff").contains(player.getName())) {
			String Money = plugin.getConfig().getString("Messages.InsufficientBusinessBalanceMessage");
			String Prefix = plugin.getConfig().getString("Messages.Prefix");
   		 String s = plugin.getConfig().getString("Info.money");
   		 sender.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + Money + " " + s));
    		} else {
    			String Prefix = plugin.getConfig().getString("Messages.Prefix");
    			
    			String Error = plugin.getConfig().getString("Messages.Error");
    			player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + Error));
    			return true;
    		}return true;
	}
}