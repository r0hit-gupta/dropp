package com.dropp.app.validation;

import com.dropp.app.common.Constant;
import com.dropp.app.exception.TokenValidationException;
import com.dropp.app.exception.UserAuthorizationException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public void validate(String authorizationHeader) {
        try {
            if (!authorizationHeader.startsWith(Constant.BEARER + " ")) {
                throw new UserAuthorizationException("User not authorized!!");
            }
            String[] headerValues = authorizationHeader.split(" ");
            if (headerValues.length != 2) {
                throw new UserAuthorizationException("User not authorized!!");
            }
            String idToken = headerValues[1];
            FirebaseAuth.getInstance().verifyIdToken(idToken);
        } catch (FirebaseAuthException ex) {
            throw new TokenValidationException("Invalid token!!", ex);
        }
    }
}
