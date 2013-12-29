package plugin;

import analysis.Analyzer;
import com.nomagic.actions.ActionsManager;
import com.nomagic.magicdraw.actions.MDAction;
import data.DataManager;
import generation.Constructor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by XJ on 13-12-30.
 */
public class AutomaticGenerationAction extends MDAction {
    private Icon icon;

    private Analyzer analyzer;
    private DataManager dataManager;
    private Constructor constructor;

    public AutomaticGenerationAction(String id, String name, KeyStroke keyStroke, String group) {
        super(id, name, keyStroke, group);
        if (icon == null) {
            icon = new ImageIcon(getClass().getResource(AutomaticGenerationConstants.MESSAGE_ICON_FILE_NAME));
        }
    }

    public AutomaticGenerationAction(String id, String name) {
        this(id, name, AutomaticGenerationConstants.HOT_KEY, AutomaticGenerationConstants.ACTION_GROUP);
    }

    /**
     * 动作触发
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        String systemModelName = getSystemModelNameFromDialog();
        if (systemModelName == null || systemModelName.equals("")) {
            return;
        }

        String detailModelName = systemModelName + "的初始详细设计模型";
        dataManager = new DataManager(this, systemModelName, detailModelName);
        if (analyze()) {
            if (generate()) {
                JOptionPane.showMessageDialog(null, "生成了" + detailModelName);
            }
            else {
                JOptionPane.showMessageDialog(null, "生成失败");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "生成失败");
        }
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public void setDataManager(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }

    private String getSystemModelNameFromDialog() {
        String name = null;
        try {
            name = (String) JOptionPane.showInputDialog(null, "请输入系统设计模型图的名字：\n", "系统设计模型", JOptionPane.PLAIN_MESSAGE, icon, null, "");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "请输入合法的字符串名字");
        }
        return name;
    }

    private boolean analyze() {
        analyzer = new Analyzer(this);
        return analyzer.analyze(dataManager.getSystemDiagramName());
    }

    private boolean generate() {
        constructor = new Constructor(this);
        return constructor.generate(dataManager);
    }
}
