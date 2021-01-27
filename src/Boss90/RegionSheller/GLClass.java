package Boss90.RegionSheller;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.chat.Chat;

public class GLClass extends JavaPlugin implements Listener{
	public static GLClass plugin;
	private static GLClass instance;
		private File datafile;
		private FileConfiguration data;
		private File logfile;
		private FileConfiguration log;
		public Chat chat;
		
		public void onEnable() {
			plugin = this;
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
   logfile = new File(getDataFolder() + File.separator + "logs.txt");
	if (!logfile.exists()) {
		try {
			logfile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
	data = YamlConfiguration.loadConfiguration(datafile);
	log = YamlConfiguration.loadConfiguration(logfile);
	EconomyManager.init();
	getCommand("shopGUI").setExecutor(new ShopGUI(this));
	getCommand("sbalance").setExecutor(new BalanceBusiness(this));
	getCommand("stakebalance").setExecutor(new BalanceBusinessTake(this));
	getCommand("shelp").setExecutor(new HelpToPlugin(this));
	getCommand("sremoveowner").setExecutor(new removeOwner(this));
	getCommand("swipebusiness").setExecutor(new wipebusiness(this));
	getCommand("sreload").setExecutor(new ReloadPlugin());
	Bukkit.getPluginManager().registerEvents(new SingHandler(this), this);
	Bukkit.getPluginManager().registerEvents(new EconomyManager(), this);
	Bukkit.getPluginManager().registerEvents(new ShopGUI(this), this);
	Bukkit.getPluginManager().registerEvents(new BalanceBusiness(this), this);
	Bukkit.getPluginManager().registerEvents(new BalanceBusinessTake(this), this);
	Bukkit.getPluginManager().registerEvents(new HelpToPlugin(this), this);
	Bukkit.getPluginManager().registerEvents(new Join(this), this);
	Bukkit.getPluginManager().registerEvents(new removeOwner(this), this);
	Bukkit.getPluginManager().registerEvents(new wipebusiness(this), this);
	Bukkit.getPluginManager().registerEvents(new ScoreBoard(this), this);
	if (Bukkit.getServer().getPluginManager().getPlugin("WorldGuard") == null ) {
			this.getLogger().info("[ERROR] First install the WorldGuard plugin");
	}
	if (Bukkit.getServer().getPluginManager().getPlugin("Vault") == null ) {
				this.getLogger().info("[ERROR] First install the Vault plugin");
	}
	setupChat();
		}
		public static GLClass getInsance() {
			return instance;
		}
	public static FileConfiguration getData() {
		return instance.data;
	}
public static FileConfiguration getLog() {
	return instance.log;
}
	public static GLClass getInstance() {
		return plugin;
		}
		public static void saveData() {
		try {
		instance.data.save(instance.datafile);
		} catch (IOException e) {
		e.printStackTrace();
	}
	}
		
		public static void saveLog() {
		try {
		instance.log.save(instance.logfile);
		} catch (IOException e) {
		e.printStackTrace();
	}
	}
		
	    private boolean setupChat() {
	        RegisteredServiceProvider<Chat> chatProvider = Bukkit.getServicesManager().getRegistration(Chat.class);
	        if (chatProvider != null) {
	            chat = (Chat) chatProvider.getProvider();
	        }
	        return chat != null;
	    }
	}