package Boss90.RegionSheller;

import java.time.LocalDate;
import java.time.LocalTime;
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
import org.bukkit.inventory.meta.ItemMeta;

public class ShopGUI implements Listener, CommandExecutor {
private GLClass plugin;

public ShopGUI(GLClass plugin) {
this.plugin = plugin;
}
private Map<Player, Inventory> holders = new HashMap<>();
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		String NameGUI = plugin.getConfig().getString("GUI.NameGUI");
		NameGUI = NameGUI.replace("&", "\u00a7");
		Player p = (Player) sender;
		Inventory i = holders.get(p);
		if(i == null) {
			i = Bukkit.createInventory(null, 9, NameGUI);
			holders.put(p, i);
		}
		
		String NameApple = plugin.getConfig().getString("GUI.NameApple");
		
		String LoreApple = plugin.getConfig().getString("GUI.LoreApple");
		
		ItemStack item = new ItemStack(Material.APPLE, 1);
		ItemMeta meta = item.getItemMeta();
		
		Methods.SetItem(NameApple, LoreApple, p, item, 0, i, meta);
		
		String NameBread = plugin.getConfig().getString("GUI.NameBread");
		
		String LoreBread = plugin.getConfig().getString("GUI.LoreBread");
		
		ItemStack item1 = new ItemStack(Material.BREAD, 1);
		
		Methods.SetItem(NameBread, LoreBread, p, item1, 1, i, meta);
		
		String LorePotato = plugin.getConfig().getString("GUI.LorePotato");
		
		String NamePotato = plugin.getConfig().getString("GUI.NamePotato");
		
		ItemStack item2 = new ItemStack(Material.BAKED_POTATO, 1);
		
		Methods.SetItem(NamePotato, LorePotato, p, item2, 2, i, meta);
		
		String LoreMilk = plugin.getConfig().getString("GUI.LoreMilk");
		
		String NameMilk = plugin.getConfig().getString("GUI.NameMilk");
		
		ItemStack item3 = new ItemStack(Material.MILK_BUCKET, 1);
		
		Methods.SetItem(NameMilk, LoreMilk, p, item3, 3, i, meta);
		
		String LoreFishing = plugin.getConfig().getString("GUI.LoreFishing");
		
		String NameFishing = plugin.getConfig().getString("GUI.NameFishing");

		ItemStack item4 = new ItemStack(Material.FISHING_ROD, 1);
		
		Methods.SetItem(NameFishing, LoreFishing, p, item4, 4, i, meta);
		
		String LoreBook = plugin.getConfig().getString("GUI.LoreBook");
		
		String NameBook = plugin.getConfig().getString("GUI.NameBook");
		
		ItemStack item5 = new ItemStack(Material.BOOK_AND_QUILL, 1);
		
		Methods.SetItem(NameBook, LoreBook, p, item5, 5, i, meta);
		
		String LoreClock = plugin.getConfig().getString("GUI.LoreClock");
		
		String NameClock = plugin.getConfig().getString("GUI.NameClock");
		
		ItemStack item6 = new ItemStack(Material.WATCH, 1);
		
		Methods.SetItem(NameClock, LoreClock, p, item6, 6, i, meta);
		
		String LoreCompass = plugin.getConfig().getString("GUI.LoreCompass");
		
		String NameCompass = plugin.getConfig().getString("GUI.NameCompass");
		
		ItemStack item7 = new ItemStack(Material.COMPASS, 1);
		
		Methods.SetItem(NameCompass, LoreCompass, p, item7, 7, i, meta);
		
		String LoreFire = plugin.getConfig().getString("GUI.LoreSteel");
		
		String NameFire = plugin.getConfig().getString("GUI.NameSteel");
		
		ItemStack item8 = new ItemStack(Material.FLINT_AND_STEEL, 1);
		
		Methods.SetItem(NameFire, LoreFire, p, item8, 8, i, meta);
		
