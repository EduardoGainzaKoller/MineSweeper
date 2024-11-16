package software.ulpgc.Control;

import software.ulpgc.MainFrame;
import software.ulpgc.Model.HardTableInitializer;
import software.ulpgc.Model.MediumTableInitializer;
import software.ulpgc.Model.Table;

public class HardCommand implements Command{
    private final MainFrame mainFrame;
    private final HardTableInitializer hardTableInitializer;

    public HardCommand(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.hardTableInitializer = new HardTableInitializer();
    }

    @Override
    public void execute() {
        Table hardTable = hardTableInitializer.initialize();
        mainFrame.put("START", new StartCommand(hardTable, mainFrame));
    }
}
