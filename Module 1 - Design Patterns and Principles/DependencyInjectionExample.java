public class DependencyInjectionExample {

    // Step 2: Repository Interface
    interface CustomerRepository {
        String findCustomerById(int id);
    }

    // Step 3: Concrete Repository
    static class CustomerRepositoryImpl
            implements CustomerRepository {

        public String findCustomerById(int id) {
            return "Customer ID: " + id +
                   ", Name: Aadira";
        }
    }

    // Step 4: Service Class
    static class CustomerService {

        private CustomerRepository repository;

        // Step 5: Constructor Injection
        public CustomerService(CustomerRepository repository) {
            this.repository = repository;
        }

        public void getCustomer(int id) {
            System.out.println(
                    repository.findCustomerById(id));
        }
    }

    // Step 6: Test Dependency Injection
    public static void main(String[] args) {

        CustomerRepository repository =
                new CustomerRepositoryImpl();

        CustomerService service =
                new CustomerService(repository);

        service.getCustomer(101);
    }
}