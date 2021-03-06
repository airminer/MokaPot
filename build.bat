@echo off
if not exist target\Plugins\MokaPot\plugins mkdir target\Plugins\MokaPot\plugins
if not exist target\classes\main mkdir target\classes\main
if not exist target\classes\test mkdir target\classes\test
echo Copying mokapot.lua
copy src\main\lua\mokapot.lua target\Plugins\MokaPot\mokapot.lua > nul
echo Building mokapot.dll
gcc -shared -static-libgcc -I"C:\lua\lua-5.1\src" -L"C:\lua" src\main\c\mokapot.c -o target\Plugins\MokaPot\mokapot.dll -llua51
echo Building mokapot.jar
javac -source 1.6 -target 1.6 -nowarn -cp lib\bukkit.jar;lib\jnlua-0.9.6.jar -d target\classes\main src\main\java\airminer\mokapot\*
jar -cf target\Plugins\MokaPot\mokapot.jar -C target\classes\main airminer
echo Copying libraries
copy lib\* target\Plugins\MokaPot > nul
echo Copying natives
copy natives\* target\Plugins\MokaPot > nul
echo Building mokapot_testplugin.jar
javac -source 1.6 -target 1.6 -nowarn -cp lib\bukkit.jar -d target\classes\test src\test\java\airminer\mokapot\testplugin\*
jar -cf target\Plugins\MokaPot\plugins\moakpot_testplugin.jar -C target\classes\test airminer -C src\test\java plugin.yml
