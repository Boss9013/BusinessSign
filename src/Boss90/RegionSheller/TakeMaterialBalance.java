package Boss90.RegionSheller;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class TakeMaterialBalance implements CommandExecutor, Listener {
	private GLClass plugin;

	public TakeMaterialBalance(GLClass plugin) {
	this.plugin = plugin;
	}
	private Map<Player, Inventory> holders = new HashMap<>();
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		String NameGUI = plugin.getConfig().getString("MaterialGUI.NameGUI");
		NameGUI = NameGUI.replace("&", "\u00a7");
		Player p = (Player) sender;
 		if(this.plugin.getConfig().getString("Info.owner").contains(p.getName())) {
		Inventory i = holders.get(p);
		if(i == null) {
			i = Bukkit.createInventory(null, 9, NameGUI);
			holders.put(p, i);
		}
		String SkullMaterial = plugin.getConfig().getString("MaterialGUI.SkullMaterial");
		String SkullLore = plugin.getConfig().getString("MaterialGUI.SkullLore3");
	    SkullLore = SkullLore.replace("&", "\u00a7");
		String SkullName = plugin.getConfig().getString("MaterialGUI.SkullName3");
	    SkullName = SkullName.replace("&", "\u00a7");
            ItemStack i2 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta meta = (SkullMeta) i2.getItemMeta();
            meta.setOwner(SkullMaterial);
            meta.setDisplayName(SkullName);
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(SkullLore);
            meta.setLore(lore);
            i2.setItemMeta(meta);
            i.setItem(2, i2);
            p.openInventory(i);
			
    		String SkullLore2 = plugin.getConfig().getString("MaterialGUI.SkullLore7");
    	    SkullLore2 = SkullLore2.replace("&", "\u00a7");
    		String SkullName2 = plugin.getConfig().getString("MaterialGUI.SkullName7");
    	    SkullName2 = SkullName2.replace("&", "\u00a7");
            ItemStack i3 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta meta3 = (SkullMeta) i3.getItemMeta();
            meta3.setOwner(SkullMaterial);
            meta3.setDisplayName(SkullName2);
            ArrayList<String> lore2 = new ArrayList<String>();
            lore2.add(SkullLore2);
            meta3.setLore(lore2);
            i3.setItemMeta(meta3);
            i.setItem(6, i3);
            p.openInventory(i);
            
    		String SkullMaterial2 = plugin.getConfig().getString("MaterialGUI.SkullMaterialInfo");
    		String SkullLore3 = plugin.getConfig().getString("MaterialGUI.SkullLore5");
    	    SkullLore3 = SkullLore3.replace("&", "\u00a7");
    		String SkullName3 = plugin.getConfig().getString("MaterialGUI.SkullName5");
    	    SkullName3 = SkullName3.replace("&", "\u00a7");
    		String SkullLore4 = plugin.getConfig().getString("MaterialGUI.SkullLore5TwoLine");
    	    SkullLore4= SkullLore4.replace("&", "\u00a7");
            ItemStack i4 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta meta4 = (SkullMeta) i4.getItemMeta();
            meta4.setOwner(SkullMaterial2);
            meta4.setDisplayName(SkullName3);
            ArrayList<String> lore3 = new ArrayList<String>();
            lore3.add(SkullLore3 + " " + plugin.getConfig().getInt("Info.material"));
            lore3.add(SkullLore4 + " " + plugin.getConfig().getInt("Info.money"));
            meta4.setLore(lore3);
            i4.setItemMeta(meta4);
            i.setItem(4, i4);
            p.openInventory(i);
            
    		String SkullMaterial3 = plugin.getConfig().getString("MaterialGUI.SkullMaterialBalance");
    		String SkullLore5 = plugin.getConfig().getString("MaterialGUI.SkullLore2");
    	    SkullLore5 = SkullLore5.replace("&", "\u00a7");
    		String SkullName4 = plugin.getConfig().getString("MaterialGUI.SkullName2");
    	    SkullName4 = SkullName4.replace("&", "\u00a7");
            ItemStack i6 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta meta5 = (SkullMeta) i6.getItemMeta();
            meta5.setOwner(SkullMaterial3);
            meta5.setDisplayName(SkullName4);
            ArrayList<String> lore4 = new ArrayList<String>();
            lore4.add(SkullLore5);
            meta5.setLore(lore4);
            i6.setItemMeta(meta5);
            i.setItem(1, i6);
            p.openInventory(i);
            
    		String SkullMaterial4 = plugin.getConfig().getString("MaterialGUI.SkullMaterialBalance");
    		String SkullLore6 = plugin.getConfig().getString("MaterialGUI.SkullLore8");
    	    SkullLore6 = SkullLore6.replace("&", "\u00a7");
    		String SkullName5 = plugin.getConfig().getString("MaterialGUI.SkullName8");
    	    SkullName5 = SkullName5.replace("&", "\u00a7");
            ItemStack i7 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta meta6 = (SkullMeta) i7.getItemMeta();
            meta6.setOwner(SkullMaterial4);
            meta6.setDisplayName(SkullName5);
            ArrayList<String> lore5 = new ArrayList<String>();
            lore5.add(SkullLore6);
            meta6.setLore(lore5);
            i7.setItemMeta(meta6);
            i.setItem(7, i7);
            p.openInventory(i);
            return true;
		} else {
			String Prefix = plugin.getConfig().getString("Messages.Prefix");
			Prefix = Prefix.replace("&", "\u00a7");
			
			String Error = plugin.getConfig().getString("Messages.Error");
			Error = Error.replace("&", "\u00a7");
			p.sendMessage(Prefix + " " + Error);
			return true;
		}
	}
		@SuppressWarnings("unused")
		@EventHandler
		public void handle(InventoryClickEvent e) {
			Player player = (Player) e.getWhoClicked();
			String NameGUI = plugin.getConfig().getString("MaterialGUI.NameGUI");
			NameGUI = NameGUI.replace("&", "\u00a7");
			
			Inventory i = e.getInventory();
			if(ChatColor.stripColor(i.getName()).equals(ChatColor.stripColor(NameGUI))) {
			Inventory c = e.getClickedInventory();
			try {
			if(e.getClickedInventory() == null) {
			return;
			}
			}catch (NullPointerException ignored) {}
			if(c.equals(i)) {
			String Prefix = plugin.getConfig().getString("Messages.Prefix");
			Prefix = Prefix.replace("&", "\u00a7");
			
			int MaterialBusiness = plugin.getConfig().getInt("Info.material");
			
			int materialtake = plugin.getConfig().getInt("MaterialGUI.MaterialTake");
			
			String NullMaterial = plugin.getConfig().getString("MaterialGUI.NullMaterial");
			NullMaterial = NullMaterial.replace("&", "\u00a7");
			
			String BuyMaterial = plugin.getConfig().getString("MaterialGUI.BuyMaterialMessage");
			BuyMaterial = BuyMaterial.replace("&", "\u00a7");
			
			String BuyBalance = plugin.getConfig().getString("MaterialGUI.BuyBalanceMessage");
			BuyBalance = BuyBalance.replace("&", "\u00a7");
			
    		String SkullLore3 = plugin.getConfig().getString("MaterialGUI.SkullLore5");
    	    SkullLore3 = SkullLore3.replace("&", "\u00a7");
    	    
	        LocalTime time = LocalTime.now();
	        Player player2 = (Player) Bukkit.getPlayer(plugin.getConfig().getString("Info.owner"));
            ArrayList<String> lore3 = new ArrayList<String>();
			if(e.getSlot() <= 9) e.setCancelled(true);
			if(e.getSlot() == 2) {
				int price = plugin.getConfig().getInt("MaterialGUI.MaterialSlot3");
				int materialitog = MaterialBusiness += price;
	            List<String> list = GLClass.getLog().getStringList("logs");
	            list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " buy material: " + price + " total: " + materialitog);
	            GLClass.getLog().set("logs", list);
	            GLClass.saveLog();
				int summa = price *= materialtake;
			if(!EconomyManager.takeMoney(player, summa)) {
				player.sendMessage(Prefix + " " + NullMaterial);
				return;
			}
					this.plugin.getConfig().set("Info.material", materialitog);
	                updateScoreboard(player2);
					GLClass.getInsance().saveConfig();
					player.sendMessage(Prefix + " " + BuyMaterial);
					return;
					}
			if(e.getSlot() == 6) {
				int price2 = plugin.getConfig().getInt("MaterialGUI.MaterialSlot7");
				int materialito2 = MaterialBusiness += price2;
	            List<String> list = GLClass.getLog().getStringList("logs");
	            list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " buy material: " + price2 + " total: " + materialito2);
	            GLClass.getLog().set("logs", list);
	            GLClass.saveLog();
				int summa2 = price2 *= materialtake;
			if(!EconomyManager.takeMoney(player, summa2)) {
				player.sendMessage(Prefix + " " + NullMaterial);
				return;
			}
					this.plugin.getConfig().set("Info.material", materialito2);
	                updateScoreboard(player2);
					GLClass.getInsance().saveConfig();
					player.sendMessage(Prefix + " " + BuyMaterial);
					return;
					}
			if(e.getSlot() == 1) {
				int price2 = plugin.getConfig().getInt("Info.money");
				int price = plugin.getConfig().getInt("MaterialGUI.BalanceSlot2");
				int materialito2 = price2 += price;
	            List<String> list = GLClass.getLog().getStringList("logs");
	            list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " pay balance business: " + price + " total: " + price2);
	            GLClass.getLog().set("logs", list);
	            GLClass.saveLog();
			if(!EconomyManager.takeMoney(player, price)) {
				player.sendMessage(Prefix + " " + NullMaterial);
				return;
			}
					this.plugin.getConfig().set("Info.money", materialito2);
	                updateScoreboard(player2);
					plugin.saveConfig();
					player.sendMessage(Prefix + " " + BuyBalance);
					return;
					}
			if(e.getSlot() == 7) {
				int price2 = plugin.getConfig().getInt("Info.money");
				int price = plugin.getConfig().getInt("MaterialGUI.BalanceSlot8");
				int materialito2 = price2 += price;
	            List<String> list = GLClass.getLog().getStringList("logs");
	            list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " pay balance business: " + price + " total: " + price2);
	            GLClass.getLog().set("logs", list);
	            GLClass.saveLog();
			if(!EconomyManager.takeMoney(player, price)) {
				player.sendMessage(Prefix + " " + NullMaterial);
				return;
			}
					this.plugin.getConfig().set("Info.money", materialito2);
	                updateScoreboard(player2);
					plugin.saveConfig();
					player.sendMessage(Prefix + " " + BuyBalance);
					return;
					}
			}
			}
		}
		private void updateScoreboard(Player player) {
			String LoreScoreBoard1 = plugin.getConfig().getString("ScoreBoard.LoreScoreBoard");
			LoreScoreBoard1 = LoreScoreBoard1.replace("&", "\u00a7");
			if(player == null) {
				return;
			}
			Scoreboard s = player.getScoreboard();
	        Objective o = s.getObjective("stats"); {
	        	if(o == null) {
	        		return;
	        	}
	        o.getScore(LoreScoreBoard1).setScore(plugin.getConfig().getInt("Info.money"));
			String LoreScoreBoard2 = plugin.getConfig().getString("ScoreBoard.LoreScoreBoard2");
			LoreScoreBoard2 = LoreScoreBoard2.replace("&", "\u00a7");
			o.getScore(LoreScoreBoard2).setScore(plugin.getConfig().getInt("Info.material"));
	        }
		}
}