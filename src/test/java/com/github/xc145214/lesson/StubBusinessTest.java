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

/**
 *  StubBusiness 测试。
 *
 *  @author xiachuan at 2017/3/21 16:01。
 */

public class StubBusinessTest {

    private StubBusiness stubBusiness;

    private IMocksControl mocksControl;

    private ExecService execService;

    @Before
    public void setUp() throws Exception {
        stubBusiness = new StubBusiness();
        stubBusiness.setStubService(prepareStubService());

        mocksControl = EasyMock.createStrictControl();
        execService = mocksControl.createMock("execService", ExecService.class);
        stubBusiness.setExecService(execService);
    }

    private StubService prepareStubService() {
        StubService service = EasyMock.createMock("stubService", StubService.class);
        service.method1();
        EasyMock.expectLastCall().andStubReturn("");
        service.method2();
        EasyMock.expectLastCall().andStubReturn("");
        EasyMock.replay(service);
        return service;
    }

    @Test
    public void testExecute1() throws Exception {
        EasyMock.expect(execService.execute()).andReturn(true);
        mocksControl.replay();
        stubBusiness.execute1();
        mocksControl.verify();
    }

    @Test
    public void testExecute2() throws Exception {
        EasyMock.expect(execService.execute()).andReturn(false);
        mocksControl.replay();
        stubBusiness.execute2();
        mocksControl.verify();
    }

    @Test
    public void testExecute3() throws Exception {
        EasyMock.expect(execService.execute()).andReturn(true);
        mocksControl.replay();
        stubBusiness.execute3();
        mocksControl.verify();
    }
}

