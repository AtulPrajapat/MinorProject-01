package in.atul.properties;

import java.util.HashMap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "app1")
@Configuration
public class AppProperties {

	private HashMap<String, String> messages = new HashMap<>();

	public HashMap<String, String> getMessages() {
		return messages;
	}

	public void setMessages(HashMap<String, String> messages) {
		this.messages = messages;
	}

}
