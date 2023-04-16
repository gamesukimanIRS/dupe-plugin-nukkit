package me.henry.plugin;

import cn.nukkit.utils.TextFormat;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.Listener;
import cn.nukkit.inventory.PlayerInventory;
import cn.nukkit.item.Item;
import cn.nukkit.plugin.PluginBase;;

public final class Plugin extends PluginBase implements Listener {
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getConsoleSender().sendMessage(TextFormat.GREEN + "[dupe-Plugin]" + "plugin enabled");
    }

    @Override
    public boolean onCommand(CommandSender sender,Command cmd,String label,  String[] args) {
        if (cmd.getName().equalsIgnoreCase("dupe")){
            if (sender instanceof Player){
                Player player = (Player) sender;
                PlayerInventory inventory = player.getInventory();
                if(inventory.contains(Item.get(370))) {
                	inventory.addItem(inventory.getItemInHand());
                	player.sendMessage(TextFormat.GREEN+"アイテムを複製しました");
                }else {
                	player.sendMessage(TextFormat.DARK_RED+"ガストの涙が必要です！");
                }
            }
        }
        return true;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(TextFormat.DARK_RED + "[dupe-Plugin]" + "bye -gamesukimanIRS#5616 and kingofhenz#3817");
    }
}
