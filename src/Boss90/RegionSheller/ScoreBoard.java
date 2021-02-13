package Boss90.RegionSheller;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreBoard implements Listener{
	private GLClass plugin;

	public ScoreBoard(GLClass plugin) {
	this.plugin = plugin;
	}
@EventHandler
public void j(PlayerJoinEvent e) {
		if (!plugin.getConfig().getBoolean("ScoreBoard.ScoreBoard"))
				return;
	  Player player = (Player) e.getPlayer();
		if(this.plugin.getConfig().getString("Info.owner").contains(player.getName()) || this.plugin.getConfig().getStringList("Staff").contains(player.getName())) {
 			Scoreboard newScoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
 			Objective o = newScoreboard.registerNewObjective("stats", "dummy");
   			String NameScoreBoard = plugin.getConfig().getString("ScoreBoard.NameScoreBoard");
   			String LoreScoreBoard = plugin.getConfig().getString("ScoreBoard.LoreScoreBoard");
   			String LoreScoreBoard2 = plugin.getConfig().getString("ScoreBoard.LoreScoreBoard2");
 			o.setDisplayName(ChatColor.translateAlternateColorCodes('&',NameScoreBoard));
 			o.setDisplaySlot(DisplaySlot.SIDEBAR);
 			o.getScore(ChatColor.translateAlternateColorCodes('&',LoreScoreBoard)).setScore(plugin.getConfig().getInt("Info.money"));
 			o.getScore(ChatColor.translateAlternateColorCodes('&',LoreScoreBoard2)).setScore(plugin.getConfig().getInt("Info.material"));
 			e.getPlayer().setScoreboard(newScoreboard);
 			return;
	 		}
 		}
}