package com.xyzcorp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel Hinojosa
 * @since 6/10/15 3:05 PM
 * url: <a href="http://www.evolutionnext.com">http://www.evolutionnext.com</a>
 * email: <a href="mailto:dhinojosa@evolutionnext.com">dhinojosa@evolutionnext.com</a>
 * tel: 505.363.5832
 */
public class DelinquentReporter {
    private final LibraryService libraryService;
    private final MemberDeserializer memberDeserializer;


    public DelinquentReporter(LibraryService libraryService, MemberDeserializer memberDeserializer) {
        this.libraryService = libraryService;
        this.memberDeserializer = memberDeserializer;
    }

    public List<String> getReport() {
        List<String> result = new ArrayList<>();
        for (Member member : libraryService.getDelinquentMembers()) {
            result.addAll(memberDeserializer.deserialize(member));
        }
        return result;
    }
}
