package com.github.chaosindustry.dimension_conflict;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
//上記の三つはコマンドを使う際に必要。
import org.bukkit.entity.Player;//プレイヤーの操作でよく使う。
import org.bukkit.inventory.ItemStack;//ItemStackの捜査でよく使う。
import org.bukkit.inventory.PlayerInventory;//プレイヤーのインベントリ操作でよく使う。
import org.bukkit.Material;//アイテム操作でよく使う。


public class beDiamond implements CommandExecutor{

    private final Dimension_conflict plugin;

    public beDiamond(Dimension_conflict plugin) {
        this.plugin = plugin;
    }

    //onCommandはコマンド入力を用いるプラグインでよく使うので知っておこう。
    //senderがコマンドを入力したプレイヤーを指定する。
    //cmdは実行されたコマンドの内容。
    //commandLabelはコマンドの別名（エイリアス）。
    //argsはコマンドの配列。例えば「fuck jesus」というコマンドがあった時、fuckはargs[0],jesusはargs[1]となる。
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        //以下のコマンドが入力されたら下記のメソッドを入力する。
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
            //どうやらInventory.(set + ItemStack系のメソッド)でプレイヤーの持ち物を変更できる。
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