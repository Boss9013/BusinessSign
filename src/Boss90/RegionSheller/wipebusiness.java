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
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class wipebusiness implements CommandExecutor, Listener {
	private GLClass plugin;

	public wipebusiness(GLClass plugin) {
	this.plugin = plugin;
	}
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
   	 if(!sender.hasPermission("Business.wipebusiness")) {
   		 sender.sendMessage("�cError");
   		 return true;			 
   	 }
   	 {
   		 Player p = (Player) sender;
		 this.plugin.getConfig().set("Info.owner", "");
		 this.plugin.getConfig().set("Info.money", 0);
		 this.plugin.getConfig().set("Info.material", 0);
		 this.plugin.getConfig().set("Staff", "[]");
		 GLClass.getInsance().saveConfig();
			String Prefix = plugin.getConfig().getString("Messages.Prefix");
			Prefix = Prefix.replace("&", "\u00a7");
            updateScoreboard(p);
		 p.sendMessage(Prefix + " " + "The business was successfully wipe");
         List<String> list = GLClass.getLog().getStringList("logs");
         list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + p.getName() + " wiped business.");
         GLClass.getLog().set("logs", list);
         GLClass.saveLog();
   	 }
   	 return true;
	}
	private void updateScoreboard(Player player) {
		String LoreScoreBoard1 = plugin.getConfig().getString("ScoreBoard.LoreScoreBoard");
		Scoreboard s = player.getScoreboard();
        Objective o = s.getObjective("stats"); {
        	if(o == null) {
        		player.sendMessage("Error");
        		return;
        	}
        o.getScore(ChatColor.translateAlternateColorCodes('&',LoreScoreBoard1)).setScore(plugin.getConfig().getInt("Info.money"));
			String LoreScoreBoard2 = plugin.getConfig().getString("ScoreBoard.LoreScoreBoard2");
			o.getScore(ChatColor.translateAlternateColorCodes('&',LoreScoreBoard2)).setScore(plugin.getConfig().getInt("Info.material"));
        }
	}
}