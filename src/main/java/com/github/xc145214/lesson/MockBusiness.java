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

/**
 *  测试业务模式。
 *
 *  @author xiachuan at 2017/3/15 17:13。
 */

public class MockBusiness {

    private Service1 service1;

    private Service2 service2;

    public void setService1(Service1 service1) {
        this.service1 = service1;
    }

    public void setService2(Service2 service2) {
        this.service2 = service2;
    }

    public void executeService1() {
        service1.method1();
        service1.method2();
    }

    public void executeService1And2() {
        service1.method1();
        service1.method2();

        service2.method3();
        service2.method4();
    }
}