		return true;
	}
	@EventHandler
	public void handle(InventoryClickEvent e) throws NullPointerException {
		String NameGUI = plugin.getConfig().getString("GUI.NameGUI");
		
		Inventory i = e.getInventory();
		if(ChatColor.stripColor(i.getName()).equals(ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&',NameGUI)))) {
		Inventory c = e.getClickedInventory();
		if(e.getClickedInventory() == null) {
		return;
		}
		if(c.equals(i)) {
		
		String TakeMoneyApple = plugin.getConfig().getString("Messages.BuyAppleMessage");
		
		String TakeMoneyBread = plugin.getConfig().getString("Messages.BuyBreadMessage");
		
		String TakeMoneyPotato = plugin.getConfig().getString("Messages.BuyPotatoMessage");
		
		String TakeMoneyMilk = plugin.getConfig().getString("Messages.BuyMilkMessage");
		
		String TakeMoneyFishing = plugin.getConfig().getString("Messages.BuyFishingMessage");
		
		String TakeMoneyBook = plugin.getConfig().getString("Messages.BuyBookMessage");
		
		String TakeMoneyClock = plugin.getConfig().getString("Messages.BuyClockMessage");
		
		String TakeMoneyCompass = plugin.getConfig().getString("Messages.BuyCompassMessage");
		
		String TakeMoneyFire = plugin.getConfig().getString("Messages.BuySteelMessage");
		
		String TakeMoneyNullApple = plugin.getConfig().getString("Messages.InsufficientFundsAppleMessage");
		
		String TakeMoneyNullBread = plugin.getConfig().getString("Messages.InsufficientFundsBreadMessage");
		
		String TakeMoneyNullPotato = plugin.getConfig().getString("Messages.InsufficientFundsPotatoMessage");
		
		String TakeMoneyNullMilk = plugin.getConfig().getString("Messages.InsufficientFundsMilkMessage");
		
		String TakeMoneyNullFishing = plugin.getConfig().getString("Messages.InsufficientFundsFishingMessage");
		
		String TakeMoneyNullBook = plugin.getConfig().getString("Messages.InsufficientFundsBookMessage");
		
		String TakeMoneyNullClock = plugin.getConfig().getString("Messages.InsufficientFundsClockMessage");
		
		String TakeMoneyNullCompass = plugin.getConfig().getString("Messages.InsufficientFundsCompassMessage");
		
		String TakeMoneyNullFire = plugin.getConfig().getString("Messages.InsufficientFundsSteelMessage");
		
		String Prefix = plugin.getConfig().getString("Messages.Prefix");
		
		String NullMaterial = plugin.getConfig().getString("Messages.NullMaterial");
		
		String LoreScoreBoard2 = plugin.getConfig().getString("ScoreBoard.LoreScoreBoard2");
		
		String LoreScoreBoard1 = plugin.getConfig().getString("ScoreBoard.LoreScoreBoard");
		
		int MaterialBusiness = plugin.getConfig().getInt("Info.material");
		
		int materialtake = plugin.getConfig().getInt("Price.MaterialTake");
		
		int priceApple = plugin.getConfig().getInt("Price.ApplePrice");
		
		int priceBread = plugin.getConfig().getInt("Price.BreadPrice");
		
		int pricePotato = plugin.getConfig().getInt("Price.PotatoPrice");
		
		int priceMilk = plugin.getConfig().getInt("Price.MilkPrice");
		
		int priceFishing = plugin.getConfig().getInt("Price.FishingPrice");
		
		int priceBook = plugin.getConfig().getInt("Price.BookPrice");
		
		int priceClock = plugin.getConfig().getInt("Price.ClockPrice");
		
		int priceCompass = plugin.getConfig().getInt("Price.CompassPrice");
		
		int priceFire = plugin.getConfig().getInt("Price.SteelPrice");
		
		int NumberAppleGive = plugin.getConfig().getInt("NumberGive.NumberAppleGive");
		
		int NumberBreadGive = plugin.getConfig().getInt("NumberGive.NumberBreadGive");
		
		int NumberPotatoGive = plugin.getConfig().getInt("NumberGive.NumberPotatoGive");
		
		int NumberMilkGive = plugin.getConfig().getInt("NumberGive.NumberMilkGive");
		
		int NumberFishingGive = plugin.getConfig().getInt("NumberGive.NumberFishingGive");
		
		int NumberBookGive = plugin.getConfig().getInt("NumberGive.NumberBookGive");
		
		int NumberClockGive = plugin.getConfig().getInt("NumberGive.NumberClockGive");
		
		int NumberCompassGive = plugin.getConfig().getInt("NumberGive.NumberCompassGive");
		
		int NumberFireGive = plugin.getConfig().getInt("NumberGive.NumberSteelGive");

		Player player = (Player) e.getWhoClicked();
        Player player2 = (Player) Bukkit.getPlayer(plugin.getConfig().getString("Info.owner"));

			if(e.getSlot() <= 9) e.setCancelled(true);
				if(e.getSlot() == 0) {
				if(!EconomyManager.takeMoney(player, priceApple)) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + TakeMoneyNullApple));
					return;
				}
				int money = this.plugin.getConfig().getInt("Info.money");
				int money2 = money += priceApple;
				int MaterialData = MaterialBusiness -= materialtake;
                if(MaterialBusiness <= -1) {
                	player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + NullMaterial));
                	return;
              } this.plugin.getConfig().set("Info.money", money2);
				this.plugin.getConfig().set("Info.material", MaterialData);
				GLClass.getData().set("Info.24", money2);
				GLClass.saveData();
	            Methods.updateScoreboard(player2, LoreScoreBoard1, LoreScoreBoard2, plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
				GLClass.getInsance().saveConfig();
                List<String> list = GLClass.getLog().getStringList("logs");
                list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " buy apple " + "total material: " + MaterialBusiness);
                GLClass.getLog().set("logs", list);
                GLClass.saveLog();
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix + " " + TakeMoneyApple)); player.getInventory().addItem(new ItemStack(Material.APPLE, NumberAppleGive));
			  } if(e.getSlot() == 1) {
				if(!EconomyManager.takeMoney(player, priceBread)) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + TakeMoneyNullBread));
					return;
			  } int money = this.plugin.getConfig().getInt("Info.money");
				int money3 = money += priceBread;
				int MaterialData = MaterialBusiness -= materialtake;
				GLClass.getData().set("Info.24", money3);
				GLClass.saveData();
                if(MaterialBusiness <= -1) {
                	player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + NullMaterial));
                	return;
              } this.plugin.getConfig().set("Info.money", money3);
				this.plugin.getConfig().set("Info.material", MaterialData);
				GLClass.getInsance().saveConfig();
	            Methods.updateScoreboard(player2, LoreScoreBoard1, LoreScoreBoard2, plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
                List<String> list = GLClass.getLog().getStringList("logs");
                list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " buy bread " + "total material: " + MaterialBusiness);
                GLClass.getLog().set("logs", list);
                GLClass.saveLog();
			player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + TakeMoneyBread)); player.getInventory().addItem(new ItemStack(Material.BREAD, NumberBreadGive));
			}
			
			if(e.getSlot() == 2) {
				if(!EconomyManager.takeMoney(player, pricePotato)) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + TakeMoneyNullPotato));
					return;
			  } int money = this.plugin.getConfig().getInt("Info.money");
				int money4 = money += pricePotato;
				int MaterialData = MaterialBusiness -= materialtake;
				GLClass.getData().set("Info.24", money4);
				GLClass.saveData();
                if(MaterialBusiness <= -1) {
                	player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + NullMaterial));
                	return;
                } this.plugin.getConfig().set("Info.money", money4);
				this.plugin.getConfig().set("Info.material", MaterialData);
				GLClass.getInsance().saveConfig();
	            Methods.updateScoreboard(player2, LoreScoreBoard1, LoreScoreBoard2, plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
                List<String> list = GLClass.getLog().getStringList("logs");
                list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " buy potato" + "total material: " + MaterialBusiness);
                GLClass.getLog().set("logs", list);
                GLClass.saveLog();
			player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + TakeMoneyPotato)); player.getInventory().addItem(new ItemStack(Material.BAKED_POTATO, NumberPotatoGive));
			}
			
			if(e.getSlot() == 3) {
				if(!EconomyManager.takeMoney(player, priceMilk)) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + TakeMoneyNullMilk));
					return;
			  } int money = this.plugin.getConfig().getInt("Info.money");
				int money5 = money += priceMilk;
				int MaterialData = MaterialBusiness -= materialtake;
				GLClass.getData().set("Info.24", money5);
				GLClass.saveData();
                if(MaterialBusiness <= -1) {
                	player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + NullMaterial));
                	return;
              } this.plugin.getConfig().set("Info.money", money5);
				this.plugin.getConfig().set("Info.material", MaterialData);
				GLClass.getInsance().saveConfig();
	            Methods.updateScoreboard(player2, LoreScoreBoard1, LoreScoreBoard2, plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
                List<String> list = GLClass.getLog().getStringList("logs");
                list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " buy milk " + "total material: " + MaterialBusiness);
                GLClass.getLog().set("logs", list);
                GLClass.saveLog();
			player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + TakeMoneyMilk)); player.getInventory().addItem(new ItemStack(Material.MILK_BUCKET, NumberMilkGive));
			} if(e.getSlot() == 4) {
				if(!EconomyManager.takeMoney(player, priceFishing)) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + TakeMoneyNullFishing));
					return;
			  } int money = this.plugin.getConfig().getInt("Info.money");
				int money7 = money += priceFishing;
				int MaterialData = MaterialBusiness -= materialtake;
				GLClass.getData().set("Info.24", money7);
				GLClass.saveData();
                if(MaterialBusiness <= -1) {
                	player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + NullMaterial));
                	return;
              } this.plugin.getConfig().set("Info.money", money7);
				this.plugin.getConfig().set("Info.material", MaterialData);
				GLClass.getInsance().saveConfig();
	            Methods.updateScoreboard(player2, LoreScoreBoard1, LoreScoreBoard2, plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
                List<String> list = GLClass.getLog().getStringList("logs");
                list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " buy Fishing rod " + "total material: " + MaterialBusiness);
                GLClass.getLog().set("logs", list);
                GLClass.saveLog();
			    player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + TakeMoneyFishing)); player.getInventory().addItem(new ItemStack(Material.FISHING_ROD, NumberFishingGive));
			}		if(e.getSlot() == 5) {
					if(!EconomyManager.takeMoney(player, priceBook)) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + TakeMoneyNullBook));
						return;
					}
					int money = this.plugin.getConfig().getInt("Info.money");
					int money8 = money += priceBook;
					int MaterialData = MaterialBusiness -= materialtake;
					GLClass.getData().set("Info.24", money8);
					GLClass.saveData();
	                if(MaterialBusiness <= -1) {
	                	player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + NullMaterial));
	                	return;
	              } this.plugin.getConfig().set("Info.money", money8);
					this.plugin.getConfig().set("Info.material", MaterialData);
					GLClass.getInsance().saveConfig();
		            Methods.updateScoreboard(player2, LoreScoreBoard1, LoreScoreBoard2, plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
	                List<String> list = GLClass.getLog().getStringList("logs");
	                list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " buy book " + "total material: " + MaterialBusiness);
	                GLClass.getLog().set("logs", list);
	                GLClass.saveLog();
				    player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + TakeMoneyBook)); player.getInventory().addItem(new ItemStack(Material.BOOK_AND_QUILL, NumberBookGive));
			}
				if(e.getSlot() == 6) {
					if(!EconomyManager.takeMoney(player, priceClock)) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + TakeMoneyNullClock));
						return;
					}			int money = this.plugin.getConfig().getInt("Info.money");
			int money9 = money += priceClock;
			int MaterialData = MaterialBusiness -= materialtake;
			GLClass.getData().set("Info.24", money9);
			GLClass.saveData();
            if(MaterialBusiness <= -1) {
            	player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + NullMaterial));
            	return;
            }			this.plugin.getConfig().set("Info.money", money9);
			this.plugin.getConfig().set("Info.material", MaterialData);
			GLClass.getInsance().saveConfig();
            Methods.updateScoreboard(player2, LoreScoreBoard1, LoreScoreBoard2, plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
            List<String> list = GLClass.getLog().getStringList("logs");
            list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " buy clock " + "total material: " + MaterialBusiness);
            GLClass.getLog().set("logs", list);
            GLClass.saveLog();
		    player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + TakeMoneyClock)); player.getInventory().addItem(new ItemStack(Material.WATCH, NumberClockGive));
			}	if(e.getSlot() == 7) {
					if(!EconomyManager.takeMoney(player, priceCompass)) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + TakeMoneyNullCompass));
						return;
					}			int money = this.plugin.getConfig().getInt("Info.money");
			int MaterialData = MaterialBusiness -= materialtake;
			this.plugin.getConfig().set("Info.material", MaterialData);
			int money10 = money += priceCompass;
			GLClass.getData().set("Info.24", money10);
			GLClass.saveData();
            if(MaterialBusiness <= -1) {
            	player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + NullMaterial));
            	return;
            }			this.plugin.getConfig().set("Info.money", money10);
			GLClass.getInsance().saveConfig();
            Methods.updateScoreboard(player2, LoreScoreBoard1, LoreScoreBoard2, plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
            List<String> list = GLClass.getLog().getStringList("logs");
            list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " buy compass " + "total material: " + MaterialBusiness);
            GLClass.getLog().set("logs", list);
            GLClass.saveLog();
		    player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + TakeMoneyCompass)); player.getInventory().addItem(new ItemStack(Material.COMPASS, NumberCompassGive));
			}	if(e.getSlot() == 8) {
					if(!EconomyManager.takeMoney(player, priceFire)) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + TakeMoneyNullFire));
						return;
					} int MaterialData = MaterialBusiness -= materialtake;
			int money = this.plugin.getConfig().getInt("Info.money");
			this.plugin.getConfig().set("Info.material", MaterialData);
			int money11 = money += priceFire;
			GLClass.getData().set("Info.24", money11);
			GLClass.saveData();
            if(MaterialBusiness <= -1) {
            	player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + NullMaterial));
            	return;
            }	this.plugin.getConfig().set("Info.money", money11);
			GLClass.getInsance().saveConfig();
            Methods.updateScoreboard(player2, LoreScoreBoard1, LoreScoreBoard2, plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
            List<String> list = GLClass.getLog().getStringList("logs");
            list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " buy flint and steel " + "total material: " + MaterialBusiness);
            GLClass.getLog().set("logs", list);
            GLClass.saveLog();
		    player.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + TakeMoneyFire)); player.getInventory().addItem(new ItemStack(Material.FLINT_AND_STEEL, NumberFireGive));
				}
		}
	}
	}
}