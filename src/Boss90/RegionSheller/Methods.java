package Boss90.RegionSheller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import com.google.common.collect.Lists;

public class Methods {
	public static void updateScoreboard(Player player, String string, String string2, int Int, int Int2) {
		if(player == null) {
			return;
		}
		Scoreboard s = player.getScoreboard();
        Objective o = s.getObjective("stats"); {
        	if(o == null) {
        		return;
        	}
        o.getScore(ChatColor.translateAlternateColorCodes('&',string)).setScore(Int);
			o.getScore(ChatColor.translateAlternateColorCodes('&',string2)).setScore(Int2);
        }
	}
	public static void SetItem(String NameDisplay, String Lore, Player player, ItemStack item, int slot, Inventory i, ItemMeta meta) {
		item.setItemMeta(meta);
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',NameDisplay));
		meta.setLore(Lists.newArrayList(ChatColor.translateAlternateColorCodes('&',Lore + " " + EconomyManager.infoMoney(player))));
		item.setItemMeta(meta);
		
		i.setItem(slot, item);
		player.openInventory(i);
	}
	public static void Log(String player, String string) {
        List<String> list = GLClass.getLog().getStringList("logs");
        list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + player + string);
        GLClass.getLog().set("logs", list);
        GLClass.saveLog();
	}
}
