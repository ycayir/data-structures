package com.yc.interviews.toast;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Reverse Strings")
public class StringReverserTest {

    @Nested
    @DisplayName("String of Characters")
    public class ReverseStringTests {
        @Test
        @DisplayName("Reverse null string")
        public void testReverseNullString() {
            assertNull(StringReverser.reverse(null));
        }

        @Test
        @DisplayName("Reverse empty string")
        public void testReverseEmptyString() {
            assertEquals("", StringReverser.reverse(""));
        }

        @Test
        @DisplayName("Reverse Hello, World!")
        public void testReverseString() {
            assertEquals("!dlroW ,olleH", StringReverser.reverse("Hello, World!"));
        }
    }

    @Nested
    @DisplayName("String of Words")
    public class StringStringsWithWords {

        @Test
        @DisplayName("Reverse null string")
        public void testReverseNullString() {
            assertNull(StringReverser.reverseWords(null));
        }

        @Test
        @DisplayName("Reverse empty string")
        public void testReverseEmptyString() {
            assertEquals("", StringReverser.reverseWords(""));
        }

        @Test
        @DisplayName("Reverse space-separated words in a string")
        public void testReverseSpaceSeparatedWordsInString() {
            assertEquals("World hello Yalcin", StringReverser.reverseWords("Yalcin hello World"));
        }

        @Test
        @DisplayName("Reverse space-separated words with punctuations in a string")
        public void testReverseSpaceSeparatedPunctuatedWordsInString() {
            assertEquals("World, hello Yalcin!", StringReverser.reverseWords("Yalcin, hello World!"));
        }
    }

}
