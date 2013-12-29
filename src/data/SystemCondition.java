package data;

import generation.FunctionBlock;

/**
 * Created by XJ on 13-12-30.
 */
public class SystemCondition {
    private String conditionName;
    private String conditionId;
    private String componentName;
    private FunctionBlock functionBlock;

    @Override
    public String toString() {
        return conditionId + ": " + conditionName;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public String getConditionId() {
        return conditionId;
    }

    public void setConditionId(String conditionId) {
        this.conditionId = conditionId;
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
