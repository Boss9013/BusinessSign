package Boss90.RegionSheller;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public class BalanceBusiness implements CommandExecutor, Listener {
private GLClass plugin;

public BalanceBusiness(GLClass plugin) {
this.plugin = plugin;
}
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
   	 if(!sender.hasPermission("Business.balance")) {
   		 sender.sendMessage("§cУ вас нету прав!");
   		 return true;			 
   	 }
   	 {
			String Money = plugin.getConfig().getString("Messages.InsufficientBusinessBalanceMessage");
			Money = Money.replace("&", "\u00a7");
   		 String s = plugin.getConfig().getString("Balance.money");
   		 sender.sendMessage(Money + " " + s);
   		 return true;
   	 }
	}
}