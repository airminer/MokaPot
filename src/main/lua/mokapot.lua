PLUGIN = nil

function Initialize(Plugin)
print(debug.getinfo(1).source)

	Plugin:SetName("MokaPot")
	Plugin:SetVersion(1)
	
	--print("PATH="..os.getenv("Path"))
	
	package.preload["mokapot"] = package.loaders[3]("mokapot")
	require("mokapot")
	mokapot.Initialize()
	
	--[[for i, v in pairs( package.loaders ) do
		print(i, v)
	end]]--
	
	mokapot.hello()
	
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
	LOG(PLUGIN:GetName() .. " C library is shutting down...");
	mokapot.OnDisable()
end