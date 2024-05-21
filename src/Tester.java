import javafx.application.Application;
import javafx.stage.Stage;
import view.Login;


public class Tester extends Application{
    public static void main(String [ ] args){
        launch(args);
    }
    
    
    @Override
	public void start(Stage st) throws Exception {
		(new Login()).show(st);
		st.show();
		
	}
    
            
            

}
