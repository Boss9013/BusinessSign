package Boss90.RegionSheller.Commands;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Boss90.RegionSheller.GLClass;

public class Vote implements CommandExecutor, Listener {
	private GLClass plugin;

	public Vote(GLClass plugin) {
	this.plugin = plugin;
	}
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
   		 Player p = (Player) sender;
   		 String Prefix = plugin.getConfig().getString("Messages.Prefix");
   		String MessageFalse = plugin.getConfig().getString("Vote.MessageFalse");
   		String MessageTrue = plugin.getConfig().getString("Vote.MessageTrue");
   		if(plugin.getConfig().getString("Vote.start") == "false") {
   		p.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + MessageFalse));
   		return true;
   		}
   		ItemStack item = new ItemStack(Material.PAPER, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(plugin.getConfig().getString("Vote.Nick1"));
			item.setItemMeta(meta);
	   		ItemStack item2 = new ItemStack(Material.PAPER, 1);
				meta.setDisplayName(plugin.getConfig().getString("Vote.Nick2"));
				item2.setItemMeta(meta);
		   		ItemStack item3 = new ItemStack(Material.PAPER, 1);
				meta.setDisplayName(plugin.getConfig().getString("Vote.Nick3"));
				item3.setItemMeta(meta);
   		if(plugin.getConfig().getString("Vote.start") == "true") {
   		p.getInventory().addItem(new ItemStack(item));
   		p.getInventory().addItem(new ItemStack(item2));
   		p.getInventory().addItem(new ItemStack(item3));
   		p.sendMessage(ChatColor.translateAlternateColorCodes('&',Prefix + " " + MessageTrue));
        List<String> list = GLClass.getLog().getStringList("logs");
        list.add("[LOGS] [" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "] [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond() + "] " + p.getName() + " voting");
        GLClass.getLog().set("logs", list);
        GLClass.saveLog();
   		}
		return true;
   	 }
}