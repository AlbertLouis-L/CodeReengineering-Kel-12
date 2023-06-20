import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;

import org.junit.jupiter.api.Test;

class ButtonTest {

	@Test
	void test() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(300, 200);
		
		JButton blueButton = new JButton("submit");
		blueButton.setBackground(Color.BLUE);
		
		JButton redButton = new JButton("submit");
		redButton.setBackground(Color.RED);
		
		frame.add(blueButton);
		frame.add(redButton);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
	}

}
