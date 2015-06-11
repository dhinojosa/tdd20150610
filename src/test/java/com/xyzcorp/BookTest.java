package com.xyzcorp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class BookTest {

    @Test
    public void testBookCreation() {
        String title = "Game of Thrones, Song of Fire and Ice";
        Book book = new Book(100L, title);
        assertThat(book.getId(), is(100L));
        assertThat(book.getTitle(), is(title));
    }

}
