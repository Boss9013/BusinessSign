package Boss90.RegionSheller.GUIMenu;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Boss90.RegionSheller.GLClass;
import Boss90.RegionSheller.Util.Methods;

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
	@EventHandler(priority = EventPriority.LOW)
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
		
		int NumberCompassGive = plugin.getConfig().getInt("NumberGive.NumberCompassGive");
		
		int NumberFireGive = plugin.getConfig().getInt("NumberGive.NumberSteelGive");

		Player player = (Player) e.getWhoClicked();
        Player player2 = (Player) Bukkit.getPlayer(plugin.getConfig().getString("Info.owner"));

			if(e.getSlot() <= 9) e.setCancelled(true);
				if(e.getSlot() == 0) {
				int money = this.plugin.getConfig().getInt("Info.money");
				int money2 = money += priceApple;
				int MaterialData = MaterialBusiness -= materialtake;
				this.plugin.getConfig().set("Info.money", money2);
				this.plugin.getConfig().set("Info.material", MaterialData);
	            Methods.updateScoreboard(player2, LoreScoreBoard1, LoreScoreBoard2, plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
				Methods.Log(player.getName(), " buy apple " + "total material: " + MaterialBusiness);
				
				Methods.ClickShop(priceApple, player, Prefix, TakeMoneyNullApple, money2, MaterialBusiness, TakeMoneyApple, NumberAppleGive, NullMaterial, Material.APPLE);
			  } if(e.getSlot() == 1) {
				  int money = this.plugin.getConfig().getInt("Info.money");
				int money3 = money += priceBread;
				int MaterialData = MaterialBusiness -= materialtake;
				this.plugin.getConfig().set("Info.money", money3);
				this.plugin.getConfig().set("Info.material", MaterialData);
				GLClass.getInsance().saveConfig();
	            Methods.updateScoreboard(player2, LoreScoreBoard1, LoreScoreBoard2, plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
				Methods.Log(player.getName(), " buy bread " + "total material: " + MaterialBusiness);
				
				Methods.ClickShop(priceBread, player, Prefix, TakeMoneyNullBread, money3, MaterialBusiness, TakeMoneyBread, NumberBreadGive, NullMaterial, Material.BREAD);
			}
			
			if(e.getSlot() == 2) {
				int money = this.plugin.getConfig().getInt("Info.money");
				int money4 = money += pricePotato;
				int MaterialData = MaterialBusiness -= materialtake;
				this.plugin.getConfig().set("Info.money", money4);
				this.plugin.getConfig().set("Info.material", MaterialData);
	            Methods.updateScoreboard(player2, LoreScoreBoard1, LoreScoreBoard2, plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
				Methods.Log(player.getName(), " buy Potato " + "total material: " + MaterialBusiness);
				
				Methods.ClickShop(pricePotato, player, Prefix, TakeMoneyNullPotato, money4, MaterialBusiness, TakeMoneyPotato, NumberPotatoGive, NullMaterial, Material.POTATO);
			}
			
			if(e.getSlot() == 3) {
                int money = this.plugin.getConfig().getInt("Info.money");
				int money5 = money += priceMilk;
				int MaterialData = MaterialBusiness -= materialtake;
                this.plugin.getConfig().set("Info.money", money5);
				this.plugin.getConfig().set("Info.material", MaterialData);
	            Methods.updateScoreboard(player2, LoreScoreBoard1, LoreScoreBoard2, plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
				Methods.Log(player.getName(), " buy Milk " + "total material: " + MaterialBusiness);
				
				Methods.ClickShop(priceMilk, player, Prefix, TakeMoneyNullMilk, money5, MaterialBusiness, TakeMoneyMilk, NumberMilkGive, NullMaterial, Material.MILK_BUCKET);
			} if(e.getSlot() == 4) {
                int money = this.plugin.getConfig().getInt("Info.money");
				int money7 = money += priceFishing;
				int MaterialData = MaterialBusiness -= materialtake;
                this.plugin.getConfig().set("Info.money", money7);
				this.plugin.getConfig().set("Info.material", MaterialData);
	            Methods.updateScoreboard(player2, LoreScoreBoard1, LoreScoreBoard2, plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
				Methods.Log(player.getName(), " buy fishing_rod " + "total material: " + MaterialBusiness);
				Methods.ClickShop(priceFishing, player, Prefix, TakeMoneyNullFishing, money7, MaterialBusiness, TakeMoneyFishing, NumberFishingGive, NullMaterial, Material.FISHING_ROD);
			}		if(e.getSlot() == 5) {
					int money = this.plugin.getConfig().getInt("Info.money");
					int money8 = money += priceBook;
					int MaterialData = MaterialBusiness -= materialtake;
                    this.plugin.getConfig().set("Info.money", money8);
					this.plugin.getConfig().set("Info.material", MaterialData);
		            Methods.updateScoreboard(player2, LoreScoreBoard1, LoreScoreBoard2, plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
					Methods.Log(player.getName(), " buy Book " + "total material: " + MaterialBusiness);
					Methods.ClickShop(priceBook, player, Prefix, TakeMoneyNullBook, money8, MaterialBusiness, TakeMoneyBook, NumberBookGive, NullMaterial, Material.BOOK_AND_QUILL);
			}	if(e.getSlot() == 6) {
			int money = this.plugin.getConfig().getInt("Info.money");
			int money9 = money += priceClock;
			int MaterialData = MaterialBusiness -= materialtake;
           	this.plugin.getConfig().set("Info.money", money9);
			this.plugin.getConfig().set("Info.material", MaterialData);
            Methods.updateScoreboard(player2, LoreScoreBoard1, LoreScoreBoard2, plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
			Methods.Log(player.getName(), " buy clock " + "total material: " + MaterialBusiness);
			
            ItemStack i2 = new ItemStack(Material.WATCH, 1);
            ItemMeta metaclock = i2.getItemMeta();
            String DisplayNameClock = plugin.getConfig().getString("GUI.ClockDisplayName");
            metaclock.setDisplayName(ChatColor.translateAlternateColorCodes('&',DisplayNameClock));
            i2.setItemMeta(metaclock);
			Methods.ClickShop2(priceClock, player, Prefix, TakeMoneyNullClock, money9, MaterialBusiness, TakeMoneyClock, NullMaterial, i2);
			}	if(e.getSlot() == 7) {
				
			int money = this.plugin.getConfig().getInt("Info.money");
			int MaterialData = MaterialBusiness -= materialtake;
			int money10 = money += priceCompass;
			this.plugin.getConfig().set("Info.material", MaterialData);
			this.plugin.getConfig().set("Info.money", money10);
            Methods.updateScoreboard(player2, LoreScoreBoard1, LoreScoreBoard2, plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
			Methods.Log(player.getName(), " buy compass " + "total material: " + MaterialBusiness);
			
			Methods.ClickShop(priceCompass, player, Prefix, TakeMoneyNullCompass, money10, MaterialBusiness, TakeMoneyCompass, NumberCompassGive, NullMaterial, Material.COMPASS);
			}	if(e.getSlot() == 8) {
            int MaterialData = MaterialBusiness -= materialtake;
			int money = this.plugin.getConfig().getInt("Info.money");
			int money11 = money += priceFire;
			this.plugin.getConfig().set("Info.material", MaterialData);
            this.plugin.getConfig().set("Info.money", money11);
            Methods.updateScoreboard(player2, LoreScoreBoard1, LoreScoreBoard2, plugin.getConfig().getInt("Info.money"), plugin.getConfig().getInt("Info.material"));
			Methods.Log(player.getName(), " buy flint and steel " + "total material: " + MaterialBusiness);
			
			Methods.ClickShop(priceFire, player, Prefix, TakeMoneyNullFire, money11, MaterialBusiness, TakeMoneyFire, NumberFireGive, NullMaterial, Material.FLINT_AND_STEEL);
				}
		}
	}
	}
}