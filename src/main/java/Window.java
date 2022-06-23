import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener{

    Logic logic;

    public Window() throws HeadlessException {

        this.setSize(1200,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLayout(new BorderLayout());

        JPanel menu = new JPanel(new FlowLayout());

        logic = new Logic();

        this.add(logic.getRender(), BorderLayout.CENTER);

        JButton colorButton = new JButton("COLOR");
        JButton button = new JButton("CLEAR");
        JRadioButton line = new JRadioButton("ciara");
        JRadioButton circle = new JRadioButton("kruh");
        JRadioButton rectangle = new JRadioButton("stvorec");
        ButtonGroup group = new ButtonGroup();
        group.add(line);
        group.add(rectangle);
        group.add(circle);


        line.addActionListener(e -> logic.setMode(1));

        circle.addActionListener(e -> logic.setMode(3));

        rectangle.addActionListener(e -> logic.setMode(2));
        
        button.addActionListener(e -> {
            dispose();
            new Window();
        });

        colorButton.addActionListener(this);
        menu.add(line);
        menu.add(circle);
        menu.add(rectangle);
        menu.add(button);
        menu.add(colorButton);
        this.add(menu, BorderLayout.PAGE_END);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        logic.getRender().setColor(JColorChooser.showDialog(this,"Select a color", Color.BLACK));
    }
}
