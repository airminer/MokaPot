function stub(name)
  return function(...)
    local t = {...}
    print("    "..name.."(): stub!")
    return 0
  end
end

function LOG(s)
  print(os.date("[%H:%M:%S]", os.time()).." "..s)
end

local Plugin = {
  ["SetName"] = function(plugin, name)
    plugin.name = name
  end,
  ["SetVersion"] = function(plugin, version)
    plugin.version = version
  end,
  ["GetName"] = function(plugin)
    return plugin.name
  end,
  ["GetVersion"] = function(plugin)
    return plugin.version
  end
}

print("Loading mokapot.lua")
dofile("Plugins/MokaPot/mokapot.lua")
print()

print("Running Initialize(Plugin)")
local cpath = package.cpath
package.cpath = "./Plugins/MokaPot/?.so;./Plugins/MokaPot/?.dll"
Initialize(Plugin)
package.cpath = cpath
print()

print("Running OnDisable()")
OnDisable()
print()
