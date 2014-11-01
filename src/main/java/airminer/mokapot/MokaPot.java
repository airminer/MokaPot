package airminer.mokapot;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.command.SimpleCommandMap;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPluginLoader;

class MokaPot {
	private static MokaPotServer server = new MokaPotServer();
	private static SimpleCommandMap commandMap = new SimpleCommandMap(server);
	public static SimplePluginManager pluginManager = new SimplePluginManager(server, commandMap);

	public static PrintStream out;
	public static PrintStream err;
	
	
	static {
		out = System.out;
		err = System.err;
		
		java.util.logging.Logger global = java.util.logging.Logger.getLogger("");
        global.setUseParentHandlers(false);
        for (java.util.logging.Handler handler : global.getHandlers()) {
            global.removeHandler(handler);
        }
        global.addHandler(new LuaHandler());
        
        System.setOut(new PrintStream(new LoggerOutputStream(global, Level.INFO), true));
        System.setErr(new PrintStream(new LoggerOutputStream(global, Level.WARNING), true));
	}
	
	public static void log(String s) {
		out.println(s);
	}
	
	public static void logInfo(String s) {
		out.println(s);
	}
	
	public static void logWarning(String s) {
		out.println(s);
	}
	
	public static void helloWorld() {
		System.out.println("Hello Java!");
	}

	public static void loadPlugins() {
		try {
			pluginManager.registerInterface(JavaPluginLoader.class);

			File pluginFolder = new File("Plugins/MokaPot/plugins");
			try {
				System.out.println(pluginFolder.getCanonicalPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (pluginFolder.exists()) {
				System.out.println("TRUE");
				Plugin[] plugins = pluginManager.loadPlugins(pluginFolder);
				System.out.println("LOADED");
				System.out.println(plugins.length);
				for (Plugin plugin : plugins) {
					try {
						String message = String.format("Loading %s", plugin.getDescription().getFullName());
						plugin.getLogger().info(message);
						plugin.onLoad();
					} catch (Throwable ex) {
						Logger.getLogger(MokaPotServer.class.getName()).log(Level.SEVERE, ex.getMessage() + " initializing " + plugin.getDescription().getFullName() + " (Is it up to date?)", ex);
					}
				}
			} else {
				pluginFolder.mkdir();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}