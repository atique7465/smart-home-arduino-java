/**
 * @author atiQue
 * @since 10'Aug 2022 at 12:13 PM
 */

public class MainClass {
    public static void main(String[] args) {

        var dataListener = new DataListener();

        var serialPort = SerialPortService.getSerialPort("COM3");
        serialPort.addDataListener(dataListener);

        Runtime.getRuntime().addShutdownHook(new Thread(serialPort::closePort));
    }
}