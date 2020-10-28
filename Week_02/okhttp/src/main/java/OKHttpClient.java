import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

public class OKHttpClient {

	public static void main(String[] args) throws IOException {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.get()
				.url("http://localhost:8801")
				.addHeader("Connection", "close")
				.build();

		Response response = client.newCall(request).execute();
		if (!response.isSuccessful()) {
			throw new IOException("Connection fail, Unexpected code " + response.code());
		}

		Reader reader = response.body().charStream();
		CharBuffer buffer = CharBuffer.allocate(10);
		reader.read(buffer);

		buffer.flip();
		char[] res = new char[buffer.limit()];
		buffer.get(res, 0, buffer.limit());
		System.out.println(res);
	}
}
