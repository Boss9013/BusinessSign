package Boss90.RegionSheller;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class wipebusiness implements CommandExecutor, Listener {
	private GLClass plugin;

	public wipebusiness(GLClass plugin) {
	this.plugin = plugin;
	}
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
   	 if(!sender.hasPermission("Business.wipebusiness")) {
   		 sender.sendMessage("§cУ вас нету прав!");
   		 return true;			 
   	 }
   	 {
		 String owner = this.plugin.getConfig().getString("Info.owner");
		 PermissionUser user = PermissionsEx.getUser(owner);
		 this.plugin.getConfig().set("Info.owner", "noOwner");
		 this.plugin.getConfig().set("Info.money", 0);
		 user.removePermission("Business.balancetake");
		 user.removePermission("Business.balance");
		 user.removePermission("Business.Join");
		 user.removePermission("Business.Quit");
		 GLClass.getInsance().saveConfig();
		 sender.sendMessage("The business was successfully wipe");
   	 }
   	 return true;
	}
}