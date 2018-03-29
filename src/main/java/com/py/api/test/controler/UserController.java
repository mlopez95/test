package com.py.api.test.controler;

import com.py.api.test.bean.User;
import com.py.api.test.bean.dto.UserDTO;
import com.py.api.test.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by mlopez on 28/03/2018
 */
@RestController
@Api(value = "UserController", tags = "API User")
public class UserController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService service;

    @ApiOperation(value = "Users", notes = "Servicio utilizado para obtener la lista de usuarios", nickname = "listAllUsers")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers(@RequestParam(value = "id",required = false) String[] ids) {
        logger.info("Method>>>>>>> /users -- listAllUsers()");
        List<User> users = service.getAllUsers(ids,"id");
        logger.info("Respuesta>>>>>> "+users);

        if (users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @ApiOperation(value = "User", notes = "Servicio utilizado para obtener un usuario existente a partir de su ID", nickname = "getUser")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id") String id) {
        logger.info("Method>>>>>>> /user/"+id+" -- getUser()");
        User user = service.getUser(id);
        logger.info("Respuesta>>>>>> "+user);

        if (user==null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @ApiOperation(value = "User", notes = "Servicio utilizado para obtener un usuario existente a partir de su ID", nickname = "getUser")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") String id,@RequestBody UserDTO user) {
        logger.info("Method>>>>>>> /user/"+id+" -- updateUser()");
        logger.info(" Nuevos datos: "+user);
        User newUser = service.updateUser(id,user);
        logger.info("Respuesta>>>>>> "+newUser);

        if (user==null) {
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }

        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @ApiOperation(value = "User", notes = "Servicio utilizado para obtener un usuario existente a partir de su ID", nickname = "getUser")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
        logger.info("Method>>>>>>> /user/"+id+" -- deleteUser()");
        service.deleteUser(id);
        logger.info("Respuesta>>>>>> Se borro correctamente");


        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "User", notes = "Servicio utilizado para obtener un usuario existente a partir de su ID", nickname = "getUser")
    @RequestMapping(value = "/users/", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody UserDTO user) {
        logger.info("Method>>>>>>> /user/ -- createUser()");
        logger.info(" Nuevos user: "+user);
        User newUser = service.creatUser(user);
        logger.info("Respuesta>>>>>> "+newUser);

        if (user==null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

}
