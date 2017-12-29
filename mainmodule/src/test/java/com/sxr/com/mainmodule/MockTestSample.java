package com.sxr.com.mainmodule;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockTestSample {
    private static final String FAKE_STRING = "HELLO WORLD";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void readStringFromContext_LocalizedString() {

        List<String> list = mock(List.class);
        when(list.get(anyInt())).thenReturn("hello", "world");
        String result = list.get(0) + list.get(1);
        verify(list, times(2)).get(anyInt());
        Assert.assertEquals("helloworld", result);
    }


}
