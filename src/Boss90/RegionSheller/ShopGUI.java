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
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import com.google.common.collect.Lists;

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
		
		NameApple = NameApple.replace("&", "\u00a7");
		
		String LoreApple = plugin.getConfig().getString("GUI.LoreApple");
		
		LoreApple = LoreApple.replace("&", "\u00a7");
		
		ItemStack item = new ItemStack(Material.APPLE, 1);
		ItemMeta meta = item.getItemMeta();
		item.setItemMeta(meta);
		meta.setDisplayName(NameApple);
		meta.setLore(Lists.newArrayList(LoreApple));
		item.setItemMeta(meta);
		
		i.setItem(0, item);
		p.openInventory(i);
		
		String NameBread = plugin.getConfig().getString("GUI.NameBread");
		NameBread = NameBread.replace("&", "\u00a7");
		
		String LoreBread = plugin.getConfig().getString("GUI.LoreBread");
		LoreBread = LoreBread.replace("&", "\u00a7");
		
		ItemStack item1 = new ItemStack(Material.BREAD, 1);
		meta.setDisplayName(NameBread);
		meta.setLore(Lists.newArrayList(LoreBread));
		item1.setItemMeta(meta);
		
		i.setItem(1, item1);
		p.openInventory(i);
		
		String LorePotato = plugin.getConfig().getString("GUI.LorePotato");
		
		LorePotato = LorePotato.replace("&", "\u00a7");
		
		String NamePotato = plugin.getConfig().getString("GUI.NamePotato");
		
		NamePotato = NamePotato.replace("&", "\u00a7");
		
		ItemStack item2 = new ItemStack(Material.BAKED_POTATO, 1);
		meta.setDisplayName(NamePotato);
		meta.setLore(Lists.newArrayList(LorePotato));
		item2.setItemMeta(meta);
		
		i.setItem(2, item2);
		p.openInventory(i);
		
		String LoreMilk = plugin.getConfig().getString("GUI.LoreMilk");
		
		LoreMilk = LoreMilk.replace("&", "\u00a7");
		
		String NameMilk = plugin.getConfig().getString("GUI.NameMilk");
		
		NameMilk = NameMilk.replace("&", "\u00a7");
		
		ItemStack item3 = new ItemStack(Material.MILK_BUCKET, 1);
		meta.setDisplayName(NameMilk);
		meta.setLore(Lists.newArrayList(LoreMilk));
		item3.setItemMeta(meta);
		
		i.setItem(3, item3);
		p.openInventory(i);
		
		String LoreFishing = plugin.getConfig().getString("GUI.LoreFishing");
		
		LoreFishing = LoreFishing.replace("&", "\u00a7");
		
		String NameFishing = plugin.getConfig().getString("GUI.NameFishing");
		
		NameFishing = NameFishing.replace("&", "\u00a7");
		
		ItemStack item4 = new ItemStack(Material.FISHING_ROD, 1);
		meta.setDisplayName(NameFishing);
		meta.setLore(Lists.newArrayList(LoreFishing));
		item4.setItemMeta(meta);
		
		i.setItem(4, item4);
		p.openInventory(i);
		
		String LoreBook = plugin.getConfig().getString("GUI.LoreBook");
		
		LoreBook = LoreBook.replace("&", "\u00a7");
		
		String NameBook = plugin.getConfig().getString("GUI.NameBook");
		
		NameBook = NameBook.replace("&", "\u00a7");
		
		ItemStack item5 = new ItemStack(Material.BOOK_AND_QUILL, 1);
		meta.setDisplayName(NameBook);
		meta.setLore(Lists.newArrayList(LoreBook));
		item5.setItemMeta(meta);
		
		i.setItem(5, item5);
		p.openInventory(i);
		
		String LoreClock = plugin.getConfig().getString("GUI.LoreClock");
		
		LoreClock = LoreClock.replace("&", "\u00a7");
		
		String NameClock = plugin.getConfig().getString("GUI.NameClock");
		
		NameClock = NameClock.replace("&", "\u00a7");
		
		ItemStack item6 = new ItemStack(Material.WATCH, 1);
		meta.setDisplayName(NameClock);
		meta.setLore(Lists.newArrayList(LoreClock));
		item6.setItemMeta(meta);
		
		i.setItem(6, item6);
		p.openInventory(i);
		
		String LoreCompass = plugin.getConfig().getString("GUI.LoreCompass");
		
		LoreCompass = LoreCompass.replace("&", "\u00a7");
		
		String NameCompass = plugin.getConfig().getString("GUI.NameCompass");
		
		NameCompass = NameCompass.replace("&", "\u00a7");
		
		ItemStack item7 = new ItemStack(Material.COMPASS, 1);
		meta.setDisplayName(NameCompass);
		meta.setLore(Lists.newArrayList(LoreCompass));
		item7.setItemMeta(meta);
		
		i.setItem(7, item7);
		p.openInventory(i);
		
		String LoreFire = plugin.getConfig().getString("GUI.LoreSteel");
		
		LoreFire = LoreFire.replace("&", "\u00a7");
		
		String NameFire = plugin.getConfig().getString("GUI.NameSteel");
		
		NameFire = NameFire.replace("&", "\u00a7");
		
		ItemStack item8 = new ItemStack(Material.FLINT_AND_STEEL, 1);
		meta.setDisplayName(NameFire);
		meta.setLore(Lists.newArrayList(LoreFire));
		item8.setItemMeta(meta);
		
		i.setItem(8, item8);
		p.openInventory(i);
		return true;
	}
	@SuppressWarnings("unused")
	@EventHandler
	public void handle(InventoryClickEvent e) {
		String NameGUI = plugin.getConfig().getString("GUI.NameGUI");
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
		
		String TakeMoneyApple = plugin.getConfig().getString("Messages.BuyAppleMessage");
		TakeMoneyApple = TakeMoneyApple.replace("&", "\u00a7");
		
		String TakeMoneyBread = plugin.getConfig().getString("Messages.BuyBreadMessage");
		TakeMoneyBread = TakeMoneyBread.replace("&", "\u00a7");
		
		String TakeMoneyPotato = plugin.getConfig().getString("Messages.BuyPotatoMessage");
		TakeMoneyPotato = TakeMoneyPotato.replace("&", "\u00a7");
		
		String TakeMoneyMilk = plugin.getConfig().getString("Messages.BuyMilkMessage");
		TakeMoneyMilk = TakeMoneyMilk.replace("&", "\u00a7");
		
		String TakeMoneyFishing = plugin.getConfig().getString("Messages.BuyFishingMessage");
		TakeMoneyFishing = TakeMoneyFishing.replace("&", "\u00a7");
		
		String TakeMoneyBook = plugin.getConfig().getString("Messages.BuyBookMessage");
		TakeMoneyBook = TakeMoneyBook.replace("&", "\u00a7");
		
		String TakeMoneyClock = plugin.getConfig().getString("Messages.BuyClockMessage");
		TakeMoneyClock = TakeMoneyClock.replace("&", "\u00a7");
		
		String TakeMoneyCompass = plugin.getConfig().getString("Messages.BuyCompassMessage");
		TakeMoneyCompass = TakeMoneyCompass.replace("&", "\u00a7");
		
		String TakeMoneyFire = plugin.getConfig().getString("Messages.BuySteelMessage");
		TakeMoneyFire = TakeMoneyFire.replace("&", "\u00a7");
		
		String TakeMoneyNullApple = plugin.getConfig().getString("Messages.InsufficientFundsAppleMessage");
		TakeMoneyNullApple = TakeMoneyNullApple.replace("&", "\u00a7");
		
		String TakeMoneyNullBread = plugin.getConfig().getString("Messages.InsufficientFundsBreadMessage");
		TakeMoneyNullBread = TakeMoneyNullBread.replace("&", "\u00a7");
		
		String TakeMoneyNullPotato = plugin.getConfig().getString("Messages.InsufficientFundsPotatoMessage");
		TakeMoneyNullPotato = TakeMoneyNullPotato.replace("&", "\u00a7");
		
		String TakeMoneyNullMilk = plugin.getConfig().getString("Messages.InsufficientFundsMilkMessage");
		TakeMoneyNullMilk = TakeMoneyNullMilk.replace("&", "\u00a7");
		
		String TakeMoneyNullFishing = plugin.getConfig().getString("Messages.InsufficientFundsFishingMessage");
		TakeMoneyNullFishing = TakeMoneyNullFishing.replace("&", "\u00a7");
		
		String TakeMoneyNullBook = plugin.getConfig().getString("Messages.InsufficientFundsBookMessage");
		TakeMoneyNullBook = TakeMoneyNullBook.replace("&", "\u00a7");
		
		String TakeMoneyNullClock = plugin.getConfig().getString("Messages.InsufficientFundsClockMessage");
		TakeMoneyNullClock = TakeMoneyNullClock.replace("&", "\u00a7");
		
		String TakeMoneyNullCompass = plugin.getConfig().getString("Messages.InsufficientFundsCompassMessage");
		TakeMoneyNullCompass = TakeMoneyNullCompass.replace("&", "\u00a7");
		
		String TakeMoneyNullFire = plugin.getConfig().getString("Messages.InsufficientFundsSteelMessage");
		TakeMoneyNullFire = TakeMoneyNullFire.replace("&", "\u00a7");
		
		String Prefix = plugin.getConfig().getString("Messages.Prefix");
		Prefix = Prefix.replace("&", "\u00a7");
		
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
        LocalTime time = LocalTime.now();
        Player player2 = (Player) Bukkit.getPlayer(plugin.getConfig().getString("Info.owner"));
        String hour = time.getHour() < 10 ? "0" + time.getHour() : String.valueOf(time.getHour());
        String minute = time.getMinute() < 10 ? "0" + time.getMinute() : String.valueOf(time.getMinute());
        String second = time.getSecond() < 10 ? "0" + time.getSecond() : String.valueOf(time.getSecond());

			if(e.getSlot() <= 9) e.setCancelled(true);
				if(e.getSlot() == 0) {
				if(!EconomyManager.takeMoney(player, priceApple)) {
					player.sendMessage(Prefix + " " + TakeMoneyNullApple);
					return;
				}
				int money = this.plugin.getConfig().getInt("Info.money");
				int money2 = money += priceApple;
				this.plugin.getConfig().set("Info.money", money2);
				GLClass.getInsance().saveConfig();
                updateScoreboard(player2);
                List<String> list = GLClass.getLog().getStringList("logs");
                list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " buy apple");
                GLClass.getLog().set("logs", list);
                GLClass.saveLog();
				player.sendMessage(Prefix + " " + TakeMoneyApple); player.getInventory().addItem(new ItemStack(Material.APPLE, NumberAppleGive));
				}
			if(e.getSlot() == 1) {
				if(!EconomyManager.takeMoney(player, priceBread)) {
					player.sendMessage(Prefix + " " + TakeMoneyNullBread);
					return;
				}
				int money = this.plugin.getConfig().getInt("Info.money");
				int money3 = money += priceBread;
				this.plugin.getConfig().set("Info.money", money3);
				GLClass.getInsance().saveConfig();
                updateScoreboard(player2);
                List<String> list = GLClass.getLog().getStringList("logs");
                list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " buy bread");
                GLClass.getLog().set("logs", list);
                GLClass.saveLog();
			player.sendMessage(Prefix + " " + TakeMoneyBread); player.getInventory().addItem(new ItemStack(Material.BREAD, NumberBreadGive));
			}
			
			if(e.getSlot() == 2) {
				if(!EconomyManager.takeMoney(player, pricePotato)) {
					player.sendMessage(Prefix + " " + TakeMoneyNullPotato);
					return;
				}
				int money = this.plugin.getConfig().getInt("Info.money");
				int money4 = money += pricePotato;
				this.plugin.getConfig().set("Info.money", money4);
				GLClass.getInsance().saveConfig();
                updateScoreboard(player2);
                List<String> list = GLClass.getLog().getStringList("logs");
                list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " buy potato");
                GLClass.getLog().set("logs", list);
                GLClass.saveLog();
			player.sendMessage(Prefix + " " + TakeMoneyPotato); player.getInventory().addItem(new ItemStack(Material.BAKED_POTATO, NumberPotatoGive));
			}
			
			if(e.getSlot() == 3) {
				if(!EconomyManager.takeMoney(player, priceMilk)) {
					player.sendMessage(Prefix + " " + TakeMoneyNullMilk);
					return;
				}
				int money = this.plugin.getConfig().getInt("Info.money");
				int money5 = money += priceMilk;
				this.plugin.getConfig().set("Info.money", money5);
				GLClass.getInsance().saveConfig();
                updateScoreboard(player2);
                List<String> list = GLClass.getLog().getStringList("logs");
                list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " buy milk");
                GLClass.getLog().set("logs", list);
                GLClass.saveLog();
			player.sendMessage(Prefix + " " + TakeMoneyMilk); player.getInventory().addItem(new ItemStack(Material.MILK_BUCKET, NumberMilkGive));
			}
			
			if(e.getSlot() == 4) {
				if(!EconomyManager.takeMoney(player, priceFishing)) {
					player.sendMessage(Prefix + " " + TakeMoneyNullFishing);
					return;
				}
				int money = this.plugin.getConfig().getInt("Info.money");
				int money7 = money += priceFishing;
				this.plugin.getConfig().set("Info.money", money7);
				GLClass.getInsance().saveConfig();
                updateScoreboard(player2);
                List<String> list = GLClass.getLog().getStringList("logs");
                list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " buy Fishing rod");
                GLClass.getLog().set("logs", list);
                GLClass.saveLog();
			    player.sendMessage(Prefix + " " + TakeMoneyFishing); player.getInventory().addItem(new ItemStack(Material.FISHING_ROD, NumberFishingGive));
			}
				if(e.getSlot() == 5) {
					if(!EconomyManager.takeMoney(player, priceBook)) {
						player.sendMessage(Prefix + " " + TakeMoneyNullBook);
						return;
					}
					int money = this.plugin.getConfig().getInt("Info.money");
					int money8 = money += priceBook;
					this.plugin.getConfig().set("Info.money", money8);
					GLClass.getInsance().saveConfig();
	                updateScoreboard(player2);
	                List<String> list = GLClass.getLog().getStringList("logs");
	                list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " buy book");
	                GLClass.getLog().set("logs", list);
	                GLClass.saveLog();
				    player.sendMessage(Prefix + " " + TakeMoneyBook); player.getInventory().addItem(new ItemStack(Material.BOOK_AND_QUILL, NumberBookGive));
			}
				if(e.getSlot() == 6) {
					if(!EconomyManager.takeMoney(player, priceClock)) {
						player.sendMessage(Prefix + " " + TakeMoneyNullClock);
						return;
					}
			int money = this.plugin.getConfig().getInt("Info.money");
			int money9 = money += priceClock;
			this.plugin.getConfig().set("Info.money", money9);
			GLClass.getInsance().saveConfig();
            updateScoreboard(player2);
            List<String> list = GLClass.getLog().getStringList("logs");
            list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " buy clock");
            GLClass.getLog().set("logs", list);
            GLClass.saveLog();
		    player.sendMessage(Prefix + " " + TakeMoneyClock); player.getInventory().addItem(new ItemStack(Material.WATCH, NumberClockGive));
			}
				if(e.getSlot() == 7) {
					if(!EconomyManager.takeMoney(player, priceCompass)) {
						player.sendMessage(Prefix + " " + TakeMoneyNullCompass);
						return;
					}
			int money = this.plugin.getConfig().getInt("Info.money");
			int money10 = money += priceCompass;
			this.plugin.getConfig().set("Info.money", money10);
			GLClass.getInsance().saveConfig();
            updateScoreboard(player2);
            List<String> list = GLClass.getLog().getStringList("logs");
            list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " buy compass");
            GLClass.getLog().set("logs", list);
            GLClass.saveLog();
		    player.sendMessage(Prefix + " " + TakeMoneyCompass); player.getInventory().addItem(new ItemStack(Material.COMPASS, NumberCompassGive));
			}
				if(e.getSlot() == 8) {
					if(!EconomyManager.takeMoney(player, priceFire)) {
						player.sendMessage(Prefix + " " + TakeMoneyNullFire);
						return;
					}
			int money = this.plugin.getConfig().getInt("Info.money");
			int money11 = money += priceFire;
			this.plugin.getConfig().set("Info.money", money11);
			GLClass.getInsance().saveConfig();
            updateScoreboard(player2);
            List<String> list = GLClass.getLog().getStringList("logs");
            list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + e.getView().getPlayer().getName() + " buy flint and steel");
            GLClass.getLog().set("logs", list);
            GLClass.saveLog();
		    player.sendMessage(Prefix + " " + TakeMoneyFire); player.getInventory().addItem(new ItemStack(Material.FLINT_AND_STEEL, NumberFireGive));
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
        }
	}
}