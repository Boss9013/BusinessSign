package Commands;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import GLClass.GLClass;
import Util.Methods;

public class RemoveStaff implements Listener, CommandExecutor{
	private GLClass plugin;

	public RemoveStaff(GLClass plugin) {
	this.plugin = plugin;
	}
		@Override
	    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {	 
		   		 Player player = (Player) sender;
				if(args.length == 0) {
	    			String Prefix = plugin.getConfig().getString("Messages.Prefix");
	    			String RemoveStaff = plugin.getConfig().getString("Messages.StaffNullMessage");
					player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + RemoveStaff));
					return true;
				}Player player1 = (Player) sender;
	    		if(this.plugin.getConfig().getString("Info.owner").contains(player1.getName())) {
	                    List<String> players = plugin.getConfig().getStringList("Staff");
		    			String Prefix = plugin.getConfig().getString("Messages.Prefix");
		    			String RemoveStaff = plugin.getConfig().getString("Messages.RemoveStaffMessage");
	                    players.remove(args[0]);
	                    plugin.getConfig().set("Staff", players);
	                    player1.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + RemoveStaff));
	                    plugin.saveConfig();
	                    Methods.Log(player.getName(), " remove staff player: " + args[0]);
	    		} else {
	    			String Prefix = plugin.getConfig().getString("Messages.Prefix");
	    			
	    			String Error = plugin.getConfig().getString("Messages.Error");
	    			player1.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + Error));
	    			return true;
	    		}   return true;
		}
	}