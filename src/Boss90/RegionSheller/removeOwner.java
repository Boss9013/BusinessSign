package Boss90.RegionSheller;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class removeOwner implements CommandExecutor, Listener {
	private GLClass plugin;

	public removeOwner(GLClass plugin) {
	this.plugin = plugin;
	}
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
   	 if(!sender.hasPermission("Business.removeowner")) {
   		 sender.sendMessage("§cError");
   		 return true;			 
   	 }
   	 {
   		 Player p = (Player) sender;
		 this.plugin.getConfig().set("Info.owner", "Null");
		 GLClass.getInsance().saveConfig();
			String Prefix = plugin.getConfig().getString("Messages.Prefix");
			Prefix = Prefix.replace("&", "\u00a7");
		 p.sendMessage(Prefix + " " + "You removed the business owner");
   	 }
   	 return true;
	}
}