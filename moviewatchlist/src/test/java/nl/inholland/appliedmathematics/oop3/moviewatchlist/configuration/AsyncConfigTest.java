package nl.inholland.appliedmathematics.oop3.moviewatchlist.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

class AsyncConfigTest {

    @Test
    void testTaskExecutorBeanExistsAndIsExecutable() throws InterruptedException {
        // Load the Spring context with AsyncConfig
        try (var context = new AnnotationConfigApplicationContext(AsyncConfig.class)) {

            // Check if the taskExecutor bean is present
            assertTrue(context.containsBean("taskExecutor"));

            Object bean = context.getBean("taskExecutor");
            assertNotNull(bean);
            assertTrue(bean instanceof Executor);

            // Test if the executor actually runs a task
            Executor executor = (Executor) bean;
            AtomicBoolean taskRan = new AtomicBoolean(false);

            executor.execute(() -> taskRan.set(true));

            // Wait a bit for the task to run
            Thread.sleep(100);

            assertTrue(taskRan.get(), "The task should have run");
        }
    }
}
