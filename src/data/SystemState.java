package data;

import generation.FunctionBlock;

/**
 * Created by XJ on 13-12-30.
 */
public class SystemState {
    private String stateName;
    private String stateId;
    private String componentName;
    private FunctionBlock functionBlock;

    @Override
    public String toString() {
        return stateId + ": " + stateName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public FunctionBlock getFunctionBlock() {
        return functionBlock;
    }

    public void setFunctionBlock(FunctionBlock functionBlock) {
        this.functionBlock = functionBlock;
    }
}
