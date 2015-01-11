#include <lua.h>
#include <lauxlib.h>
#include <lualib.h>

#include <windows.h>

void LOG(lua_State *L, const char* s1, const char* s2) {
	char s[strlen(s1) + strlen(s2)];
	s[0] = '\0';
	strcat(s, s1);
	strcat(s, s2);
	lua_getfield(L, LUA_GLOBALSINDEX, "LOG");
	lua_pushstring(L, s);
	lua_call(L, 1, 0);
}

int initenv(lua_State *L) {
	HKEY jre;
	LONG jre_lRes = RegOpenKeyExA(HKEY_LOCAL_MACHINE, "SOFTWARE\\JavaSoft\\Java Runtime Environment", 0, KEY_READ, &jre);

	if (jre_lRes != ERROR_SUCCESS) {
		LOG(L, "The automatic JRE Location failed. Please install the ORACLE JRE, or add the path of jvm.dll to the PATH", "");
		return 0;
	}

	CHAR version[512];
	DWORD dwversionSize = sizeof(version);
	RegQueryValueExA(jre, "CurrentVersion", 0, NULL, (LPBYTE) version, &dwversionSize);

	LOG(L, "Most recent JRE version installed: ", version);

	HKEY currentjre;
	RegOpenKeyExA(jre, version, 0, KEY_READ, &currentjre);

	CHAR runtime[512];
	DWORD dwruntimeSize = sizeof(runtime);
	RegQueryValueExA(currentjre, "JavaHome", 0, NULL, (LPBYTE) runtime, &dwruntimeSize);
	strcat(runtime, "\\bin\\client");

	LOG(L, "JRE Runtime Location: ", runtime);

	CHAR path[4096];
	GetEnvironmentVariableA("PATH", path, (DWORD) sizeof(path));

	strcat(path, ";");
	strcat(path, runtime);
	SetEnvironmentVariableA("PATH", path);

	return 0;
}

int luaopen_mokapot(lua_State *L) {
	lua_newtable(L);

	lua_pushcfunction(L, initenv);
	lua_setfield(L, -2, "initenv");

	lua_setglobal(L, "mokapot");

	return 0;
}
