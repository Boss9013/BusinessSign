package Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

import GLClass.GLClass;
public class ReloadPlugin implements Listener, CommandExecutor{
	private GLClass plugin;

	public ReloadPlugin(GLClass plugin) {
	this.plugin = plugin;
	}
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
   	 if(!sender.hasPermission("Business.removeOwner")) {
   		 sender.sendMessage("§cУ вас нету прав!");
   		 return true;			 
   } Bukkit.getPluginManager().disablePlugin(GLClass.getInsance());
     plugin.reloadConfig();
     Bukkit.getPluginManager().enablePlugin(GLClass.getInsance());
     sender.sendMessage("Plugin is succes reload.");
 	return true;
}
}