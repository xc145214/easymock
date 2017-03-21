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
 *
 *
 *  @author xiachuan at 2017/3/21 15:55。
 */

public class StubBusiness {

    private ExecService execService;

    private StubService stubService;

    public void setExecService(ExecService execService) {
        this.execService = execService;
    }

    public void setStubService(StubService stubService) {
        this.stubService = stubService;
    }


    public void execute1(){
        if(execService.execute()){
            stubService.method1();
        }
    }

    public void execute2(){
        if(execService.execute()){
            stubService.method2();
        }
    }

    public void execute3(){
        if(execService.execute()){
            stubService.method1();
            stubService.method2();
        }
    }
}

