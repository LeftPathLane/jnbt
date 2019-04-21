package com.github.leftpathlane.jnbt.utils;

import com.github.leftpathlane.jnbt.types.*;

public class Printer {
	public static void print(NbtCompound nbt) {
		print(nbt, 0);
	}

	private static void print(NbtType type, int indent) {
		if (type.getId() == NbtType.NBT_TAG_COMPOUND) {
			String tab = new String(new char[indent]).replace("\0", "\t");
			System.out.println(String.format("%s%s(\"%s\"): %d entries {", tab, type.getClass().getSimpleName(), type.getName(), type.asCompound().getValue().size()));
			for (NbtType innerType : type.asCompound().getValue().values()) {
				print(innerType, indent + 1);
			}
			System.out.println(tab + "}");
		} else if (type.getId() == NbtType.NBT_TAG_LIST) {
			String tab = new String(new char[indent]).replace("\0", "\t");
			System.out.println(String.format("%s%s(\"%s\"): %d entries of %d {", tab, type.getClass().getSimpleName(), type.getName(), type.asList().getValue().size(), type.asList().getType()));
			for (NbtType innerType : type.asList().getValue()) {
				print(innerType, indent + 1);
			}
			System.out.println(tab + "}");
		} else if (type.getId() == NbtType.NBT_TAG_BYTE_ARRAY) {
			System.out.println(String.format("%s%s(\"%s\"): %d entries", new String(new char[indent]).replace("\0", "\t"), type.getClass().getSimpleName(), type.getName(), type.asByteArray().getValue().length));
		} else if (type.getId() == NbtType.NBT_TAG_INT_ARRAY) {
			System.out.println(String.format("%s%s(\"%s\"): %d entries", new String(new char[indent]).replace("\0", "\t"), type.getClass().getSimpleName(), type.getName(), type.asIntArray().getValue().length));
		} else if (type.getId() == NbtType.NBT_TAG_LONG_ARRAY) {
			System.out.println(String.format("%s%s(\"%s\"): %d entries", new String(new char[indent]).replace("\0", "\t"), type.getClass().getSimpleName(), type.getName(), type.asLongArray().getValue().length));
		} else {
			System.out.println(String.format("%s%s(\"%s\"): %s", new String(new char[indent]).replace("\0", "\t"), type.getClass().getSimpleName(), type.getName(), type.getValue().toString()));
		}
	}
}
