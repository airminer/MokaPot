#include <jni.h>

extern "C" {
	#include <lua.h>
	#include <lauxlib.h>
	#include <lualib.h>
}
	
#include<stdio.h>

JNIEnv *env;
JavaVM *jvm;

//using namespace std;

JNIEnv* create_vm(JavaVM ** jvm) {//, char* optionString) {
	
    JNIEnv *env;
    JavaVMInitArgs vm_args;
    JavaVMOption options;
    options.optionString = (char*) "-Djava.class.path=Plugins/mokapot/mokapot.jar;Plugins/mokapot/bukkit.jar"; //Path to the java source code
    vm_args.version = JNI_VERSION_1_6;
    vm_args.nOptions = 1;
    vm_args.options = &options;
    vm_args.ignoreUnrecognized = 0;
    
    int ret = JNI_CreateJavaVM(jvm, (void**)&env, &vm_args);
    if(ret < 0)
    	printf("\nUnable to Launch JVM\n");   	
	return env;
}

void LOG(lua_State *L, const char* s) {
	lua_getfield(L, LUA_GLOBALSINDEX, "LOG");
	lua_pushstring(L, s);
	lua_call(L, 1, 0);
}
	
int Initialize(lua_State *L) {
	env = create_vm(&jvm);
	if (env == NULL) {
		lua_pushstring(L, "Unable to Launch JVM");
		lua_error(L);
	}
	jclass cls = env->FindClass("Lairminer/mokapot/MokaPot;");
	if(cls == NULL) {
		printf("NULL CLASS !\n");
	} else {
		printf("CLASS!\n");
		jmethodID mid = env->GetStaticMethodID(cls, "helloWorld", "()V");
		if(mid == NULL) {
			printf("NULL METHOD!\n");
		} else {
			printf("METHOD!\n");
			env->CallStaticVoidMethod(cls, mid);
		}
		mid = env->GetStaticMethodID(cls, "loadPlugins", "()V");
		if(mid == NULL) {
			printf("NULL METHOD!\n");
		} else {
			printf("METHOD!\n");
			env->CallStaticVoidMethod(cls, mid);
		}
	}
	/*
	jclass cls = env->FindClass("Ljava/lang/System;");
	jfieldID fid = env->GetStaticFieldID(cls, "out", "Ljava/io/PrintStream;");
	jobject obj = env->GetStaticObjectField(cls, fid);
	jclass clsA = env->GetObjectClass(obj);
	jmethodID mid = env->GetMethodID(clsA, "println", "(Ljava/lang/String;)V");
	jstring jstr = env->NewStringUTF("Hello Java!");
	env->CallVoidMethod(obj, mid, jstr);
	*/
	LOG(L, "Initialised mokapot C library");
	return 0;
}

int OnDisable(lua_State *L) {
	LOG(L,"mokapot Java library is shutting down...");
	jvm->DestroyJavaVM();
	return 0;
}

int hello(lua_State *L) {
	LOG(L, "Hello World!");
	return 0;
}

extern "C" {
	int luaopen_mokapot(lua_State *L) {
		lua_newtable(L);
		
		lua_pushcfunction(L, Initialize);
		lua_setfield(L, -2, "Initialize");
		
		lua_pushcfunction(L, OnDisable);
		lua_setfield(L, -2, "OnDisable");
		
		lua_pushcfunction(L, hello);
		lua_setfield(L, -2, "hello");
		
		lua_setglobal(L, "mokapot");

		return 0;
	}
}
