package plugin;

import com.nomagic.magicdraw.actions.ActionsGroups;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Created by XJ on 13-12-30.
 */
public class AutomaticGenerationConstants {
    public final static String ACTION_ID = "Plugin.AGFB";
    public final static String ACTION_NAME = "Automatically Generate Function Block";
    public final static KeyStroke HOT_KEY = KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK);    //Not activated
    public final static String ACTION_GROUP = ActionsGroups.APPLICATION_RELATED;
    public final static String ACTION_ICON_FILE_NAME = "icons/action icon.gif";

    public final static String MESSAGE_ICON_FILE_NAME = "icons/message icon.gif";
}
