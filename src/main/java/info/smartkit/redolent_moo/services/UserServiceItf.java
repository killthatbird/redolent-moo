package info.smartkit.redolent_moo.services;

import com.google.common.collect.Lists;
import info.smartkit.redolent_moo.domains.User;

import java.util.List;

/**
 * Created by yangboz on 10/19/15.
 */
public interface UserServiceItf {

    public List<User> findAll();

    public User findById(String id);

    public void save(User user);

    public void delete(User user);

    public void deleteAll();
}
