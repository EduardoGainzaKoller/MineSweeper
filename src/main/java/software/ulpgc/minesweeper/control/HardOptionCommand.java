package software.ulpgc.minesweeper.control;

import software.ulpgc.minesweeper.model.HardTableBuilder;
import software.ulpgc.minesweeper.model.interfaces.TableBuilder;
import software.ulpgc.minesweeper.view.MainFrame;

import java.awt.*;

public class HardOptionCommand implements Command{

    private final MainFrame mainFrame;
    private final TableBuilder tableBuilder;

    public HardOptionCommand(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.tableBuilder = new HardTableBuilder();
    }

    @Override
    public void execute() {
        mainFrame.setSize(new Dimension(700,750));
        mainFrame.revalidate();
    }
}
