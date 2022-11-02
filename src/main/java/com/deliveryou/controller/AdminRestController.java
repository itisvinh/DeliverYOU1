package com.deliveryou.controller;

import com.deliveryou.controller.util.ControllerUtil;
import com.deliveryou.pojo.DriverRegistration;
import com.deliveryou.pojo.Role;
import com.deliveryou.pojo.User;
import com.deliveryou.pojo.auxiliary.RegistrationFilter;
import com.deliveryou.service.interfaces.UserService;
import com.deliveryou.util.JSONConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.regex.Pattern;
import static java.util.Arrays.asList;

@RestController
public class AdminRestController {
    private final ResponseEntity _500 = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    private final ResponseEntity _200 = new ResponseEntity(HttpStatus.OK);
    private final ResponseEntity _400 = new ResponseEntity(HttpStatus.BAD_REQUEST);

    private final ResponseEntity _401 = new ResponseEntity(HttpStatus.UNAUTHORIZED);
    private final ResponseEntity _304 = new ResponseEntity(HttpStatus.NOT_MODIFIED);

    @Autowired
    private UserService userServiceImpl;

    @Transactional
    @PostMapping(value = "/admin/api/get-drivers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getDrivers(@RequestBody Map<String, String> map) {
        try {
            int start = Integer.valueOf(map.get("start_index"));
            int end = Integer.valueOf(map.get("max_results"));

            List<User> drivers = userServiceImpl.getUsersWithinRange(Role.SHIPPER, start, end);

            return new ResponseEntity(JSONConverter.convert(new HashMap<String, Object>() {{
                put("list", drivers);
            }}), HttpStatus.OK);

        } catch (NumberFormatException numberFormatException) {
            numberFormatException.printStackTrace();
            return _400;
        } catch (Exception ex) {
            ex.printStackTrace();
            return _500;
        }
    }

//    private String normalizeRole(String role) {
//        if (Pattern.matches("^(role_)?(shipper|driver)$", role.toLowerCase()))
//            return Role.SHIPPER;
//        if (Pattern.matches("^(role_)?(admin|administrator)$", role.toLowerCase()))
//            return Role.ADMIN;
//        if (Pattern.matches("^(role_)?(user|regular_user)$", role.toLowerCase()))
//            return Role.REGULAR_USER;
//        return null;
//    }

    private ResponseEntity responseEntity(HttpStatus status) {
        return responseEntity(status, null, null);
    }

    private ResponseEntity responseEntity(HttpStatus status, List<String> keys, List<Object> values) {
        if (keys != null && values != null) {
            if (keys.size() != values.size())
                throw new IllegalArgumentException("Keys and Values have different size");

            return new ResponseEntity(JSONConverter.convert(new HashMap<String, Object>() {{
                for (int i = 0; i < keys.size(); i++) {
                    put(keys.get(i), values.get(i));
                }
            }}), status);

        } else
            return new ResponseEntity(status);

    }

    @Transactional
    @PostMapping(value = "/admin/api/update-user/{role}")
    public ResponseEntity updateUser(@PathVariable("role") String role, @RequestBody User user) {
//        int user_id = 0;
//        try {
//            user_id = Integer.parseInt(id);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return _400;
//        }
        User real_user = userServiceImpl.getUser(user.getId());

        if (role == null || real_user == null)
            return _400;
        else {
            String nRole = ControllerUtil.normalizeRole(role);
            if (nRole == null || !nRole.equals(real_user.getRole().getName()))
                return responseEntity(HttpStatus.BAD_REQUEST, asList("error"), asList("requested role and user's role are different"));

            if (real_user.update(user)) {
                if (userServiceImpl.updateUser(real_user))
                    return _200;
                return _500;
            } else
                return _304;
        }
    }

    @Transactional
    @PostMapping(value = "/admin/api/delete-user/{role}")
    public ResponseEntity deleteUser(@PathVariable String role, @RequestBody Map<String, String> map) {
        String indexable = map.get("id") != null ? map.get("id") : map.get("phone_number");

        if (indexable == null)
            return _400;
        else {
            boolean parsable = !Pattern.matches("/^[0\\+].{9,}$/gm", indexable);
            User user = parsable ? userServiceImpl.getUser(Integer.parseInt(indexable))
                                    : userServiceImpl.getUser(indexable);

            if (user == null)
                return _400;
            else {
                String nRole = ControllerUtil.normalizeRole(role);
                if (nRole == null || !nRole.equals(user.getRole().getName()))
                    return responseEntity(HttpStatus.BAD_REQUEST, asList("error"), asList("requested role and user's role are different"));

                user.setDeleted((byte) 1);
                if (userServiceImpl.updateUser(user))
                    return _200;
                return _500;
            }
        }

    }

    @Transactional
    @PostMapping(value = "/admin/api/create-registration")
    public ResponseEntity createDriverRegistration(@RequestBody DriverRegistration registration) {
        boolean result = userServiceImpl.createDriverRegistration(registration);

        return result ? _200 : _500;
    }

    /**
     *
     * @param filter_code: 0 for IS_PROCESSED, 1 for IS_NOT_PROCESSED, 2 for ALL,
     * @return JSON
     */
    @Transactional
    @PostMapping(value = "/admin/api/get-driver-registrations", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getDriverRegistrations(@RequestBody int filter_code) {
        if (!new HashSet<Integer>(asList(0,1,2)).contains(filter_code))
            return _400;
        else {
            final List<DriverRegistration> list = userServiceImpl.getDriverRegistrations(RegistrationFilter.values()[filter_code]);

            if (list == null)
                return _500;
            else {
                try {
                    return responseEntity(HttpStatus.OK,
                            asList("list"),
                            asList(list));
                } catch (Exception e) {
                    e.printStackTrace();
                    return _500;
                }
            }
        }
    }

    @Transactional
    @PostMapping(value = "/admin/api/process-registration/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity processRegistration(@PathVariable int id) {
        DriverRegistration registration = userServiceImpl.getDriverRegistration(id);

        if (registration != null) {
            if (userServiceImpl.processDriverRegistration(registration))
                return _200;
            return _500;
        }
        return _400;
    }

    @Transactional
    @PostMapping(value = "/admin/api/count-users/{role}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity countUsers(@PathVariable String role) {
        String nRole = ControllerUtil.normalizeRole(role);

        if (nRole != null) {
            long result = userServiceImpl.countUsers(nRole);
            if (result == -1)
                return ControllerUtil.responseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            return ControllerUtil.responseEntity(HttpStatus.OK, asList("count"), asList(result));
        }
        return ControllerUtil.responseEntity(HttpStatus.BAD_REQUEST);
    }



    @Transactional
    @PostMapping(value = "/public/api/get-user-info/{phoneNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserInfo(@PathVariable String phoneNumber) {
        try {
            User user = userServiceImpl.getUser(phoneNumber);

            if (user == null)
                return ControllerUtil.responseEntity(HttpStatus.BAD_REQUEST);

            return ControllerUtil.responseEntity(HttpStatus.OK, asList("user"), asList(user));

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            return ControllerUtil.responseEntity(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return ControllerUtil.responseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
