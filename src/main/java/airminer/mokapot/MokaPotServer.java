package airminer.mokapot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.BanList;
import org.bukkit.BanList.Type;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.UnsafeValues;
import org.bukkit.Warning.WarningState;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;

import com.avaje.ebean.config.ServerConfig;
import com.naef.jnlua.LuaState;

@SuppressWarnings("deprecation")
public class MokaPotServer implements Server {

	private final Logger logger = Logger.getLogger("Minecraft");

	@Override
	public void sendPluginMessage(Plugin source, String channel, byte[] message) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public Set<String> getListeningPluginChannels() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public String getName() {
		/*LuaState l  = LuaStateRegistry.getLuaState();  //causes problems on linux for some reason
		l.getGlobal("mokapot");
		l.getField(-1, "luaplugin");
		l.getField(-1, "GetName");
		l.pushValue(-2);
		l.call(1, 1);
		return l.toString(-1);*/
		return "MokaPot";
	}

	@Override
	public String getVersion() {
		/*LuaState l  = LuaStateRegistry.getLuaState();
		l.getGlobal("mokapot");
		l.getField(-1, "luaplugin");
		l.getField(-1, "GetVersion");
		l.pushValue(-2);
		l.call(1, 1);
		return l.toString(-1);*/
		return "1";
	}

	@Override
	public String getBukkitVersion() {
		return "1.7.9-R0.2";
	}

	@Override
	public Player[] getOnlinePlayers() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public int getMaxPlayers() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public int getPort() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public int getViewDistance() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public String getIp() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public String getServerName() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public String getServerId() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public String getWorldType() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public boolean getGenerateStructures() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public boolean getAllowEnd() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public boolean getAllowNether() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public boolean hasWhitelist() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public void setWhitelist(boolean value) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public Set<OfflinePlayer> getWhitelistedPlayers() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public void reloadWhitelist() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public int broadcastMessage(String message) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public String getUpdateFolder() {
		// TODO Auto-generated method stub
		return "update";
	}

	@Override
	public File getUpdateFolderFile() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public long getConnectionThrottle() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public int getTicksPerAnimalSpawns() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public int getTicksPerMonsterSpawns() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public Player getPlayer(String name) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public Player getPlayerExact(String name) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public List<Player> matchPlayer(String name) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public Player getPlayer(UUID id) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public PluginManager getPluginManager() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public BukkitScheduler getScheduler() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public ServicesManager getServicesManager() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public List<World> getWorlds() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public World createWorld(WorldCreator creator) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public boolean unloadWorld(String name, boolean save) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public boolean unloadWorld(World world, boolean save) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public World getWorld(String name) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public World getWorld(UUID uid) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public MapView getMap(short id) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public MapView createMap(World world) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public void reload() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public PluginCommand getPluginCommand(String name) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public void savePlayers() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public boolean dispatchCommand(CommandSender sender, String commandLine) throws CommandException {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public void configureDbConfig(ServerConfig config) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public boolean addRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public List<Recipe> getRecipesFor(ItemStack result) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public Iterator<Recipe> recipeIterator() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public void clearRecipes() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public void resetRecipes() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public Map<String, String[]> getCommandAliases() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public int getSpawnRadius() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public void setSpawnRadius(int value) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public boolean getOnlineMode() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public boolean getAllowFlight() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public boolean isHardcore() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public boolean useExactLoginLocation() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public int broadcast(String message, String permission) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public OfflinePlayer getOfflinePlayer(String name) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public OfflinePlayer getOfflinePlayer(UUID id) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public Set<String> getIPBans() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public void banIP(String address) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public void unbanIP(String address) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public Set<OfflinePlayer> getBannedPlayers() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public BanList getBanList(Type type) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public Set<OfflinePlayer> getOperators() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public GameMode getDefaultGameMode() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public void setDefaultGameMode(GameMode mode) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public ConsoleCommandSender getConsoleSender() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public File getWorldContainer() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public OfflinePlayer[] getOfflinePlayers() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public Messenger getMessenger() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public HelpMap getHelpMap() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public Inventory createInventory(InventoryHolder owner, InventoryType type) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public Inventory createInventory(InventoryHolder owner, InventoryType type, String title) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public Inventory createInventory(InventoryHolder owner, int size) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public Inventory createInventory(InventoryHolder owner, int size, String title) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public int getMonsterSpawnLimit() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public int getAnimalSpawnLimit() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public int getWaterAnimalSpawnLimit() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public int getAmbientSpawnLimit() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public boolean isPrimaryThread() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public String getMotd() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public String getShutdownMessage() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public WarningState getWarningState() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public ItemFactory getItemFactory() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public ScoreboardManager getScoreboardManager() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public CachedServerIcon getServerIcon() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public CachedServerIcon loadServerIcon(File file) throws IllegalArgumentException, Exception {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public CachedServerIcon loadServerIcon(BufferedImage image) throws IllegalArgumentException, Exception {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public void setIdleTimeout(int threshold) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public int getIdleTimeout() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public UnsafeValues getUnsafe() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

}
