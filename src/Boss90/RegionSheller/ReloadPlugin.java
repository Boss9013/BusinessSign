package Boss90.RegionSheller;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
public class ReloadPlugin implements Listener, CommandExecutor{

	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
   	 if(!sender.hasPermission("Business.removeOwner")) {
   		 sender.sendMessage("§cУ вас нету прав!");
   		 return true;			 
   	 }
     Bukkit.getPluginManager().disablePlugin(GLClass.getInstance());
     Thread.onSpinWait();
     Bukkit.getPluginManager().enablePlugin(GLClass.getInstance());
     sender.sendMessage("Plugin is succes reload.");
 	return true;
	}
}