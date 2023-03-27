package ntnu.idatt2105.semesterProject.eCommerceMarketplace.repositories;

import org.springframework.data.repository.CrudRepository;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.User;
import org.springframework.stereotype.Repository;

/**
 * This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
 * CRUD refers Create, Read, Update, Delete
 */

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    /**
     * READ / GET username
     * @param username String
     * @return User
     */
    public User findByUsername(String username);

    /**
     * READ / GET phoneNumber
     * @param phoneNumber String
     * @return User
     */
    public User findByPhoneNumber(String phoneNumber);

    /**
     * READ / GET email
     * @param email String
     * @return User
     */
    public User findByEmail(String email);

    /**
     * READ / GET id
     * @param id int
     * @return User
     */
    public User findById (int id);
    /**
     * DELETE id
     * @param id int
     */
    public void deleteById(Integer id);
}
