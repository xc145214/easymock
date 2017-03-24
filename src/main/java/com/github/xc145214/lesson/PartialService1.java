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
 * partial class mocking.
 *
 * @author xiachuan at 2017/3/24 13:22。
 */

public class PartialService1 {


    public void execute() {
        actualMethod();
        needMockMethod();
    }

    void actualMethod() {
        System.out.println("call actualMethod()!");
    }

    public void needMockMethod() {
        System.out.println("call needMockMethod()!");
    }

    public String execute3() {
        actualMethod();
        return toString();
    }

    @Override
    public String toString() {
        return "defaultToString{}";
    }
}

