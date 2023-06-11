import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PlaceholderTextPane extends JTextPane {
    private String placeholder;

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        setForeground(Color.GRAY);
        setText(placeholder);

        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(placeholder)) {
                    setText("");
                    setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setText(placeholder);
                    setForeground(Color.GRAY);
                }
            }
        });
    }
}