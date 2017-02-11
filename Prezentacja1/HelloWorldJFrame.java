import javax.swing.JFrame;
/**
* @author Krzysztof Adamczyk
*/
public class HelloWorldJFrame {
    /**
    * @author Krzysztof Adamczyk
    * @param args Array of String
    */
    public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            test();
        }
    });
}

private static void test() {
    JFrame f = new JFrame();
    f.setSize(640, 480);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
    }
}