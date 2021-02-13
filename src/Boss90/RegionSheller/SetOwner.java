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

public class SetOwner implements CommandExecutor, Listener {
	private GLClass plugin;

	public SetOwner(GLClass plugin) {
	this.plugin = plugin;
	}
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
   	 if(!sender.hasPermission("Business.setowner")) {
   		 sender.sendMessage("§cError");
   		 return true;			 
   	 }
   	 {
			String Prefix = plugin.getConfig().getString("Messages.Prefix");
   		 Player p = (Player) sender;
   		 if(args.length == 0) {
   			 p.sendMessage(Prefix + " Enter nickname.");
   			 return true;
   		 }
		 this.plugin.getConfig().set("Info.owner", args[0]);
		 GLClass.getInsance().saveConfig();
		 p.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + "You set the business owner: " + args[0]));
         List<String> list = GLClass.getLog().getStringList("logs");
         list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + p.getName() + " set owner: " + args[0]);
         GLClass.getLog().set("logs", list);
         GLClass.saveLog();
   	 }
   	 return true;
	}
}