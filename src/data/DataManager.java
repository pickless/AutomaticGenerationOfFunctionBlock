package data;

import plugin.AutomaticGenerationAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XJ on 13-12-30.
 */
public class DataManager {
    private AutomaticGenerationAction action;
    private String systemDiagramName;
    private String detailDiagramName;

    private List<SystemState> systemStates;
    private List<SystemTransition> systemTransitions;
    private List<SystemCondition> systemConditions;

    public DataManager(AutomaticGenerationAction action, String systemDiagramName, String detailDiagramName) {
        this.action = action;
        this.systemDiagramName = systemDiagramName;
        this.detailDiagramName = detailDiagramName;

        if (systemStates == null) {
            systemStates = new ArrayList<SystemState>();
        }
        if (systemConditions == null) {
            systemConditions = new ArrayList<SystemCondition>();
        }
        if (systemTransitions == null) {
            systemTransitions = new ArrayList<SystemTransition>();
        }
    }

    public AutomaticGenerationAction getAction() {
        return action;
    }

    public void setAction(AutomaticGenerationAction action) {
        this.action = action;
    }

    public List<SystemState> getSystemStates() {
        return systemStates;
    }

    public void setSystemStates(List<SystemState> systemStates) {
        this.systemStates = systemStates;
    }

    public void addSystemState(SystemState systemState) {
        if (systemStates == null) {
            systemStates = new ArrayList<SystemState>();
        }
        systemStates.add(systemState);
    }

    public boolean setSystemState(int index, SystemState systemState) {
        if (systemStates != null && systemStates.size() > index) {
            systemStates.set(index, systemState);
            return true;
        }
        return false;
    }

    public boolean deleteSystemState(int index) {
        if (systemStates != null && systemStates.size() > index) {
            systemStates.remove(index);
            return true;
        }
        return false;
    }

    public boolean deleteSystemState(SystemState systemState) {
        if (systemStates != null) {
            return systemStates.remove(systemState);
        }
        return false;
    }

    public List<SystemTransition> getSystemTransitions() {
        return systemTransitions;
    }

    public void setSystemTransitions(List<SystemTransition> systemTransitions) {
        this.systemTransitions = systemTransitions;
    }

    public void addSystemTransition(SystemTransition systemTransition) {
        if (systemTransitions == null) {
            systemTransitions = new ArrayList<SystemTransition>();
        }
        systemTransitions.add(systemTransition);
    }

    public boolean setSystemTransition(int index, SystemTransition systemTransition) {
        if (systemTransitions != null && systemTransitions.size() > index) {
            systemTransitions.set(index, systemTransition);
            return true;
        }
        return false;
    }

    public boolean deleteSystemTransition(int index) {
        if (systemTransitions != null && systemTransitions.size() > index) {
            systemTransitions.remove(index);
            return true;
        }
        return false;
    }

    public boolean deleteSystemTransition(SystemTransition systemTransition) {
        if (systemTransitions != null) {
            return systemTransitions.remove(systemTransition);
        }
        return false;
    }

    public List<SystemCondition> getSystemConditions() {
        return systemConditions;
    }

    public void setSystemConditions(List<SystemCondition> systemConditions) {
        this.systemConditions = systemConditions;
    }

    public void addSystemCondition(SystemCondition systemCondition) {
        if (systemConditions == null) {
            systemConditions = new ArrayList<SystemCondition>();
        }
        systemConditions.add(systemCondition);
    }

    public boolean setSystemCondition(int index, SystemCondition systemCondition) {
        if (systemConditions != null && systemConditions.size() > index) {
            systemConditions.set(index, systemCondition);
            return true;
        }
        return false;
    }

    public boolean deleteSystemCondition(int index) {
        if (systemConditions != null && systemConditions.size() > index) {
            systemConditions.remove(index);
            return true;
        }
        return false;
    }

    public boolean deleteSystemCondition(SystemCondition systemCondition) {
        if (systemConditions != null) {
            return systemConditions.remove(systemCondition);
        }
        return false;
    }

    public String getSystemDiagramName() {
        return systemDiagramName;
    }

    public void setSystemDiagramName(String systemDiagramName) {
        this.systemDiagramName = systemDiagramName;
    }

    public String getDetailDiagramName() {
        return detailDiagramName;
    }

    public void setDetailDiagramName(String detailDiagramName) {
        this.detailDiagramName = detailDiagramName;
    }
}
