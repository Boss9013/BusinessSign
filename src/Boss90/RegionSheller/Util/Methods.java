package Boss90.RegionSheller.Util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import com.google.common.collect.Lists;

import Boss90.RegionSheller.GLClass;

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
	public static boolean ClickShop(int price, Player player, String Prefix, String TakeMoneyNull, int money, int MaterialBusiness, String TakeMoney, int NumberGive, String NullMaterial, Material Material) {
		if(MaterialBusiness <= -1) {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + NullMaterial));
			return false;
		}
		if(!EconomyManager.takeMoney(player, price)) {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + TakeMoneyNull));
			return true;
		}
GLClass.getData().set("Info.24", money);
GLClass.saveData();
GLClass.getInsance().saveConfig();
player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + TakeMoney)); player.getInventory().addItem(new ItemStack(Material, NumberGive));
return true;
	}
	public static boolean ClickShop2(int price, Player player, String Prefix, String TakeMoneyNull, int money, int MaterialBusiness, String TakeMoney, String NullMaterial, ItemStack Material) {
		if(MaterialBusiness <= -1) {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + NullMaterial));
			return false;
		}
		if(!EconomyManager.takeMoney(player, price)) {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + TakeMoneyNull));
			return true;
		}
GLClass.getData().set("Info.24", money);
GLClass.saveData();
GLClass.getInsance().saveConfig();
player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + TakeMoney)); player.getInventory().addItem(new ItemStack(Material));
return true;
	}
}
