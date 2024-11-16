package software.ulpgc.Control;

import software.ulpgc.MainFrame;
import software.ulpgc.Model.EasyTableInitializer;
import software.ulpgc.Model.Table;

public class EasyCommand implements Command{
    private final MainFrame mainFrame;
    private final EasyTableInitializer easyTableInitializer;

    public EasyCommand(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        easyTableInitializer = new EasyTableInitializer();
    }

    @Override
    public void execute() {
        Table easyTable = easyTableInitializer.initialize();
        mainFrame.put("START", new StartCommand(easyTable, mainFrame));
    }
}
