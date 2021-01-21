package Boss90.RegionSheller;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class removeOwner implements CommandExecutor, Listener {
	private GLClass plugin;

	public removeOwner(GLClass plugin) {
	this.plugin = plugin;
	}
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
   	 if(!sender.hasPermission("Business.removeOwner")) {
   		 sender.sendMessage("§cУ вас нету прав!");
   		 return true;			 
   	 }
   	 {
		 String owner = this.plugin.getConfig().getString("Info.owner");
		 PermissionUser user = PermissionsEx.getUser(owner);
		 this.plugin.getConfig().set("Info.owner", "noOwner");
		 GLClass.getInsance().saveConfig();
		 user.removePermission("Business.balancetake");
		 user.removePermission("Business.balance");
		 user.removePermission("Business.Join");
		 user.removePermission("Business.Quit");
		 sender.sendMessage("You removed the business owner");
   	 }
   	 return true;
	}
}