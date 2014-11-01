@echo off
if not exist target call build.bat
pushd target
lua ..\src\test\lua\test.lua 
popd
