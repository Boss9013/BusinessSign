package Boss90.RegionSheller;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public class HelpToPlugin implements CommandExecutor, Listener {
private GLClass plugin;

public HelpToPlugin(GLClass plugin) {
this.plugin = plugin;
}
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
   	 if(!sender.hasPermission("Business.balance")) {
   		 sender.sendMessage("ßc” ‚‡Ò ÌÂÚÛ Ô‡‚!");
   		 return true;			 
   	 }
   	 {
   		 String prefixsign = plugin.getConfig().getString("Sign.Prefix");
   		 sender.sendMessage("ßdHelp:");
   		 sender.sendMessage("To create a business, you need to enter: ß3" + prefixsign +  "ßf, in the first line of the table, then the region and the cost of the business.");
   		 sender.sendMessage("The ßedata.yml ßffile will store the coordinates of all the placemarks where ß3"  + prefixsign + "ßf, is specified, when the buy business coordinates disappear.");
   		 sender.sendMessage("ß6Commands:");
   		 sender.sendMessage("ßa/sbalanceßf - find out the business balance.");
   		 sender.sendMessage("ßa/stakebalance ßf- withdraw money from the business.");
   		 sender.sendMessage("ßa/shopGUI ßf- GUI shop from business.");
   		 sender.sendMessage("ßa/sremoveowner ßf- remove owner from business.");
   		 sender.sendMessage("ßa/swipebusiness ßf- wipe from business.");
   		 sender.sendMessage("ß4WARNING:");
   		 sender.sendMessage("ßcOnly 1 business can be put up for sale. 2 or more businesses can lead to a bug.");
   		 return true;
   	 }
	}
}