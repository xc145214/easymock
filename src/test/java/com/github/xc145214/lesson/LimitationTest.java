/**
 * **********************************************************************
 * HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
 * <p/>
 * COPYRIGHT (C) HONGLING CAPITAL CORPORATION 2012
 * ALL RIGHTS RESERVED BY HONGLING CAPITAL CORPORATION. THIS PROGRAM
 * MUST BE USED  SOLELY FOR THE PURPOSE FOR WHICH IT WAS FURNISHED BY
 * HONGLING CAPITAL CORPORATION. NO PART OF THIS PROGRAM MAY BE REPRODUCED
 * OR DISCLOSED TO OTHERS,IN ANY FORM, WITHOUT THE PRIOR WRITTEN
 * PERMISSION OF HONGLING CAPITAL CORPORATION. USE OF COPYRIGHT NOTICE
 * DOES NOT EVIDENCE PUBLICATION OF THE PROGRAM.
 * HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
 * ***********************************************************************
 */
package com.github.xc145214.lesson;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.expect;

/**
 *  LimitationTest
 *
 *  @author xiachuan at 2017/3/15 16:57。
 */

public class LimitationTest {

    private Business business;

    private IMocksControl mocksControl;

    private Service service;

    @Before
    public void setUp() throws Exception {
        business = new Business();
        mocksControl = EasyMock.createStrictControl();
        service = mocksControl.createMock(Service.class);
        business.setService(service);
    }

    @Test
    public void testDefault() throws Exception {
        business.execute();
    }

    @Test
    public void testCustomer() throws Exception {
        EasyMock.expect(service.toString()).andReturn("Customized toString");
        EasyMock.expect(service.hashCode()).andReturn(100000);
        mocksControl.replay();

        business.execute();
        mocksControl.verify();

    }
}

