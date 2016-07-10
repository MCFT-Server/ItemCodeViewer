package itemcodeviewer.codeviewer;

import java.util.ArrayList;
import java.util.List;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import cn.nukkit.utils.TextFormat;

public class CodeViewer {
	public static List<String> viewers = new ArrayList<>();
	
	private Player player;
	private Item item;
	
	public CodeViewer(CommandSender player, Item item) {
		this.player = (Player) player;
		this.item = item;
	}
	
	public void sendItemCode() {
		if (CodeViewer.viewers.contains(player.getName())) {
			player.sendMessage(TextFormat.DARK_AQUA + "name: " + item.getName());
			player.sendMessage(TextFormat.DARK_AQUA + "id: " + item.getId());
			player.sendMessage(TextFormat.DARK_AQUA + "damage: " + item.getDamage());
		}
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Item getItem() {
		return item;
	}
}
