package info.smartkit.redolent_moo.services.impls;

import com.google.common.collect.Lists;
import info.smartkit.redolent_moo.daos.UserRepository;
import info.smartkit.redolent_moo.domains.User;
import info.smartkit.redolent_moo.services.UserServiceItf;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.awt.print.Book;
import java.util.List;

/**
 * Created by yangboz on 10/19/15.
 */
@Service
public class UserServiceImpl implements UserServiceItf {

    @Inject
    private UserRepository userRepository;

    public List<User> findAll() {
        return Lists.newArrayList(userRepository.findAll());
    }

    public User findById(String id) {
        return userRepository.findById(id);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }
}
