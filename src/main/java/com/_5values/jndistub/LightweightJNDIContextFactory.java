package com._5values.jndistub;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;

public class LightweightJNDIContextFactory implements InitialContextFactory {

    private static Context _context;

    public static void setContext(Context context) {
        _context = context;
    }
    
    @Override
	public Context getInitialContext(Hashtable<?, ?> arg0) throws NamingException {
        return _context;
    }

}
