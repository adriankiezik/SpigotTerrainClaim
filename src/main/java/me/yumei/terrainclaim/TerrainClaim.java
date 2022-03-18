package me.yumei.terrainclaim;

import me.yumei.terrainclaim.Commands.ClaimCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class TerrainClaim extends JavaPlugin {

    @Override
    public void onEnable() {
        RegisterCommands();
    }

    private void RegisterCommands() {
        this.getCommand("claim").setExecutor(new ClaimCommand());
    }
}
