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

public class removeOwner implements CommandExecutor, Listener {
	private GLClass plugin;

	public removeOwner(GLClass plugin) {
	this.plugin = plugin;
	}
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
   	 if(!sender.hasPermission("Business.removeowner")) {
   		 sender.sendMessage("�cError");
   		 return true;			 
   	 }
   	 {
   		 Player p = (Player) sender;
		 this.plugin.getConfig().set("Info.owner", "Null");
		 GLClass.getInsance().saveConfig();
			String Prefix = plugin.getConfig().getString("Messages.Prefix");
		 p.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + "You removed the business owner"));
         List<String> list = GLClass.getLog().getStringList("logs");
         list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + p.getName() + " removed owner");
         GLClass.getLog().set("logs", list);
         GLClass.saveLog();
   	 }
   	 return true;
	}
}