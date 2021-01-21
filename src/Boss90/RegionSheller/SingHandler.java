package Boss90.RegionSheller;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class SingHandler implements Listener {
	private GLClass plugin;

	public SingHandler(GLClass plugin) {
	this.plugin = plugin;
	}
	public static Player player;
	
	@EventHandler
	public void create(SignChangeEvent e) {
		String InvalidPrice = plugin.getConfig().getString("Sign.InvalidPrice");
		InvalidPrice = InvalidPrice.replace("&", "\u00a7");
		String FirstLine = plugin.getConfig().getString("Sign.FirstLine");
		FirstLine = FirstLine.replace("&", "\u00a7");
		String TwoLine = plugin.getConfig().getString("Sign.TwoLine");
		TwoLine = TwoLine.replace("&", "\u00a7");
		Player p = e.getPlayer();
		if(!p.hasPermission("Business.CreateBusiness")) return;
		
		String PrefixBusiness = plugin.getConfig().getString("Sign.Prefix");
		if(!e.getLine(0).equalsIgnoreCase(PrefixBusiness)) return;
		String name;
		double amount;
		name = e.getLine(1);
		try {
			amount = Double.parseDouble(e.getLine(2));
		}   catch (NumberFormatException el) {
			e.setLine(3, InvalidPrice);
			return;
		}
		
		if(amount < 0) {
			e.setLine(3, InvalidPrice);
			return;
		}
		
		String key = locToString(e.getBlock().getLocation());
		
		GLClass.getData().set(key + ".region", name);
		GLClass.getData().set(key + ".price", amount);
		GLClass.saveData();
		p.sendMessage("§aSell business create");
		e.setLine(0, FirstLine);
		e.setLine(2, TwoLine + " " + amount);
	}
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(!p.hasPermission("Business.DeleteBusiness")) return;
		Material t = e.getBlock().getType();
		if(t != Material.SIGN_POST && t != Material.WALL_SIGN) return;
		

		String key = locToString(e.getBlock().getLocation());
		if(GLClass.getData().getString(key + ".region") != null) {
			GLClass.getData().set(key, null);
			GLClass.saveData();
			p.sendMessage("§cSell business delete.");
		}
	}
	@EventHandler
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
		BusinessErrorBuy = BusinessErrorBuy.replace("&", "\u00a7");
		
		String Invalid = plugin.getConfig().getString("Sign.InsufficientFundsMessage");
		Invalid = Invalid.replace("&", "\u00a7");
		
		if(region == null) {
			p.sendMessage("§cRegion is null.");
			return;
		}
		
		if(region.getOwners().size() > 0 || region.getMembers().size() > 0) {
			p.sendMessage(BusinessErrorBuy);
			return;
		}
		
		if(!EconomyManager.takeMoney(p, price)) {
			p.sendMessage(Invalid);
			return;
		}
		String SucessBusinessBuy = plugin.getConfig().getString("Sign.MessageBusinessBuy");
		SucessBusinessBuy = SucessBusinessBuy.replace("&", "\u00a7");
		
		String ThreeLine = plugin.getConfig().getString("Sign.ThirdLine");
		ThreeLine = ThreeLine.replace("&", "\u00a7");
		
		region.getOwners().addPlayer(p.getName());
		
		GLClass.getData().set(key, null);
		GLClass.saveData();
  		System.out.println("Player " + e.getPlayer().getName() + " buy Business!");
		p.sendMessage(SucessBusinessBuy + " " + region.getId());
		Sign sign = (Sign) e.getClickedBlock().getState();
		sign.setLine(2, ThreeLine + " " + p.getName());
		sign.update();
		this.plugin.getConfig().set("Info.owner", e.getPlayer().getName());
		GLClass.getInsance().saveConfig();
		String MessageTitle = plugin.getConfig().getString("Sign.MessageTitleBusinessBuy");
		MessageTitle = MessageTitle.replace("&", "\u00a7");
		String MessageTitleTwo = plugin.getConfig().getString("Sign.MessageTitleBusinessBuyTwoLine");
		MessageTitleTwo = MessageTitleTwo.replace("&", "\u00a7");
        p.sendTitle(MessageTitle,MessageTitleTwo,20,90,20);
		 PermissionUser user = PermissionsEx.getUser(p);
		 user.addPermission("Business.balancetake");
		 user.addPermission("Business.balance");
		 user.addPermission("Business.Join");
		 user.addPermission("Business.Quit");
	}
	
	public String locToString(Location loc) {
		return loc.getWorld().getName() + "_" + loc.getBlockX() + "_" + loc.getBlockY() + "_" + loc.getBlockZ();
	}
}