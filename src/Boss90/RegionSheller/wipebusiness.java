package Boss90.RegionSheller;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class wipebusiness implements CommandExecutor, Listener {
	private GLClass plugin;

	public wipebusiness(GLClass plugin) {
	this.plugin = plugin;
	}
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
   	 if(!sender.hasPermission("Business.wipebusiness")) {
   		 sender.sendMessage("§cError");
   		 return true;			 
   	 }   Player p = (Player) sender;
		 this.plugin.getConfig().set("Info.owner", "");
		 this.plugin.getConfig().set("Info.money", 0);
		 this.plugin.getConfig().set("Info.material", 0);
		 this.plugin.getConfig().set("Staff", "[]");
		 GLClass.getInsance().saveConfig();
			String Prefix = plugin.getConfig().getString("Messages.Prefix");
			Prefix = Prefix.replace("&", "\u00a7");
            Methods.updateScoreboard(p, plugin.getConfig().getString("ScoreBoard.LoreScoreBoard"), plugin.getConfig().getString("ScoreBoard.LoreScoreBoard2"), plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
		 p.sendMessage(Prefix + " " + "The business was successfully wipe");
		 Methods.Log(p.getName(), " wiped business.");
   	     return true;
	}
}