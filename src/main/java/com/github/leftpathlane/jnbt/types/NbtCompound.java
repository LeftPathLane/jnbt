package com.github.leftpathlane.jnbt.types;

import java.util.Map;

public class NbtCompound extends NbtType<Map<String, NbtType>> {
	private final Map<String, NbtType> value;

	public NbtCompound(String name, Map<String, NbtType> value) {
		super(name, NBT_TAG_COMPOUND);
		this.value = value;
	}

	@Override
	public Map<String, NbtType> getValue() {
		return value;
	}
}
