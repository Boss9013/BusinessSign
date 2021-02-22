package Boss90.RegionSheller.Util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import net.milkbowl.vault.economy.Economy;

public class EconomyManager implements Listener{
	private static Economy e;
	
	public static void init() {
		RegisteredServiceProvider<Economy> reg = Bukkit.getServicesManager().getRegistration(Economy.class);
		if (reg != null) e = reg.getProvider();
	}	public static boolean takeMoney(Player p, double amount) {
		if(e == null) return false;
		
		if(e.getBalance(p) < amount) return false;
		return e.withdrawPlayer(p, amount).transactionSuccess();
		}	public static void init1() {
	RegisteredServiceProvider<Economy> reg = Bukkit.getServicesManager().getRegistration(Economy.class);
	if (reg != null) e = reg.getProvider();

  }	public static boolean giveMoney(Player p, double amount) {
	if (e == null) return false;
	return e.depositPlayer(p, amount).transactionSuccess();
	}public static double infoMoney(Player p) {
		return e.getBalance(p);
	}
}