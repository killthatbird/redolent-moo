package info.smartkit.redolent_moo.controllers;

import com.wordnik.swagger.annotations.ApiOperation;
import info.smartkit.redolent_moo.daos.UserRepository;
import info.smartkit.redolent_moo.domains.User;
import info.smartkit.redolent_moo.services.UserServiceItf;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.awt.print.Book;
import java.util.List;

/**
 * Created by yangboz on 10/18/15.
 */
@RestController
@RequestMapping("/redis/demo")
public class UserController {

    @Autowired
    UserServiceItf userService;


//    @Inject
//    private RedisTemplate<String, Book> redisTemplate;

//    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
//    @ApiOperation(httpMethod = "POST", value = "Response a string describing if the User info is successfully created or not.")
//    @ResponseBody
//    public ResponseEntity<Boolean> putCache() {
//        demoService.findUser(1l, "wang", "yunfei");
//        demoService.findAddress(1l, "anhui", "hefei");
//        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
//    }
//
//    @RequestMapping("/address")
//    @ApiOperation(httpMethod = "GET", value = "Response a list describing all of Address that is successfully get or not.")
//    public Address getAddress() {
//        return demoService.findAddress(1l, "anhui", "hefei");
//    }
//
//    @RequestMapping("/user")
//    @ApiOperation(httpMethod = "GET", value = "Response a list describing all of User that is successfully get or not.")
//    public User geUser() {
//        return demoService.findUser(1l, "wang", "yunfei");
//    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
    @ApiOperation(httpMethod = "POST", value = "Response a string describing if the User info is successfully created or not.")
//    public Map<String, Float> create(@RequestBody @Valid Map<String, Float> value) {
    public ResponseEntity<Boolean> create(@RequestBody User user) {
        //
//        ValueOperations<String, String> ops = this.redisTemplate.opsForValue();
//        String key = "spring.boot.redis.test";
//        if (!this.redisTemplate.hasKey(key)) {
//            ops.set(key, "foo");
//        }

//        redisTemplate.opsForValue().set(user.getId().toString(), user);
        userService.save(user);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Response a list describing all of User that is successfully get or not.")
    public List<User> list() {
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Response a string describing if the User related value is successfully get or not.")
    public User get(@PathVariable("id") long id) {
        return userService.findById(id + "");
    }

    //
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(httpMethod = "PUT", value = "Response a string describing if the  User item  is successfully updated or not.")
    public void update(@PathVariable("id") long id, @RequestBody User value) {
//		User find = UserRepository.findOne(id);
        userService.save(value);
    }


    //
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(httpMethod = "DELETE", value = "Response a string describing if the User item is successfully delete or not.")
    public ResponseEntity<Boolean> delete(@PathVariable("id") long id) {
        //
        User user = new User();
        user.setId(id + "");
        userService.delete(user);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ApiOperation(httpMethod = "DELETE", value = "Response a string describing if the User item is successfully delete or not.")
    public ResponseEntity<Boolean> deleteAll() {
        //
        userService.deleteAll();
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }
}
