package bw.practise.ang.global;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;

public final class ConfigHelper {

	private static final Logger logger = Logger.getLogger(ConfigHelper.class);

	public static final URL locateConfig(String path) {
		try {
			return new URL(path);
		} catch (MalformedURLException e) {
		}
		return findAsResource(path);
	}

	public static final URL findAsResource(String path) {
		URL url = null;

		ClassLoader contextClassLoader = Thread.currentThread()
				.getContextClassLoader();
		if (contextClassLoader != null) {
			url = contextClassLoader.getResource(path);
		}
		if (url != null) {
			return url;
		}

		url = ConfigHelper.class.getClassLoader().getResource(path);
		if (url != null) {
			return url;
		}

		url = ClassLoader.getSystemClassLoader().getResource(path);

		return url;
	}

	public static final InputStream getConfigStream(String path)
			throws IOException {
		URL url = locateConfig(path);

		if (url == null) {
			String msg = "Unable to locate config file: " + path;
			logger.error(msg);
		}
		try {
			return url.openStream();
		} catch (IOException e) {
			throw e;
		}
	}

	public static final Reader getConfigStreamReader(String path)
			throws IOException {
		return new InputStreamReader(getConfigStream(path));
	}

	public static final Properties getConfigProperties(String path)
			throws IOException {
		try {
			Properties properties = new Properties();
			properties.load(getConfigStream(path));
			return properties;
		} catch (IOException e) {
			throw e;
		}
	}

	public static InputStream getResourceAsStream(String resource) {
		String stripped = (resource.startsWith("/")) ? resource.substring(1)
				: resource;
		InputStream stream = null;
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		if (classLoader != null) {
			stream = classLoader.getResourceAsStream(stripped);
		}
		if (stream == null) {
			stream = ConfigHelper.class.getResourceAsStream(resource);
		}
		if (stream == null) {
			stream = ConfigHelper.class.getClassLoader().getResourceAsStream(
					stripped);
		}
		if (stream == null) {
		}
		return stream;
	}

	public static URL getResource(String resource) {
		String stripped = (resource.startsWith("/")) ? resource.substring(1)
				: resource;
		URL filePath = null;
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		if (classLoader != null) {
			filePath = classLoader.getResource(stripped);
		}
		if (filePath == null) {
			filePath = ConfigHelper.class.getResource(resource);
		}
		if (filePath == null) {
			filePath = ConfigHelper.class.getClassLoader()
					.getResource(stripped);
		}
		if (filePath == null) {
		}
		return filePath;
	}

	public static InputStream getUserResourceAsStream(String resource) {
		boolean hasLeadingSlash = resource.startsWith("/");
		String stripped = (hasLeadingSlash) ? resource.substring(1) : resource;

		InputStream stream = null;

		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		if (classLoader != null) {
			stream = classLoader.getResourceAsStream(resource);
			if ((stream == null) && (hasLeadingSlash)) {
				stream = classLoader.getResourceAsStream(stripped);
			}
		}

		if (stream == null) {
			stream = ConfigHelper.class.getClassLoader().getResourceAsStream(
					resource);
		}
		if ((stream == null) && (hasLeadingSlash)) {
			stream = ConfigHelper.class.getClassLoader().getResourceAsStream(
					stripped);
		}
		return stream;
	}
}
