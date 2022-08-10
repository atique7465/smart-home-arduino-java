import com.fazecast.jSerialComm.SerialPort;

/**
 * @author atiQue
 * @since 10'Aug 2022 at 12:13 PM
 */

public class SerialPortService {
    private SerialPortService() {
    }

    public static SerialPort getSerialPort(String portDescriptor) {
        var sp = SerialPort.getCommPort(portDescriptor);
        sp.setComPortParameters(115200, Byte.SIZE, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);

        var hasOpened = sp.openPort();

        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            System.out.println("4 second sleep error.");
        }

        if (!hasOpened) {
            throw new IllegalStateException("Failed to open port : [COM3]");
        } else {
            System.out.println("Port Opened [COM3].");
        }

        return sp;
    }
}
