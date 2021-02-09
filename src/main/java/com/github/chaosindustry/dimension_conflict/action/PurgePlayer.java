package com.github.chaosindustry.dimension_conflict.action;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import java.util.function.Supplier;

public class PurgePlayer implements Listener {
    public Player player;

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        player = event.getPlayer();
        int r = 1;
        boolean count = false;

        Location startLoc = player.getLocation().subtract(r, r, r);

        for(int i=startLoc.getBlockX(); i<startLoc.getBlockX()+r*2; i++){
            for(int j=startLoc.getBlockY(); j<startLoc.getBlockY()+r*2; j++){
                for(int k=startLoc.getBlockZ(); k<startLoc.getBlockZ()+r*2; k++){
                    Location loc = new Location(startLoc.getWorld(), i, j, k);
                    Block b = loc.getBlock();

                    if(b.getType() != Material.AIR&&b.getType() != Material.CAVE_AIR&&b.getType() != Material.WATER){
                        //b.setType(Material.PURPLE_WOOL);
                        player.setVelocity(player.getLocation().getDirection().rotateAroundY(180));
                    }
                }
            }
        }
    }
}
