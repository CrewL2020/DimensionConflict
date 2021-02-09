package com.github.chaosindustry.dimension_conflict;

import com.github.chaosindustry.dimension_conflict.action.PurgePlayer;
import com.github.chaosindustry.dimension_conflict.command.MotionCommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Dimension_conflict extends JavaPlugin {

    private static Dimension_conflict plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new PurgePlayer(), this);
        getCommand("DC").setExecutor(new MotionCommandExecutor(this));
        getLogger().info("モーションプラグインが有効になりました");
    }

    @Override
    public void onDisable() {
        getLogger().info("モーションプラグインが無効になりました");
    }

    public static Dimension_conflict getPlugin(){
        return plugin;
    }
}
