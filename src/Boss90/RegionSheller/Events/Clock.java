package Boss90.RegionSheller.Events;

import java.time.LocalDate;
import java.time.LocalTime;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Boss90.RegionSheller.GLClass;
public class Clock implements Listener {
private GLClass plugin;

public Clock(GLClass plugin) {
this.plugin = plugin;
}
@EventHandler(priority = EventPriority.LOWEST)
public void playerInteract(PlayerInteractEvent e){
Player p = e.getPlayer();
Action a = e.getAction();
if(a != Action.RIGHT_CLICK_BLOCK && a != Action.RIGHT_CLICK_AIR) return;
@SuppressWarnings("deprecation")
ItemStack item = p.getItemInHand();
ItemMeta meta = item.getItemMeta();
if(meta == null) {
	return;
}
if(meta.getDisplayName() == null) {
	return;
}
String DisplayNameClock = plugin.getConfig().getString("GUI.ClockDisplayName");
String TitleClock = plugin.getConfig().getString("GUI.TitleClock");
if(meta.getDisplayName().contains(ChatColor.translateAlternateColorCodes('&', DisplayNameClock))) {
p.sendTitle(TitleClock, "§e" + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + ", §a" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond(),20,20,20);
}
}
}