import ViewModel.ChatViewModel;
import ViewModel.UserListViewModel;
import ViewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import model.Model;
import model.ModelManager;
import view.ViewHandler;

public class MyApplication extends Application
{

  @Override public void start(Stage stage) throws Exception
  {
    Model model = new ModelManager("Bob");
    ChatViewModel chatViewModel = new ChatViewModel(model);
    UserListViewModel userListViewModel = new UserListViewModel(model);
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);

    ViewHandler viewHandler = new ViewHandler(viewModelFactory);
    viewHandler.start(stage);
    stage.setOnCloseRequest((WindowEvent event1) -> {
      model.removeUser();
    });
  }
  public void stop(){
    Platform.exit();
    System.exit(0);
  }
}
