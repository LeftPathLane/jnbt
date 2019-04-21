package com.github.leftpathlane.jnbt.types;

import java.util.HashMap;
import java.util.List;

public class NbtList extends NbtType<List<NbtType>> {
	private final List<NbtType> value;
	private final int type;

	public NbtList(String name, int type, List<NbtType> value) {
		super(name, NBT_TAG_LIST);
		this.type = type;
		this.value = value;
	}

	public void addNbt(byte val) {
		value.add(new NbtByte(null, val));
	}

	public void addNbt(short val) {
		value.add(new NbtShort(null, val));
	}

	public void addNbt(int val) {
		value.add(new NbtInt(null, val));
	}

	public void addNbt(long val) {
		value.add(new NbtLong(null, val));
	}

	public void addNbt(float val) {
		value.add(new NbtFloat(null, val));
	}

	public void addNbt(double val) {
		value.add(new NbtDouble(null, val));
	}

	public void addNbt(byte[] val) {
		value.add(new NbtByteArray(null, val));
	}

	public void addNbt(String val) {
		value.add(new NbtString(null, val));
	}

	public void addNbt(int nbtType, List<NbtType> val) {
		value.add(new NbtList(null, nbtType, val));
	}

	public void addNbt(HashMap<String, NbtType> val) {
		value.add(new NbtCompound(null, val));
	}

	public void addNbt(int[] val) {
		value.add(new NbtIntArray(null, val));
	}

	public void addNbt(long[] val) {
		value.add(new NbtLongArray(null, val));
	}

	@Override
	public List<NbtType> getValue() {
		return value;
	}

	public int getType() {
		return type;
	}
}
