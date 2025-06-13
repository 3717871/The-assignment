package nl.inholland.appliedmathematics.oop3.moviewatchlist.configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;

// The class which makes multithreading possible which is waayyy easier then what we saw in week 4 of the term.

public class AsyncConfig {

    // "Task Executor" will be seen above methods which will run on threads.
    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        return Executors.newVirtualThreadPerTaskExecutor();
    }
}
