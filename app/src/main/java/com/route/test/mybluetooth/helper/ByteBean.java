package com.route.test.mybluetooth.helper;

/**
 * Created by my301s on 2017/9/4.
 */

public class ByteBean {

    public static final byte[] START = new byte[]{(byte) 0xEB, 0x20, 0x00,
            (byte) 0xf5, (byte) 0xEB};

    public static final byte[] END = new byte[]{(byte) 0xEB, 0x20, 0x01,
            (byte) 0xf4, (byte) 0xEB};

    public static final byte[] QUERY = new byte[]{(byte) 0xEB, 0x21,
            (byte) 0xf4, (byte) 0xEB };

}
