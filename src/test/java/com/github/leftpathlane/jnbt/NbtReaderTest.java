package com.github.leftpathlane.jnbt;

import com.github.leftpathlane.jnbt.types.NbtByte;
import com.github.leftpathlane.jnbt.types.NbtCompound;
import com.github.leftpathlane.jnbt.types.NbtInt;
import com.github.leftpathlane.jnbt.types.NbtShort;
import com.github.leftpathlane.jnbt.utils.Printer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.zip.GZIPInputStream;

import static org.junit.Assert.*;

public class NbtReaderTest {

	@Test
	public void testReader() throws IOException {
		File file = new File(this.getClass().getClassLoader().getResource("bigtest.nbt").getFile());
		NbtReader reader = new NbtReader(file);
		NbtCompound nbt = reader.readAll();
		assertEquals(32767, ((NbtShort)nbt.getValue().get("shortTest")).getValue().longValue());
		assertEquals(2147483647, ((NbtInt)nbt.getValue().get("intTest")).getValue().longValue());
		assertEquals(127,((NbtByte)nbt.getValue().get("byteTest")).getValue().longValue());
	}
}