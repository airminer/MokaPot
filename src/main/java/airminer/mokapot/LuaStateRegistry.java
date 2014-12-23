package airminer.mokapot;

import com.naef.jnlua.JavaFunction;
import com.naef.jnlua.JavaReflector;
import com.naef.jnlua.LuaState;

public class LuaStateRegistry {

	private static LuaState instance;

	public static final SetLuaState setLuaState = new SetLuaState();

	public static class SetLuaState implements JavaReflector, JavaFunction {

		private SetLuaState() {
		}

		@Override
		public JavaFunction getMetamethod(Metamethod metamethod) {
			switch (metamethod) {
			case CALL:
				return this;
			default:
				return null;
			}
		}

		@Override
		public int invoke(LuaState luaState) {
			setLuaState(luaState);
			return 0;
		}
	}

	public static void setLuaState(LuaState luaState) {
		instance = luaState;
	}

	public static LuaState getLuaState() {
		return instance;
	}

}
