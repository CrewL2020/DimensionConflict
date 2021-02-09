package com.github.chaosindustry.dimension_conflict;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.Material;


public class beDiamond implements CommandExecutor{

    private final Dimension_conflict plugin;

    public beDiamond(Dimension_conflict plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (cmd.getName().equalsIgnoreCase("IwannabeaDiamondman")) {

            //サーバーからの命令を無視するために必要。バグを発生させないために必要らしい。
            if (!(sender instanceof Player)) {
                sender.sendMessage("プレーヤーのみが実行できます");
                return false;
            }
            //コマンドを入力したプレーヤーの情報を取得。
            Player player = (Player) sender;

            //playerの装備（武器、防具）の情報を取得。
            PlayerInventory inventory = player.getInventory();

            //playerの武器、防具の情報を上書き。全部ダイアモンドにする。
            ItemStack DiamondHelmet = new ItemStack(Material.DIAMOND_HELMET);
            inventory.setHelmet(DiamondHelmet);
            ItemStack DiamondChestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE);
            inventory.setChestplate(DiamondChestPlate);
            ItemStack DiamondBoots = new ItemStack(Material.DIAMOND_BOOTS);
            inventory.setBoots(DiamondBoots);
            ItemStack DiamondLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
            inventory.setLeggings(DiamondLeggings);
            ItemStack DiamondSword = new ItemStack(Material.DIAMOND_SWORD);
            inventory.setItemInMainHand(DiamondSword);


        }
        //trueを返してif文を抜ける。
        return true;
    }
}

//https://wiki.yama2211.biz/javadoc/1.15.2/org/bukkit/inventory/PlayerInventory.html#getLeggings--
//https://wiki.yama2211.biz/javadoc/1.15.2/org/bukkit/inventory/ItemStack.html#addEnchantment-org.bukkit.enchantments.Enchantment-int-
//