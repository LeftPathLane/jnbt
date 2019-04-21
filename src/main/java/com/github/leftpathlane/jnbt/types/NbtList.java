package com.github.leftpathlane.jnbt.types;

import java.util.List;

public class NbtList extends NbtType<List<NbtType>> {
	private final List<NbtType> value;
	private final int type;

	public NbtList(String name, int type, List<NbtType> value) {
		super(name, NBT_TAG_LIST);
		this.type = type;
		this.value = value;
	}

	@Override
	public List<NbtType> getValue() {
		return value;
	}

	public int getType() {
		return type;
	}
}
