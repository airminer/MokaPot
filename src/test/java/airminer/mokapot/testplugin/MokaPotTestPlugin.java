package airminer.mokapot.testplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class MokaPotTestPlugin extends JavaPlugin {
	
	@Override
    public void onLoad() {
		getLogger().info("MokaTestPlugin loaded");
	}
	
	@Override
    public void onEnable() {
		getLogger().info("MokaTestPlugin enabled");
	}
	
	@Override
    public void onDisable() {
		getLogger().info("MokaTestPlugin disabled");
	}
}
