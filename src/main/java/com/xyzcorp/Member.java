package com.xyzcorp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel Hinojosa
 * @since 6/10/15 1:58 PM
 * url: <a href="http://www.evolutionnext.com">http://www.evolutionnext.com</a>
 * email: <a href="mailto:dhinojosa@evolutionnext.com">dhinojosa@evolutionnext.com</a>
 * tel: 505.363.5832
 */
public class Member {
    private final Long id;
    private String firstName;
    private String lastName;
    private List<Checkout> checkouts;

    public Member(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.checkouts = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Checkout> getCheckouts() {
        return checkouts;
    }

    public void addCheckout(Checkout checkout) {
        this.checkouts.add(checkout);
    }
}
