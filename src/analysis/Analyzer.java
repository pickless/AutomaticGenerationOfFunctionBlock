package analysis;

import com.nomagic.actions.ActionsManager;
import com.nomagic.magicdraw.actions.DiagramsActionsManager;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.openapi.uml.ModelElementsManager;
import com.nomagic.magicdraw.uml.symbols.DiagramPresentationElement;
import com.nomagic.magicdraw.uml.symbols.PresentationElement;
import com.starbase.caliber.ProjectManager;
import data.DataManager;
import plugin.AutomaticGenerationAction;

import javax.swing.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static plugin.AutomaticGenerationConstants.*;

/**
 * Created by XJ on 13-12-30.
 */
public class Analyzer {
    private AutomaticGenerationAction action;
    private DiagramPresentationElement diagram;
    private DataManager dataManager;

    public Analyzer(AutomaticGenerationAction action) {
        this.action = action;
        dataManager = action.getDataManager();
    }

    public boolean analyze(String systemModelName) {
        diagram = searchDiagram(systemModelName);
        if (dataManager == null || diagram == null) {
            return false;
        }
        getInfoFromDiagram();
        return true;
    }

    private DiagramPresentationElement searchDiagram(String diagramName) {
        Collection<DiagramPresentationElement> diagrams  = Application.getInstance().getProject().getDiagrams();
        if (diagrams != null) {
            for (DiagramPresentationElement diagram : diagrams) {
                if (diagram.getHumanName().equals("Diagram " + diagramName) && diagram.getHumanType().equals(SYSTEM_STATE_VIEW_TYPE)) {
                    return diagram;
                }
            }
        }
        return null;
    }

    /**
     * 从系统状态视图中读取信息，并存储到dataManager中
     */
    private void getInfoFromDiagram() {
        List<PresentationElement> presentationElements = diagram.getPresentationElements();
        for (PresentationElement presentationElement : presentationElements) {
//            JOptionPane.showMessageDialog(null, presentationElement.getHumanType() + ":" + presentationElement.getHumanName());
        }
        //TODO 将所有信息存储到dataManager中
    }
}
