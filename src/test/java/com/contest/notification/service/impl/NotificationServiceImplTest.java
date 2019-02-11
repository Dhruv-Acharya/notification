package com.contest.notification.service.impl;

import com.contest.notification.consumer.*;
import com.contest.notification.entity.NotificationData;
import com.contest.notification.repository.NotificationRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

@RunWith(MockitoJUnitRunner.class)
public class NotificationServiceImplTest {
    
    @InjectMocks
    NotificationServiceImpl notificationService;
    
    @Mock
    NotificationRepository notificationRepository;

    @Mock
    FollowConsumer followConsumer;

    @Mock
    LikeConsumer likeConsumer;

    @Mock
    CommentConsumer commentConsumer;

    @Mock
    WelcomeConsumer welcomeConsumer;

    @Mock
    ContestConsumer contestConsumer;

    @Mock
    GenericConsumer genericConsumer;

    @Mock
    QuestionsConsumer questionsConsumer;

    @Mock
    ResultConsumer resultConsumer;

    @Mock
    SubscriptionNoticeConsumer subscriptionNoticeConsumer;

    @Mock
    ShareConsumer shareConsumer;

    @BeforeClass
    public static void init() {
//        initMocks(NotificationServiceImplTest.class);
    }

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        verifyNoMoreInteractions(notificationRepository);
    }

    @Test
    public void addNotification() {
        NotificationData notification = new NotificationData();
        notification.setNotificationId("123");
        when(notificationRepository.save(any(NotificationData.class))).thenReturn(notification);

        NotificationData resultNotification = notificationService.addNotification(new NotificationData());
        Assert.assertNotNull(resultNotification);
        verify(notificationRepository, times(1)).save(any(NotificationData.class));
    }

    @Test
    public void findByUserId_Follow() {
    }

    @Test
    public void findByUserIdPagenation() {
    }

    @Test
    public void findOne() {
    }

    @Test
    public void markRead() {
    }
}