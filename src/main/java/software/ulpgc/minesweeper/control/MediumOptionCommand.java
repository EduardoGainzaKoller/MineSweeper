package software.ulpgc.minesweeper.control;

import software.ulpgc.minesweeper.model.MediumTableBuilder;
import software.ulpgc.minesweeper.model.interfaces.TableBuilder;
import software.ulpgc.minesweeper.view.MainFrame;

import java.awt.*;

public class MediumOptionCommand implements Command{

    private final MainFrame mainFrame;
    private final TableBuilder tableBuilder;

    public MediumOptionCommand(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.tableBuilder = new MediumTableBuilder();

    }

    @Override
    public void execute() {
        mainFrame.setSize(new Dimension(650,650));
        mainFrame.revalidate();
    }
}
