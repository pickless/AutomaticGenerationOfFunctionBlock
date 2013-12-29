package plugin;

import com.nomagic.actions.AMConfigurator;
import com.nomagic.actions.ActionsCategory;
import com.nomagic.actions.ActionsManager;
import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;
import com.nomagic.magicdraw.actions.ActionsID;
import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.plugins.Plugin;

import javax.swing.*;

import java.util.List;

import static plugin.AutomaticGenerationConstants.*;

/**
 * Created by XJ on 13-12-30.
 */
public class AutomaticGenerationPlugin extends Plugin {
    @Override
    public void init() {
        MDAction action = createAction();
        registerAction(action);
    }

    @Override
    public boolean close() {
        return true;
    }

    @Override
    public boolean isSupported() {
        return true;
    }

    private MDAction createAction() {
        AutomaticGenerationAction action = new AutomaticGenerationAction(ACTION_ID, ACTION_NAME);
        action.setLargeIcon(new ImageIcon(getClass().getResource(ICON_FILE_NAME)));
        action.setDescription(ACTION_NAME);
        return action;
    }

    private void registerAction(final MDAction action) {
        AMConfigurator configurator = new AMConfigurator() {
            @Override
            public void configure(ActionsManager actionsManager) {
                NMAction found = actionsManager.getActionFor(ActionsID.NEW_PROJECT);
                if (found != null) {
                    ActionsCategory category = (ActionsCategory) actionsManager.getActionParent(found);
                    List actionList = category.getActions();
                    actionList.add(action);
                    category.setActions(actionList);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Automatic Generation of Function Block插件启动失败");
                }
            }

            @Override
            public int getPriority() {
                return AMConfigurator.MEDIUM_PRIORITY;
            }
        };
        ActionsConfiguratorsManager.getInstance().addMainToolbarConfigurator(configurator);
    }
}
