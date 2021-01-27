package Boss90.RegionSheller;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class BalanceBusiness implements CommandExecutor, Listener {
private GLClass plugin;

public BalanceBusiness(GLClass plugin) {
this.plugin = plugin;
}
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {		 
   		 Player player = (Player) sender;
    		if(this.plugin.getConfig().getString("Info.owner").contains(player.getName())) {
			String Money = plugin.getConfig().getString("Messages.InsufficientBusinessBalanceMessage");
			Money = Money.replace("&", "\u00a7");
			String Prefix = plugin.getConfig().getString("Messages.Prefix");
			Prefix = Prefix.replace("&", "\u00a7");
   		 String s = plugin.getConfig().getString("Info.money");
   		 sender.sendMessage(Prefix + " " + Money + " " + s);
    		} else {
    			String Prefix = plugin.getConfig().getString("Messages.Prefix");
    			Prefix = Prefix.replace("&", "\u00a7");
    			
    			String Error = plugin.getConfig().getString("Messages.Error");
    			Error = Error.replace("&", "\u00a7");
    			player.sendMessage(Prefix + " " + Error);
    			return true;
    		}
			return true;
	}
}