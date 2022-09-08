package com.udacity.catpoint.security;

import com.udacity.catpoint.image.service.FakeImageService;
import com.udacity.catpoint.security.data.*;
import com.udacity.catpoint.security.service.SecurityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SecurityServiceTest {

    @Mock
    private SecurityRepository securityRepository;

    private final FakeImageService fakeImageService = new FakeImageService();
    private SecurityService securityService;
    private final Sensor sensor = new Sensor("Front Door", SensorType.DOOR);


    @Test
    public void shouldAnswerWithTrue(){
        //assertTrue(true);
        securityService = new SecurityService(securityRepository,fakeImageService);

        when(securityRepository.getArmingStatus()).thenReturn(ArmingStatus.ARMED_HOME);
        when(securityRepository.getAlarmStatus()).thenReturn(AlarmStatus.NO_ALARM);

        securityService.changeSensorActivationStatus(sensor,true);

        verify(securityRepository,times(1)).setAlarmStatus(AlarmStatus.PENDING_ALARM);
    }

}
