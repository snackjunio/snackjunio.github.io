package jointest;
import action.CustomerSearchAction;

public class JoinTest_OrderControl04 {
	public static void main(String[] args) {

		CustomerSearchAction act = new CustomerSearchAction();

		try {
			String[] data = {"","タカハシミホ"};
			String[][] list = act.execute(data);
			System.out.println(list[0][0] + " " + list[0][1]);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
