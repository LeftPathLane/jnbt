package com.github.leftpathlane.jnbt;

import com.github.leftpathlane.jnbt.types.*;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class NbtReader {
	private final DataInputStream in;

	public NbtReader(byte[] bytes) {
		in = new DataInputStream(new ByteArrayInputStream(bytes));
	}

	public NbtReader(File file) throws IOException {
		byte[] data = Files.readAllBytes(file.toPath());
		if (data[0] == NbtTag.NBT_TAG_COMPOUND.ordinal()) {
			in = new DataInputStream(new ByteArrayInputStream(data));
		} else {
			try (GZIPInputStream gzin = new GZIPInputStream(new ByteArrayInputStream(data));
				 ByteArrayOutputStream out = new ByteArrayOutputStream()) {
				byte buf[] = new byte[1024];
				int len;
				while ((len = gzin.read(buf,0,buf.length)) > 0) {
					out.write(buf, 0, len);
				}
				in = new DataInputStream(new ByteArrayInputStream(out.toByteArray()));
			}
		}
	}

	public NbtReader(DataInputStream in) {
		this.in = in;
	}

	public NbtReader(InputStream in) {
		this.in = new DataInputStream(in);
	}

	public NbtCompound readAll() throws IOException, NbtTagException {
		return (NbtCompound) read(false, NbtTag.NBT_TAG_END);
	}

	private NbtType read(boolean list, NbtTag listId) throws IOException, NbtTagException {
		NbtTag id = list ? listId : NbtTag.values()[in.read()];
		if (id == NbtTag.NBT_TAG_END) return null;
		String name = list ? "" : readString();
		switch (id) {
			case NBT_TAG_BYTE:
				return new NbtByte(name, in.readByte());
			case NBT_TAG_SHORT:
				return new NbtShort(name, in.readShort());
			case NBT_TAG_INT:
				return new NbtInt(name, in.readInt());
			case NBT_TAG_LONG:
				return new NbtLong(name, in.readLong());
			case NBT_TAG_FLOAT:
				return new NbtFloat(name, in.readFloat());
			case NBT_TAG_DOUBLE:
				return new NbtDouble(name, in.readDouble());
			case NBT_TAG_BYTE_ARRAY: {
				byte[] bytes = new byte[in.readInt()];
				in.read(bytes);
				return new NbtByteArray(name, bytes);
			}
			case NBT_TAG_STRING:
				return new NbtString(name, readString());
			case NBT_TAG_LIST: {
				NbtTag tagId = NbtTag.valueOf(in.read());
				int length = in.readInt();
				List<NbtType> value = new ArrayList<>(length);
				for (int i = 0; i < length; i++) {
					value.add(read(true, tagId));
				}
				return new NbtList(name, tagId, value);
			}
			case NBT_TAG_COMPOUND: {
				Map<String, NbtType<?>> value = new HashMap<>();
				NbtType type;
				while ((type = read(false, NbtTag.NBT_TAG_END)) != null) {
					value.put(type.getName(), type);
				}
				return new NbtCompound(name, value);
			}
			case NBT_TAG_INT_ARRAY: {
				int length = in.readInt();
				int[] ints = new int[length];
				for (int i = 0; i < length; i++) {
					ints[i] = in.readInt();
				}
				return new NbtIntArray(name, ints);
			}
			case NBT_TAG_LONG_ARRAY: {
				int length = in.readInt();
				long[] longs = new long[length];
				for (int i = 0; i < length; i++) {
					longs[i] = in.readLong();
				}
				return new NbtLongArray(name, longs);
			}
			default:
			    throw new NbtTagException(id, name);
		}
	}

	private String readString() throws IOException {
		short len = in.readShort();
		byte[] stringBytes = new byte[len];
		in.read(stringBytes);
		return new String(stringBytes);
	}

	public static class NbtTagException extends Exception {
	    private final NbtTag nbtTagId;
        private final String nbtTagName;

        private NbtTagException(NbtTag nbtTagId, String nbtTagName) {
            this.nbtTagId = nbtTagId;
            this.nbtTagName = nbtTagName;
        }

        public NbtTag getId() {
            return nbtTagId;
        }

        public String getName() {
            return nbtTagName;
        }

        @Override
        public String getMessage() {
            return "Error reading tag " + nbtTagName + " with id " + nbtTagId;
        }
    }
}
