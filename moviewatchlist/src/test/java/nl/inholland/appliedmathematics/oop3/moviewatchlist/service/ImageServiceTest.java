package nl.inholland.appliedmathematics.oop3.moviewatchlist.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

public class ImageServiceTest {

    private ImageService imageService;

    @BeforeEach
    void setUp() {
        imageService = new ImageService();
    }

    @Test
    void testDownloadImage_completesSuccessfully() throws Exception {
        // We cannot easily mock URLConnection here since your code creates it internally.
        // So just call and ensure it completes without throwing exceptions.
        // Use a dummy image path and a temp directory.

        String dummyImagePath = "2w4xG178RpB4MDAIfTkqAuSJzec.jpg";
        String tempDir = System.getProperty("java.io.tmpdir");

        CompletableFuture<Void> future = imageService.downloadImage(dummyImagePath, tempDir);

        // Wait for completion
        future.get(); // Throws if exception happens inside CompletableFuture

        // Check the file was created (most likely empty or partial if no real image)
        File createdFile = new File(tempDir, dummyImagePath);
        assertTrue(createdFile.exists(), "File should be created");

        // Cleanup
        createdFile.delete();
    }

    @Test
    void testCopyImage_copiesFileSuccessfully() throws Exception {
        // Create a temp source file
        Path source = Files.createTempFile("sourceImage", ".tmp");
        Files.writeString(source, "dummy data");

        Path dest = Path.of(source.getParent().toString(), "copiedImage.tmp");

        CompletableFuture<Void> future = imageService.copyImage(source.toString(), dest.toString());

        future.get(); // wait for async completion

        assertTrue(Files.exists(dest), "Destination file should exist");
        assertEquals("dummy data", Files.readString(dest));

        // Cleanup
        Files.deleteIfExists(source);
        Files.deleteIfExists(dest);
    }

    @Test
    void testCopyImage_throwsRuntimeExceptionOnError() {
        // Use invalid source path to cause IOException

        CompletableFuture<Void> future = imageService.copyImage("nonexistent_file.tmp", "dest.tmp");

        ExecutionException ex = assertThrows(ExecutionException.class, future::get);
        assertTrue(ex.getCause() instanceof RuntimeException);
        assertTrue(ex.getCause().getMessage().contains("Error processing image"));
    }
}