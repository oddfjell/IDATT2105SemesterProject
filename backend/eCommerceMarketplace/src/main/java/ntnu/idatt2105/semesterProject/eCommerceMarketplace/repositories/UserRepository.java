package ntnu.idatt2105.semesterProject.eCommerceMarketplace.repositories;

import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.Address;
import org.springframework.data.repository.CrudRepository;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

    // READ / GET
    public User findByUsername(String username);
    public User findByPhoneNumber(String phoneNumber);
    public User findByEmail(String email);
    public User findById (int id);


    // DELETE
    public void deleteById(int id);
}
