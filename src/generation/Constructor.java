package generation;

import com.nomagic.actions.ActionsManager;
import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.actions.DiagramsActionsManager;
import com.nomagic.magicdraw.core.Application;
import data.DataManager;
import plugin.AutomaticGenerationAction;
import plugin.FunctionBlockConstants;

import javax.swing.*;

import static plugin.FunctionBlockConstants.ActionsConstants.*;
import static plugin.FunctionBlockConstants.DiagramsConstants.*;

/**
 * Created by XJ on 13-12-30.
 */
public class Constructor {
    private AutomaticGenerationAction action;
    private DataManager dataManager;
    private ActionsManager fbdActionsManager;
    private ActionsManager eccActionsManager;

    public Constructor(AutomaticGenerationAction action) {
        this.action = action;

    }

    public boolean generate(DataManager dataManager) {
        if (!prepare(dataManager)) {
            return false;
        }

        // TODO
        if (!generateFBs()) {
            return false;
        }
        if (!fillStates()) {
            return false;
        }
        if (!addInterface()) {
            return false;
        }
        return true;
    }

    private boolean prepare(DataManager dataManager) {
        if (dataManager == null) {
            return false;
        }
        this.dataManager = dataManager;
        fbdActionsManager = Application.getInstance().getDiagramDescriptor(FUNCTION_BLOCK_DIAGRAM_NAME).getDiagramActions();
        JOptionPane.showMessageDialog(null, fbdActionsManager == null ? "none" : fbdActionsManager.getActionFor(BASIC_FUNCTION_BLOCK_DRAW_ACTION_ID).getName());
        eccActionsManager = Application.getInstance().getDiagramDescriptor(ECC_DIAGRAM_NAME).getDiagramActions();
        JOptionPane.showMessageDialog(null, eccActionsManager == null ? "none" : eccActionsManager.getActionFor(ECC_STATE_DRAW_ACTION_ID).getName());
        return true;
    }

    private boolean generateFBs() {
        return true;
    }

    private boolean fillStates() {
        return true;
    }

    private boolean addInterface() {
        return true;
    }
}
