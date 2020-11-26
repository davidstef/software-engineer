import controller.LoginController;
import factory.ComponentFactory;
import repository.EntityNotFoundException;
import service.account.AccountService;
import view.LoginView;

/**
 * Created by Alex on 18/03/2017.
 */
public class Launcher {

    public static void main(String[] args) throws EntityNotFoundException {
        ComponentFactory componentFactory = ComponentFactory.instance(false);
        new LoginController(new LoginView(), componentFactory.getAuthenticationService());
    }

}
