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
        AccountService acc = componentFactory.getAccountService();

        /*AccountBuilder acb1 = new AccountBuilder();
        acb1.setAmountOfMoney(123.34);
        acb1.setDateOfCreation(new Date(2020, 3, 5));
        acb1.setType("Cont economii");
        acb1.setCustomerCnp(new Long(1123456789));
        Account a1 = acb1.build();

        AccountBuilder acb2 = new AccountBuilder();
        acb2.setAmountOfMoney(200.05);
        acb2.setDateOfCreation(new Date(2020, 5, 12));
        acb2.setType("Cont curent");
        acb2.setCustomerCnp(new Long(1234567891));
        Account a2 = acb2.build();

        // acc.save(a1);
        // System.out.println(acc.findById(new Long(1)).getAmountOfMoney());
        // System.out.println(acc.update(a2, new Long(2)));
        // System.out.println(acc.remove(new Long(1)));

        CustomerService customer = componentFactory.getCustomerService();

        CustomerBuilder csb1 = new CustomerBuilder();
        csb1.setCnp(new Long(1123456789));
        csb1.setName("Banel Nicolita");
        csb1.setIcn(new Long(1132));
        csb1.setEmail("banel.nico@iahu.rom");
        csb1.setPhoneNumber(new Long(0722222222));
        csb1.setAdress("Strada Aurului, nr. 49");
        Customer c1 = csb1.build();

        CustomerBuilder csb2 = new CustomerBuilder();
        csb2.setCnp(new Long(1123456789));
        csb2.setName("Banel Nicolita");
        csb2.setIcn(new Long(1132));
        csb2.setEmail("banel.nico@iahu.rom");
        csb2.setPhoneNumber(new Long(07672041312));
        csb2.setAdress("Strada Plopilor, nr. 4");
        Customer c2 = csb2.build();

        //System.out.println(customer.save(c1));
        System.out.println(customer.update(c2, new Long(1123456789)));*/


    }

}
