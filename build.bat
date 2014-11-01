@echo off
if not exist target\Plugins\MokaPot\plugins mkdir target\Plugins\MokaPot\plugins
if not exist target\classes\main mkdir target\classes\main
if not exist target\classes\test mkdir target\classes\test
echo Copying mokapot.lua
copy src\main\lua\mokapot.lua target\Plugins\MokaPot\mokapot.lua > nul
echo Building mokapot.dll
g++ -shared -static-libgcc -static-libstdc++ -I"C:\lua\lua-5.1\src" -I"C:\Program Files (x86)\Java\jdk1.8.0_25\include" -I"C:\Program Files (x86)\Java\jdk1.8.0_25\include\win32" -L"C:\lua" -L"C:\Program Files (x86)\Java\jdk1.8.0_25\lib" src\main\cpp\mokapot.cpp -o target\Plugins\MokaPot\mokapot.dll -llua51 -ljvm 
echo Building mokapot.jar
javac -source 1.6 -target 1.6 -nowarn -cp lib\bukkit.jar -d target\classes\main src\main\java\airminer\mokapot\*
jar -cf target\Plugins\MokaPot\mokapot.jar -C target\classes\main airminer
echo Copying bukkit.jar
copy lib\bukkit.jar target\Plugins\MokaPot > nul
echo Building mokapot_testplugin.jar
javac -source 1.6 -target 1.6 -nowarn -cp lib\bukkit.jar -d target\classes\test src\test\java\airminer\mokapot\testplugin\*
jar -cf target\Plugins\MokaPot\plugins\moakpot_testplugin.jar -C target\classes\test airminer -C src\test\java plugin.yml
