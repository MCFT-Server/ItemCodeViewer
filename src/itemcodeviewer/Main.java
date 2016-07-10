package itemcodeviewer;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import itemcodeviewer.listener.EventListener;

public class Main extends PluginBase {
	private EventListener listener;
	@Override
	public void onEnable() {
		listener = new EventListener(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return listener.onCommand(sender, command, label, args);
	}
}
