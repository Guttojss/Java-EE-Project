/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * https://github.com/javaee/firstcup-examples/LICENSE.txt
 */
package firstcup.web;

import firstcup.ejb.DukesBirthdayBean;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

@Named
@SessionScoped
public class Login implements Serializable {

    @EJB
    private DukesBirthdayBean dukesBirthdayBean;

    @NotNull
    private String Name;
    private String User;

    private static final Logger logger = Logger.getLogger("firstcup.web.DukesBDay");

    public Login() {
    }

    /**
     * Process User and log the user name.
     */
    public String processUser() {
        logger.log(Level.INFO, "User: {0}", Name);
        return "/user.xhtml";
    }

    /**
     * Get the value of User by calling the external service.
     *
     * @return the User name retrieved from the external service
     */
    public String getName() {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://localhost:8080/firstcup-war/login.xhtml"); // Update to a valid API endpoint
            Name = target.request().get(String.class); // Retrieve the response as a string
            logger.log(Level.INFO, "Retrieved User: {0}", User);
        } catch (IllegalArgumentException | NullPointerException | WebApplicationException ex) {
            logger.severe("Processing of HTTP response failed: " + ex.getMessage());
            User = "Error retrieving user"; // Default value in case of failure
        }
        return Name;
    }

    /**
     * Get the current User value.
     *
     * @return the User
     */
    public String getYourName() {
        return User;
    }
    public void setYourName(String Name) {
        this.User = Name;
    }
    
    /*
    ---------------------------------------------------------------
    */
    /**
     * Get the value of yourBD
     *
     * @return the value of yourBD
     
    public Date getYourBD() {
        return yourBD;
    }
    */
    /**
     * Set the value of yourBD
     *
     * @param yourBD new value of yourBD
     
    public void setYourBD(Date yourBD) {
        this.yourBD = yourBD;
    }
*/
    /**
     * Get the value of ageDiff
     *
     * @return the value of ageDiff
     
    public int getAgeDiff() {
        return ageDiff;
    }*/

    /**
     * Set the value of ageDiff
     *
     * @param ageDiff new value of ageDiff
     
    public void setAgeDiff(int ageDiff) {
        this.ageDiff = ageDiff;
    }

     * Get the value of absAgeDiff
     *
     * @return the value of absAgeDiff
     
    public int getAbsAgeDiff() {
        return absAgeDiff;
    }

    /**
     * Set the value of absAgeDiff
     *
     * @param absAgeDiff new value of absAgeDiff
     
    public void setAbsAgeDiff(int absAgeDiff) {
        this.absAgeDiff = absAgeDiff;
    }

    /**
     * Get the value of averageAgeDifference
     *
     * @return the value of averageAgeDifference
     
    public Double getAverageAgeDifference() {
        return averageAgeDifference;
    }

    /**
     * Set the value of averageAgeDifference
     *
     * @param averageAgeDifference new value of averageAgeDifference
     
    public void setAverageAgeDifference(Double averageAgeDifference) {
        this.averageAgeDifference = averageAgeDifference;
    }
    */
}
