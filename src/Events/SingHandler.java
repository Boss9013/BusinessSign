package Events;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

import GLClass.GLClass;
import Util.EconomyManager;

public class SingHandler implements Listener {
	private GLClass plugin;

	public SingHandler(GLClass plugin) {
	this.plugin = plugin;
  } public static Player player;

    @EventHandler(priority = EventPriority.LOWEST)
	public void create(SignChangeEvent e) {
		String InvalidPrice = plugin.getConfig().getString("Sign.InvalidPrice");
		String FirstLine = plugin.getConfig().getString("Sign.FirstLine");
		String TwoLine = plugin.getConfig().getString("Sign.TwoLine");
		Player p = e.getPlayer();
		if(!p.hasPermission("Business.CreateBusiness")) return;
		
		String PrefixBusiness = plugin.getConfig().getString("Sign.Prefix");
		if(!e.getLine(0).equalsIgnoreCase(PrefixBusiness)) return;
		String name;
		double amount;
		name = e.getLine(1);
		try { amount = Double.parseDouble(e.getLine(2));
		}   catch (NumberFormatException el) {
			e.setLine(3, ChatColor.translateAlternateColorCodes('&',InvalidPrice));
			return;
	 } if(amount < 0) {
			e.setLine(3, ChatColor.translateAlternateColorCodes('&',InvalidPrice));
			return;
	  } String key = locToString(e.getBlock().getLocation());
		GLClass.getData().set(key + ".region", name);
		GLClass.getData().set(key + ".price", amount);
		GLClass.saveData();
		String Prefix = plugin.getConfig().getString("Messages.Prefix");
		p.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " §aSell business create"));
		e.setLine(0, ChatColor.translateAlternateColorCodes('&',FirstLine));
		e.setLine(2, ChatColor.translateAlternateColorCodes('&',TwoLine + " " + amount));
        GLClass.saveData();
        Block b = e.getBlock();
        List<String> list = GLClass.getLog().getStringList("logs");
        list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + p.getName() + " creating business " + b.getX() + " " + b.getY() + " " + b.getZ());
        GLClass.getLog().set("logs", list);
        GLClass.saveLog();
  } @EventHandler(priority = EventPriority.LOWEST)
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(!p.hasPermission("Business.DeleteBusiness")) return;
		Material t = e.getBlock().getType();
		if(t != Material.SIGN_POST && t != Material.WALL_SIGN) return;
		String Prefix = plugin.getConfig().getString("Messages.Prefix");
		String key = locToString(e.getBlock().getLocation());
		if(GLClass.getData().getString(key + ".region") != null) {
			GLClass.getData().set(key, null);
			p.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " §cSell business delete."));
			GLClass.saveData();
	        Block b = e.getBlock();
	        List<String> list = GLClass.getLog().getStringList("logs");
	        list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + p.getName() + " deleted business " + b.getX() + " " + b.getY() + " " + b.getZ());
	        GLClass.getLog().set("logs", list);
	        GLClass.saveLog();
		}
  }@EventHandler(priority = EventPriority.NORMAL)
	public void click(PlayerInteractEvent e) {
		if(e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
		Material t = e.getClickedBlock().getType();
		if(t != Material.SIGN_POST && t != Material.WALL_SIGN) return;
		
		Player p = e.getPlayer();
		
		String key = locToString(e.getClickedBlock().getLocation());
		
		String rg = GLClass.getData().getString(key + ".region");
		if(rg  == null) return;
		
		double price = GLClass.getData().getDouble(key + ".price");
		if(price == 0) return;
		
		RegionManager manager = WorldGuardPlugin.inst().getRegionManager(e.getClickedBlock().getWorld());
		ProtectedRegion region = manager.getRegion(rg);
		
		String BusinessErrorBuy = plugin.getConfig().getString("Sign.BusinessErrorBuy");
		
		String Invalid = plugin.getConfig().getString("Sign.InsufficientFundsMessage");
		
		String Prefix = plugin.getConfig().getString("Messages.Prefix");
		
		String NullRegion = plugin.getConfig().getString("Sign.MessageRegionNull");
		if(region == null) {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + NullRegion));
			return;
		}		if(region.getOwners().size() > 0 || region.getMembers().size() > 0) {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + BusinessErrorBuy));
			return;
		}	if(!EconomyManager.takeMoney(p, price)) {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + Invalid));
			return;
		}		String SucessBusinessBuy = plugin.getConfig().getString("Sign.MessageBusinessBuy");
		
		String ThreeLine = plugin.getConfig().getString("Sign.ThirdLine");
		
		region.getOwners().addPlayer(p.getName());
		
		GLClass.getData().set(key, null);
		GLClass.saveData();
  		System.out.println(ChatColor.translateAlternateColorCodes('&',Prefix + " " + SucessBusinessBuy + " " + region.getId()));
		Sign sign = (Sign) e.getClickedBlock().getState();
		sign.setLine(2, ChatColor.translateAlternateColorCodes('&',ThreeLine));
		sign.setLine(3, p.getName());
		sign.update();
		this.plugin.getConfig().set("Info.owner", e.getPlayer().getName());
		GLClass.getInsance().saveConfig();
		String MessageTitle = plugin.getConfig().getString("Sign.MessageTitleBusinessBuy");
		String MessageTitleTwo = plugin.getConfig().getString("Sign.MessageTitleBusinessBuyTwoLine");
		MessageTitle = MessageTitle.replace("&", "\u00a7");
		MessageTitleTwo = MessageTitleTwo.replace("&", "\u00a7");
        p.sendTitle(MessageTitle,MessageTitleTwo,20,90,20);
        List<String> list = GLClass.getLog().getStringList("logs");
        list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + p.getName() + " buy business");
        GLClass.getLog().set("logs", list);
        GLClass.saveLog();
	}	public String locToString(Location loc) {
		return loc.getWorld().getName() + "_" + loc.getBlockX() + "_" + loc.getBlockY() + "_" + loc.getBlockZ();
	}
}