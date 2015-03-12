PLUGIN = nil

function Initialize(Plugin)
  --print(debug.getinfo(1).source)

  Plugin:SetName("MokaPot")
  Plugin:SetVersion(1)
 
  package.preload["mokapot"] = package.loaders[3]("mokapot")
  require("mokapot")
  mokapot.initenv()

  mokapot.luaplugin = Plugin

  require("javavm")
  javavm.create("-Djava.class.path=Plugins/MokaPot/jnlua-0.9.6.jar;Plugins/MokaPot/mokapot.jar;Plugins/MokaPot/bukkit.jar", "-Djava.library.path=Plugins/MokaPot")

  mokapot.mainclass = java.require("airminer.mokapot.MokaPot")

  java.require("airminer.mokapot.LuaStateRegistry"):setLuaState()

  mokapot.mainclass:helloWorld()

  mokapot.mainclass:loadPlugins()


  -- Hooks

 
  -- Command Bindings

  --[[


  LOG("LOG")


  LOGINFO("LOGINFO")


  LOGWARNING("LOGWARNING")


  LOGERROR("LOGERROR")


  --]]

  LOG("Initialised " .. Plugin:GetName() .. " v." .. Plugin:GetVersion())
  return true
end

function OnDisable()
  LOG(mokapot.luaplugin:GetName() .. " is shutting down...");
  javavm.destroy()
end
