package com.qa.test;

import com.qa.endpoints.UserSectionCrudOperation;
import com.qa.payload.User;
import com.qa.utilities.Dataproviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataDrivenTest {

    User userPayload;

    @Test(priority = 1, dataProvider = "Data", dataProviderClass = Dataproviders.class)
    public void createMultipleUsers(String UserName, String FirstName, String LastName, String UserEmail, String Pwd, String Ph) {

        userPayload = new User();

        userPayload.setId(Integer.parseInt(UserName));
        userPayload.setFirstName(FirstName);
        userPayload.setLastName(LastName);
        userPayload.setEmail(UserEmail);
        userPayload.setPassword(Pwd);
        userPayload.setPhone(Ph);

        Response response = UserSectionCrudOperation.createUser(userPayload);

        Assert.assertEquals(response.getStatusCode(), 200);


    }

}
