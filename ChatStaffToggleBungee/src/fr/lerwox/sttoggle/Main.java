package fr.lerwox.sttoggle;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

public class Main extends Plugin{
	
	@Override
	public void onEnable() {
		PluginManager pm = getProxy().getPluginManager();
		pm.registerCommand(this, new CommandChatStaff("stt"));
	}	
}


class CommandChatStaff extends Command {

	public CommandChatStaff(String name) {
		super(name, "staffchat.toggle");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		if(sender instanceof ProxiedPlayer) {
			ProxiedPlayer p = (ProxiedPlayer) sender;
				
			if (!p.hasPermission("gssentials.admin.chat")) {//toggle on, si le joueur est dans la list des toggle
				p.setPermission("gssentials.admin.chat", true);
				
				p.sendMessage(new TextComponent("§8[§a!§8] §7Vous activez le §aChat Staff §7!"));
			}
			else {//toggle off
				p.setPermission("gssentials.admin.chat", false);
				
				p.sendMessage(new TextComponent("§8[§a!§8] §7Vous désactivez le §cChat Staff §7!"));
			}
		}
	}
}
