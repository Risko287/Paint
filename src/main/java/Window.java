import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window() throws HeadlessException {

        this.setSize(1200,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLayout(new BorderLayout());

        JPanel menu = new JPanel(new FlowLayout());

        Logic logic = new Logic();

        this.add(logic.getRender(), BorderLayout.CENTER);
        this.add(menu, BorderLayout.PAGE_END);

        this.setVisible(true);
    }
}
