package nl.inholland.appliedmathematics.oop3.moviewatchlist.service;

import java.util.concurrent.CompletableFuture;

public interface IImageService {

    /**
     * Download an image from a source to a destination, as long as the source
     * is an image on the internet and the destination is a local file
     * @param imageUrl A string representing the URL of the image
     * @param destinationFile A string with the path of the target image (including directory and filename)
     * @return The compleatable future, as clients of this interface will have to implement async operations
     */
    CompletableFuture<Void> downloadImage(String imagePath, String destinationFolder);

    /**
     * Copy an image from a source to a destination, as long as they are
     * both in the local file system
     * @param source A string with the path of the source image
     * @param destination A string with the path of the target image (including directory and filename)
     * @return The compleatable future, as clients of this interface will have to implement async operations
     */
    CompletableFuture<Void> copyImage(String source, String destination);

}
