package com.route.test.mybluetooth.xueya;


import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.route.test.mybluetooth.R;
import com.route.test.mybluetooth.helper.ByteBean;
import com.route.test.mybluetooth.helper.ReceiveSocketService;
import com.route.test.mybluetooth.view.MyZhu;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.UUID;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class XueYaFragment extends Fragment {
    @Bind(R.id.blueName)
    EditText blueName;
    @Bind(R.id.openBlue)
    Button openBlue;
    @Bind(R.id.sousuoBlue)
    Button sousuoBlue;
    @Bind(R.id.guanBlue)
    Button guanBlue;
    @Bind(R.id.blueStart)
    Button blueStart;
    @Bind(R.id.blueEnd)
    Button blueEnd;
    @Bind(R.id.lin2)
    LinearLayout lin2;
    @Bind(R.id.myzhu)
    MyZhu myzhu;
    @Bind(R.id.activity_main)
    RelativeLayout activityMain;
    BluetoothSocket socket;
    BluetoothManager bluetoothManager;   //获取蓝牙管理
    BluetoothAdapter mBluetoothAdapter;  //本机设备   只有一个
    int connectNum;
    public final int REQUEST_ENABLE_BT = 110;
    InputStream input;

    BroadcastReceiver broad = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                //广播搜索到的所有蓝牙对象，从这里获取蓝牙设备的信息
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                //获取到的远程设备
                Toast.makeText(getContext(), device.getName(), Toast.LENGTH_SHORT).show();
                Log.e("name",device.getName());
                Log.e("address",device.getAddress());

                // 如果查找到的设备符合要连接的设备，处理
                if (blueName.getText().toString().trim().equals(device.getName()) && device.getName() != null) {
                    mBluetoothAdapter.cancelDiscovery();   //及时关闭搜索
                    // 获取蓝牙设备的连接状态
                    connectNum = device.getBondState();
                    switch (connectNum) {
                        // 未配对
                        case BluetoothDevice.BOND_NONE:
                            try {
                                Method createBondMethod = BluetoothDevice.class.getMethod("createBond");
                                createBondMethod.invoke(device);  //发送配对请求
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        // 已配对  直接连接
                        case BluetoothDevice.BOND_BONDED:
                            connect(device);
                            break;
                    }
                }
            } else if (BluetoothDevice.ACTION_BOND_STATE_CHANGED.equals(action)) {
                // 状态改变的广播
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if (device.getName().equals(blueName.getText().toString().trim()) && device.getName() != null) {
                    connectNum = device.getBondState();
                    switch (connectNum) {
                        case BluetoothDevice.BOND_NONE:
                            break;
                        case BluetoothDevice.BOND_BONDED:
                            // 直接连接
                            connect(device);
                            break;
                    }
                }
            }
        }
    };
    Handler hand = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    Map<String, Integer> map2 = (Map) msg.obj;
                    myzhu.setZhu(Math.abs(map2.get("shou")),Math.abs(map2.get("shu")));
                    Log.e("hhhhhhhhhhhhh", "shou" + Math.abs(map2.get("shou")) + "  shu" + Math.abs(map2.get("shu")));
                    break;
                case 2:
                    Map<String, Integer> map = (Map) msg.obj;
                    myzhu.setZhu(Math.abs(map.get("b1")),Math.abs(map.get("b2")));
                    new AlertDialog.Builder(getContext())
                            .setMessage("收缩压：" + Math.abs(map.get("b1")) + "   /n"
                                    + "舒张压：" + Math.abs(map.get("b2")) + "   /n"
                                    + "脉率：" + Math.abs(map.get("b3")))
                            .show();
                    hand.removeCallbacks(runnable);
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_xue_ya, null);
        ButterKnife.bind(this, view);


        if (!getActivity().getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            Toast.makeText(getContext(), "设备不支持蓝牙4.0", Toast.LENGTH_SHORT).show();
        }             //判断SDK

        bluetoothManager = (BluetoothManager) getActivity().getSystemService(Context.BLUETOOTH_SERVICE);  //获取BlueToothManager
        mBluetoothAdapter = bluetoothManager.getAdapter();       //获取BlueToothAdapter，用来控制蓝牙

        blueName.setText("KBB3-1");   //初始化设备名称
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.openBlue, R.id.sousuoBlue, R.id.guanBlue, R.id.blueStart, R.id.blueEnd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.openBlue:
                openBlue();
                break;
            case R.id.sousuoBlue:
                connection();
                break;
            case R.id.guanBlue:
                guan();
                break;
            case R.id.blueStart:
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            Log.e("ReceiveSocketService", "---------inputStream");
                            input = socket.getInputStream();
                            ReceiveSocketService.receiveMessage(hand, input);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
                sends(ByteBean.START);
                hand.postDelayed(runnable, 250);
                break;
            case R.id.blueEnd:
                hand.removeCallbacks(runnable);
                sends(ByteBean.END);
                break;
        }
    }
    private void openBlue() {
        // 发intent打开蓝牙
        if (!mBluetoothAdapter.isEnabled()) {
            Intent it = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            it.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
            startActivityForResult(it, REQUEST_ENABLE_BT);
            Toast.makeText(getContext(), "蓝牙已开启", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "请检查设备状态", Toast.LENGTH_SHORT).show();
        }
    }

    private void connection() {
        if (mBluetoothAdapter.isEnabled()) {
            if (blueName.getText().length() > 1) {
                // 设置广播信息过滤
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(BluetoothDevice.ACTION_FOUND);
                intentFilter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
                intentFilter.addAction(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED);
                intentFilter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
                getActivity().registerReceiver(broad, intentFilter);
                mBluetoothAdapter.startDiscovery();  //开始查找附件所有符合条件的设备
            } else {
                Toast.makeText(getContext(), "请输入设备名称", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getContext(), "请检查蓝牙是否开启", Toast.LENGTH_SHORT).show();
        }
    }

    private void guan() {
        if (mBluetoothAdapter.isEnabled()) {   //蓝牙是否开启
            // mBluetoothAdapter.cancelDiscovery();   取消扫描
            mBluetoothAdapter.disable();         //关闭蓝牙
            Toast.makeText(getContext(), "关闭成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "请检查蓝牙是否开启", Toast.LENGTH_SHORT).show();
        }
    }

    private void connect(BluetoothDevice device) {
        // 固定的 UUID
        try {
            final String SPP_UUID = "00001101-0000-1000-8000-00805F9B34FB";
            UUID uuid = UUID.fromString(SPP_UUID);
            //创建一个连接
            socket = device.createRfcommSocketToServiceRecord(uuid);
            socket.connect();  //连接
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sends(byte[] bt) {   //接收发送指令
        try {
            if (socket != null) {
                socket.getOutputStream().write(bt);
                socket.getOutputStream().flush();
            } else {
                Toast.makeText(getContext(), "请连接设备", Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            sends(ByteBean.QUERY);
            //500毫秒递归
            hand.postDelayed(runnable, 500);
            // Log.e("RRRRRRRRRRRRRRR", "runnable");
        }
    };
}
