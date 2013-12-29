package plugin;

import com.nomagic.actions.ActionsManager;
import com.nomagic.magicdraw.actions.MDAction;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by XJ on 13-12-30.
 */
public class AutomaticGenerationAction extends MDAction {

    public AutomaticGenerationAction(String id, String name, KeyStroke keyStroke, String group) {
        super(id, name, keyStroke, group);
    }

    public AutomaticGenerationAction(String id, String name) {
        this(id, name, AutomaticGenerationConstants.HOT_KEY, AutomaticGenerationConstants.ACTION_GROUP);
    }

    @Override
    /**
     * 动作触发
     */
    public void actionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "被触发了");
    }
}
