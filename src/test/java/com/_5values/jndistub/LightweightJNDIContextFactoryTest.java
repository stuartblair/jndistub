package com._5values.jndistub;

import static org.junit.Assert.*;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com._5values.jndistub.LightweightJNDIContextFactory;

import org.jmock.Expectations;
import org.jmock.Mockery;

public class LightweightJNDIContextFactoryTest {

    private LightweightJNDIContextFactory lightweightJNDIContextFactory;
    private Context context;
    
    @After
	public void tearDown() throws Exception {
        context = null;
    }

    @Test
	public void shouldReturnTheSameContextAcrossDifferentInstances() throws NamingException {
        LightweightJNDIContextFactory.setContext(providedContext());
        LightweightJNDIContextFactory first = new LightweightJNDIContextFactory();
        LightweightJNDIContextFactory second = new LightweightJNDIContextFactory();
        assertSame(first.getInitialContext(dummyEnvironment()), second.getInitialContext(dummyEnvironment()));
    }

    private Context providedContext() {
        if (context == null) {
            Mockery factory = new Mockery();        
            context = factory.mock(Context.class);
        }
        return context;
    }

    private Hashtable<?, ?> dummyEnvironment() {
        return null;
    }
}
