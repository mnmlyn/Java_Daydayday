package com.mnmlyn;

import java.io.IOException;

public class MyStream implements AutoCloseable {
	@Override
	public void close() throws IOException {
		System.out.println(this.getClass().getName() + "πÿ±’¡À");
	}
}
