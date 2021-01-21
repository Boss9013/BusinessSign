package Boss90.RegionSheller;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class BalanceBusinessTake implements CommandExecutor, Listener {
private GLClass plugin;

public BalanceBusinessTake(GLClass plugin) {
this.plugin = plugin;
}
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
   	 if(!sender.hasPermission("Business.balancetake")) {
   		 sender.sendMessage("§cУ вас нету прав!");
   		 return true;			 
   	 }
   	 {
			String Failed = plugin.getConfig().getString("Messages.InsufficientBusinessFailedMessage");
			Failed = Failed.replace("&", "\u00a7");
			
			String Sucess = plugin.getConfig().getString("Messages.InsufficientBusinessSucessMessage");
			Sucess = Sucess.replace("&", "\u00a7");
		 int money = this.plugin.getConfig().getInt("Info.money");
		 Player player = (Player) sender;
		 this.plugin.getConfig().set("Info.money", 0);
		 GLClass.getInsance().saveConfig();
		 if(money == 0) {
			 sender.sendMessage(Failed);
			 return true;
		 }
		 EconomyManager.giveMoney(player, money);
   		 sender.sendMessage(Sucess + " " + money);
   		 return true;
		 }
	}
}