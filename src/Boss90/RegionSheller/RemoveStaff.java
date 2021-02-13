package Boss90.RegionSheller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class RemoveStaff implements Listener, CommandExecutor{
	private GLClass plugin;

	public RemoveStaff(GLClass plugin) {
	this.plugin = plugin;
	}
		@Override
	    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {	 
			{
		   		 Player player = (Player) sender;
				if(args.length == 0) {
	    			String Prefix = plugin.getConfig().getString("Messages.Prefix");
	    			String RemoveStaff = plugin.getConfig().getString("Messages.StaffNullMessage");
					player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + RemoveStaff));
					return true;
				}
			}
			Player player = (Player) sender;
	    		if(this.plugin.getConfig().getString("Info.owner").contains(player.getName())) {
	                    List<String> players = plugin.getConfig().getStringList("Staff");
		    			String Prefix = plugin.getConfig().getString("Messages.Prefix");
		    			String RemoveStaff = plugin.getConfig().getString("Messages.RemoveStaffMessage");
	                    players.remove(args[0]);
	                    plugin.getConfig().set("Staff", players);
	                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + RemoveStaff));
	                    plugin.saveConfig();
	    	            List<String> list = GLClass.getLog().getStringList("logs");
	    	            list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + player.getName() + " remove staff player: " + args[0]);
	    	            GLClass.getLog().set("logs", list);
	    	            GLClass.saveLog();
	    		} else {
	    			String Prefix = plugin.getConfig().getString("Messages.Prefix");
	    			
	    			String Error = plugin.getConfig().getString("Messages.Error");
	    			player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + Error));
	    			return true;
	    		}
				return true;
		}
	}