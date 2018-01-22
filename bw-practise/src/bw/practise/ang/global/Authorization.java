package bw.practise.ang.global;

import java.util.Map;

import org.apache.log4j.Logger;

public class Authorization {
	private final Logger logger = Logger.getLogger(Authorization.class);
	private static final String AUTH_FILE = "/authorization.xml";
	private static final String AUTH_ROOT_NODE = "auth_data"; 
	private static final String AUTH_STR_NODE = "auth_strict";
	private static final String AUTH_OBS_NODE = "auth_obs";
	private static final String AUTH_FINAL_NODE = "param";
	public static Configuration configurationStrict;
	public static Configuration configurationObs;
	
	public static Configuration initConfigurationStr(){
		configurationStrict = new Configuration(AUTH_FILE, "//" + AUTH_ROOT_NODE + "/" + AUTH_STR_NODE + "/" + AUTH_FINAL_NODE);
		return configurationStrict;
	}
	
	public static Configuration initConfigurationObs(){
		configurationObs = new Configuration(AUTH_FILE, "//" + AUTH_ROOT_NODE + "/" + AUTH_OBS_NODE + "/" + AUTH_FINAL_NODE);
		return configurationObs;
	}
	
	public static Map<String, String> getStrMap() {
		if (configurationStrict == null){
			configurationStrict = initConfigurationStr();
		}
		return configurationStrict.getMap();
	}
	
	public static Map<String, String> getObsMap(){
		if (configurationObs == null){
			configurationObs = initConfigurationObs();
		}
		return configurationObs.getMap();
	}
}
