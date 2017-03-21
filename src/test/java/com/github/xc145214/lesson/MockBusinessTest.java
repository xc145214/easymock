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
import org.junit.Test;

/**
 *  mock模式测试
 *
 *  @author xiachuan at 2017/3/15 17:14。
 */

public class MockBusinessTest {

    /**
     * 测试案例可以通过，说明EasyMock.createMock()的确是不检测方法的调用顺序。
     *
     * @throws Exception
     */
    @Test
    public void testMock() throws Exception {

        MockBusiness mockBusiness = new MockBusiness();
        Service1 service1 = EasyMock.createMock("service1",Service1.class);
        mockBusiness.setService1(service1);

        service1.method2();
        EasyMock.expectLastCall();
        service1.method1();
        EasyMock.expectLastCall();

        EasyMock.replay(service1);
        mockBusiness.executeService1();

        EasyMock.verify(service1);
    }

    /**
     *  说明strict mock下，easymock检测到了实际调用时的顺序和预期的不同。
     * @throws Exception
     */
    @Test
    public void testStrictMock() throws Exception {
        MockBusiness mockBusiness = new MockBusiness();
        Service1 service1 = EasyMock.createStrictMock("service1", Service1.class);
        mockBusiness.setService1(service1);

        service1.method2();
        EasyMock.expectLastCall();
        service1.method1();
        EasyMock.expectLastCall();

        EasyMock.replay(service1);
        mockBusiness.executeService1();

        EasyMock.verify(service1);
    }


    /**
     *  测试案例可以通过，说明EasyMock.createNiceMock()是不检测方法的调用顺序。
     *
     * @throws Exception
     */
    @Test
    public void testNiceMock() throws Exception {
        MockBusiness mockBusiness = new MockBusiness();
        Service1 service1 = EasyMock.createNiceMock("service1",Service1.class);
        mockBusiness.setService1(service1);

        service1.method2();
        EasyMock.expectLastCall();
        service1.method1();
        EasyMock.expectLastCall();

        EasyMock.replay(service1);
        mockBusiness.executeService1();

        EasyMock.verify(service1);
    }

    /**
     *  测试案例可以通过，nick mock，record阶段可以简化
     * @throws Exception
     */
    @Test
    public void testNiceMockSimplify() throws Exception {

        MockBusiness mockBusiness = new MockBusiness();
        Service1 service1 = EasyMock.createNiceMock("service1",Service1.class);
        mockBusiness.setService1(service1);

        EasyMock.replay(service1);
        mockBusiness.executeService1();

        EasyMock.verify(service1);

    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testWithoutControlInWrongOrder() throws Exception {

        MockBusiness mockBusiness = new MockBusiness();
        Service1 service1 = EasyMock.createStrictMock("service1",Service1.class);
        Service2 service2 = EasyMock.createStrictMock("service2",Service2.class);
        mockBusiness.setService1(service1);
        mockBusiness.setService2(service2);


        service2.method4();
        EasyMock.expectLastCall();
        service2.method3();
        EasyMock.expectLastCall();


        service1.method2();
        EasyMock.expectLastCall();
        service1.method1();
        EasyMock.expectLastCall();

        EasyMock.replay(service1, service2);
        mockBusiness.executeService1And2();
        EasyMock.verify(service1,service2);

    }

    @Test
    public void testWithStrictControlInWrongOrder() throws Exception {
        MockBusiness mockBusiness = new MockBusiness();
        IMocksControl mockControl = EasyMock.createStrictControl();
        Service1 service1 = mockControl.createMock("service1",Service1.class);
        Service2 service2 = mockControl.createMock("service2",Service2.class);


        mockBusiness.setService1(service1);
        mockBusiness.setService2(service2);


        service2.method3();
        EasyMock.expectLastCall();


        service1.method1();
        EasyMock.expectLastCall();

        EasyMock.replay();
        mockBusiness.executeService1And2();
        EasyMock.verify();
    }
}

