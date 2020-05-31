package server.amqp_integration;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BindingsConfiguration {

    @Value("${binding.simple.email}")
    private String emailDirectBindingKey;

    @Value("${binding.user.new.general}")
    private String newUserGeneralBindingKey;

    @Value("${binding.connection.student.parent}")
    private String studentParentConnectionBindingKey;

    @Value("${binding.connection.teacher.subject}")
    private String teacherSubjectConnectionBindingKey;

    @Value("${binding.connection.student.class}")
    private String studentClassConnectionBindingKey;

    @Value("${binding.notification}")
    private String notificationBindingKey;

    @Value("${binding.meeting.new.general}")
    private String newGeneralMeetingBindingKey;

    @Bean
    public Binding bindDirectExchangeToEmailQueue(@Qualifier("emailQueue") Queue emailQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(emailQueue).to(directExchange).with(emailDirectBindingKey);
    }

    @Bean
    public Binding bindTopicExchangeToNewStudentsQueue(@Qualifier("newStudentsQueue") Queue newStudentsQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(newStudentsQueue).to(topicExchange).with(newUserGeneralBindingKey);
    }

    @Bean
    public Binding bindTopicExchangeToNewParentsQueue(@Qualifier("newParentsQueue") Queue newParentsQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(newParentsQueue).to(topicExchange).with(newUserGeneralBindingKey);
    }

    @Bean
    public Binding bindTopicExchangeToNewTeachersQueue(@Qualifier("newTeachersQueue") Queue newTeachersQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(newTeachersQueue).to(topicExchange).with(newUserGeneralBindingKey);
    }

    @Bean
    public Binding bindTopicExchangeToNewAdminsQueue(@Qualifier("newAdminsQueue") Queue newAdminsQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(newAdminsQueue).to(topicExchange).with(newUserGeneralBindingKey);
    }

    @Bean
    public Binding bindDirectExchangeToStudentParentConnectionQueue(@Qualifier("parentStudentConnectionQueue") Queue parentStudentConnectionQueue,
                                                                    DirectExchange directExchange) {
        return BindingBuilder.bind(parentStudentConnectionQueue).to(directExchange).with(studentParentConnectionBindingKey);
    }

    @Bean
    public Binding bindDirectExchangeToNotificationQueue(@Qualifier("notificationQueue") Queue notificationQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(notificationQueue).to(directExchange).with(notificationBindingKey);
    }

    @Bean
    public Binding bindTopicExchangeToNewOnlineMeetingQueue(@Qualifier("newOnlineMeetingQueue") Queue newOnlineMeetingQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(newOnlineMeetingQueue).to(topicExchange).with(newGeneralMeetingBindingKey);
    }

    @Bean
    public Binding bindTopicExchangeToNewOfflineMeetingQueue(@Qualifier("newOfflineMeetingQueue") Queue newOfflineMeetingQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(newOfflineMeetingQueue).to(topicExchange).with(newGeneralMeetingBindingKey);
    }

    @Bean
    public Binding bindDirectExchangeToTeacherSubjectConnectionQueue(@Qualifier("teacherSubjectConnectionQueue") Queue teacherSubjectConnectionQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(teacherSubjectConnectionQueue).to(directExchange).with(teacherSubjectConnectionBindingKey);
    }

    @Bean
    public Binding bindDirectExchangeToStudentClassConnectionQueue(@Qualifier("studentClassConnectionQueue") Queue studentClassConnectionQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(studentClassConnectionQueue).to(directExchange).with(studentClassConnectionBindingKey);
    }

}
