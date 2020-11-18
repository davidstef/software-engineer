package repository.customer;

public abstract class CustomerRepositoryDecorator implements CustomerRepository {

    protected CustomerRepository decoratedRepository;

    public CustomerRepositoryDecorator(CustomerRepository customerRepository) {
        this.decoratedRepository = customerRepository;
    }

}
