package FileHandling_Test;

import static org.junit.jupiter.api.Assertions.*;
import org.capgemini.Problem_8.FileProcessor;
import org.junit.jupiter.api.*;
import java.io.*;

class FileProcessorTest {

    private static final String TEST_FILE = "testfile.txt";
    private FileProcessor fileProcessor;

    @BeforeEach
    void setUp() {
        fileProcessor = new FileProcessor();
    }

    @AfterEach
    void tearDown() {
        File file = new File(TEST_FILE);
        if (file.exists()) {
            file.delete(); // Cleanup test file
        }
    }

    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello, File Handling!";

        fileProcessor.writeToFile(TEST_FILE, content);
        String readContent = fileProcessor.readFromFile(TEST_FILE);

        assertEquals(content, readContent, "File content should match");
    }

    @Test
    void testFileExistsAfterWriting() throws IOException {
        fileProcessor.writeToFile(TEST_FILE, "Sample Data");
        File file = new File(TEST_FILE);
        assertTrue(file.exists(), "File should exist after writing");
    }

    @Test
    void testReadNonExistentFileThrowsException() {
        Exception exception = assertThrows(FileNotFoundException.class, () -> fileProcessor.readFromFile("nonexistent.txt"));
        assertTrue(exception.getMessage().contains("nonexistent.txt"));
    }
}
