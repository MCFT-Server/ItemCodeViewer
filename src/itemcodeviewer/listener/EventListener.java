package itemcodeviewer.listener;

import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.ConsoleCommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.TranslationContainer;
import cn.nukkit.event.player.PlayerItemHeldEvent;
import cn.nukkit.utils.TextFormat;
import itemcodeviewer.Main;
import itemcodeviewer.codeviewer.CodeViewer;

public class EventListener implements Listener {
	private Main plugin;
	
	public EventListener(Main plugin) {
		this.plugin = plugin;
		
		Server.getInstance().getPluginManager().registerEvents(this, plugin);
	}
	
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) {
			sender.sendMessage(new TranslationContainer(TextFormat.RED + "%commands.generic.ingame"));
			return true;
		}
		if (!CodeViewer.viewers.contains(sender.getName())) {
			CodeViewer.viewers.add(sender.getName());
			sender.sendMessage(TextFormat.DARK_AQUA + "Now, you can see itemcode when you pick up item.");
			sender.sendMessage(TextFormat.DARK_AQUA + "If you enter this command again, you can't see itemcode.");
		} else {
			CodeViewer.viewers.remove(sender.getName());
			sender.sendMessage(TextFormat.DARK_AQUA + "Now, you can't see itemcode");
		}
		return true;
	}
	
	@EventHandler(ignoreCancelled = true)
	public void itemPickupEvent(PlayerItemHeldEvent event) {
		new CodeViewer(event.getPlayer(), event.getItem()).sendItemCode();
	}
	
	public Main getPlugin() {
		return plugin;
	}
}
