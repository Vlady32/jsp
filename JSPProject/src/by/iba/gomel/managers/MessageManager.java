package by.iba.gomel.managers;

import java.util.ResourceBundle;

import by.iba.gomel.Constants;

/**
 * This service class contains method getProperty that gets information from property file
 * 'messages'.
 */
public class MessageManager {
    private final static ResourceBundle RESOURCE_BUNDLE = ResourceBundle
                                                                .getBundle(Constants.FILE_MESSAGES_PROPERTY);

    private MessageManager() {

    }

    public static String getProperty(final String key) {
        return MessageManager.RESOURCE_BUNDLE.getString(key);
    }
}
