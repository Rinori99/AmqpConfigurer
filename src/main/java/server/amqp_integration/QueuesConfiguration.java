package server.amqp_integration;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueuesConfiguration {

    @Value("${queue.email}")
    private String emailQueueName;

    @Value("${queue.user.new.student}")
    private String newStudentsQueueName;

    @Value("${queue.user.new.parent}")
    private String newParentsQueueName;

    @Value("${queue.user.new.teacher}")
    private String newTeachersQueueName;

    @Value("${queue.user.new.admin}")
    private String newAdminsQueueName;

    @Value("${routing.connection.student.parent}")
    private String studentParentConnectionQueueName;

    @Value("${queue.connection.teacher.subject}")
    private String teacherSubjectConnectionQueueName;

    @Value("${queue.connection.student.class}")
    private String studentClassConnectionQueueName;

    @Value("${queue.notification}")
    private String notificationQueueName;

    @Value("${queue.meeting.new.online}")
    private String newOnlineMeetingQueueName;

    @Value("${queue.meeting.new.offline}")
    private String newOfflineMeetingQueueName;

    @Bean(name = "emailQueue")
    public Queue emailQueue() {
        return new Queue(emailQueueName);
    }

    @Bean(name = "newStudentsQueue")
    public Queue newStudentsQueue() {
        return new Queue(newStudentsQueueName);
    }

    @Bean(name = "newParentsQueue")
    public Queue newParentsQueue() {
        return new Queue(newParentsQueueName);
    }

    @Bean(name = "newTeachersQueue")
    public Queue newTeachersQueue() {
        return new Queue(newTeachersQueueName);
    }

    @Bean(name = "newAdminsQueue")
    public Queue newAdminsQueue() {
        return new Queue(newAdminsQueueName);
    }

    @Bean(name = "parentStudentConnectionQueue")
    public Queue parentStudentConnectionQueue() {
        return new Queue(studentParentConnectionQueueName);
    }

    @Bean(name = "teacherSubjectConnectionQueue")
    public Queue teacherSubjectConnectionQueue() {
        return new Queue(teacherSubjectConnectionQueueName);
    }

    @Bean(name = "studentClassConnectionQueue")
    public Queue studentClassConnectionQueue() {
        return new Queue(studentClassConnectionQueueName);
    }

    @Bean(name = "notificationQueue")
    public Queue notificationQueue() {
        return new Queue(notificationQueueName);
    }

    @Bean(name = "newOnlineMeetingQueue")
    public Queue newOnlineMeetingQueue() {
        return new Queue(newOnlineMeetingQueueName);
    }

    @Bean(name = "newOfflineMeetingQueue")
    public Queue newOfflineMeetingQueue() {
        return new Queue(newOfflineMeetingQueueName);
    }

}
