package ntnu.idatt2105.semesterProject.eCommerceMarketplace.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.accessingdatamysql.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByUsername(String username);

    public User findByPhoneNumber(String phoneNumber);

    public User findByEmail(String email);
}
