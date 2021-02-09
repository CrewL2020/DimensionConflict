package com.github.chaosindustry.dimension_conflict.command;

import com.github.chaosindustry.dimension_conflict.Dimension_conflict;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MotionCommandExecutor implements CommandExecutor {

    private final Dimension_conflict plugin;

    public MotionCommandExecutor(Dimension_conflict plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){

        if (cmd.getName().equalsIgnoreCase("DC"))
        {
            if (!(sender instanceof Player)) {
                sender.sendMessage("プレーヤーのみが実行できます");
                return false;
            }
            for(Player p : Bukkit.getOnlinePlayers()){
                p.sendTitle("Dimension Conflict","制作 Chaos Industry",0,50,0);
            }
        }

        return false;

    }
}