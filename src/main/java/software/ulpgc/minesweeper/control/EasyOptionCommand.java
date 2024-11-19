package software.ulpgc.minesweeper.control;

import software.ulpgc.minesweeper.model.EasyTableBuilder;
import software.ulpgc.minesweeper.model.interfaces.TableBuilder;
import software.ulpgc.minesweeper.view.MainFrame;

import java.awt.*;


public class EasyOptionCommand implements Command {

    private final MainFrame mainFrame;
    private final TableBuilder tableBuilder;

    public EasyOptionCommand(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.tableBuilder = new EasyTableBuilder();
    }

    @Override
    public void execute() {
        mainFrame.setSize(new Dimension(450,450));
        mainFrame.revalidate();
    }
}
