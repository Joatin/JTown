package com.hotmail.joatin37.JTown.util;

import java.util.UUID;

public class JUtil {

	public static String uuidToString(UUID uuid) {
		return uuid.getMostSignificantBits() + ";"
				+ uuid.getLeastSignificantBits();
	}

	public static UUID stringToUUID(String uuid) {
		String[] s = uuid.split(";");
		return new UUID(Long.parseLong(s[0]), Long.parseLong(s[1]));
	}

	public static String getTypeFromUuidString(String uuidwithtype) {
		return uuidwithtype.split(";")[3];
	}

	public static String getPluginFromUuidString(String uuidwithplugin) {
		return uuidwithplugin.split(";")[2];
	}

}
