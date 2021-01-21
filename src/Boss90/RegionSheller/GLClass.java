package Boss90.RegionSheller;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class GLClass extends JavaPlugin implements Listener{
	private static GLClass instance;
		private File datafile;
		private FileConfiguration data;
		
		public void onEnable() {
		File config = new File(getDataFolder() + File.separator + "config.yml");
	if (!config.exists()) {
		getLogger().info("Creating new file config...");
	getConfig().options().copyDefaults(true);
	saveDefaultConfig();
	}
	instance = this;
	getDataFolder().mkdirs();
	datafile = new File(getDataFolder() + File.separator + "data.yml");
	if (!datafile.exists()) {
		try {
			datafile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
	data = YamlConfiguration.loadConfiguration(datafile);
	EconomyManager.init();
	getCommand("shopGUI").setExecutor(new ShopGUI(this));
	getCommand("sbalance").setExecutor(new BalanceBusiness(this));
	getCommand("stakebalance").setExecutor(new BalanceBusinessTake(this));
	getCommand("shelp").setExecutor(new HelpToPlugin(this));
	getCommand("sremoveowner").setExecutor(new removeOwner(this));
	getCommand("swipebusiness").setExecutor(new wipebusiness(this));
	Bukkit.getPluginManager().registerEvents(new SingHandler(this), this);
	Bukkit.getPluginManager().registerEvents(new EconomyManager(), this);
	Bukkit.getPluginManager().registerEvents(new ShopGUI(this), this);
	Bukkit.getPluginManager().registerEvents(new BalanceBusiness(this), this);
	Bukkit.getPluginManager().registerEvents(new BalanceBusinessTake(this), this);
	Bukkit.getPluginManager().registerEvents(new HelpToPlugin(this), this);
	Bukkit.getPluginManager().registerEvents(new Join(this), this);
	Bukkit.getPluginManager().registerEvents(new removeOwner(this), this);
	Bukkit.getPluginManager().registerEvents(new wipebusiness(this), this);
	if (Bukkit.getServer().getPluginManager().getPlugin("PermissionsEx") == null ) {
		this.getLogger().info("[ERROR] First install the PermissionEx plugin");
	}
	if (Bukkit.getServer().getPluginManager().getPlugin("WorldGuard") == null ) {
			this.getLogger().info("[ERROR] First install the WorldGuard plugin");
	}
	if (Bukkit.getServer().getPluginManager().getPlugin("Vault") == null ) {
				this.getLogger().info("[ERROR] First install the Vault plugin");
	}
		}
		public static GLClass getInsance() {
			return instance;
		}
	public static FileConfiguration getData() {
		return instance.data;
	}
	
		public static void saveData() {
		try {
		instance.data.save(instance.datafile);
		} catch (IOException e) {
		e.printStackTrace();
	}
	}
}