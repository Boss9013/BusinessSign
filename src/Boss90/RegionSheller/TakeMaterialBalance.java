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
		Player p = (Player) sender;
		Inventory i = holders.get(p);
		if(i == null) {
		    i = Bukkit.createInventory(null, 9, ChatColor.translateAlternateColorCodes('&',NameGUI));
			holders.put(p, i);
	  }
		String SkullMaterial = plugin.getConfig().getString("MaterialGUI.SkullMaterial");
		String SkullLore = plugin.getConfig().getString("MaterialGUI.SkullLore3");
		String SkullName = plugin.getConfig().getString("MaterialGUI.SkullName3");
            ItemStack i2 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta meta = (SkullMeta) i2.getItemMeta();
            meta.setOwner(SkullMaterial);
            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',SkullName));
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.translateAlternateColorCodes('&',SkullLore + " " + EconomyManager.infoMoney(p)));
            meta.setLore(lore);
            i2.setItemMeta(meta);
            i.setItem(2, i2);
            p.openInventory(i);
			
    		String SkullLore2 = plugin.getConfig().getString("MaterialGUI.SkullLore7");
    		String SkullName2 = plugin.getConfig().getString("MaterialGUI.SkullName7");
            ItemStack i3 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta meta3 = (SkullMeta) i3.getItemMeta();
            meta3.setOwner(SkullMaterial);
            meta3.setDisplayName(ChatColor.translateAlternateColorCodes('&',SkullName2));
            ArrayList<String> lore2 = new ArrayList<String>();
            lore2.add(ChatColor.translateAlternateColorCodes('&',SkullLore2 + " " + EconomyManager.infoMoney(p)));
            meta3.setLore(lore2);
            i3.setItemMeta(meta3);
            i.setItem(6, i3);
            p.openInventory(i);
            
    		String SkullMaterial2 = plugin.getConfig().getString("MaterialGUI.SkullMaterialInfo");
    		String SkullLore3 = plugin.getConfig().getString("MaterialGUI.SkullLore5");
			String SkullName3 = plugin.getConfig().getString("MaterialGUI.SkullName5");
    		String SkullLore4 = plugin.getConfig().getString("MaterialGUI.SkullLore5TwoLine");
    		String SkullLore9 = plugin.getConfig().getString("MaterialGUI.SkullLore5ThreeLine");
    		String SkullLore0 = plugin.getConfig().getString("MaterialGUI.SkullLore5FourLine");
            ItemStack i4 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta meta4 = (SkullMeta) i4.getItemMeta();
            meta4.setOwner(SkullMaterial2);
            meta4.setDisplayName(ChatColor.translateAlternateColorCodes('&',SkullName3));
            ArrayList<String> lore3 = new ArrayList<String>();
            lore3.add(ChatColor.translateAlternateColorCodes('&',SkullLore3 + " " + plugin.getConfig().getInt("Info.material")));
            lore3.add(ChatColor.translateAlternateColorCodes('&',SkullLore4 + " " + plugin.getConfig().getInt("Info.money")));
            lore3.add(ChatColor.translateAlternateColorCodes('&',SkullLore9 + " " + plugin.getConfig().getStringList("Staff")));
            lore3.add(ChatColor.translateAlternateColorCodes('&',SkullLore0 + " " + GLClass.getData().getInt("Info.24")));
            meta4.setLore(lore3);
            i4.setItemMeta(meta4);
            i.setItem(4, i4);
            p.openInventory(i);
            
    		String SkullMaterial3 = plugin.getConfig().getString("MaterialGUI.SkullMaterialBalance");
    		String SkullLore5 = plugin.getConfig().getString("MaterialGUI.SkullLore2");
    		String SkullName4 = plugin.getConfig().getString("MaterialGUI.SkullName2");
            ItemStack i6 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta meta5 = (SkullMeta) i6.getItemMeta();
            meta5.setOwner(SkullMaterial3);
            meta5.setDisplayName(ChatColor.translateAlternateColorCodes('&',SkullName4));
            ArrayList<String> lore4 = new ArrayList<String>();
            lore4.add(ChatColor.translateAlternateColorCodes('&',SkullLore5 + " " + EconomyManager.infoMoney(p)));
            meta5.setLore(lore4);
            i6.setItemMeta(meta5);
            i.setItem(1, i6);
            p.openInventory(i);
            
    		String SkullMaterial4 = plugin.getConfig().getString("MaterialGUI.SkullMaterialBalance");
    		String SkullLore6 = plugin.getConfig().getString("MaterialGUI.SkullLore8");
    		String SkullName5 = plugin.getConfig().getString("MaterialGUI.SkullName8");
    	    SkullName5 = SkullName5.replace("&", "\u00a7");
            ItemStack i7 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta meta6 = (SkullMeta) i7.getItemMeta();
            meta6.setOwner(SkullMaterial4);
            meta6.setDisplayName(ChatColor.translateAlternateColorCodes('&',SkullName5));
            ArrayList<String> lore5 = new ArrayList<String>();
            lore5.add(ChatColor.translateAlternateColorCodes('&',SkullLore6 + " " + EconomyManager.infoMoney(p)));
            meta6.setLore(lore5);
            i7.setItemMeta(meta6);
            i.setItem(7, i7);
            p.openInventory(i);
            return true;
	}		
	@SuppressWarnings("unused")
		    @EventHandler
		public void handle(InventoryClickEvent e) throws NullPointerException {
			Player player = (Player) e.getWhoClicked();
			String NameGUI = plugin.getConfig().getString("MaterialGUI.NameGUI");
			
			Inventory i = e.getInventory();
			if(ChatColor.stripColor(i.getName()).equals(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&',NameGUI)))) {
			Inventory c = e.getClickedInventory();
			if(e.getClickedInventory() == null) {
			return;
			} if(c.equals(i)) {
			String Prefix = plugin.getConfig().getString("Messages.Prefix");
			
			int MaterialBusiness = plugin.getConfig().getInt("Info.material");
			
			int materialtake = plugin.getConfig().getInt("MaterialGUI.MaterialTake");
			
			String NullMaterial = plugin.getConfig().getString("MaterialGUI.NullMaterial");
			
			String BuyMaterial = plugin.getConfig().getString("MaterialGUI.BuyMaterialMessage");
			
			String BuyBalance = plugin.getConfig().getString("MaterialGUI.BuyBalanceMessage");
			
    		String SkullLore3 = plugin.getConfig().getString("MaterialGUI.SkullLore5");
    		
    		String LoreScoreBoard2 = plugin.getConfig().getString("ScoreBoard.LoreScoreBoard2");
    		
    		String LoreScoreBoard1 = plugin.getConfig().getString("ScoreBoard.LoreScoreBoard");
    	    
	        LocalTime time = LocalTime.now();
	        Player player2 = (Player) Bukkit.getPlayer(plugin.getConfig().getString("Info.owner"));
            ArrayList<String> lore3 = new ArrayList<String>();
			if(e.getSlot() <= 9) e.setCancelled(true);
	 		if(this.plugin.getConfig().getString("Info.owner").contains(player.getName()) || this.plugin.getConfig().getStringList("Staff").contains(player.getName())) {
			if(e.getSlot() == 2) {
				int price = plugin.getConfig().getInt("MaterialGUI.MaterialSlot3");
				int materialitog = MaterialBusiness += price;
	            List<String> list = GLClass.getLog().getStringList("logs");
	            list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " buy material: " + price + " total: " + materialitog);
	            GLClass.getLog().set("logs", list);
	            GLClass.saveLog();
				int summa = price *= materialtake;
			if(!EconomyManager.takeMoney(player, summa)) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + NullMaterial));
				return;
			}	    this.plugin.getConfig().set("Info.material", materialitog);
            Methods.updateScoreboard(player2, LoreScoreBoard1, LoreScoreBoard2, plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
					GLClass.getInsance().saveConfig();
					player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + BuyMaterial));
					return;
			  } if(e.getSlot() == 6) {
				int price2 = plugin.getConfig().getInt("MaterialGUI.MaterialSlot7");
				int materialito2 = MaterialBusiness += price2;
	            List<String> list = GLClass.getLog().getStringList("logs");
	            list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " buy material: " + price2 + " total: " + materialito2);
	            GLClass.getLog().set("logs", list);
	            GLClass.saveLog();
				int summa2 = price2 *= materialtake;
			if(!EconomyManager.takeMoney(player, summa2)) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + NullMaterial));
				return;
			}		this.plugin.getConfig().set("Info.material", materialito2);
            Methods.updateScoreboard(player2, LoreScoreBoard1, LoreScoreBoard2, plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
					GLClass.getInsance().saveConfig();
					player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + BuyMaterial));
					return;
			} if(e.getSlot() == 1) {
				int price2 = plugin.getConfig().getInt("Info.money");
				int price = plugin.getConfig().getInt("MaterialGUI.BalanceSlot2");
				int materialito2 = price2 += price;
	            List<String> list = GLClass.getLog().getStringList("logs");
	            list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " pay balance business: " + price + " total: " + price2);
	            GLClass.getLog().set("logs", list);
	            GLClass.saveLog();
			if(!EconomyManager.takeMoney(player, price)) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + NullMaterial));
				return;
			}		this.plugin.getConfig().set("Info.material", materialito2);
            Methods.updateScoreboard(player2, LoreScoreBoard1, LoreScoreBoard2, plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
					plugin.saveConfig();
					player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + BuyBalance));
					return;
			} if(e.getSlot() == 7) {
				int price2 = plugin.getConfig().getInt("Info.money");
				int price = plugin.getConfig().getInt("MaterialGUI.BalanceSlot8");
				int materialito2 = price2 += price;
	            List<String> list = GLClass.getLog().getStringList("logs");
	            list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " pay balance business: " + price + " total: " + price2);
	            GLClass.getLog().set("logs", list);
	            GLClass.saveLog();
			if(!EconomyManager.takeMoney(player, price)) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + NullMaterial));
				return;
			}       this.plugin.getConfig().set("Info.money", materialito2);
            Methods.updateScoreboard(player2, LoreScoreBoard1, LoreScoreBoard2, plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
					plugin.saveConfig();
					player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + BuyBalance));
					return;
					}
			}
			}
			}
	}
}