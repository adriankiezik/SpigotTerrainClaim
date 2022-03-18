package me.yumei.terrainclaim.Commands;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class ClaimCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {

            Player player = (Player) sender;

            Gui gui = Gui.gui()
                    .title(Component.text("Terrain management"))
                    .rows(3)
                    .create();

            GuiItem chunkClaimingItem = ItemBuilder.from(Material.GRASS_BLOCK)
                    .name(Component.text(ChatColor.GREEN + "Chunk claiming"))
                    .lore(Arrays.asList(
                            Component.text(""),
                            Component.text(ChatColor.YELLOW + "Click to open.")
                    ))
                    .asGuiItem(event -> {
                        event.setCancelled(true);
                        gui.close(player);
                    });

            gui.setItem(13, chunkClaimingItem);
            gui.open(player);

            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

            return true;
        }
        sender.sendMessage(ChatColor.RED + "You can't use this command from console.");
        return true;
    }
}
