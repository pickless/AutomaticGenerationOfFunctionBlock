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
    private String systemModelName;
    private String detailModelName;
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
        systemModelName = getSystemModelNameFromDialog();
        if (hasDiagram(systemModelName)) {
            detailModelName = systemModelName + "的初始详细设计模型";
            analyzer = new Analyzer(this);
            dataManager = new DataManager(this);
            constructor = new Constructor(this);
        }
        else {
            JOptionPane.showMessageDialog(null, "当前项目中不存在该系统设计模型！");
        }
        JOptionPane.showMessageDialog(null, "生成了" + detailModelName);
    }

    public String getSystemModelName() {
        return systemModelName;
    }

    public void setSystemModelName(String systemModelName) {
        this.systemModelName = systemModelName;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getDetailModelName() {
        return detailModelName;
    }

    public void setDetailModelName(String detailModelName) {
        this.detailModelName = detailModelName;
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

    public Analyzer getAnalyzer() {
        return analyzer;
    }

    public void setAnalyzer(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    private String getSystemModelNameFromDialog() {
        String name = null;
        while (name == null || name.equals("")) {
            try {
                name = (String) JOptionPane.showInputDialog(null, "请输入系统设计模型图的名字：\n", "系统设计模型", JOptionPane.PLAIN_MESSAGE, icon, null, "");
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "请输入合法的字符串名字");
            }
        }
        return name;
    }

    private boolean hasDiagram(String diagramName) {
        return true;
    }
}
