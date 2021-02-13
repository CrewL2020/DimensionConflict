package com.github.chaosindustry.dimension_conflict;
//java_plugin is library or module ni
import org.bukkit.plugin.java.JavaPlugin;
//main_class
public final class Dimension_conflict extends JavaPlugin {
    // conducted in plugin off we don't use absolutely

    // Plugin startup logic　pluginが発生するイベントをしていする。
    @Override
    public void onEnable() {
        //getCommand()は指定のコマンドが入力されたらプラグインを実行する。
        //setExecutor()でどのプラグインが実行されるか指定する。
        getCommand("IwannabeaDiamondman").setExecutor(new beDiamond(this));
    }

    //プラグインを終了させるイベントを指定する。
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
