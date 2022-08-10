import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author atiQue
 * @since 10'Aug 2022 at 12:13 PM
 */

public class DataListener implements SerialPortDataListener {

    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
    }

    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {

        if (serialPortEvent.getEventType() == SerialPort.LISTENING_EVENT_DATA_RECEIVED) {

            var data = serialPortEvent.getReceivedData();

            // Convert the received Byte array into a String
            String dataString;
            dataString = null;
            try {
                dataString = new String(data, StandardCharsets.UTF_8);
                dataString = StringUtils.chop(dataString);  // remove the carriage return (CR)
            } catch (Exception e) {
                System.out.println("Received Data parsing error.");
            }

            if (!StringUtils.isEmpty(dataString)) {
                String[] dataSplit = dataString.split(",");

                if (dataSplit.length != 3) {
                    int ldrValue = Integer.parseInt(dataSplit[0]);
                    int temperature = Integer.parseInt(dataSplit[1]);
                    int humidity = Integer.parseInt(dataSplit[2]);
                    String ledStatus;
                    if (ldrValue < 150) {
                        ledStatus = "Low light, LED ON";
                    } else {
                        ledStatus = "Enough light, LED OFF";
                    }

                    System.out.println("################# Room Status #################");
                    System.out.println("Time : " + getCurrentDateTime());
                    System.out.println("LDR current value is : " + ldrValue);
                    System.out.println(ledStatus);
                    System.out.println("Current Room Temperature is : " + temperature);
                    System.out.println("Current Humidity is : " + humidity);

                } else {
                    System.out.println("Not enough data");

                }
            } else {
                System.out.println("Empty data read.");

            }
        } else {
            System.out.println("Not LISTENING_EVENT_DATA_RECEIVED event.");
        }
    }

    private static String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy h:mm:ss a");
        return sdf.format(new Date());
    }

}
