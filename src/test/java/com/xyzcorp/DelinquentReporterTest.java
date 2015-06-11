package com.xyzcorp;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DelinquentReporterTest {

    @Test
    public void testReportingWith0Entries() {
        LibraryService libraryService = mock(LibraryService.class);
        MemberDeserializer memberDeserializer = mock(MemberDeserializer.class);
        List<Member> members = Lists.newArrayList();
        when(libraryService.getDelinquentMembers()).
                thenReturn(members);
        DelinquentReporter delinquentReporter =
                new DelinquentReporter(libraryService, memberDeserializer);
        List<String> report = delinquentReporter.getReport();
        assertThat(report, is(empty()));
    }

    @Test
    public void testReportingWith1Entry() {
        LibraryService libraryService = mock(LibraryService.class);
        MemberDeserializer memberDeserializer = mock(MemberDeserializer.class);

        Member member1 = new Member(12L, "Jaycee", "Williams");

        when(libraryService.getDelinquentMembers())
                .thenReturn(Lists.newArrayList(member1));

        when(memberDeserializer.deserialize(member1)).thenReturn(
                Lists.newArrayList(
                        "Member Jaycee Williams owes .30 for Project A",
                        "Member Jaycee Williams owes .90 for Project B")
        );

        DelinquentReporter delinquentReporter =
                new DelinquentReporter(libraryService, memberDeserializer);

        List<String> report = delinquentReporter.getReport();

        assertThat(report.size(), is(2));
        assertThat(report.get(0),
                is("Member Jaycee Williams owes .30 for Project A"));
        assertThat(report.get(1),
                is("Member Jaycee Williams owes .90 for Project B"));
    }
}
