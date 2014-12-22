PLUGIN = nil

function Initialize(Plugin)
  --print(debug.getinfo(1).source)

  Plugin:SetName("MokaPot")
  Plugin:SetVersion(1)

  javavm = require("javavm")
  javavm.create("-Djava.class.path=Plugins/MokaPot/jnlua-0.9.6.jar;Plugins/MokaPot/mokapot.jar;Plugins/MokaPot/bukkit.jar", "-Djava.library.path=Plugins/MokaPot")

  MokaPot = java.require("airminer.mokapot.MokaPot")

  LuaStateRegistry = java.require("airminer.mokapot.LuaStateRegistry")

  LuaStateRegistry:setLuaState()

  MokaPot:helloWorld()

  MokaPot:loadPlugins()


  -- Hooks

  PLUGIN = Plugin -- NOTE: only needed if you want OnDisable() to use GetName() or something like that

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
  LOG(PLUGIN:GetName() .. " is shutting down...");
  javavm.destroy()
end
