package com.github.leftpathlane.jnbt.types;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NbtCompound extends NbtType<Map<String, NbtType>> {
	private final Map<String, NbtType> value;

	public NbtCompound(String name, Map<String, NbtType> value) {
		super(name, NBT_TAG_COMPOUND);
		this.value = value;
	}

	public void addNbt(String name, byte val) {
		value.put(name, new NbtByte(name, val));
	}

	public void addNbt(String name, short val) {
		value.put(name, new NbtShort(name, val));
	}

	public void addNbt(String name, int val) {
		value.put(name, new NbtInt(name, val));
	}

	public void addNbt(String name, long val) {
		value.put(name, new NbtLong(name, val));
	}

	public void addNbt(String name, float val) {
		value.put(name, new NbtFloat(name, val));
	}

	public void addNbt(String name, double val) {
		value.put(name, new NbtDouble(name, val));
	}

	public void addNbt(String name, byte[] val) {
		value.put(name, new NbtByteArray(name, val));
	}

	public void addNbt(String name, String val) {
		value.put(name, new NbtString(name, val));
	}

	public void addNbt(String name, int nbtType, List<NbtType> val) {
		value.put(name, new NbtList(name, nbtType, val));
	}

	public void addNbt(String name, HashMap<String, NbtType> val) {
		value.put(name, new NbtCompound(name, val));
	}

	public void addNbt(String name, int[] val) {
		value.put(name, new NbtIntArray(name, val));
	}

	public void addNbt(String name, long[] val) {
		value.put(name, new NbtLongArray(name, val));
	}


	@Override
	public Map<String, NbtType> getValue() {
		return value;
	}
}
