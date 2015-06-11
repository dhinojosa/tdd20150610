package com.xyzcorp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MemberTest {

    @Test
    public void testMember() {
        Member member = new Member(30L, "Jimmy", "Newton");
        assertThat(member.getId(), is(30L));
        assertThat(member.getFirstName(), is("Jimmy"));
        assertThat(member.getLastName(), is("Newton"));
    }

}
