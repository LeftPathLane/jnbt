package com.github.leftpathlane.jnbt.types;

import java.util.*;

public class NbtList <T extends NbtType<?>> extends NbtType<List<T>> {
	private final List<T> value;
	private final NbtTag type;

	public NbtList(String name, NbtTag type) {
		this(name, type, new ArrayList<>());
	}

	public NbtList(String name, NbtTag type, List<T> value) {
		super(name, NbtTag.NBT_TAG_LIST);
		this.type = type;
		this.value = value;
	}

	public void addNbt(T nbt) {
		value.add(nbt);
	}

	@Override
	public List<T> getValue() {
		return value;
	}

	public NbtTag getType() {
		return type;
	}

	@Override
	public String toJson() {
		StringJoiner joiner = new StringJoiner(",");
		for (T val : value) {
			joiner.add(val.toJson());
		}
		return name == null || name.isEmpty() ? joiner.toString() : "\"" + name + "\":[" + joiner.toString() + "]";
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) return false;
		if (object instanceof NbtList) {
			return value.equals(object);
		}
		return false;
	}
}
