package software.ulpgc.Control;

import software.ulpgc.MainFrame;
import software.ulpgc.Model.MediumTableInitializer;
import software.ulpgc.Model.Table;

public class MediumCommand implements Command{
    private final MainFrame mainFrame;
    private final MediumTableInitializer mediumTableInitializer;

    public MediumCommand(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.mediumTableInitializer = new MediumTableInitializer();
    }

    @Override
    public void execute() {
        Table mediumTable = mediumTableInitializer.initialize();
        mainFrame.put("START", new StartCommand(mediumTable, mainFrame));
    }
}
