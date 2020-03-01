package com.github.leftpathlane.jnbt.types;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class NbtCompound extends NbtType<Map<String, NbtType>> {
	private final Map<String, NbtType> value;

	public NbtCompound() {
		this(null, new HashMap<>());
	}

	public NbtCompound(String name) {
		this(name, new HashMap<>());
	}

	public NbtCompound(String name, Map<String, NbtType> value) {
		super(name, NBT_TAG_COMPOUND);
		this.value = value;
	}

	public void addNbt(NbtType nbt) {
		value.put(nbt.getName(), nbt);
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

	public NbtType getNbt(String name) {
		return value.get(name);
	}

	@Override
	public Map<String, NbtType> getValue() {
		return value;
	}

	@Override
	public String toJson() {
		StringJoiner joiner = new StringJoiner(",");
		for (NbtType val : value.values()) {
			joiner.add(val.toJson());
		}
		return name == null || name.isEmpty() ? joiner.toString() : "\"" + name + "\":{" + joiner.toString() + "}";
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) return false;
		if (object instanceof NbtCompound) {
			if (value.size() != ((NbtCompound) object).value.size()) return false;
			NbtType<?> t;
			for (Map.Entry<String, NbtType> entry : ((NbtCompound) object).value.entrySet()) {
				t = value.get(entry.getKey());
				if (t == null) return false;
				if (!t.equals(entry.getValue())) return false;
			}
			return true;
		}
		return false;
	}
}
