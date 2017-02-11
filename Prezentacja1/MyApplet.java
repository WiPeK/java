import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
/**
* @author Krzysztof Adamczyk
*/
public class MyApplet extends JApplet {
	private static final long serialVersionUID = 1L;
	@Override
	public void init() {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					add(new JButton("Button"));
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}