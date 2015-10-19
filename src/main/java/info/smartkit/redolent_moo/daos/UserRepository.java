package info.smartkit.redolent_moo.daos;

import info.smartkit.redolent_moo.domains.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by yangboz on 10/19/15.
 */
@Repository
public class UserRepository {

    @Inject
    private RedisTemplate<String, User> redisTemplate;

    public void save(User user) {
        redisTemplate.opsForValue().set(user.getId().toString(), user);
    }

    public User findById(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public List<User> findAll() {
        List<User> books = new ArrayList<>();

        Set<String> keys = redisTemplate.keys("*");
        Iterator<String> it = keys.iterator();

        while (it.hasNext()) {
            books.add(findById(it.next()));
        }

        return books;
    }

    public void delete(User user) {
        String key = user.getId().toString();
        redisTemplate.opsForValue().getOperations().delete(key);
    }


    public void deleteAll() {
        Set<String> keys = redisTemplate.keys("*");
        Iterator<String> it = keys.iterator();

        while (it.hasNext()) {
            User b = new User(it.next());
            delete(b);
        }
    }
}
