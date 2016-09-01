package research2016.legobot;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;

public class Main
{
    public static void main(String[] args)
    {
        String address = Bluetooth.getLocalAddress();
        System.out.println(address);
        System.out.println("waiting for connection...");
        BTConnection btConnection = Bluetooth.waitForConnection();
        System.out.println("connection established!...");
        btConnection.setIOMode(BTConnection.RAW);
        InputStream btInputStream = btConnection.openInputStream();
        while(true)
        {
            try
            {
                int integer = btInputStream.read();
                if (integer != -1)
                {
                    System.out.println("theysaid:"+integer);
                }
                else
                {
                    break;
                }
            }
            catch(Exception e)
            {
                break;
            }
        }
        btConnection.close();
    }

//    static class MyStopRunnable implements Runnable
//    {
//        @Override
//        public void run()
//        {
//            UltrasonicSensor sensor = new UltrasonicSensor(SensorPort.S1);
//            while (true)
//            {
//                sensor.ping();
//                if (sensor.getDistance() < 5)
//                {
//                    break;
//                }
//            }
//            Motor.A.stop(true);
//            Motor.B.stop(true);
//            Motor.A.stop();
//            Motor.B.stop();
//        }
//    }
}
